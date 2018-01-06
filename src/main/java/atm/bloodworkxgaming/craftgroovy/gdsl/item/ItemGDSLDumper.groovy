package atm.bloodworkxgaming.craftgroovy.gdsl.item

import atm.bloodworkxgaming.craftgroovy.CraftGroovy
import groovy.transform.CompileStatic
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

@CompileStatic
class ItemGDSLDumper {
    static void dumpItems(File f) {
        PrintWriter writer = null
        try {
            writer = new PrintWriter(f)
            Map<String, List<String>> itemNames = new HashMap<>()

            for (ResourceLocation itemName : Item.REGISTRY.getKeys()) {
                def list = itemNames.getOrDefault(itemName.resourceDomain, new ArrayList<String>())
                list.add(itemName.resourcePath)
                itemNames.put(itemName.resourceDomain, list)
            }

            // lists with stuff:
            // itemmap
            writer.append "def m = ["
            for (def items : itemNames) {
                writer.append "$items.key: ["
                items.value.each { writer.append "\"${it.capitalize()}\"," }
                writer.append "],\n"
            }
            writer.append "]\n"

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
                            |""".stripMargin()

            for (int i : 1..2) {
/*
                writer.append """
                                |m.each { e ->
                                |    e.value.each { v ->
                                |        contributor(context(ctype: "\${n$i}_\${e.value}")){
                                |            method(name: "get" + v.capitalize(), type: o$i)
                                |        }
                                |    }
                                |}
                                """.stripMargin()
*/


                itemNames.keySet().each {
                    /*for (c in m["minecraft"]) {
        property(name: c, type: o1)

                                        |    m["$it"].each { c ->
                                    |        property(name: c, type: o$i)
                                    |    }

                                    method(name: "and", type: "crafttweaker.api.data.IData",
          params: [obj: "crafttweaker.api.data.IData"])
    }*/
                    writer.append """
                                    |contributor(context(ctype: "\${n${i}}_$it")){
                                    |   
                                    """.stripMargin()

                    itemNames.get(it).each {
                        writer.append("\tmethod(name: \"get${it.capitalize()}\", type: o$i)\n")
                    }

                    writer.append("}\n")
                }
            }

        } catch (Exception e) {
            CraftGroovy.error("Errored while gdsling items", e)
        } finally {
            writer?.flush()
            writer?.close()
        }
    }
}
