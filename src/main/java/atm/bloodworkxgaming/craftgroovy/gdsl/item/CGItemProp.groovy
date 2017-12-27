package atm.bloodworkxgaming.craftgroovy.gdsl.item

class CGItemProp {
    def propertyMissing(String name) {
        return new CGdslItemPropModName(name)
    }

    def propertyMissing(String name, def arg) {
        throw new IllegalAccessError("Item fields can only be read")
    }
}
