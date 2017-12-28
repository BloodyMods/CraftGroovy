package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl

class CrTItemProp {
    def propertyMissing(String name) {
        return new CrTdslItemPropModName(name)
    }

    def propertyMissing(String name, def arg) {
        throw new IllegalAccessError("Item fields can only be read")
    }
}
