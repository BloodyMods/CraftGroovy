package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import net.minecraftforge.event.world.BlockEvent;

public class PCreateFluidSourceEvent {

    public PWorld world;
    public PBlockPos pos;
    public PBlockState state;

    public PCreateFluidSourceEvent(BlockEvent.CreateFluidSourceEvent e){
            this.world = new PWorld(e.getWorld());
            this.pos =  new PBlockPos(e.getPos());
            this.state = new PBlockState(e.getState());
    }
}
