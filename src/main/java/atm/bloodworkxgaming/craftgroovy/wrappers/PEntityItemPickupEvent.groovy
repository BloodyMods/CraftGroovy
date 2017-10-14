package atm.bloodworkxgaming.craftgroovy.wrappers

import atm.bloodworkxgaming.craftgroovy.delegate.MCInWorldObjects
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraftforge.event.entity.player.EntityItemPickupEvent

@GSLWhitelistClass
@CompileStatic
class PEntityItemPickupEvent extends AbstractICGWrapper<EntityItemPickupEvent> implements MCInWorldObjects {
    PEntityItemPickupEvent(EntityItemPickupEvent e) {
        super(e)
    }

    /**
     * @return The {@link PEntityItem} that has been picked up
     */
    @GSLWhitelistMember
    PEntityItem getItem() {
        return new PEntityItem(internal.getItem())
    }

    /**
     * @return The {@link PPlayer} that picked up the item
     */
    @GSLWhitelistMember
    PPlayer getEntityPlayer() {
        return new PPlayer(internal.getEntityPlayer())
    }

    /**
     * This cancels the event preventing the Block from being broken
     */
    @GSLWhitelistMember
    void cancelEvent() {
        internal.setCanceled(true)
    }
}
