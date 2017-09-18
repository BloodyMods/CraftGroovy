package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class PBlock extends ICGWrapper<Block> {

    public PBlock(Block block) {
        super(block);
    }

    @GSLWhitelistMember
    public static int getIdFromBlock(Block blockIn) {
        return Block.getIdFromBlock(blockIn);
    }

    @GSLWhitelistMember
    public static int getStateId(IBlockState state) {
        return Block.getStateId(state);
    }

    @GSLWhitelistMember
    public static Block getBlockById(int id) {
        return Block.getBlockById(id);
    }

    @GSLWhitelistMember
    public static IBlockState getStateById(int id) {
        return Block.getStateById(id);
    }

    @GSLWhitelistMember
    public static Block getBlockFromItem(@Nullable Item itemIn) {
        return Block.getBlockFromItem(itemIn);
    }

    @Nullable
    @GSLWhitelistMember
    public static Block getBlockFromName(String name) {
        return Block.getBlockFromName(name);
    }

    @GSLWhitelistMember
    public PBlockState getDefaultState() {
        return new PBlockState(internal.getDefaultState());
    }

    @GSLWhitelistMember
    public boolean isBurning(IBlockAccess world, BlockPos pos) {
        return internal.isBurning(world, pos);
    }

    @GSLWhitelistMember
    public boolean isAir(IBlockState state, IBlockAccess world, BlockPos pos) {
        return internal.isAir(state, world, pos);
    }

    @GSLWhitelistMember
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return internal.isFlammable(world, pos, face);
    }

    @GSLWhitelistMember
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        return internal.isFireSource(world, pos, side);
    }

    @GSLWhitelistMember
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return internal.quantityDropped(state, fortune, random);
    }

    @GSLWhitelistMember
    public boolean isToolEffective(String type, IBlockState state) {
        return internal.isToolEffective(type, state);
    }

    @GSLWhitelistMember
    @Nullable
    public ResourceLocation getRegistryName() {
        return internal.getRegistryName();
    }

    @GSLWhitelistMember
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        internal.breakBlock(worldIn, pos, state);
    }

    @GSLWhitelistMember
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
        internal.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @GSLWhitelistMember
    public String getLocalizedName() {
        return internal.getLocalizedName();
    }

    @GSLWhitelistMember
    public String getUnlocalizedName() {
        return internal.getUnlocalizedName();
    }

    @GSLWhitelistMember
    public BlockStateContainer getBlockState() {
        return internal.getBlockState();
    }
}
