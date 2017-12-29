package atm.bloodworkxgaming.craftgroovy.worldgen;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.worldgen.worldgenTypes.FlowerWorldGenType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static atm.bloodworkxgaming.craftgroovy.worldgen.CGWorldGenManager.WORLGEN_DEBUG;

public class CGWorldGen implements IWorldGenerator {
    private void generateWorld(World world, Random rand, int blockX, int blockZ) {
        int dimID = world.provider.getDimension();
        for (FlowerWorldGenType flowerWorldGenType : CGWorldGenManager.FLOWER_WORLD_GEN_LIST) {
            if (flowerWorldGenType.blockState != null) {
                if ((flowerWorldGenType.whitelistDimensions.isEmpty() || flowerWorldGenType.whitelistDimensions.contains(dimID)) && !flowerWorldGenType.blacklistDimensions.contains(dimID)) {
                    WorldGenerator genFlower = new FlowerGenerator(flowerWorldGenType);

                    int MIN = flowerWorldGenType.minFlowers;
                    int MAX = flowerWorldGenType.maxFlowers;
                    int numBushes = MIN + rand.nextInt(MAX - MIN);

                    if (WORLGEN_DEBUG)
                        CraftGroovy.info("We are in the chunk at X: " + blockX + " Y: " + blockZ + " of the dimension " + dimID + " and we are trying to spawn " + numBushes + " bushes");
                    for (int i = 0; i < numBushes; i++) {
                        // get a random position in the chunk
                        int randX = blockX + rand.nextInt(16);
                        int randZ = blockZ + rand.nextInt(16);

                        // the y-value we pass here will do nothing
                        genFlower.generate(world, rand, new BlockPos(randX, 0, randZ));
                    }
                } else {
                    if (WORLGEN_DEBUG)
                        CraftGroovy.info("Skipping as we are in the chunk at X: " + blockX + " Y: " + blockZ + " of the dimension " + dimID);
                }
            } else {
                if (WORLGEN_DEBUG) CraftGroovy.info("Skipping due to null BlockState");
            }
        }
    }

    /**
     * Generate some world
     *
     * @param random         the chunk specific {@link Random}.
     * @param chunkX         the chunk X coordinate of this chunk.
     * @param chunkZ         the chunk Z coordinate of this chunk.
     * @param world          : additionalData[0] The minecraft {@link World} we're generating for.
     * @param chunkGenerator : additionalData[1] The {@link IChunkProvider} that is generating.
     * @param chunkProvider  : additionalData[2] {@link IChunkProvider} that is requesting the world generation.
     */
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;

        generateWorld(world, random, blockX, blockZ);
    }
}
