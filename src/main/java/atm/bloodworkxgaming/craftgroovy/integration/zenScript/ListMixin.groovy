package atm.bloodworkxgaming.craftgroovy.integration.zenScript

import net.minecraftforge.fml.common.discovery.ASMDataTable
import stanhebben.zenscript.annotations.ZenMethod

import java.lang.reflect.Method

class ListMixin extends AnnotatedElementMixiner{
    ListMixin() {
        super(ZenMethod.class, "lists")
    }

    @Override
    protected void doMixin(Set<ASMDataTable.ASMData> dataSet, PrintWriter writer) {
        for (ASMDataTable.ASMData methodData : dataSet) {
            def zsName = methodData.annotationInfo["value"] as String
            println "methodData = ${methodData.objectName}"
            println "zsName = ${zsName}"

            try {
                def clazz = Thread.currentThread().getContextClassLoader().loadClass(methodData.className)
                def funName = methodData.objectName.substring(0, methodData.objectName.indexOf('('))
                def matcher = methodData.objectName.substring(methodData.objectName.indexOf('('), methodData.objectName.indexOf(')')) =~ /((L.*?;)|[ZBCDFIJSV])/
                def argCount = matcher.count


                if (methodData.objectName ==~ /.*\(.*\[.*\).*/ ){
                    println "function has a array as arg"

                    List<Method> methods = new ArrayList<>()

                    for (def m : clazz.getDeclaredMethods()) {
                        if (m.getName() == funName && argCount == m.parameterCount) {
                            methods.add(m)
                            break
                        }
                    }


                    if (methods.size() == 1) {
                        registerMethod(writer, clazz, methods.get(0))
                    } else if (methods.size() >= 2) {
                        println "$methods has mulitple overloads with same arg count"
                    }
                }





                // if (methodData.objectName ==~ /.*\).*\[.*/ ){
                //    println "function has a array as return"
                // }

            } catch (ClassNotFoundException e) {
                println "error finding class which should have a annotation"
                e.printStackTrace()
            }
        }
    }

    static void registerMethod(PrintWriter writer, Class clazz, Method method) {
        def cl = { Object... args ->
            
        }


/*
            CraftGroovy.sandboxedLauncher.whitelistRegistry.registerMethod(clazz, method.getName())

            // Creates a gdsl file as otherwise it wouldn't work with highlighting
            writer?.append """contributor(context(ctype: \"${clazz.getName()}\")) {
                            |   method(name: "$gType", type: "${method.getReturnType().getName()}",
                            |          $params)
                            |}\n""".stripMargin()
             */

    }

}
