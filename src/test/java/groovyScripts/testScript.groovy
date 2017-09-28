package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager
import atm.bloodworkxgaming.craftgroovy.util.VanillaSounds
import atm.bloodworkxgaming.craftgroovy.wrappers.PItemStack
import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos
import com.teamacronymcoders.contenttweaker.api.ctobjects.blockstate.ICTBlockState
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld
import com.teamacronymcoders.contenttweaker.modules.vanilla.VanillaFactory
import net.minecraft.util.EnumParticleTypes
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

import static com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler.getBlockMaterial
import static com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler.getSoundType

println "Hi I am a test script"


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

CGEventManager.blockBreak {
    println "Player ${player.displayName} is breaking ${state.block} block at ${pos}"
    expToDrop = 100

    if (state.identifier == "minecraft:dirt:0"){
        println "Item: " + player.heldMain.displayName

        if (player.heldMain.identifier.contains("pickaxe")){
            player.fire = 20
        }

        player.addExperienceLevel(3)
    }
}

CGEventManager.blockPlace {
    println "Block $state being placed by $player"
}

CGEventManager.rightClickBlock {
    println "ItemStack: $itemStack"
    println "Block at $pos clicked with ${itemStack?.displayName}"

    if (itemStack?.identifier == "minecraft:diamond:0"){
        if (world.getBlockAt(pos).registryName == "minecraft:stone"
                && world.getBlockAt(pos, 1,0,0).registryName == "minecraft:dirt"
                && world.getBlockAt(pos, -1,0,0).registryName == "minecraft:dirt"
                && world.getBlockAt(pos, 0,0,1).registryName == "minecraft:dirt"
                && world.getBlockAt(pos, 0,0,-1).registryName == "minecraft:dirt") {


            world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, pos.x, pos.y, pos.z, 0, 0, 0)
            world.playRecord(pos, VanillaSounds.ENTITY_GENERIC_EXPLODE.getSoundEvent())
            world.setToAir(pos)

            player.heldMain.count--
            world.spawnItemInWorld(new PItemStack("minecraft:redstone") * 20, pos.add(0,1,0), 0, 0.2, 0)

        }
    }
}

CGEventManager.craftTweaker {
    int hi = 20
    println hi
    println item("coal")
    println "iron ${Defaults.iron}"

    def closure = { int a, int b ->
        println a + " -> " + b
    }

    closure(20, 30)


    def coal = item("minecraft:coal")
    def iron = item("minecraft:iron_ingot")

    println coal.anyAmount()

    recipes.addShaped(coal.amount(20), [[coal], [coal]])
    recipes.addShapeless(coal.amount(10), [coal, coal, iron, Defaults.iron])


    recipes.addShaped(coal, [[coal], [coal]])

    recipes.addShaped("bla",     item("minecraft:potion").withTag(nbt('{Potion:"minecraft:swiftness"}')), [[coal, coal], [coal]])

    logger.logError"blablalbla"
    logger.logWarning("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")

    item("minecraft:potion")



} setPriority(20) setLoaderName( "bla") addPackMode("normal") addPackMode("potato")

CGEventManager.craftTweaker (["bla", "boob", "normal"]) {
    int hi = 20
    println hi
}