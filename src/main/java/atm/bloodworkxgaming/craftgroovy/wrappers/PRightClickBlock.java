package atm.bloodworkxgaming.craftgroovy.wrappers;

import atm.bloodworkxgaming.craftgroovy.delegate.MCInWorldObjects;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import javax.annotation.Nullable;

public class PRightClickBlock extends ICGWrapper<PlayerInteractEvent.RightClickBlock> implements MCInWorldObjects {

    public PRightClickBlock(PlayerInteractEvent.RightClickBlock internal) {
        super(internal);
    }

    public Vec3d getHitVec() {
        return internal.getHitVec();
    }

    @GSLWhitelistMember
    public Event.Result getUseBlock() {
        return internal.getUseBlock();
    }

    @GSLWhitelistMember
    public void setUseBlock(Event.Result triggerBlock) {
        internal.setUseBlock(triggerBlock);
    }

    @GSLWhitelistMember
    public Event.Result getUseItem() {
        return internal.getUseItem();
    }

    @GSLWhitelistMember
    public void setUseItem(Event.Result triggerItem) {
        internal.setUseItem(triggerItem);
    }

    @GSLWhitelistMember
    public EnumHand getHand() {
        return internal.getHand();
    }

    @GSLWhitelistMember
    public PItemStack getItemStack() {
        return new PItemStack(internal.getItemStack());
    }

    @GSLWhitelistMember
    public PBlockPos getPos() {
        return new PBlockPos(internal.getPos());
    }

    @Nullable
    @GSLWhitelistMember
    public EnumFacing getFace() {
        return internal.getFace();
    }

    @GSLWhitelistMember
    public PWorld getWorld() {
        return new PWorld(internal.getWorld());
    }

    @GSLWhitelistMember
    public EnumActionResult getCancellationResult() {
        return internal.getCancellationResult();
    }

    @GSLWhitelistMember
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

    @GSLWhitelistMember
    public PEntity getEntity() {
        return new PEntity(internal.getEntity());
    }

    @GSLWhitelistMember
    public void cancelEvent() {
        internal.setCanceled(true);
    }
}
