package atm.bloodworkxgaming.craftgroovy.wrappers;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.util.PlayerUtil;
import com.mojang.authlib.GameProfile;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.FoodStats;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.UUID;

public class PPlayer extends AbstractICGWrapper<EntityPlayer> {

    public PPlayer(EntityPlayer player) {
        super(player);
    }

    public static UUID getUUID(GameProfile profile) {
        return EntityPlayer.getUUID(profile);
    }

    public static UUID getOfflineUUID(String username) {
        return EntityPlayer.getOfflineUUID(username);
    }

    /**
     * Gets the {@link PItemStack} held in the main Hand
     */
    @GSLWhitelistMember
    public PItemStack getHeldMain() {
        return new PItemStack(internal.getHeldItem(EnumHand.MAIN_HAND));
    }

    /**
     * Sets the {@link PItemStack} held in the main Hand
     */
    @GSLWhitelistMember
    public void setHeldMain(PItemStack heldMain) {
        internal.setHeldItem(EnumHand.MAIN_HAND, heldMain.getInternal());
    }

    /**
     * Gets the {@link PItemStack} held in the Offhand
     */
    @GSLWhitelistMember
    public PItemStack getHeldOffHand() {
        return new PItemStack(internal.getHeldItem(EnumHand.OFF_HAND));
    }

    /**
     * Sets the {@link PItemStack} held in the Offhand
     */
    @GSLWhitelistMember
    public void setHeldOffHand(PItemStack heldOff) {
        internal.setHeldItem(EnumHand.OFF_HAND, heldOff.getInternal());
    }

    /**
     * Entity motion X
     */
    @GSLWhitelistMember
    public double getMotionX() {
        return internal.motionX;
    }

    /**
     * Entity motion Y
     */
    @GSLWhitelistMember
    public double getMotionY() {
        return internal.motionY;
    }

    /**
     * Entity motion Z
     */
    @GSLWhitelistMember
    public double getMotionZ() {
        return internal.motionZ;
    }

    /**
     * Get the currently computed display name, cached for efficiency.
     *
     * @return the current display name
     */
    @GSLWhitelistMember
    public String getDisplayName() {
        return internal.getDisplayNameString();
    }

    /**
     * Sets the player's game mode and sends it to them.
     *
     * @param type String of the gametype Name
     *             [survival, creative, adventure, spectator]
     */
    @GSLWhitelistMember
    public void setGameType(String type) {
        switch (type.toLowerCase()) {
            case "survival":
                internal.setGameType(GameType.SURVIVAL);
                break;
            case "creative":
                internal.setGameType(GameType.CREATIVE);
                break;
            case "adventure":
                internal.setGameType(GameType.ADVENTURE);
                break;
            case "spectator":
                internal.setGameType(GameType.SPECTATOR);
                break;
            default:
                break;
        }
    }

    /**
     * Sets the player's game mode and sends it to them.
     *
     * @param type EnumValue of the GameType
     */
    @GSLWhitelistMember
    public void setGameType(GameType type) {
        internal.setGameType(type);
    }

    /**
     * Returns if this Player is sneaking.
     */
    @GSLWhitelistMember
    public boolean isSneaking() {
        return internal.isSneaking();
    }

    /**
     * Sets the sneaking flag.
     */
    @GSLWhitelistMember
    public void setSneaking(boolean sneaking) {
        internal.setSneaking(sneaking);
    }

    /**
     * Get if the Player is sprinting.
     */
    @GSLWhitelistMember
    public boolean isSprinting() {
        return internal.isSprinting();
    }

    /**
     * Get if the Player is glowing.
     */
    @GSLWhitelistMember
    public boolean isGlowing() {
        return internal.isGlowing();
    }

    /**
     * Set if the Player is glowing.
     */
    @GSLWhitelistMember
    public void setGlowing(boolean glowingIn) {
        internal.setGlowing(glowingIn);
    }

    /**
     * Get if the Player is invisible.
     */
    @GSLWhitelistMember
    public boolean isInvisible() {
        return internal.isInvisible();
    }

