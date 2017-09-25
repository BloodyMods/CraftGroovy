package atm.bloodworkxgaming.craftgroovy.wrappers

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistConstructor
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.item.EnumAction
import net.minecraft.item.EnumRarity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.ITextComponent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@GSLWhitelistConstructor
@GSLWhitelistClass
@CompileStatic
class PItemStack extends ICGWrapper<ItemStack> {
    PItemStack(ItemStack internal) {
        super(internal)
    }

    PItemStack(String name, int meta = 0) {
        super(new ItemStack(Item.getByNameOrId(name), 1, meta))
    }

    PItemStack(Item item, int meta = 0) {
        super(new ItemStack(item, meta))
    }

    static boolean areItemStackTagsEqual(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemStackTagsEqual(stackA, stackB)
    }

    static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemStacksEqual(stackA, stackB)
    }

    static boolean areItemsEqual(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemsEqual(stackA, stackB)
    }

    static boolean areItemsEqualIgnoreDurability(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemsEqualIgnoreDurability(stackA, stackB)
    }

    static boolean areItemStacksEqualUsingNBTShareTag(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemStacksEqualUsingNBTShareTag(stackA, stackB)
    }

    static boolean areItemStackShareTagsEqual(ItemStack stackA, ItemStack stackB) {
        return ItemStack.areItemStackShareTagsEqual(stackA, stackB)
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
    String getIdentifier(){
        ResourceLocation reg = internal.getItem().getRegistryName()
        return (reg == null ? "INVALID_NAME" : reg.toString()) + ":" + getMetadata()
    }

    @GSLWhitelistMember
    PItemStack multiply(int amount){
        internal.setCount(amount)
        return this
    }

    @GSLWhitelistMember
    void next(){
        internal.grow(1)
    }

    @GSLWhitelistMember
    void previous(){
        internal.shrink(1)
    }
}
