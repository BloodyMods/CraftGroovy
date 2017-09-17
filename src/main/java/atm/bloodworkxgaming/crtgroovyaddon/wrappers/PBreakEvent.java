package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraftforge.event.world.BlockEvent;

public class PBreakEvent {

    @GSLWhitelistMember public PWorld world;
    @GSLWhitelistMember public PBlockPos pos;
    @GSLWhitelistMember public PBlockState state;
    @GSLWhitelistMember public PPlayer player;

    public PBreakEvent(BlockEvent.BreakEvent e) {
        this.world = new PWorld(e.getWorld());
        this.pos = new PBlockPos(e.getPos());
        this.state = new PBlockState(e.getState());
        this.player = new PPlayer(e.getPlayer());
    }
}