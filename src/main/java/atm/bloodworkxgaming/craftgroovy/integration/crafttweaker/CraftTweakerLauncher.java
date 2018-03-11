package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.closures.CGClosureList;
import atm.bloodworkxgaming.craftgroovy.closures.CGCraftTweakerClosure;
import atm.bloodworkxgaming.craftgroovy.events.CGEventHandler;
import atm.bloodworkxgaming.craftgroovy.events.ClosureManager;
import atm.bloodworkxgaming.craftgroovy.integration.contenttweaker.ContentTweakerLauncher;
import atm.bloodworkxgaming.craftgroovy.integration.packmode.PackModeChecker;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.network.NetworkSide;
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.GroovySandboxedLauncher;
import net.minecraftforge.fml.common.Loader;

import java.text.Format;
import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static de.bloodworkxgaming.groovysandboxedlauncher.sandbox.GroovySandboxedLauncher.*;

public class CraftTweakerLauncher {
    public static void registerToEvent() {
        CraftTweakerAPI.tweaker.registerLoadStartedEvent(crTLoadingStartedEvent -> handleLoading(crTLoadingStartedEvent.getLoaderName(), crTLoadingStartedEvent.getNetworkSide(), crTLoadingStartedEvent.isSyntaxCommand()));
    }

    private static void handleLoading(String loaderName, NetworkSide networkSide, boolean isSyntaxCommand) {
        if (isSyntaxCommand) return;
        if (networkSide != null && networkSide != (CraftTweakerAPI.tweaker.getNetworkSide())) return;

        CraftGroovy.info("Attempting to load with loaderName: " + loaderName);

        if (Objects.equals(loaderName, "contenttweaker")) {
            if (Loader.isModLoaded("contenttweaker")) {
                ContentTweakerLauncher.handleLoading();
            }
        } else {
            loadClosures(loaderName);
        }
    }

    private static void loadClosures(String loaderName) {
        // gets all scripts with the correct loader name
        long timeStart = System.nanoTime();

        List<CGCraftTweakerClosure> closures = CGEventHandler.craftTweakerDelegates.getList()
                .stream()
                .filter(cgCraftTweakerClosure -> Objects.equals(cgCraftTweakerClosure.getLoaderName(), loaderName) && PackModeChecker.shouldLoad(cgCraftTweakerClosure.getPackModes()))
                .collect(Collectors.toList());

        ClosureManager.runClosuresWithDelegate(new CraftTweakerDelegate(), new CGClosureList<>(closures), null);

        CraftGroovy.info("Finished executing CraftTweakerClosures in " + DF.format((System.nanoTime() - timeStart)/1.0e6) + "ms.");
    }
}
