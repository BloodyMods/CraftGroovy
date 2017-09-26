package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager

class Defaults {
    static def iron
    static def coal

    Defaults() {
        CGEventManager.craftTweaker{
            iron = ore("ingotIron")
            coal = item("minecraft:coal")
        }.setPriority(100)
    }
}
