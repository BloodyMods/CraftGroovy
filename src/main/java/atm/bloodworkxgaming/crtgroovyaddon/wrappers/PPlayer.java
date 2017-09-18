package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import com.mojang.authlib.GameProfile;
import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.item.MCItemStack;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.FoodStats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.UUID;

public class PPlayer extends ICGWrapper<EntityPlayer>{

    public PPlayer(EntityPlayer player) {
        super(player);
    }

    @GSLWhitelistMember
    public IItemStack getHeldMain() {
        return new MCItemStack(internal.getHeldItem(EnumHand.MAIN_HAND));
    }

    @GSLWhitelistMember
    public IItemStack getHeldOffHand() {
        return new MCItemStack(internal.getHeldItem(EnumHand.OFF_HAND));
    }

    @GSLWhitelistMember
    public double getMotionX() {
        return internal.motionX;
    }

    @GSLWhitelistMember
    public double getMotionY() {
        return internal.motionY;
    }

    @GSLWhitelistMember
    public double getMotionZ() {
        return internal.motionZ;
    }

    @GSLWhitelistMember
    public String getDisplayName() {
        return internal.getDisplayNameString();
    }

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

    @GSLWhitelistMember
    public boolean isSneaking(){
        return internal.isSneaking();
    }

    @GSLWhitelistMember
    public void setSneaking(boolean sneaking) {
        internal.setSneaking(sneaking);
    }

    @GSLWhitelistMember
    public boolean isSprinting() {
        return internal.isSprinting();
    }

    @GSLWhitelistMember
    public boolean isGlowing() {
        return internal.isGlowing();
    }

    @GSLWhitelistMember
    public void setGlowing(boolean glowingIn) {
        internal.setGlowing(glowingIn);
    }

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

    @GSLWhitelistMember
    public void setDead() {
        internal.setDead();
    }

    @GSLWhitelistMember
    public boolean isUser() {
        return internal.isUser();
    }

    @GSLWhitelistMember
    public boolean isPlayerSleeping() {
        return internal.isPlayerSleeping();
    }

    @GSLWhitelistMember
    public boolean isPlayerFullyAsleep() {
        return internal.isPlayerFullyAsleep();
    }

    @SideOnly(Side.CLIENT)
    @GSLWhitelistMember
    public int getSleepTimer() {
        return internal.getSleepTimer();
    }

    @GSLWhitelistMember
    public PBlockPos getBedLocation() {
        return new PBlockPos(internal.getBedLocation());
    }

    @GSLWhitelistMember
    public void setSpawnPoint(PBlockPos pos, boolean forced) {
        internal.setSpawnPoint(pos.getInternal(), forced);
    }

    @GSLWhitelistMember
    public void jump() {
        internal.jump();
    }

    @GSLWhitelistMember
    public void fall(float distance, float damageMultiplier) {
        internal.fall(distance, damageMultiplier);
    }

    @GSLWhitelistMember
    public void addExperience(int amount) {
        internal.addExperience(amount);
    }

    @GSLWhitelistMember
    public int getXPSeed() {
        return internal.getXPSeed();
    }

    @GSLWhitelistMember
    public void addExperienceLevel(int levels) {
        internal.addExperienceLevel(levels);
    }

    @GSLWhitelistMember
    public int xpBarCap() {
        return internal.xpBarCap();
    }

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

    @GSLWhitelistMember
    public boolean shouldHeal() {
        return internal.shouldHeal();
    }

    @GSLWhitelistMember
    public String getName() {
        return internal.getName();
    }

    public InventoryEnderChest getInventoryEnderChest() {
        return internal.getInventoryEnderChest();
    }

    @GSLWhitelistMember
    public IItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
        return new MCItemStack(internal.getItemStackFromSlot(slotIn));
    }

    @GSLWhitelistMember //TODO: either with string param or make enum public
    public void setItemStackToSlot(EntityEquipmentSlot slotIn, IItemStack stack) {
        internal.setItemStackToSlot(slotIn, (ItemStack) stack.getInternal());
    }

    @GSLWhitelistMember
    public boolean isSpectator() {
        return internal.isSpectator();
    }

    @GSLWhitelistMember
    public boolean isCreative() {
        return internal.isCreative();
    }

    @GSLWhitelistMember
    public boolean isPushedByWater() {
        return internal.isPushedByWater();
    }

    public static UUID getUUID(GameProfile profile) {
        return EntityPlayer.getUUID(profile);
    }

    public static UUID getOfflineUUID(String username) {
        return EntityPlayer.getOfflineUUID(username);
    }

    @GSLWhitelistMember
    public boolean replaceItemInInventory(int inventorySlot, IItemStack itemStackIn) {
        return internal.replaceItemInInventory(inventorySlot, (ItemStack) itemStackIn.getInternal());
    }

    public EnumHandSide getPrimaryHand() {
        return internal.getPrimaryHand();
    }

    @GSLWhitelistMember
    public float getLuck() {
        return internal.getLuck();
    }

    @GSLWhitelistMember
    public void setHeldItem(EnumHand hand, IItemStack stack) {
        internal.setHeldItem(hand, (ItemStack) stack.getInternal());
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
    public boolean addItemStackToInventory(IItemStack itemStackIn)
    {
        return internal.inventory.add(-1, (ItemStack) itemStackIn.getInternal());
    }
}