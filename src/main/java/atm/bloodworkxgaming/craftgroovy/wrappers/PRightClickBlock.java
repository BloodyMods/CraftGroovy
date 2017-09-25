package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PRightClickBlock extends ICGWrapper<PlayerInteractEvent.RightClickBlock> {

    public PRightClickBlock(PlayerInteractEvent.RightClickBlock internal) {
        super(internal);
    }

    public Vec3d getHitVec() {
        return internal.getHitVec();
    }

    public Event.Result getUseBlock() {
        return internal.getUseBlock();
    }

    public void setUseBlock(Event.Result triggerBlock) {
        internal.setUseBlock(triggerBlock);
    }

    public Event.Result getUseItem() {
        return internal.getUseItem();
    }

    public void setUseItem(Event.Result triggerItem) {
        internal.setUseItem(triggerItem);
    }

    public void setCanceled(boolean canceled) {
        internal.setCanceled(canceled);
    }

    @Nonnull
    public EnumHand getHand() {
        return internal.getHand();
    }

    @GSLWhitelistMember
    public PItemStack getItemStack() {
        return new PItemStack(internal.getItemStack());
    }

    @Nonnull
    @GSLWhitelistMember
    public PBlockPos getPos() {
        return new PBlockPos(internal.getPos());
    }

    @Nullable
    public EnumFacing getFace() {
        return internal.getFace();
    }

    @GSLWhitelistMember
    public PWorld getWorld() {
        return new PWorld(internal.getWorld());
    }

    public Side getSide() {
        return internal.getSide();
    }

    public EnumActionResult getCancellationResult() {
        return internal.getCancellationResult();
    }

    public void setCancellationResult(EnumActionResult result) {
        internal.setCancellationResult(result);
    }

    @GSLWhitelistMember
    public PPlayer getPlayer() {
        return new PPlayer(internal.getEntityPlayer());
    }

    public EntityLivingBase getEntityLiving() {
        return internal.getEntityLiving();
    }

    public Entity getEntity() {
        return internal.getEntity();
    }


}
