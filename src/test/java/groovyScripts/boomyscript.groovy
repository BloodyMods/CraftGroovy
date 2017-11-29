package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager
import atm.bloodworkxgaming.craftgroovy.util.CGRandom

println "HI I AM A SCRIPT AND I AM GETTING LOADED!!!!"

CGEventManager.blockBreak {
    println "HI I AM A TEST LINE"
    if (world.getBlockStateAt(pos).identifier == "minecraft:dirt:0" ){
        def tag = player.getPersistentNBT().getBoolean("TrustFallBlockBroken")
        if (!tag){
            world.setBlockState(pos.down(5), createBlockState("minecraft:dirt"))
            player.getPersistentNBT().setBoolean("TrustFallBlockBroken", true)
            player.addItemStackToInventory(createItemStack("minecraft:dirt") * 2)
            player.sendMessage("FEEL THE DROP!!!")
        }
    }
}

CGEventManager.initialItems {
    player.addItemStackToInventory(createItemStack(createItem("minecraft:coal"), 0, 1))
}

CGEventManager.rightClickBlock {
    player.swingArmMain()
    if (CGRandom.nextInt(5) == 0 && player.sneaking && world.getBlockStateAt(pos).identifier == "minecraft:dirt:0" && player.getHeldMain().isEmpty() ){
        world.spawnItemInWorld(createItemStack("minecraft:diamond"), pos.up(1), CGRandom.nextDouble(-0.1, 0.1), 0.1, CGRandom.nextDouble(-0.1, 0.1))
    }
}