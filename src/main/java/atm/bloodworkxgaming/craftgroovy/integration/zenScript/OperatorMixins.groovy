package atm.bloodworkxgaming.craftgroovy.integration.zenScript

import atm.bloodworkxgaming.craftgroovy.CGConfig
import atm.bloodworkxgaming.craftgroovy.CraftGroovy
import net.minecraftforge.fml.common.discovery.ASMDataTable
import net.minecraftforge.fml.common.discovery.asm.ModAnnotation
import stanhebben.zenscript.annotations.ZenOperator

import java.lang.reflect.Method

class OperatorMixins {
    private static PrintWriter writer = null

    static void manageOperators(ASMDataTable dataTable){
        Set<ASMDataTable.ASMData> zenOperators = dataTable.getAll(ZenOperator.class.getCanonicalName())

        try {
            File file
            if (CGConfig.getCustomScriptPaths().length > 0){
                file = new File(CGConfig.getCustomScriptPaths()[0], "operators.gdsl")
            } else {
                file = new File("operators.gdsl")
            }

            writer = new PrintWriter(file)
        } catch (Exception e){
            CraftGroovy.error("Error while writing to operators.gdsl", e)

            writer?.flush()
            writer?.close()
        }


        for (ASMDataTable.ASMData zenOperator : zenOperators) {
            def type = (zenOperator.annotationInfo["value"] as ModAnnotation.EnumHolder).value

            try {
                def clazz = Thread.currentThread().getContextClassLoader().loadClass(zenOperator.className)
                def funName = zenOperator.objectName.substring(0, zenOperator.objectName.indexOf('('))

                for (def m : clazz.getDeclaredMethods()){
                    if (m.getName() == funName && m.isAnnotationPresent(ZenOperator.class)){
                        registerMethod(clazz, m, type)
                        break
                    }
                }
            } catch (ClassNotFoundException e){
                println "error finding class which should have a annotation"
                e.printStackTrace()
            }
        }

        writer?.flush()
        writer?.close()
    }

    /**
     * Dynamic mixin on the method which is getting forwarded to the other original
     * @param clazz
     * @param method
     * @param type
     */
    static void registerMethod(Class clazz, Method method, String type){
        def gType = TYPES[type]

        if (gType != null) {

            def params = ""

            if (gType == "putAt"){
                clazz.getMetaClass()."$gType" { a1, a2 ->
                    method.invoke(delegate, a1, a2)
                }

                def p = method.getParameterTypes()
                if (p.length > 1){
                    params = "params: [index: \"${p[0].name}\", value: \"${p[1]}\"]"
                }

            } else if (gType == "bitwiseNegate") {
                clazz.getMetaClass()."$gType" {
                    method.invoke(delegate)
                }
            } else {
                clazz.getMetaClass()."$gType" { Object a1 ->
                    method.invoke(delegate, a1)
                }

                def p = method.getParameterTypes()
                if (p.length > 0){
                    params = "params: [obj: \"${p[0].name}\"]"
                }
            }

            CraftGroovy.sandboxedLauncher.whitelistRegistry.registerMethod(clazz, method.getName())

            // Creates a gdsl file as otherwise it wouldn't work with highlighting
            writer?.append """contributor(context(ctype: \"${clazz.getName()}\")) {
                            |   method(name: "$gType", type: "${method.getReturnType().getName()}",
                            |          $params)
                            |}\n""".stripMargin()

        }
    }


    static def TYPES = [
            "ADD": "plus",
            "SUB": "minus",
            "MUL": "multiply",
            "DIV": "div",
            "MOD": "mod",
            "CAT": "leftShift",
            "OR": "or",
            "AND": "and",
            "XOR": "xor",
            "NEG": "bitwiseNegate",
            "NOT": null,
            "INDEXSET": "putAt",
            "INDEXGET": "getAt",
            "RANGE": null,
            "CONTAINS": null,
            "COMPARE": null,
            "MEMBERGETTER": "getAt",
            "MEMBERSETTER": "putAt",
            "EQUALS": null
    ]
}
