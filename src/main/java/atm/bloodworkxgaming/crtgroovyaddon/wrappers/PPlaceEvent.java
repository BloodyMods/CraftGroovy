package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import net.minecraftforge.event.world.BlockEvent;

public class PPlaceEvent {

    public PBlockSnapshot snapshot;
    public PPlayer player;
    public PBlockState placedAgainst;
    public PBlockState placedBlock;

    public PPlaceEvent(BlockEvent.PlaceEvent e) {
        this.snapshot = new PBlockSnapshot(e.getBlockSnapshot());
        this.player = new PPlayer(e.getPlayer());
        this.placedAgainst = new PBlockState(e.getPlacedAgainst());
        this.placedBlock = new PBlockState(e.getState());
        //TODO e.getHand()

        //        public PlaceEvent(@Nonnull BlockSnapshot blockSnapshot,
        // @Nonnull IBlockState placedAgainst, @Nonnull EntityPlayer player, @Nonnull EnumHand hand) {

    }
}
