package atm.bloodworkxgaming.craftgroovy.integration.zenScript

import atm.bloodworkxgaming.craftgroovy.CraftGroovy
import net.minecraftforge.fml.common.discovery.ASMDataTable
import net.minecraftforge.fml.common.discovery.asm.ModAnnotation
import stanhebben.zenscript.annotations.ZenOperator

import java.lang.reflect.Method

class OperatorMixins {
    static void manageOperators(ASMDataTable dataTable){
        Set<ASMDataTable.ASMData> zenOperators = dataTable.getAll(ZenOperator.class.getCanonicalName())
        for (ASMDataTable.ASMData zenOperator : zenOperators) {
            def type = (zenOperator.annotationInfo["value"] as ModAnnotation.EnumHolder).value
            println "type = $type"


            try {
                def clazz = Thread.currentThread().getContextClassLoader().loadClass(zenOperator.className)
                def funName = zenOperator.objectName.substring(0, zenOperator.objectName.indexOf('('))

                for (def m : clazz.getDeclaredMethods()){
                    if (m.getName() == funName && m.isAnnotationPresent(ZenOperator.class)){

                        registerMethod(clazz, m, type)
                        break
                    }
                }
            }catch (ClassNotFoundException e){
                println "error finding class which should have a annotation"
                e.printStackTrace()
            }
        }
    }


    static void registerMethod(Class clazz, Method method, String type){
        def gType = TYPES[type]

        if (gType != null) {
            if (gType == "putAt"){
                clazz.getMetaClass()."$gType" { a1, a2 ->
                    method.invoke(delegate, a1, a2)
                }
            }

            if (gType == "bitwiseNegate") {
                clazz.getMetaClass()."$gType" {
                    method.invoke(delegate)
                }
            }

            clazz.getMetaClass()."$gType" { Object a1 ->
                method.invoke(delegate, a1)
            }

            CraftGroovy.sandboxedLauncher.whitelistRegistry.registerMethod(clazz, method.getName())
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
