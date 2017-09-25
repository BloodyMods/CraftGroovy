package atm.bloodworkxgaming.craftgroovy.wrappers

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

import javax.annotation.Nullable

@CompileStatic
class PItem extends ICGWrapper<Item> {
    PItem(Item internal) {
        super(internal)
    }

    @GSLWhitelistMember
    void setMaxStackSize(int maxStackSize) {
        internal.setMaxStackSize(maxStackSize)
    }

    @GSLWhitelistMember
    boolean getHasSubtypes() {
        return internal.getHasSubtypes()
    }

    @GSLWhitelistMember
    boolean isDamageable() {
        return internal.isDamageable()
    }

    @SideOnly(Side.CLIENT)
    @GSLWhitelistMember
    boolean isFull3D() {
        return internal.isFull3D()
    }

    @GSLWhitelistMember
    boolean isMap() {
        return internal.isMap()
    }

    @SideOnly(Side.CLIENT)
    @GSLWhitelistMember
    void addInformation(PItemStack stack, PWorld worldIn = null, List<String> tooltip, ITooltipFlag flagIn) {
        internal.addInformation(stack.getInternal(), worldIn?.internal , tooltip, flagIn)
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

    @Nullable
    @GSLWhitelistMember
    Entity createEntity(PWorld world, PEntity location, PItemStack itemstack) {
        return internal.createEntity(world.internal, location.internal, itemstack.internal)
    }

    @GSLWhitelistMember
    void setHarvestLevel(String toolClass, int level) {
        internal.setHarvestLevel(toolClass, level)
    }

    @GSLWhitelistMember
    String getRegistryName() {
        return internal.getRegistryName() == null ? "" : internal.getRegistryName().toString()
    }
}
