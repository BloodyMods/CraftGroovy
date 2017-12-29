package atm.bloodworkxgaming.craftgroovy.worldgen

import atm.bloodworkxgaming.craftgroovy.worldgen.worldgenTypes.FlowerWorldGenType
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember

class CGWorldGenManager {
    @GSLWhitelistMember
    public static boolean WORLGEN_DEBUG = true
    public static final List<FlowerWorldGenType> FLOWER_WORLD_GEN_LIST = new ArrayList<>()

    @GSLWhitelistMember
    static void registerFlowerWorldGen(FlowerWorldGenType flowerWorldGenType) {
        FLOWER_WORLD_GEN_LIST.add(flowerWorldGenType)
    }

    @GSLWhitelistMember
    static void registerFlowerWorldGen(
            @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = FlowerWorldGenType) Closure closure) {
        FlowerWorldGenType flower = new FlowerWorldGenType(null)
        flower.with(closure)

        FLOWER_WORLD_GEN_LIST.add(flower)
    }
}
