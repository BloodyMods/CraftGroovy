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

public class PPlayer {

    private EntityPlayer player;

    public PPlayer(EntityPlayer player) {
        this.player = player;
    }

    @GSLWhitelistMember
    public IItemStack getHeldMain() {
        return new MCItemStack(player.getHeldItem(EnumHand.MAIN_HAND));
    }

    @GSLWhitelistMember
    public IItemStack getHeldOffHand() {
        return new MCItemStack(player.getHeldItem(EnumHand.OFF_HAND));
    }

    @GSLWhitelistMember
    public double getMotionX() {
        return player.motionX;
    }

    @GSLWhitelistMember
    public double getMotionY() {
        return player.motionY;
    }

    @GSLWhitelistMember
    public double getMotionZ() {
        return player.motionZ;
    }

    @GSLWhitelistMember
    public String getDisplayName() {
        return player.getDisplayNameString();
    }

    @GSLWhitelistMember
    public void setGameType(String type) {
        switch (type.toLowerCase()) {
            case "survival":
                player.setGameType(GameType.SURVIVAL);
                break;
            case "creative":
                player.setGameType(GameType.CREATIVE);
                break;
            case "adventure":
                player.setGameType(GameType.ADVENTURE);
                break;
            case "spectator":
                player.setGameType(GameType.SPECTATOR);
                break;
            default:
                break;
        }
    }

    @GSLWhitelistMember
    public boolean isSneaking(){
        return player.isSneaking();
    }

    public void setSneaking(boolean sneaking) {
        player.setSneaking(sneaking);
    }

    public boolean isSprinting() {
        return player.isSprinting();
    }

    public boolean isGlowing() {
        return player.isGlowing();
    }

    public void setGlowing(boolean glowingIn) {
        player.setGlowing(glowingIn);
    }

    public boolean isInvisible() {
        return player.isInvisible();
    }

    @Nullable
    public EntityItem dropItem(boolean dropAll) {
        return player.dropItem(dropAll);
    }

    @Nullable
    public EntityItem dropItem(ItemStack itemStackIn, boolean unused) {
        return player.dropItem(itemStackIn, unused);
    }

    @Nullable
    public EntityItem dropItem(ItemStack droppedItem, boolean dropAround, boolean traceItem) {
        return player.dropItem(droppedItem, dropAround, traceItem);
    }

    public ItemStack dropItemAndGetStack(EntityItem p_184816_1_) {
        return player.dropItemAndGetStack(p_184816_1_);
    }

    public void setDead() {
        player.setDead();
    }

    public boolean isUser() {
        return player.isUser();
    }

    public boolean isPlayerSleeping() {
        return player.isPlayerSleeping();
    }

    public boolean isPlayerFullyAsleep() {
        return player.isPlayerFullyAsleep();
    }

    @SideOnly(Side.CLIENT)
    public int getSleepTimer() {
        return player.getSleepTimer();
    }

    public BlockPos getBedLocation() {
        return player.getBedLocation();
    }

    public void setSpawnPoint(BlockPos pos, boolean forced) {
        player.setSpawnPoint(pos, forced);
    }

    public void jump() {
        player.jump();
    }

    public void fall(float distance, float damageMultiplier) {
        player.fall(distance, damageMultiplier);
    }

    public void addExperience(int amount) {
        player.addExperience(amount);
    }

    public int getXPSeed() {
        return player.getXPSeed();
    }

    public void addExperienceLevel(int levels) {
        player.addExperienceLevel(levels);
    }

    public int xpBarCap() {
        return player.xpBarCap();
    }

    public void addExhaustion(float exhaustion) {
        player.addExhaustion(exhaustion);
    }

    public FoodStats getFoodStats() {
        return player.getFoodStats();
    }

    public boolean canEat(boolean ignoreHunger) {
        return player.canEat(ignoreHunger);
    }

    public boolean shouldHeal() {
        return player.shouldHeal();
    }

    public String getName() {
        return player.getName();
    }

    public InventoryEnderChest getInventoryEnderChest() {
        return player.getInventoryEnderChest();
    }

    public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
        return player.getItemStackFromSlot(slotIn);
    }

    public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
        player.setItemStackToSlot(slotIn, stack);
    }

    public boolean isSpectator() {
        return player.isSpectator();
    }

    public boolean isCreative() {
        return player.isCreative();
    }

    public boolean isPushedByWater() {
        return player.isPushedByWater();
    }

    public static UUID getUUID(GameProfile profile) {
        return EntityPlayer.getUUID(profile);
    }

    public static UUID getOfflineUUID(String username) {
        return EntityPlayer.getOfflineUUID(username);
    }

    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
        return player.replaceItemInInventory(inventorySlot, itemStackIn);
    }

    public EnumHandSide getPrimaryHand() {
        return player.getPrimaryHand();
    }

    public float getLuck() {
        return player.getLuck();
    }

    public void setHeldItem(EnumHand hand, ItemStack stack) {
        player.setHeldItem(hand, stack);
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        player.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, teleport);
    }

    public boolean attackable() {
        return player.attackable();
    }

    public int getEntityId() {
        return player.getEntityId();
    }

    public void setDropItemsWhenDead(boolean dropWhenDead) {
        player.setDropItemsWhenDead(dropWhenDead);
    }

    @SideOnly(Side.CLIENT)
    public void turn(float yaw, float pitch) {
        player.turn(yaw, pitch);
    }

    public void setFire(int seconds) {
        player.setFire(seconds);
    }

    public void extinguish() {
        player.extinguish();
    }

    public boolean hasNoGravity() {
        return player.hasNoGravity();
    }

    public void setNoGravity(boolean noGravity) {
        player.setNoGravity(noGravity);
    }

    public boolean isWet() {
        return player.isWet();
    }

    public boolean isInWater() {
        return player.isInWater();
    }

    public boolean isOverWater() {
        return player.isOverWater();
    }

    public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
        player.setPositionAndRotation(x, y, z, yaw, pitch);
    }

    public Vec3d getLookVec() {
        return player.getLookVec();
    }

    @SideOnly(Side.CLIENT)
    public Vec3d getForward() {
        return player.getForward();
    }

    public boolean isBurning() {
        return player.isBurning();
    }

    public boolean isRiding() {
        return player.isRiding();
    }

    public boolean isBeingRidden() {
        return player.isBeingRidden();
    }
}