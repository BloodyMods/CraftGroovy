package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager
import crafttweaker.api.item.IItemStack

class Defaults {
    static IItemStack iron
    static IItemStack coal

    Defaults() {
        println "defaults is getting run"
        CGEventManager.craftTweaker {
            iron = ore("ingotIron")
            coal = item("minecraft:coal")

            println "iron ${this.iron} coal ${this.coal}"
        }.setPriority(100)
    }
}
