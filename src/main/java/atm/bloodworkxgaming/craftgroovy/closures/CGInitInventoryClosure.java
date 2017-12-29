package atm.bloodworkxgaming.craftgroovy.closures;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import groovy.lang.Closure;

public class CGInitInventoryClosure extends CGClosure {
    /**
     * Whether the closure should run even if the items are already present in the players Inventory
     */
    public boolean shouldRunAnyways = false;

    public CGInitInventoryClosure(Closure closure) {
        super(closure);
    }

    @GSLWhitelistMember
    public void setShouldRunAnyways() {
        this.shouldRunAnyways = true;
    }

    @GSLWhitelistMember
    public void setShouldRunAnyways(boolean shouldRunAnyways) {
        this.shouldRunAnyways = shouldRunAnyways;
    }
}