    @Nullable
    public EntityItem dropItem(boolean dropAll) {
        return internal.dropItem(dropAll);
    }

    @Nullable
    public EntityItem dropItem(ItemStack itemStackIn, boolean unused) {
        return internal.dropItem(itemStackIn, unused);
    }

    @Nullable
    public EntityItem dropItem(ItemStack droppedItem, boolean dropAround, boolean traceItem) {
        return internal.dropItem(droppedItem, dropAround, traceItem);
    }

    public ItemStack dropItemAndGetStack(EntityItem p_184816_1_) {
        return internal.dropItemAndGetStack(p_184816_1_);
    }

    /**
     * Will get destroyed next tick.
     */
    @GSLWhitelistMember
    public void setDead() {
        internal.setDead();
    }

    /**
     * returns true if this is an EntityPlayerSP, or the logged in player.
     */
    @GSLWhitelistMember
    public boolean isUser() {
        return internal.isUser();
    }

    /**
     * Returns whether player is sleeping or not
     */
    @GSLWhitelistMember
    public boolean isPlayerSleeping() {
        return internal.isPlayerSleeping();
    }

    /**
     * Returns whether or not the player is asleep and the screen has fully faded.
     */
    @GSLWhitelistMember
    public boolean isPlayerFullyAsleep() {
        return internal.isPlayerFullyAsleep();
    }

    /*@SideOnly(Side.CLIENT)
    public int getSleepTimer() {
        return internal.getSleepTimer();
    }*/

    /**
     * Gets the Location of the Bed
     */
    @GSLWhitelistMember
    public PBlockPos getBedLocation() {
        return new PBlockPos(internal.getBedLocation());
    }

