package atm.bloodworkxgaming.craftgroovy.wrappers;

import net.minecraft.tileentity.TileEntity;

public class PTileEntity {

    private TileEntity tile;

    public PTileEntity(TileEntity tile) {
        this.tile = tile;
    }

    public PBlockPos getPos() {
        return new PBlockPos(tile.getPos());
    }
}
