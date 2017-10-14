package atm.bloodworkxgaming.craftgroovy.events

import atm.bloodworkxgaming.craftgroovy.closures.CGContentTweakerClosure
import atm.bloodworkxgaming.craftgroovy.closures.CGCraftTweakerClosure
import atm.bloodworkxgaming.craftgroovy.integration.contenttweaker.ContentTweakerDelegate
import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.CraftTweakerDelegate
import atm.bloodworkxgaming.craftgroovy.wrappers.PBreakEvent
import atm.bloodworkxgaming.craftgroovy.wrappers.PEntityItemPickupEvent
import atm.bloodworkxgaming.craftgroovy.wrappers.PPlaceEvent
import atm.bloodworkxgaming.craftgroovy.wrappers.PRightClickBlock
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic

class CGEventManager {

    @CompileStatic
    @GSLWhitelistMember
    static def blockBreak(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PBreakEvent) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_BLOCK_BREAK.name(), cl)
    }

    @CompileStatic
    @GSLWhitelistMember
    static def blockPlace(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PPlaceEvent) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_BLOCK_PLACE.name(), cl)
    }

    @CompileStatic
    @GSLWhitelistMember
    static def rightClickBlock(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PRightClickBlock) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_RIGHTCLICK_BLOCK_MAINHAND.name(), cl)
    }

    @CompileStatic
    @GSLWhitelistMember
    static def rightClickBlockOffHand(
            @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PRightClickBlock) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_RIGHTCLICK_BLOCK_OFFHAND.name(), cl)
    }

    @CompileStatic
    @GSLWhitelistMember
    static def itemPickUp(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = PEntityItemPickupEvent) Closure cl) {
        return ClosureManager.addClosureToMap(CGEventNames.CG_ITEM_PICKUP.name(), cl)
    }

    @GSLWhitelistMember
    static CGCraftTweakerClosure craftTweaker(List<String> packMode = [], String loderName = "crafttweaker",
                                              @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = CraftTweakerDelegate) Closure cl) {
        CGCraftTweakerClosure closure = new CGCraftTweakerClosure(cl, loderName, packMode)
        CGEventHandler.craftTweakerDelegates.add(closure)
        CGEventHandler.craftTweakerDelegates.sort(ClosureManager.CG_CLOSURE_COMPARATOR)

        return closure
    }

    @GSLWhitelistMember
    static CGContentTweakerClosure contentTweaker(List<String> packMode = [],
                                                  @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = ContentTweakerDelegate) Closure cl) {
        CGContentTweakerClosure closure = new CGContentTweakerClosure(cl, packMode)
        CGEventHandler.contentTweakerDelegates.add(closure)
        CGEventHandler.contentTweakerDelegates.sort(ClosureManager.CG_CLOSURE_COMPARATOR)

        return closure
    }
}
