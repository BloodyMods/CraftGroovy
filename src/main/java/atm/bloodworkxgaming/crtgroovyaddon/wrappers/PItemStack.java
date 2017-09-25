package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistConstructor;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GSLWhitelistConstructor
@GSLWhitelistClass
public class PItemStack extends ICGWrapper<ItemStack> {
    public PItemStack(ItemStack internal) {
        super(internal);
    }

    public static boolean areItemStackTagsEqual(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemStackTagsEqual(stackA, stackB);
    }

    public static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemStacksEqual(stackA, stackB);
    }

    public static boolean areItemsEqual(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemsEqual(stackA, stackB);
    }

    public static boolean areItemsEqualIgnoreDurability(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemsEqualIgnoreDurability(stackA, stackB);
    }

    public static boolean areItemStacksEqualUsingNBTShareTag(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemStacksEqualUsingNBTShareTag(stackA, stackB);
    }

    public static boolean areItemStackShareTagsEqual(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemStackShareTagsEqual(stackA, stackB);
    }

    @GSLWhitelistMember
    public boolean isEmpty() {
        return internal.isEmpty();
    }

    @GSLWhitelistMember
    public PItemStack splitStack(int amount) {
        return new PItemStack(internal.splitStack(amount));
    }

    @GSLWhitelistMember
    public PItem getItem() {
        return new PItem(internal.getItem());
    }

    @GSLWhitelistMember
    public float getStrVsBlock(PBlockState blockIn) {
        return internal.getStrVsBlock(blockIn.getInternal());
    }

    @GSLWhitelistMember
    public int getMaxStackSize() {
        return internal.getMaxStackSize();
    }

    @GSLWhitelistMember
    public boolean isStackable() {
        return internal.isStackable();
    }

    @GSLWhitelistMember
    public boolean isItemStackDamageable() {
        return internal.isItemStackDamageable();
    }

    @GSLWhitelistMember
    public boolean getHasSubtypes() {
        return internal.getHasSubtypes();
    }

    @GSLWhitelistMember
    public boolean isItemDamaged() {
        return internal.isItemDamaged();
    }

    @GSLWhitelistMember
    public int getItemDamage() {
        return internal.getItemDamage();
    }

    @GSLWhitelistMember
    public void setItemDamage(int meta) {
        internal.setItemDamage(meta);
    }

    @GSLWhitelistMember
    public int getMetadata() {
        return internal.getMetadata();
    }

    @GSLWhitelistMember
    public int getMaxDamage() {
        return internal.getMaxDamage();
    }

    @GSLWhitelistMember
    public PItemStack copy() {
        return new PItemStack(internal.copy());
    }

    @GSLWhitelistMember
    public boolean isItemEqual(PItemStack other) {
        return internal.isItemEqual(other.getInternal());
    }

    public boolean isItemEqualIgnoreDurability(PItemStack stack) {
        return internal.isItemEqualIgnoreDurability(stack.getInternal());
    }

    @GSLWhitelistMember
    public String getUnlocalizedName() {
        return internal.getUnlocalizedName();
    }

    @GSLWhitelistMember
    public int getMaxItemUseDuration() {
        return internal.getMaxItemUseDuration();
    }

    @GSLWhitelistMember
    public EnumAction getItemUseAction() {
        return internal.getItemUseAction();
    }

    @SideOnly(Side.CLIENT)
    @GSLWhitelistMember
    public boolean hasEffect() {
        return internal.hasEffect();
    }

    public EnumRarity getRarity() {
        return internal.getRarity();
    }

    @GSLWhitelistMember
    public boolean isItemEnchantable() {
        return internal.isItemEnchantable();
    }

    @GSLWhitelistMember
    public int getRepairCost() {
        return internal.getRepairCost();
    }

    @GSLWhitelistMember
    public void setRepairCost(int cost) {
        internal.setRepairCost(cost);
    }

    public ITextComponent getTextComponent() {
        return internal.getTextComponent();
    }

    @GSLWhitelistMember
    public int getCount() {
        return internal.getCount();
    }

    @GSLWhitelistMember
    public void setCount(int size) {
        internal.setCount(size);
    }

    @GSLWhitelistMember
    public void grow(int quantity) {
        internal.grow(quantity);
    }

    @GSLWhitelistMember
    public void shrink(int quantity) {
        internal.shrink(quantity);
    }
}
