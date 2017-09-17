package atm.bloodworkxgaming.crtgroovyaddon.events

import atm.bloodworkxgaming.crtgroovyaddon.delegate.BreakEventDelegate
import atm.bloodworkxgaming.crtgroovyaddon.delegate.InitDelegate
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember

class EventManager {
    static List<Closure> blockBreakClosures = new ArrayList<>()



    @GSLWhitelistMember
    static def init(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = InitDelegate) Closure cl){
        def initDel = new InitDelegate()
        def code = cl.rehydrate(initDel, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY

        System.out.println("init: Thread.currentThread() = " + Thread.currentThread())

        code()
    }

    @GSLWhitelistMember
    static def blockBreak(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = BreakEventDelegate) Closure cl){
        println "called stuff in blockBreak delegate thingy "
        blockBreakClosures.add(cl)
    }
}
