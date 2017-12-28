package atm.bloodworkxgaming.craftgroovy.gdsl.item

import atm.bloodworkxgaming.craftgroovy.CraftGroovy
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

class ItemGDSLDumper {
    static void dumpItems(File f){
        PrintWriter writer = null
        try {
            writer = new PrintWriter(f)
            Map<String, List<String>> itemNames = new HashMap<>()

            for(ResourceLocation itemName : Item.REGISTRY.getKeys()) {
                def list = itemNames.getOrDefault(itemName.resourceDomain, new ArrayList<String>())
                list.add(itemName.resourcePath)
                itemNames.put(itemName.resourceDomain, list)
            }

            // Stuff for shortening the file:
            def cgPropString = "def a = {List<String> s -> s.each {property(name: it, type: 'atm.bloodworkxgaming.craftgroovy.wrappers.PItem')}}\n"
            def crtPropString = "def b = {List<String> s -> s.each {property(name: it, type: 'crafttweaker.api.item.IItemStack')}}\n"


            def cgModNameString = "def d = {List<String> s -> s.each {property(name: it, type: \"atm.bloodworkxgaming.craftgroovy.gdsl.item.CGdslItemPropModName_\$it\")}}\n"
            def crtModNameString = "def e = {List<String> s -> s.each {property(name: it, type: \"atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTdslItemPropModName_\$it\")}}\n"


            // lists with stuff:
            // itemmap
            writer.append "def m = ["
            for (def items : itemNames) {
                writer.append "$items.key: ["
                items.value.each { writer.append "\"$it\"," }
                writer.append "],\n"
            }
            writer.append "]\n"

            /*
            //modlist
            writer.append "def l = ["
            itemNames.keySet().each { writer.append "\"$it\"," }
            writer.append "]\n\n"*/

            writer.append """
                            |contributor(context(ctype: 'atm.bloodworkxgaming.craftgroovy.gdsl.item.CGItemProp')){
                            |   m.keySet().each { property(name: it, type: \"atm.bloodworkxgaming.craftgroovy.gdsl.item.CGdslItemPropModName_\$it\")}
                            |}
                            |
                            |contributor(context(ctype: 'atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTItemProp')){
                            |   m.keySet().each { property(name: it, type: \"atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTdslItemPropModName_\$it\") }
                            |}
                            |
                            |def n1 = "atm.bloodworkxgaming.craftgroovy.gdsl.item.CGdslItemPropModName"
                            |def o1 = "atm.bloodworkxgaming.craftgroovy.wrappers.PItem"
                            |
                            |def n2 = "atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTdslItemPropModName"
                            |def o2 = "crafttweaker.api.item.IItemStack"
                            """.stripMargin()

            for (int i : 1..2){
                itemNames.keySet().each {
                    writer.append """
                                    |contributor(context(ctype: "\${n${i}}_$it")){
                                    |    m["$it"].each { c ->
                                    |        property(name: c, type: o$i)
                                    |    }
                                    |}
                                    """.stripMargin()
                }
            }
/*

            writer.append """
                            |["atm.bloodworkxgaming.craftgroovy.gdsl.item.CGdslItemPropModName": 'atm.bloodworkxgaming.craftgroovy.wrappers.PItem',
                            | "atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTdslItemPropModName": 'crafttweaker.api.item.IItemStack'].each { b ->
                            |   m.each { def a ->
                            |       contributor(context(ctype: "\${b.key}_\$a.key")) {
                            |           a.value.each {
                            |               property(name: it, type: b.value)
                            |           }
                            |       }
                            |   }
                            |}
                            """.stripMargin()
*/
            /*
            // CG
            // Mod list:
            writer.append "contribute(context(ctype: 'atm.bloodworkxgaming.craftgroovy.gdsl.item.CGItemProp')){\n"
            writer.append cgModNameString
            writer.append "d(["
            itemNames.keySet().each { writer.append "\"$it\"," }
            writer.append "])}\n\n"

            // Items:
            for (def items : itemNames) {
                writer.append "contribute(context(ctype: 'atm.bloodworkxgaming.craftgroovy.gdsl.item.CGdslItemPropModName_${items.key}')){\n"
                writer.append cgPropString
                writer.append "a(["
                items.value.each { writer.append "\"$it\"," }
                writer.append "])}\n\n"
            }

            // CrT
            //Modlist:
            writer.append "contribute(context(ctype: 'atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTItemProp')){\n"
            writer.append crtModNameString
            writer.append "d(["
            itemNames.keySet().each { writer.append "\"$it\"," }
            writer.append "])}\n\n"


            for (def items : itemNames) {
                writer.append "contribute(context(ctype: 'atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTdslItemPropModName_${items.key}')){\n"
                items.value.each {
                    writer.append "\tb(\"$it\")\n"
                }

                writer.append "}\n\n"
            }
            */

        } catch (Exception e){
            CraftGroovy.error("Errored while gdsling items", e)
        } finally {
            writer?.flush()
            writer?.close()
        }
    }
}
