package atm.bloodworkxgaming.craftgroovy.events

import atm.bloodworkxgaming.craftgroovy.delegate.CGClosure
import atm.bloodworkxgaming.craftgroovy.delegate.CGCraftTweakerClosure
import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.CraftTweakerDelegate
import atm.bloodworkxgaming.craftgroovy.wrappers.PBreakEvent
import atm.bloodworkxgaming.craftgroovy.wrappers.PEntityItemPickupEvent
import atm.bloodworkxgaming.craftgroovy.wrappers.PPlaceEvent
import atm.bloodworkxgaming.craftgroovy.wrappers.PRightClickBlock
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic

@CompileStatic
class CGEventManager {

    @GSLWhitelistMember
    static def blockBreak(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PBreakEvent) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_BLOCK_BREAK.name(), cl)
    }

    @GSLWhitelistMember
    static def blockPlace(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PPlaceEvent) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_BLOCK_PLACE.name(), cl)
    }

    @GSLWhitelistMember
    static def rightClickBlock(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PRightClickBlock) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_RIGHTCLICK_BLOCK_MAINHAND.name(), cl)
    }

    @GSLWhitelistMember
    static def rightClickBlockOffHand(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PRightClickBlock) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_RIGHTCLICK_BLOCK_OFFHAND.name(), cl)
    }

   @GSLWhitelistMember
    static def itemPickUp(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PEntityItemPickupEvent) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_ITEM_PICKUP.name(), cl)
    }

    @GSLWhitelistMember
    static CGCraftTweakerClosure craftTweaker(List<String> packMode = [], String loderName = "crafttweaker",
                                              @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = CraftTweakerDelegate) Closure cl) {
        CGCraftTweakerClosure closure = new CGCraftTweakerClosure(cl, loderName, packMode)
        CGEventHandler.craftTweakerDelegates.add(closure)
        return closure
    }
}
