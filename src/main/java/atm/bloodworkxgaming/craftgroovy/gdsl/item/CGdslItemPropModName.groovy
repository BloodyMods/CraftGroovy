package atm.bloodworkxgaming.craftgroovy.gdsl.item

import atm.bloodworkxgaming.craftgroovy.wrappers.PItem
import net.minecraft.item.Item

class CGdslItemPropModName {
    String modname

    CGdslItemPropModName(String modname) {
        this.modname = modname
    }

    def propertyMissing(String name) {
        return new PItem(Item.getByNameOrId("$modname:$name"))
    }

    def propertyMissing(String name, def arg) {
        throw new IllegalAccessError("Item fields can only be read")
    }
}
