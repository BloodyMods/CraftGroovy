package atm.bloodworkxgaming.craftgroovy.integration.contenttweaker;

import atm.bloodworkxgaming.craftgroovy.events.CGEventHandler;
import atm.bloodworkxgaming.craftgroovy.events.ClosureManager;

public class ContentTweakerLauncher {
    public static void handleLoading(){
        ClosureManager.runClosuresWithDelegate(new ContentTweakerDelegate(), CGEventHandler.contentTweakerDelegates);
    }
}
