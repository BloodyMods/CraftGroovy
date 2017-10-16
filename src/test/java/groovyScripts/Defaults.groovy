package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager

class Defaults {
    static def iron
    static def coal

    Defaults() {
        println "defaults is getting run"
        CGEventManager.craftTweaker {
            iron = ore("ingotIron")
            coal = item("minecraft:coal")
        }.setPriority(100)
    }
}
