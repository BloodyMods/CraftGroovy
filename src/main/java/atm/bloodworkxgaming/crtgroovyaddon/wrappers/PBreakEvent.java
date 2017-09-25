package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraftforge.event.world.BlockEvent;

public class PBreakEvent extends ICGWrapper<BlockEvent.BreakEvent> {

    public PBreakEvent(BlockEvent.BreakEvent e) {
        super(e);
    }

    @GSLWhitelistMember
    public PPlayer getPlayer() {
        return new PPlayer(internal.getPlayer());
    }

    @GSLWhitelistMember
    public int getExpToDrop() {
        return internal.getExpToDrop();
    }

    @GSLWhitelistMember
    public void setExpToDrop(int exp) {
        internal.setExpToDrop(exp);
    }

    @GSLWhitelistMember
    public PWorld getWorld() {
        return new PWorld(internal.getWorld());
    }

    @GSLWhitelistMember
    public PBlockPos getPos() {
        return new PBlockPos(internal.getPos());
    }

    @GSLWhitelistMember
    public PBlockState getState() {
        return new PBlockState(internal.getState());
    }
}