    /**
     * Sets the Spawn Point of the Player
     *
     * @param pos    position of the Spawnpoint
     * @param forced whether to force or not spawning exactly there (I think)
     */
    @GSLWhitelistMember
    public void setSpawnPoint(PBlockPos pos, boolean forced) {
        internal.setSpawnPoint(pos.getInternal(), forced);
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    @GSLWhitelistMember
    public void jump() {
        internal.jump();
    }

    @GSLWhitelistMember
    public void fall(float distance, float damageMultiplier) {
        internal.fall(distance, damageMultiplier);
    }

    /**
     * Add experience points to player.
     */
    @GSLWhitelistMember
    public void addExperience(int amount) {
        internal.addExperience(amount);
    }

    /**
     * Add experience levels to this player.
     */
    @GSLWhitelistMember
    public void addExperienceLevel(int levels) {
        internal.addExperienceLevel(levels);
    }

    /**
     * This method returns the cap amount of experience that the experience bar can hold. With each level, the
     * experience cap on the player's experience bar is raised by 10.
     */
    @GSLWhitelistMember
    public int xpBarCap() {
        return internal.xpBarCap();
    }

    /**
     * increases exhaustion level by supplied amount
     */
    @GSLWhitelistMember
    public void addExhaustion(float exhaustion) {
        internal.addExhaustion(exhaustion);
    }

    public FoodStats getFoodStats() {
        return internal.getFoodStats();
    }

    @GSLWhitelistMember
    public boolean canEat(boolean ignoreHunger) {
        return internal.canEat(ignoreHunger);
    }

    /**
     * Checks if the player's health is not full and not zero.
     */
    @GSLWhitelistMember
    public boolean shouldHeal() {
        return internal.shouldHeal();
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    @GSLWhitelistMember
    public String getName() {
        return internal.getName();
    }

    public InventoryEnderChest getInventoryEnderChest() {
        return internal.getInventoryEnderChest();
    }

    /**
     * Gets the {@link PItemStack} from the given Armor or equipment slot
     *
     * @param slotIn Slot to get Item from
     */
    @GSLWhitelistMember
    public PItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
        return new PItemStack(internal.getItemStackFromSlot(slotIn));
    }

    /**
     * Sets the {@link PItemStack} for the given Armor or equipment slot
     *
     * @param slotIn Slot to set Item
     */
    @GSLWhitelistMember
    public void setItemStackToSlot(EntityEquipmentSlot slotIn, PItemStack stack) {
        internal.setItemStackToSlot(slotIn, stack.getInternal());
    }

    /**
     * Returns true if the player is in spectator mode.
     */
    @GSLWhitelistMember
    public boolean isSpectator() {
        return internal.isSpectator();
    }

    /**
     * Returns true if the player is in creative mode.
     */
    @GSLWhitelistMember
    public boolean isCreative() {
        return internal.isCreative();
    }

    @GSLWhitelistMember
    public boolean isPushedByWater() {
        return internal.isPushedByWater();
    }

    @GSLWhitelistMember
    public boolean replaceItemInInventory(int inventorySlot, PItemStack itemStackIn) {
        return internal.replaceItemInInventory(inventorySlot, itemStackIn.getInternal());
    }

    @GSLWhitelistMember
    public float getLuck() {
        return internal.getLuck();
    }

    @GSLWhitelistMember
    public void setHeldItem(EnumHand hand, PItemStack stack) {
        internal.setHeldItem(hand, stack.getInternal());
    }

    @SideOnly(Side.CLIENT)
    @GSLWhitelistMember
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        internal.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, teleport);
    }

    @GSLWhitelistMember
    public boolean attackable() {
        return internal.attackable();
    }

    @GSLWhitelistMember
    public int getEntityId() {
        return internal.getEntityId();
    }

    @GSLWhitelistMember
    public void setDropItemsWhenDead(boolean dropWhenDead) {
        internal.setDropItemsWhenDead(dropWhenDead);
    }

    @SideOnly(Side.CLIENT)
    @GSLWhitelistMember
    public void turn(float yaw, float pitch) {
        internal.turn(yaw, pitch);
    }

    @GSLWhitelistMember
    public void setFire(int seconds) {
        internal.setFire(seconds);
    }

    @GSLWhitelistMember
    public void extinguish() {
        internal.extinguish();
    }

    @GSLWhitelistMember
    public boolean hasNoGravity() {
        return internal.hasNoGravity();
    }

    @GSLWhitelistMember
    public void setNoGravity(boolean noGravity) {
        internal.setNoGravity(noGravity);
    }

    @GSLWhitelistMember
    public boolean isWet() {
        return internal.isWet();
    }

    @GSLWhitelistMember
    public boolean isInWater() {
        return internal.isInWater();
    }

    @GSLWhitelistMember
    public boolean isOverWater() {
        return internal.isOverWater();
    }

    @GSLWhitelistMember
    public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
        internal.setPositionAndRotation(x, y, z, yaw, pitch);
    }

    public Vec3d getLookVec() {
        return internal.getLookVec();
    }

    @SideOnly(Side.CLIENT)
    public Vec3d getForward() {
        return internal.getForward();
    }

    @GSLWhitelistMember
    public boolean isBurning() {
        return internal.isBurning();
    }

    @GSLWhitelistMember
    public boolean isRiding() {
        return internal.isRiding();
    }

    @GSLWhitelistMember
    public boolean isBeingRidden() {
        return internal.isBeingRidden();
    }

    @GSLWhitelistMember
    public boolean addItemStackToInventory(PItemStack itemStackIn) {
        return internal.inventory.add(-1, itemStackIn.getInternal());
    }

    @GSLWhitelistMember
    public void sendStatusMessage(String message, boolean actionBar) {
        internal.sendStatusMessage(new TextComponentString(message), actionBar);
    }

    /**
     * Send a chat message to the CommandSender
     * @param message
     */
    @GSLWhitelistMember
    public void sendMessage(String message) {
        internal.sendMessage(new TextComponentString(message));
    }

    @GSLWhitelistMember
    public PNBTTagCompound getPersistentNBT(){
        return new PNBTTagCompound(PlayerUtil.getPersistedTag(internal, CraftGroovy.MODID));
    }
}