package atm.bloodworkxgaming.crtgroovyaddon.delegate;

import atm.bloodworkxgaming.crtgroovyaddon.wrappers.PBreakEvent;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;

public class BreakEventDelegate {
    @GSLWhitelistMember
    public PBreakEvent breakEvent;

    public BreakEventDelegate(PBreakEvent breakEvent) {
        this.breakEvent = breakEvent;
    }
}
