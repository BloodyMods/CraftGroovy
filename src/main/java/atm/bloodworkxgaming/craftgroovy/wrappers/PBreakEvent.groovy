package atm.bloodworkxgaming.craftgroovy.wrappers

import atm.bloodworkxgaming.craftgroovy.delegate.MCInWorldObjects
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraftforge.event.world.BlockEvent

@CompileStatic
class PBreakEvent extends AbstractICGWrapper<BlockEvent.BreakEvent> implements MCInWorldObjects {

    PBreakEvent(BlockEvent.BreakEvent e) {
        super(e)
    }

    /**
     * @return Player which is breaking the block
     */
    @GSLWhitelistMember
    PPlayer getPlayer() {
        return new PPlayer(internal.getPlayer())
    }

    /**
     * Get the experience dropped by the block after the event has processed
     *
     * @return The experience to drop or 0 if the event was canceled
     */
    @GSLWhitelistMember
    int getExpToDrop() {
        return internal.getExpToDrop()
    }

    /**
     * Set the amount of experience dropped by the block after the event has processed
     *
     * @param exp 1 or higher to drop experience, else nothing will drop
     */
    @GSLWhitelistMember
    void setExpToDrop(int exp) {
        internal.setExpToDrop(exp)
    }

    /**
     * @return the affected world where the block was broken inside of
     */
    @GSLWhitelistMember
    PWorld getWorld() {
        return new PWorld(internal.getWorld())
    }

    /**
     * @return Position of the broken Block
     */
    @GSLWhitelistMember
    PBlockPos getPos() {
        return new PBlockPos(internal.getPos())
    }

    /**
     * @return State of the broken Block
     */
    @GSLWhitelistMember
    PBlockState getState() {
        return new PBlockState(internal.getState())
    }

    /**
     * This cancels the event preventing the Block from being broken
     */
    @GSLWhitelistMember
    void cancelEvent() {
        internal.setCanceled(true)
    }
}