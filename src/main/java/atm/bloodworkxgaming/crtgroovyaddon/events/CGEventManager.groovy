package atm.bloodworkxgaming.crtgroovyaddon.events

import atm.bloodworkxgaming.crtgroovyaddon.wrappers.PBreakEvent
import atm.bloodworkxgaming.crtgroovyaddon.wrappers.PPlaceEvent
import atm.bloodworkxgaming.crtgroovyaddon.wrappers.PRightClickBlock
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember

class CGEventManager {
    static List<Closure> blockBreakClosures = new ArrayList<>()
    static List<Closure> blockPlaceClosures = new ArrayList<>()
    static List<Closure> rightClickBlockClosures = new ArrayList<>()

    @GSLWhitelistMember
    static def blockBreak(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PBreakEvent) Closure cl){
        blockBreakClosures.add(cl)
    }

    @GSLWhitelistMember
    static def blockPlace(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PPlaceEvent) Closure cl){
        blockPlaceClosures.add(cl)
    }

    @GSLWhitelistMember
    static def rightClickBlock(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PRightClickBlock) Closure cl){
        rightClickBlockClosures.add(cl)
    }
}
