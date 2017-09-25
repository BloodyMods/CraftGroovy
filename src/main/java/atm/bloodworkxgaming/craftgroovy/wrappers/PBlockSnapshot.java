package atm.bloodworkxgaming.craftgroovy.wrappers;

import net.minecraftforge.common.util.BlockSnapshot;

public class PBlockSnapshot {

    BlockSnapshot snapshot;


    public PBlockSnapshot(BlockSnapshot snapshot) {
        this.snapshot = snapshot;
    }

    public PBlockState getCurrentBlock() {
        return new PBlockState(snapshot.getCurrentBlock());
    }

}
