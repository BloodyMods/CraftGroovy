package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker

import java.util.regex.Matcher
import java.util.regex.Pattern

class ZsCrossCompiler {
    private static String importPattern = "import\\s+((\\w+\\.?)+);"
    private static Map<String, String> importReplaces = [
        "crafttweaker.item.IIngredient": "crafttweaker.api.item.IIngredient",
        "crafttweaker.item.IItemStack": "crafttweaker.api.item.IItemStack",
        "crafttweaker.oredict.IOreDict": "crafttweaker.api.oredict.IOreDict",
        "crafttweaker.oredict.IOreDictEntry": "crafttweaker.api.oredict.IOreDictEntry",
    ]

    static String transform(String script){
        StringBuilder sb = new StringBuilder()
        sb.append("package groovyScripts\n")

        Pattern pattern = Pattern.compile(importPattern)
        Matcher matcher = pattern.matcher(script)

        while (matcher.find()) {
            String loc = matcher.group(1)
            def newImp = importReplaces.get(loc)

            if (newImp == null){
                newImp = loc
            }

            sb.append("import $newImp\n")
        }
        sb.append("import atm.bloodworkxgaming.craftgroovy.events.CGEventManager\n")
        sb.append("import atm.bloodworkxgaming.craftgroovy.events.CGEventManager\n")

        sb.append("\nCGEventManager.craftTweaker {\n")

        script = script.replaceAll("print\\(", "println(")
        script = script.replaceAll("var\\s+(\\w+)\\s+=", "def \$1 =")
        script = script.replaceAll("val\\s+(\\w+)\\s+=", "final def \$1 =")
        script = script.replaceAll("#", "//")
        script = script.replaceAll(importPattern, "")

        // bracket handlers
        script = script.replaceAll("<ore:([\\w*:#]*?)>", "ore(\"\$1\")")
        script = script.replaceAll("<fluid:([\\w*:#]*?)>", "fluid(\"\$1\")")
        script = script.replaceAll("<liquid:([\\w*:#]*?)>", "liquid(\"\$1\")")
        script = script.replaceAll("<entity:([\\w*:#]*?)>", "entity(\"\$1\")")

        // item replacing, must happen after ALL other other brackets
        script = script.replaceAll("<(\\w*:\\w*)>", "item(\"\$1\")")
        script = script.replaceAll("<(\\w*:\\w*):(\\d+)>", "item(\"\$1\", \$2)")

        script = script.replaceAll("<([\\w*:#]*?)>", "bracket(\"\$1\")")

        script = script.replaceAll("for\\s+(\\w+)\\s+in\\s(.*?)\\s*\\{", "for (\$1 in \$2) {")
        script = script.replaceAll("for\\s+(\\w+)\\s*,\\s*(\\w+)\\s+in\\s(.*?)\\s*\\{", "\$3.eachWithIndex { \$2, int \$1 -> ")




        sb.append(script)
        sb.append("\n}")



        return sb.toString()
    }
}
