package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager
import atm.bloodworkxgaming.craftgroovy.util.VanillaSounds
import atm.bloodworkxgaming.craftgroovy.worldgen.CGWorldGenManager
import atm.bloodworkxgaming.craftgroovy.worldgen.worldgenTypes.FlowerWorldGenType
import atm.bloodworkxgaming.craftgroovy.wrappers.PBlock
import atm.bloodworkxgaming.craftgroovy.wrappers.PItemStack
import atm.bloodworkxgaming.craftgroovy.wrappers.PParticleTypes
import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos
import com.teamacronymcoders.contenttweaker.api.ctobjects.blockstate.ICTBlockState
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld
import com.teamacronymcoders.contenttweaker.modules.vanilla.VanillaFactory
import crafttweaker.api.item.IItemStack
import groovy.transform.Field

import static com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler.getBlockMaterial
import static com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler.getSoundType

println "Hi I am a test script"

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


            world.spawnParticle(PParticleTypes.EXPLOSION_HUGE, pos.x, pos.y, pos.z, 0, 0, 0)
            world.playRecord(pos, VanillaSounds.ENTITY_GENERIC_EXPLODE.getSoundEvent())
            world.setToAir(pos)

            player.heldMain.count--
            world.spawnItemInWorld(new PItemStack("minecraft:redstone") * 20, pos.add(0,1,0), 0, 0.2d, 0)
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

CGEventManager.craftTweaker {
    def i = item("minecraft:coal")

    println i
    i = i * 20
    println i

    println bracket("ore:coal")
    def sap  = bracket("minecraft:sapling:3")

    println sap.toString()

    println sap.getClass()
    sap = sap as IItemStack
    println sap.getClass()

    PBlock.getBlockFromName("minecraft:bedrock").setHardness(4)

    recipes.addShaped(item("minecraft:coal"), [[item("minecraft:coal", 2), item("minecraft:coal")]])
    recipes.addShaped(sap, [[item("minecraft:coal", 2), item("minecraft:coal")]])
    recipes.addShapedMirrored(item("minecraft:coal") * 20, [[item("minecraft:coal"), item("minecraft:coal")], [ore("dustRedstone") * 20]])
}

CGEventManager.contentTweaker {
    println "Hi I am in the contenttweaker thingy"



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

    def cobalt5 = MaterialBuilder {
        name = "Cobalt5"
        color = 18300
        hasEffect = true
    }

    def cobalt4 = getMaterialBuilder().setName("Cobalt4").setColor(18347).setHasEffect(true).build()

    def cobalt3 = MaterialBuilder { name = "Cobalt3"; color = 0x0033cc; hasEffect = false}

    def cobalt2 = MaterialBuilder { setName("Cobalt2"); setColor(0x0033cc); setHasEffect(false)}

    def cobalt1 = MaterialBuilder (name: "Cobalt1", color: 0x0033cc, hasEffect: false)

    def ingots = [
            MaterialBuilder { name = "Cobalt"; color = 0x0033cc; hasEffect = false},
            MaterialBuilder { name = "Gold"; color = 0xffff00; hasEffect = true},
            MaterialBuilder { name = "Iron"; color = 0x999966; hasEffect = false},
            cobalt1, cobalt2, cobalt3, cobalt4, cobalt5
    ]

    for (i in ingots){
        i.registerParts("gear", "ingot")
    }
}

CGEventManager.initEvent {
    println "Running init"
    CGWorldGenManager.WORLGEN_DEBUG = false

    println("2to2 test" + (20 .. 1))

    def blockFlower = createBlockState("minecraft:red_flower", 2)
    println "blockFlower: $blockFlower"

    def flower = new FlowerWorldGenType(null)
    flower.blockState = blockFlower
    flower.maxFlowers = 30
    flower.minFlowers = 20
    flower.whitelistDimensions.add(0)

    // println "BlockState of flower: ${flower.blockState}"
    CGWorldGenManager.registerFlowerWorldGen {
        blockState = createBlockState("minecraft:red_flower", 3)
        maxFlowers = 30
        minFlowers = 20
        whitelistDimensions.add(0)
    }
    // CGWorldGenManager.registerFlowerWorldGen (flower)
}

CGEventManager.initialItems {
    player.addItemStackToInventory(createItemStack(createItem("minecraft:coal"), 0, 10))
}

CGEventManager.initialItems (true) {
    player.addItemStackToInventory(createItemStack(createItem("minecraft:redstone"), 0, 10))
    player.addItemStackToInventory(createItemStack("minecraft:potion").setNBT('{Potion:"minecraft:strong_strength"}'))

    player.sendStatusMessage "Thanks for playing", true
    player.sendMessage "Welcome to All The Mods whatever."
}

@Field
static def iron = "bla"