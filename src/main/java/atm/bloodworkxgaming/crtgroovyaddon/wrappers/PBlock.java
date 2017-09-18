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
    public static int getIdFromBlock(PBlock blockIn) {
        return Block.getIdFromBlock(blockIn.getInternal());
    }

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

    @GSLWhitelistMember
    public static PBlock getBlockFromItem(@Nullable Item itemIn) {
        return new PBlock(Block.getBlockFromItem(itemIn));
    }

    @Nullable
    @GSLWhitelistMember
    public static PBlock getBlockFromName(String name) {
        return new PBlock(Block.getBlockFromName(name));
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
    public String getRegistryName() {
        return String.valueOf(internal.getRegistryName());
    }

    @GSLWhitelistMember
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        internal.breakBlock(worldIn, pos, state);
    }

    public void harvestBlock(World worldIn, PPlayer player, PBlockPos pos, PBlockState state, @Nullable TileEntity te, ItemStack stack) {
        internal.harvestBlock(worldIn, player.getInternal(), pos.getInternal(), state.getInternal(), te, stack);
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
