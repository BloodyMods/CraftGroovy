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
            writer.append "def a(String s) {property(name: s, type: 'atm.bloodworkxgaming.craftgroovy.wrappers.PItem')}"
            writer.append "def b(String s) {property(name: s, type: 'crafttweaker.api.item.IItemStack')}"

            // CG
            writer.append "contribute(context(ctype: 'atm.bloodworkxgaming.craftgroovy.gdsl.item.CGItemProp')){\n"
            for (def n : itemNames.keySet()){
                writer.append "\tproperty(name: '$n', type: 'atm.bloodworkxgaming.craftgroovy.gdsl.item.CGdslItemPropModName_$n')\n"
            }
            writer.append "}\n"

            for (def items : itemNames) {
                writer.append "contribute(context(ctype: 'atm.bloodworkxgaming.craftgroovy.gdsl.item.CGdslItemPropModName_${items.key}')){\n"
                items.value.each {
                    writer.append "\tproperty(name: '$it', type: 'atm.bloodworkxgaming.craftgroovy.wrappers.PItem')\n"
                }

                writer.append "}\n\n"
            }

            // CrT
            writer.append "contribute(context(ctype: 'atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTItemProp')){\n"
            for (def n : itemNames.keySet()){
                writer.append "\tproperty(name: '$n', type: 'atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTdslItemPropModName_$n')\n"
            }
            writer.append "}\n"

            for (def items : itemNames) {
                writer.append "contribute(context(ctype: 'atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTdslItemPropModName_${items.key}')){\n"
                items.value.each {
                    writer.append "\tproperty(name: '$it', type: 'crafttweaker.api.item.IItemStack')\n"
                }

                writer.append "}\n\n"
            }


        } catch (Exception e){
            CraftGroovy.error("Errored while gdsling items", e)
        } finally {
            writer?.flush()
            writer?.close()
        }
    }
}
