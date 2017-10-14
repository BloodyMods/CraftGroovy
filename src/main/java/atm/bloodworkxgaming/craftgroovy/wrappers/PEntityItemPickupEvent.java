package atm.bloodworkxgaming.craftgroovy.wrappers;

import atm.bloodworkxgaming.craftgroovy.delegate.MCInWorldObjects;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

@GSLWhitelistClass
public class PEntityItemPickupEvent extends ICGWrapper<EntityItemPickupEvent> implements MCInWorldObjects {
    public PEntityItemPickupEvent(EntityItemPickupEvent e) {
        super(e);
    }

    /**
     * @return The {@link PEntityItem} that has been picked up
     */
    @GSLWhitelistMember
    public PEntityItem getItem() {
        return new PEntityItem(internal.getItem());
    }

    /**
     * @return The {@link PPlayer} that picked up the item
     */
    @GSLWhitelistMember
    public PPlayer getEntityPlayer() {
        return new PPlayer(internal.getEntityPlayer());
    }

    /**
     * This cancels the event preventing the Block from being broken
     */
    @GSLWhitelistMember
    public void cancelEvent() {
        internal.setCanceled(true);
    }
}
