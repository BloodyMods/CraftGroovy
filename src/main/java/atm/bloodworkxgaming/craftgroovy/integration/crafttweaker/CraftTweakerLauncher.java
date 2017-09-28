package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.delegate.CGCraftTweakerClosure;
import atm.bloodworkxgaming.craftgroovy.events.CGEventHandler;
import atm.bloodworkxgaming.craftgroovy.integration.contenttweaker.ContentTweakerLauncher;
import atm.bloodworkxgaming.craftgroovy.integration.packmode.PackModeChecker;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.network.NetworkSide;
import net.minecraftforge.fml.common.Loader;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CraftTweakerLauncher  {
    public static void registerToEvent(){
        // CraftTweakerAPI.tweaker.registerLoadStartedEvent(crTLoadingStartedEvent -> handleLoading(crTLoadingStartedEvent.getLoaderName(), crTLoadingStartedEvent.getNetworkSide(), crTLoadingStartedEvent.isSyntaxCommand()));
    }

    private static void handleLoading(String loaderName, NetworkSide networkSide, boolean isSyntaxCommand){
        if (isSyntaxCommand) return;
        if (networkSide != null && networkSide != (CraftTweakerAPI.tweaker.getNetworkSide())) return;

        CraftGroovy.info("Attempting to load with loaderName: " + loaderName);

        if (Objects.equals(loaderName, "contenttweaker")){
            if (Loader.isModLoaded("contenttweaker")){
                ContentTweakerLauncher.handleLoading();
            }
        }else {
            loadClosures(loaderName);
        }
    }

    private static void loadClosures(String loaderName){
        // gets all scripts with the correct loader name
        List<CGCraftTweakerClosure> closures = CGEventHandler.craftTweakerDelegates
                .stream()
                .filter(cgCraftTweakerClosure -> Objects.equals(cgCraftTweakerClosure.getLoaderName(), loaderName))
                .collect(Collectors.toList());

        for (CGCraftTweakerClosure closure : closures) {
            // checks whether the pack mode is correct
            if (PackModeChecker.shouldLoad(closure.getPackModes())){
                CraftGroovy.sandboxedLauncher.runClosure(closure.getClosure());
            }
        }

    }
}
