package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.brackets.*;
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.AnnotationManager;
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.GroovySandboxedLauncher;
import stanhebben.zenscript.annotations.*;


public class CrTIntegration {
    public static void registerCrTCompat(GroovySandboxedLauncher sandboxedLauncher) {
        registerCraftTweakerClasses(sandboxedLauncher);
        registerMixins(sandboxedLauncher);
        CraftTweakerLauncher.registerToEvent();
    }

    private static void registerCraftTweakerClasses(GroovySandboxedLauncher sandboxedLauncher) {
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenSetter.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenGetter.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenMethod.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenMethodStatic.class);

        AnnotationManager.registerMemberWhitelistingAnnotation(ZenMemberGetter.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenMemberSetter.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenCaster.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenOperator.class);

        AnnotationManager.registerOptionalParameterAnnotation(Optional.class);
        sandboxedLauncher.whitelistRegistry.registerObjectExistence(IItemStack.class);
        sandboxedLauncher.whitelistRegistry.registerMethod(IItemStack.class, "getInternal");

        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerItem.class, "getItem");
        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerOre.class, "getOre");
        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerPotion.class, "getPotion");
        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerLiquid.class, "getLiquid");
        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerEntity.class, "getEntity");

        sandboxedLauncher.whitelistRegistry.registerMethod(CraftTweakerAPI.class, "getLogger");
        sandboxedLauncher.whitelistRegistry.registerField(CraftTweakerAPI.class, "recipes");

        // mixins
        sandboxedLauncher.whitelistRegistry.registerMethod(IIngredient.class, "multiply");
        sandboxedLauncher.whitelistRegistry.registerMethod(IItemStack.class, "power");


    }

    private static void registerMixins(GroovySandboxedLauncher sandboxedLauncher) {
        sandboxedLauncher.launchWrapper.registerMixinProvider(new CrTMixinClasses());
    }
}
