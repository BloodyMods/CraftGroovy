package atm.bloodworkxgaming.craftgroovy.wrappers;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class PEntityItemPickupEvent {

    public PPlayer player;
    public PEntityItem item;

    public PEntityItemPickupEvent(EntityItemPickupEvent e) {
        this.item = new PEntityItem(e.getItem());
        this.player = new PPlayer(e.getEntityPlayer());
    }
}
