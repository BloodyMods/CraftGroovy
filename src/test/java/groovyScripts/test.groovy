package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager
import com.teamacronymcoders.contenttweaker.modules.materials.CTMaterialSystem
import crafttweaker.api.item.IItemUtils
import groovy.transform.Field

def bla(double f) {
    println f
}

@Field
static String str = "Potato"

bla(23.0d)

CGEventManager.craftTweaker {

}

CGEventManager.contentTweaker {
    def builder = CTMaterialSystem.partBuilder

    def partList = [
            builder.with {
                name = "advancedRivet"
                partType = CTMaterialSystem.getPartType("item")
                return build()
            },
            builder.with {
                name = "ultimateRivet"
                partType = CTMaterialSystem.getPartType("item")
                return build()
            }
    ]


    def cobalt = MaterialBuilder {
        name = "Cobalt"
        color = 18300
        hasEffect = false
    }




    // CTMaterialSystem.registerPartsForMaterial(cobalt, ["advancedRivet", "ultimateRivet"])

}

