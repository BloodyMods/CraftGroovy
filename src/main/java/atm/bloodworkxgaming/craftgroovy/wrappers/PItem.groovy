package atm.bloodworkxgaming.craftgroovy.wrappers

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

import javax.annotation.Nullable

@CompileStatic
class PItem extends AbstractICGWrapper<Item> {
    PItem(Item internal) {
        super(internal)
    }

    /** Maximum size of the stack. */
    @GSLWhitelistMember
    void setMaxStackSize(int maxStackSize) {
        internal.setMaxStackSize(maxStackSize)
    }

    /**
     * Some items (like dyes) have multiple subtypes on same item,
     * this is the function to check for that
     */

    @GSLWhitelistMember
    boolean getHasSubtypes() {
        return internal.getHasSubtypes()
    }

    @GSLWhitelistMember
    boolean isDamageable() {
        return internal.isDamageable()
    }

    @GSLWhitelistMember
    boolean isFull3D() {
        return FMLCommonHandler.instance().getSide().isClient() && internal.isFull3D()
    }

    @GSLWhitelistMember
    boolean isMap() {
        return internal.isMap()
    }

    @SideOnly(Side.CLIENT)
    @GSLWhitelistMember
    void addInformation(PItemStack stack, PWorld worldIn = null, List<String> tooltip, ITooltipFlag flagIn) {
        internal.addInformation(stack.getInternal(), worldIn?.internal, tooltip, flagIn)
    }

    @GSLWhitelistMember
    int getItemEnchantability() {
        return internal.getItemEnchantability()
    }

    @Nullable
    CreativeTabs getCreativeTab() {
        return internal.getCreativeTab()
    }

    Item setCreativeTab(CreativeTabs tab) {
        return internal.setCreativeTab(tab)
    }

    @GSLWhitelistMember
    boolean isRepairable() {
        return internal.isRepairable()
    }

    @GSLWhitelistMember
    Item setNoRepair() {
        return internal.setNoRepair()
    }

    @GSLWhitelistMember
    void setHarvestLevel(String toolClass, int level) {
        internal.setHarvestLevel(toolClass, level)
    }

    /**
     * Gets the Registry name of the Block
     *
     * @return String of the Registry Name
     */
    @GSLWhitelistMember
    String getRegistryName() {
        return internal.getRegistryName() == null ? "" : internal.getRegistryName().toString()
    }

    @GSLWhitelistMember
    PItemStack asStack(int value = 0){
        return new PItemStack(this.internal, value)
    }

    @GSLWhitelistMember
    PItemStack power(int value) {
        return asStack(value)
    }
}
