package atm.bloodworkxgaming.craftgroovy.delegate

import atm.bloodworkxgaming.craftgroovy.wrappers.PPlayer
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember

class InitialInventoryDelegate implements MCInWorldObjects {
    @GSLWhitelistMember
    public PPlayer player
    @GSLWhitelistMember
    public boolean hasGottenItemsAlready

    InitialInventoryDelegate(PPlayer player, boolean hasGottenItemsAlready) {
        this.player = player
        this.hasGottenItemsAlready = hasGottenItemsAlready
    }
}
