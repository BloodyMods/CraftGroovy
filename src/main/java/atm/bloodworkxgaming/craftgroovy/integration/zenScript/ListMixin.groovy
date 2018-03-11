package atm.bloodworkxgaming.craftgroovy.integration.zenScript

import atm.bloodworkxgaming.craftgroovy.CraftGroovy
import it.unimi.dsi.fastutil.ints.Int2IntMap
import it.unimi.dsi.fastutil.ints.Int2IntRBTreeMap
import net.minecraftforge.fml.common.discovery.ASMDataTable
import org.apache.commons.lang3.ClassUtils
import stanhebben.zenscript.annotations.ZenMethod

import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.lang.reflect.Parameter
import java.util.regex.Pattern

class ListMixin extends AnnotatedElementMixiner {
    ListMixin() {
        super(ZenMethod.class, "lists")
    }

    @Override
    protected void doMixin(Set<ASMDataTable.ASMData> dataSet, PrintWriter writer) {
        for (ASMDataTable.ASMData methodData : dataSet) {
            if (!(methodData.objectName ==~ /.*\(.*\[.*\).*/)) {
                continue
            }


            def zsName = methodData.annotationInfo["value"] as String

            try {
                def clazz = Class.forName(methodData.className)
                def funName = methodData.objectName.substring(0, methodData.objectName.indexOf('('))

                def arg_string = methodData.objectName.substring(methodData.objectName.indexOf('('), methodData.objectName.indexOf(')'))
                def arg_list = contructArgList(arg_string)

                def method = clazz.getMethod(funName, arg_list as Class<?>[])
                if (method == null)
                    continue

                // Creates the alternative arguments to check for already implemented alternative
                def arg_list_of_list = new ArrayList<>()
                for (a in arg_list) {
                    if (a.isArray()) {
                        arg_list_of_list.add(List.class)
                    } else {
                        arg_list_of_list.add(a)
                    }
                }

                // registers the alt method if the other one doesn't exist yet
                try {
                    def altMethod = clazz.getMethod(funName, arg_list_of_list as Class<?>[])
                    println "Function already has an alternative method implemented, ignoring = $altMethod"
                } catch (NoSuchMethodException ignored) {
                    registerMethod(writer, clazz, funName, method, method.getParameters(), method.getReturnType())
                }

            } catch (Exception e) {
                println "error finding class or function which should have a annotation"
                e.printStackTrace()
            }

        }
    }

    static Pattern pattern = Pattern.compile(/(\[*((L.*?;)|[ZBCDFIJSV]))/)

    static List<Class<?>> contructArgList(String argString) {
        def strings = argString.findAll(pattern)
        List<Class<?>> classList = new ArrayList<>()

        outLoop:
        for (origName in strings) {
            def s = origName.replace("/", ".")
            if (s.startsWith("L")) {
                s = s.substring(1, s.size() - 1)
            }

            switch (s) {
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

            } catch (ClassNotFoundException e) {
                e.printStackTrace()
            }
        }


        return classList

    }

    private static void registerMethod(PrintWriter writer, final Class mainClass, String methodName, Method method, Parameter[] params, Class<?> returnType) {
        // Creates the alternative arguments to check for already implemented alternative
        final def arg_list_of_list = new ArrayList<Class<?>>()
        final Int2IntMap int2IntMap = new Int2IntRBTreeMap()
        def sb = new StringBuilder()

        sb.append("contributor(context(ctype: \"$mainClass.canonicalName\")){method(name:\"$methodName\",type:\"$returnType.canonicalName\",params: [")

        params.eachWithIndex { Parameter entry, int i ->
            def clazz = entry.getType()

            if (clazz.isArray()) {

                // counts the depth of the array
                def array = clazz
                int count = 0
                while (array.isArray()) {
                    count++
                    array = array.getComponentType()
                }

                arg_list_of_list.add(List.class)
                int2IntMap.put(i, count)
                sb.append("$entry.name: \"${"List<" * count}$array.canonicalName${">" * count}\"")

            } else {
                arg_list_of_list.add(clazz)
                sb.append("$entry.name: \"$clazz.canonicalName\"")
            }

            sb.append(", ")
        }
        sb.append("])}\n")

        // creates the closure that is the new function
        def cl = { Object... args ->
            def list = []

            args.eachWithIndex { Object entry, int i ->
                list.add(entry.asType(params[i].getType()))
            }

            return method.invoke(delegate, list as Object[])
        }

        // different adding of static methods
        if (method.getModifiers() & Modifier.STATIC) {
            mainClass.getMetaClass().static."$methodName" = cl
        } else {
            mainClass.getMetaClass()."$methodName" = cl
        }

        writer?.append(sb)
        CraftGroovy.sandboxedLauncher.whitelistRegistry.registerMethod(mainClass, methodName)
    }

}
