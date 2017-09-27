package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class PBlock extends ICGWrapper<Block> {

    public PBlock(Block block) {
        super(block);
    }

    /**
     * Gets the numeric ID of the Block
     *
     * @param blockIn block to get the ID from
     * @return ID of the Block
     */
    @GSLWhitelistMember
    public static int getIdFromBlock(PBlock blockIn) {
        return Block.getIdFromBlock(blockIn.getInternal());
    }

    /**
     * Get a unique ID for the given BlockState, containing both BlockID and metadata
     */
    @GSLWhitelistMember
    public static int getStateId(PBlockState state) {
        return Block.getStateId(state.getInternal());
    }

    @GSLWhitelistMember
    public static PBlock getBlockById(int id) {
        return new PBlock(Block.getBlockById(id));
    }

    @GSLWhitelistMember
    public static IBlockState getStateById(int id) {
        return Block.getStateById(id);
    }

    /**
     * Gets the Block of the Item
     *
     * @return returns empty {@link PBlock} if there is no Block for this item
     */
    @GSLWhitelistMember
    public static PBlock getBlockFromItem(@Nullable Item itemIn) {
        return new PBlock(Block.getBlockFromItem(itemIn));
    }

    @Nullable
    @GSLWhitelistMember
    public static PBlock getBlockFromName(String name) {
        Block block = Block.getBlockFromName(name);
        return block == null ? null : new PBlock(block);
    }

    @GSLWhitelistMember
    public PBlockState getDefaultState() {
        return new PBlockState(internal.getDefaultState());
    }

    /**
     * Determines if this block should set fire and deal fire damage
     * to entities coming into contact with it.
     *
     * @param world The current world
     * @param pos   Block position in world
     * @return True if the block should deal damage
     */
    @GSLWhitelistMember
    public boolean isBurning(IBlockAccess world, BlockPos pos) {
        return internal.isBurning(world, pos);
    }

    /**
     * Determines this block should be treated as an air block
     * by the rest of the code. This method is primarily
     * useful for creating pure logic-blocks that will be invisible
     * to the player and otherwise interact as air would.
     *
     * @param state The current state
     * @param world The current world
     * @param pos   Block position in world
     * @return True if the block considered air
     */
    @GSLWhitelistMember
    public boolean isAir(IBlockState state, IBlockAccess world, BlockPos pos) {
        return internal.isAir(state, world, pos);
    }

    /**
     * Called when fire is updating, checks if a block face can catch fire.
     *
     * @param world The current world
     * @param pos   Block position in world
     * @param face  The face that the fire is coming from
     * @return True if the face can be on fire, false otherwise.
     */
    @GSLWhitelistMember
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return internal.isFlammable(world, pos, face);
    }

    /**
     * Currently only called by fire when it is on top of this block.
     * Returning true will prevent the fire from naturally dying during updating.
     * Also prevents firing from dying from rain.
     *
     * @param world The current world
     * @param pos   Block position in world
     * @param side  The face that the fire is coming from
     * @return True if this block sustains fire, meaning it will never go out.
     */
    @GSLWhitelistMember
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        return internal.isFireSource(world, pos, side);
    }

    /**
     * State and fortune sensitive version, this replaces the old (int meta, Random rand)
     *
     * @param state   Current state
     * @param fortune Current item fortune level
     * @param random  Random number generator
     * @return The number of items to drop
     */
    @GSLWhitelistMember
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return internal.quantityDropped(state, fortune, random);
    }

    /**
     * Checks if the specified tool type is efficient on this block,
     * meaning that it digs at full speed.
     */
    @GSLWhitelistMember
    public boolean isToolEffective(String type, IBlockState state) {
        return internal.isToolEffective(type, state);
    }

    /**
     * Gets the Registry name of the Block
     *
     * @return String of the Registry Name
     */
    @GSLWhitelistMember
    public String getRegistryName() {
        return String.valueOf(internal.getRegistryName());
    }

    /**
     * Gets the localized name of this block. Used for the statistics page.
     */
    @GSLWhitelistMember
    public String getLocalizedName() {
        return internal.getLocalizedName();
    }

    /**
     * Returns the unlocalized name of the block with "tile." appended to the front.
     */
    @GSLWhitelistMember
    public String getUnlocalizedName() {
        return internal.getUnlocalizedName();
    }

    @GSLWhitelistMember
    public BlockStateContainer getBlockState() {
        return internal.getBlockState();
    }
}
