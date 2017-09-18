package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.world.BlockEvent;

public class PPlaceEvent extends ICGWrapper<BlockEvent.PlaceEvent>{
    public PPlaceEvent(BlockEvent.PlaceEvent e) {
        super(e);
    }

    @GSLWhitelistMember
    public PPlayer getPlayer() {
        return new PPlayer(internal.getPlayer());
    }

    @GSLWhitelistMember
    public PBlockSnapshot getBlockSnapshot() {
        return new PBlockSnapshot(internal.getBlockSnapshot());
    }

    @GSLWhitelistMember
    public PBlockState getPlacedBlock() {
        return new PBlockState(internal.getPlacedBlock());
    }

    @GSLWhitelistMember
    public PBlockState getPlacedAgainst() {
        return new PBlockState(internal.getPlacedAgainst());
    }

    @GSLWhitelistMember
    public EnumHand getHand() {
        return internal.getHand();
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
