package groovyScripts

import atm.bloodworkxgaming.crtgroovyaddon.events.EventManager
import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos
import com.teamacronymcoders.contenttweaker.api.ctobjects.blockstate.ICTBlockState
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld
import com.teamacronymcoders.contenttweaker.modules.vanilla.VanillaFactory
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


    VanillaFactory.createBlock("anti_ice", getBlockMaterial("ice")).with {
        lightOpacity = 3
        lightValue = 10
        setBlockHardness(5.0f)
        setBlockResistance(5.0f)
        setToolClass("pickaxe")
        setToolLevel(0)
        setBlockSoundType(getSoundType("snow"))
        setSlipperiness(0.3f)
        onBlockBreak = { IWorld world, IBlockPos pos, ICTBlockState var3 ->
            println "breaking a block at pos ${pos.getX()}, ${pos.getY()}, ${pos.getZ()}"
        }
        register()
    }
}


EventManager.init {
    println magic
}

EventManager.blockBreak {
    println "Player ${player.displayName} is breaking ${state.block} block at ${pos}"
    expToDrop = 100   // either this syntax
    setExpToDrop(300) // or this syntax

    if (state.block.registryName.toString() == "minecraft:stone"){
        player.setFire(20) // same here
        player.fire = 20   // <-|

        player.addExperienceLevel(3)
    }
}
