package groovyScripts

import com.teamacronymcoders.contenttweaker.api.ContentTweakerAPI
import com.teamacronymcoders.contenttweaker.modules.vanilla.VanillaFactory
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

import static com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler.getBlockMaterial
import static com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler.getSoundType
import static crafttweaker.CraftTweakerAPI.logger
import static crafttweaker.CraftTweakerAPI.recipes
import static crafttweaker.mc1120.brackets.BracketHandlerItem.getItem

println "Hi I am a test script"

def coal = getItem("minecraft:coal", 0)
def iron = getItem("minecraft:iron_ingot", 0)
println coal.anyAmount()

recipes.addShaped(coal.amount(20), [[coal], [coal]])
recipes.addShapeless(coal.amount(10), [coal, coal, iron, iron])


recipes.addShaped(coal, [[coal], [coal]])


recipes.addShaped("bla", coal, [[coal, coal], [coal]])

logger.logError"blablalbla"
logger.logWarning("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")

void preinit(FMLPreInitializationEvent event){
    println " This should be in preinit"


    def antiIceBlock = VanillaFactory.createBlock("anti_ice", getBlockMaterial("ice"))
    antiIceBlock.with {
        setLightOpacity(3)
        setLightValue(0)
        setBlockHardness(5.0f)
        setBlockResistance(5.0f)
        setToolClass("pickaxe")
        setToolLevel(0)
        setBlockSoundType(getSoundType("snow"))
        setSlipperiness(0.3f)
        register()
    }
}
