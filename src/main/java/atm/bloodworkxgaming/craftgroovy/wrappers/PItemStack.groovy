package atm.bloodworkxgaming.craftgroovy.wrappers

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistConstructor
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.item.EnumAction
import net.minecraft.item.EnumRarity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.JsonToNBT
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.ITextComponent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@GSLWhitelistConstructor
@GSLWhitelistClass
@CompileStatic
class PItemStack extends AbstractICGWrapper<ItemStack> {
    PItemStack(ItemStack internal) {
        super(internal)
    }

    PItemStack(String name, int meta = 0) {
        super(new ItemStack(Item.getByNameOrId(name), 1, meta))
    }

    PItemStack(Item item, int meta = 0) {
        super(new ItemStack(item, 1, meta))
    }

    @GSLWhitelistMember
    static boolean areItemStackTagsEqual(PItemStack stackA, PItemStack stackB) {
        return ItemStack.areItemStackTagsEqual(stackA.internal, stackB.internal)
    }

    @GSLWhitelistMember
    static boolean areItemStacksEqual(PItemStack stackA, PItemStack stackB) {
        return ItemStack.areItemStacksEqual(stackA.internal, stackB.internal)
    }

    @GSLWhitelistMember
    static boolean areItemsEqual(PItemStack stackA, PItemStack stackB) {
        return ItemStack.areItemsEqual(stackA.internal, stackB.internal)
    }

    @GSLWhitelistMember
    static boolean areItemsEqualIgnoreDurability(PItemStack stackA, PItemStack stackB) {
        return ItemStack.areItemsEqualIgnoreDurability(stackA.internal, stackB.internal)
    }

    @GSLWhitelistMember
    static boolean areItemStacksEqualUsingNBTShareTag(PItemStack stackA, PItemStack stackB) {
        return ItemStack.areItemStacksEqualUsingNBTShareTag(stackA.internal, stackB.internal)
    }

    @GSLWhitelistMember
    static boolean areItemStackShareTagsEqual(PItemStack stackA, PItemStack stackB) {
        return ItemStack.areItemStackShareTagsEqual(stackA.internal, stackB.internal)
    }

    @GSLWhitelistMember
    boolean isEmpty() {
        return internal.isEmpty()
    }

    @GSLWhitelistMember
    PItemStack splitStack(int amount) {
        return new PItemStack(internal.splitStack(amount))
    }

    @GSLWhitelistMember
    PItem getItem() {
        return new PItem(internal.getItem())
    }

    @GSLWhitelistMember
    float getStrVsBlock(PBlockState blockIn) {
        return internal.getStrVsBlock(blockIn.getInternal())
    }

    @GSLWhitelistMember
    int getMaxStackSize() {
        return internal.getMaxStackSize()
    }

    @GSLWhitelistMember
    boolean isStackable() {
        return internal.isStackable()
    }

    @GSLWhitelistMember
    boolean isItemStackDamageable() {
        return internal.isItemStackDamageable()
    }

    @GSLWhitelistMember
    boolean getHasSubtypes() {
        return internal.getHasSubtypes()
    }

    @GSLWhitelistMember
    boolean isItemDamaged() {
        return internal.isItemDamaged()
    }

    @GSLWhitelistMember
    int getItemDamage() {
        return internal.getItemDamage()
    }

    @GSLWhitelistMember
    void setItemDamage(int meta) {
        internal.setItemDamage(meta)
    }

    @GSLWhitelistMember
    int getMetadata() {
        return internal.getMetadata()
    }

    @GSLWhitelistMember
    int getMaxDamage() {
        return internal.getMaxDamage()
    }

    @GSLWhitelistMember
    PItemStack copy() {
        return new PItemStack(internal.copy())
    }

    @GSLWhitelistMember
    boolean isItemEqual(PItemStack other) {
        return internal.isItemEqual(other.getInternal())
    }

    boolean isItemEqualIgnoreDurability(PItemStack stack) {
        return internal.isItemEqualIgnoreDurability(stack.getInternal())
    }

    @GSLWhitelistMember
    String getUnlocalizedName() {
        return internal.getUnlocalizedName()
    }

    @GSLWhitelistMember
    int getMaxItemUseDuration() {
        return internal.getMaxItemUseDuration()
    }

    @GSLWhitelistMember
    EnumAction getItemUseAction() {
        return internal.getItemUseAction()
    }

    @SideOnly(Side.CLIENT)
    @GSLWhitelistMember
    boolean hasEffect() {
        return internal.hasEffect()
    }

    @GSLWhitelistMember
    EnumRarity getRarity() {
        return internal.getRarity()
    }

    @GSLWhitelistMember
    boolean isItemEnchantable() {
        return internal.isItemEnchantable()
    }

    @GSLWhitelistMember
    int getRepairCost() {
        return internal.getRepairCost()
    }

    @GSLWhitelistMember
    void setRepairCost(int cost) {
        internal.setRepairCost(cost)
    }

    ITextComponent getTextComponent() {
        return internal.getTextComponent()
    }

    @GSLWhitelistMember
    int getCount() {
        return internal.getCount()
    }

    @GSLWhitelistMember
    void setCount(int size) {
        internal.setCount(size)
    }

    @GSLWhitelistMember
    void grow(int quantity) {
        internal.grow(quantity)
    }

    @GSLWhitelistMember
    void shrink(int quantity) {
        internal.shrink(quantity)
    }

    @GSLWhitelistMember
    String getDisplayName() {
        return internal.getDisplayName()
    }

    /**
     * Returns the registryname:meta
     * eg: minecraft:wool:3
     */
    @GSLWhitelistMember
    String getIdentifier() {
        ResourceLocation reg = internal.getItem().getRegistryName()
        return (reg == null ? "INVALID_NAME" : reg.toString()) + ":" + getMetadata()
    }

    @GSLWhitelistMember
    PItemStack multiply(int amount) {
        internal.setCount(amount)
        return this
    }

    @GSLWhitelistMember
    void next() {
        internal.grow(1)
    }

    @GSLWhitelistMember
    void previous() {
        internal.shrink(1)
    }

    @GSLWhitelistMember
    PItemStack setNBT(String nbtString){
        internal.setTagCompound(JsonToNBT.getTagFromJson(nbtString))
        return this
    }
}
