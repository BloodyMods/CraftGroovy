package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraftforge.event.world.BlockEvent;

public class PBreakEvent extends ICGWrapper<BlockEvent.BreakEvent> {

    public PBreakEvent(BlockEvent.BreakEvent e) {
        super(e);
    }

    /**
     * @return Player which is breaking the block
     */
    @GSLWhitelistMember
    public PPlayer getPlayer() {
        return new PPlayer(internal.getPlayer());
    }

    /**
     * Get the experience dropped by the block after the event has processed
     *
     * @return The experience to drop or 0 if the event was canceled
     */
    @GSLWhitelistMember
    public int getExpToDrop() {
        return internal.getExpToDrop();
    }
    /**
     * Set the amount of experience dropped by the block after the event has processed
     *
     * @param exp 1 or higher to drop experience, else nothing will drop
     */
    @GSLWhitelistMember
    public void setExpToDrop(int exp) {
        internal.setExpToDrop(exp);
    }

    /**
     * @return the affected world where the block was broken inside of
     */
    @GSLWhitelistMember
    public PWorld getWorld() {
        return new PWorld(internal.getWorld());
    }

    /**
     * @return Position of the broken Block
     */
    @GSLWhitelistMember
    public PBlockPos getPos() {
        return new PBlockPos(internal.getPos());
    }

    /**
     * @return State of the broken Block
     */
    @GSLWhitelistMember
    public PBlockState getState() {
        return new PBlockState(internal.getState());
    }

    /**
     * This cancels the event preventing the Block from being broken
     */
    @GSLWhitelistMember
    public void cancelEvent() {
        internal.setCanceled(true);
    }
}