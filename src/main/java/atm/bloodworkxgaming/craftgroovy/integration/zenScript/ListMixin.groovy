    package atm.bloodworkxgaming.craftgroovy.integration.zenScript

import net.minecraftforge.fml.common.discovery.ASMDataTable
    import org.apache.commons.lang3.ClassUtils
    import stanhebben.zenscript.annotations.ZenMethod

import java.lang.reflect.Method
import java.util.regex.Pattern

class ListMixin extends AnnotatedElementMixiner{
    ListMixin() {
        super(ZenMethod.class, "lists")
    }

    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader()

    @Override
    protected void doMixin(Set<ASMDataTable.ASMData> dataSet, PrintWriter writer) {
        for (ASMDataTable.ASMData methodData : dataSet) {
            if (!(methodData.objectName ==~ /.*\(.*\[.*\).*/ )){
                continue
            }


            def zsName = methodData.annotationInfo["value"] as String

            try {
                def clazz = Class.forName(methodData.className)
                def funName = methodData.objectName.substring(0, methodData.objectName.indexOf('('))

                def arg_string = methodData.objectName.substring(methodData.objectName.indexOf('('), methodData.objectName.indexOf(')'))

                println "methodData = ${methodData.objectName}"

                def arg_list = contructArgList(arg_string)


                println "arg_list = $arg_list"

                def method = clazz.getMethod(funName, arg_list as Class<?>[])
                println "method = $method"



                def arg_list_of_list = new ArrayList()

                for (a in arg_list){
                    if (a.isArray()){
                        arg_list_of_list.add(List.class)
                    } else {
                        arg_list_of_list.add(a)
                    }
                }


                try {
                    def altMethod = clazz.getMethod(funName, arg_list_of_list as Class<?>[])
                    println "altMethod = $altMethod"
                } catch (NoSuchMethodException e){
                    println "No alt method is implemented yet for funName"
                }




            } catch (ClassNotFoundException e) {
                println "error finding class which should have a annotation"
                e.printStackTrace()
            }

        }
    }

    static Pattern pattern = Pattern.compile(/(\[*((L.*?;)|[ZBCDFIJSV]))/)
    static List<Class<?>> contructArgList(String argString){
        def strings = argString.findAll(pattern)
        List<Class<?>> classList = new ArrayList<>()

        outLoop:
        for (origName in strings) {
            def s = origName.replace("/", ".")
            if (s.startsWith("L")) {
                s = s.substring(1, s.size() - 1)
            }

            switch (s){
                case "Z": classList.add(boolean); continue outLoop
                case "B": classList.add(byte); continue outLoop
                case "C": classList.add(char); continue outLoop
                case "D": classList.add(double); continue outLoop
                case "F": classList.add(float); continue outLoop
                case "I": classList.add(int); continue outLoop
                case "J": classList.add(long); continue outLoop
                case "S": classList.add(short); continue outLoop
                case "V": classList.add(void); continue outLoop
            }

            try {
                def clazz = ClassUtils.getClass(s)
                classList.add(clazz)

            } catch (ClassNotFoundException e ){
                e.printStackTrace()
            }
        }


        return classList

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
