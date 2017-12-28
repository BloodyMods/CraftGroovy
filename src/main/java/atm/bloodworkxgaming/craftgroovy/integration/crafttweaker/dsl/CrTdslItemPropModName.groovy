package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl

import crafttweaker.mc1120.brackets.BracketHandlerItem

class CrTdslItemPropModName {
    String modname

    CrTdslItemPropModName(String modname) {
        this.modname = modname
    }

    def propertyMissing(String name) {
        return BracketHandlerItem.getItem(modname, 0)
    }

    def propertyMissing(String name, def arg) {
        throw new IllegalAccessError("Item fields can only be read")
    }
}
