package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import net.minecraftforge.event.world.BlockEvent;

public class PNeighborNotifyEvent {

    public PWorld world;
    public PBlockState state;
    public boolean forceRedstoneUpdate;

    public PNeighborNotifyEvent(BlockEvent.NeighborNotifyEvent e){
        world = new PWorld(e.getWorld());
        state = new PBlockState(e.getState());
        forceRedstoneUpdate = e.getForceRedstoneUpdate();
        // (World internal, BlockPos pos, IBlockState state, EnumSet<EnumFacing> notifiedSides, boolean forceRedstoneUpdate)

    }
}
