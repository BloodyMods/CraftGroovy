package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class PEntityItem extends ICGWrapper<EntityItem> {

    public PEntityItem(EntityItem item) {
        super(item);
    }

    /**
     * sets the age of the item so that it'll despawn one minute after it has been dropped (instead of five). Used when
     * items are dropped from players in creative mode
     */
    @GSLWhitelistMember
    public void setAgeToCreativeDespawnTime() {
        internal.setAgeToCreativeDespawnTime();
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    @GSLWhitelistMember
    public String getName() {
        return internal.getName();
    }

    /**
     * Gets the item that this entity represents.
     */
    @GSLWhitelistMember
    public PItemStack getItem() {
        return new PItemStack(internal.getItem());
    }

    /**
     * Sets the item that this entity represents.
     *
     * @param stack
     */
    @GSLWhitelistMember
    public void setItem(ItemStack stack) {
        internal.setItem(stack);
    }

    @GSLWhitelistMember
    public String getOwner() {
        return internal.getOwner();
    }

    @GSLWhitelistMember
    public void setOwner(String owner) {
        internal.setOwner(owner);
    }

    @GSLWhitelistMember
    public String getThrower() {
        return internal.getThrower();
    }

    @GSLWhitelistMember
    public void setThrower(String thrower) {
        internal.setThrower(thrower);
    }

    @GSLWhitelistMember
    public void setDefaultPickupDelay() {
        internal.setDefaultPickupDelay();
    }

    @GSLWhitelistMember
    public void setNoPickupDelay() {
        internal.setNoPickupDelay();
    }

    @GSLWhitelistMember
    public void setInfinitePickupDelay() {
        internal.setInfinitePickupDelay();
    }

    @GSLWhitelistMember
    public void setPickupDelay(int ticks) {
        internal.setPickupDelay(ticks);
    }

    @GSLWhitelistMember
    public boolean cannotPickup() {
        return internal.cannotPickup();
    }

    @GSLWhitelistMember
    public void setNoDespawn() {
        internal.setNoDespawn();
    }

    @GSLWhitelistMember
    public void makeFakeItem() {
        internal.makeFakeItem();
    }

    /**
     * Get the position in the world. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return
     * the coordinates 0, 0, 0
     */
    @GSLWhitelistMember
    public BlockPos getPosition() {
        return internal.getPosition();
    }

    /**
     * Sets the position of the entity and updates the 'last' variables
     *
     * @param x
     * @param y
     * @param z
     */
    @GSLWhitelistMember
    public void setPositionAndUpdate(double x, double y, double z) {
        internal.setPositionAndUpdate(x, y, z);
    }
}
