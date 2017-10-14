package atm.bloodworkxgaming.craftgroovy.wrappers

import atm.bloodworkxgaming.craftgroovy.delegate.MCInWorldObjects
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.entity.EntityLivingBase
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.Vec3d
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.fml.common.eventhandler.Event

import javax.annotation.Nullable

@CompileStatic
class PRightClickBlock extends AbstractICGWrapper<PlayerInteractEvent.RightClickBlock> implements MCInWorldObjects {

    PRightClickBlock(PlayerInteractEvent.RightClickBlock internal) {
        super(internal)
    }

    Vec3d getHitVec() {
        return internal.getHitVec()
    }

    @GSLWhitelistMember
    Event.Result getUseBlock() {
        return internal.getUseBlock()
    }

    @GSLWhitelistMember
    void setUseBlock(Event.Result triggerBlock) {
        internal.setUseBlock(triggerBlock)
    }

    @GSLWhitelistMember
    Event.Result getUseItem() {
        return internal.getUseItem()
    }

    @GSLWhitelistMember
    void setUseItem(Event.Result triggerItem) {
        internal.setUseItem(triggerItem)
    }

    @GSLWhitelistMember
    EnumHand getHand() {
        return internal.getHand()
    }

    @GSLWhitelistMember
    PItemStack getItemStack() {
        return new PItemStack(internal.getItemStack())
    }

    @GSLWhitelistMember
    PBlockPos getPos() {
        return new PBlockPos(internal.getPos())
    }

    @Nullable
    @GSLWhitelistMember
    EnumFacing getFace() {
        return internal.getFace()
    }

    @GSLWhitelistMember
    PWorld getWorld() {
        return new PWorld(internal.getWorld())
    }

    @GSLWhitelistMember
    EnumActionResult getCancellationResult() {
        return internal.getCancellationResult()
    }

    @GSLWhitelistMember
    void setCancellationResult(EnumActionResult result) {
        internal.setCancellationResult(result)
    }

    @GSLWhitelistMember
    PPlayer getPlayer() {
        return new PPlayer(internal.getEntityPlayer())
    }

    EntityLivingBase getEntityLiving() {
        return internal.getEntityLiving()
    }

    @GSLWhitelistMember
    PEntity getEntity() {
        return new PEntity(internal.getEntity())
    }

    @GSLWhitelistMember
    void cancelEvent() {
        internal.setCanceled(true)
    }
}
