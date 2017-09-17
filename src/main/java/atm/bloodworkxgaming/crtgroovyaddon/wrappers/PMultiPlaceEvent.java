package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.world.BlockEvent;

import java.util.List;

public class PMultiPlaceEvent {

    private List<BlockSnapshot> blockSnapshots;
    public PBlockState placedAgainst;
    public PPlayer player;

    public PMultiPlaceEvent(BlockEvent.MultiPlaceEvent e) {
        this.blockSnapshots = e.getReplacedBlockSnapshots();
        this.player = new PPlayer(e.getPlayer());
        this.placedAgainst = new PBlockState(e.getPlacedAgainst());
        //TODO enumHand
    }

    public boolean removeBlockSnapshot() {
        return false; //TODO
    }

    public void addBlockSnapShot(PBlockSnapshot snapshot) {
        blockSnapshots.add(snapshot.snapshot);
    }
}
