package atm.bloodworkxgaming.craftgroovy.worldgen;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.worldgen.worldgenTypes.FlowerWorldGenType;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

import static atm.bloodworkxgaming.craftgroovy.worldgen.CGWorldGenManager.WORLGEN_DEBUG;

public class FlowerGenerator extends WorldGenerator
{

    private FlowerWorldGenType flowerWorldGenType;

    public FlowerGenerator(FlowerWorldGenType flowerWorldGenType)
    {
        this.flowerWorldGenType = flowerWorldGenType;
    }


    @Override
    public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
        if (WORLGEN_DEBUG) CraftGroovy.info("Attempting to generate at " + pos);
        if (flowerWorldGenType.whitelistDimensions.contains(worldIn.provider.getDimension())){
            int y = 1 + getGroundFromAbove(worldIn, pos.getX(), pos.getZ());

            // debug:
            // System.out.println("Y-value of ground is " + y + " at (" + pos.getX() + ", " + pos.getZ() + ")");
            // the Y we passed earlier will be used here as the minimum spawn height allowed
            if(y >= flowerWorldGenType.minHeight)
            {
                BlockPos bushPos = new BlockPos(pos.getX(), y, pos.getZ());
                IBlockState toReplace = worldIn.getBlockState(bushPos);

                // only place if it is air or plant
                if(worldIn.isAirBlock(bushPos) || toReplace.getMaterial() == Material.PLANTS)
                {
                    if (WORLGEN_DEBUG) CraftGroovy.info("Placed " + flowerWorldGenType.blockState + " at " + bushPos + " and therefore replacing " + toReplace);
                    return worldIn.setBlockState(bushPos, flowerWorldGenType.blockState, 2);
                }else {
                    if (WORLGEN_DEBUG) CraftGroovy.info("Block obstructed, there is a " + toReplace + " at " + bushPos);
                }
            }else {
                if (WORLGEN_DEBUG) CraftGroovy.info("Wrong height: [" + y + "]");
            }
        }

        return false;
    }

    /**
     * Finds the first block where the flower can stay on
     * @param world
     * @param x
     * @param z
     * @return
     */
    public int getGroundFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        Block block = flowerWorldGenType.blockState.getBlock();
        while(!foundGround && y-- >= 0)
        {
            BlockPos checkPos = new BlockPos(x, y, z);
            if (world.isAirBlock(checkPos)) continue;
            if (block instanceof BlockBush){
                foundGround = ((BlockFlower) block).canBlockStay(world, checkPos.up(), flowerWorldGenType.blockState);
            }else {
                foundGround = flowerWorldGenType.whitelistedSoil.contains(world.getBlockState(checkPos));
            }
        }

        return y;
    }
}