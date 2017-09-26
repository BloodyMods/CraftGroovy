package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager

class Defaults {
    static def iron

    Defaults() {
        CGEventManager.craftTweaker{
            iron = ore("ingotIron")
        }
    }
}
