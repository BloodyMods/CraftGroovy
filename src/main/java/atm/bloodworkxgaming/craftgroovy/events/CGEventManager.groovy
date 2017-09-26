package atm.bloodworkxgaming.craftgroovy.events

import atm.bloodworkxgaming.craftgroovy.delegate.CGClosure
import atm.bloodworkxgaming.craftgroovy.delegate.CraftTweakerDelegate
import atm.bloodworkxgaming.craftgroovy.wrappers.PBreakEvent
import atm.bloodworkxgaming.craftgroovy.wrappers.PPlaceEvent
import atm.bloodworkxgaming.craftgroovy.wrappers.PRightClickBlock
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember

class CGEventManager {

    @GSLWhitelistMember
    static def blockBreak(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PBreakEvent) Closure cl){
        CGClosure closure = new CGClosure(cl)
        CGEventHandler.blockBreakClosures.add(closure)
        return closure
    }

    @GSLWhitelistMember
    static def blockPlace(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PPlaceEvent) Closure cl){
        CGClosure closure = new CGClosure(cl)
        CGEventHandler.blockPlaceClosures.add(closure)
        return closure
    }

    @GSLWhitelistMember
    static def rightClickBlock(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PRightClickBlock) Closure cl){
        CGClosure closure = new CGClosure(cl)
        CGEventHandler.rightClickBlockClosures.add(closure)
        return closure
    }

    @GSLWhitelistMember
    static def rightClickBlockOffHand(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PRightClickBlock) Closure cl){
        CGClosure closure = new CGClosure(cl)
        CGEventHandler.rightClickBlockOffhandClosures.add(closure)
        return closure
    }

    @GSLWhitelistMember
    static CGClosure craftTweaker(String loderName = "crafttweaker", String packMode = null, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = CraftTweakerDelegate) Closure cl){
        CGClosure closure = new CGClosure(cl)
        CGEventHandler.craftTweakerDelegates.add(closure)
        return closure
    }
}
