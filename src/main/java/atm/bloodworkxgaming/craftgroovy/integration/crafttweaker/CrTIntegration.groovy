package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker

import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.BlockBracketHandler
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundEventBracketHandler
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler
import crafttweaker.CraftTweakerAPI
import crafttweaker.api.item.IIngredient
import crafttweaker.api.item.IItemStack
import crafttweaker.mc1120.brackets.*
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.AnnotationManager
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.GroovySandboxedLauncher
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import stanhebben.zenscript.annotations.*

@TypeChecked
class CrTIntegration {
    static void registerCrTCompat(GroovySandboxedLauncher sandboxedLauncher) {
        registerCraftTweakerClasses(sandboxedLauncher)
        registerMixins(sandboxedLauncher)
        CraftTweakerLauncher.registerToEvent()
    }

    private static void registerCraftTweakerClasses(GroovySandboxedLauncher sandboxedLauncher) {
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenSetter.class)
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenGetter.class)
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenMethod.class)
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenMethodStatic.class)

        AnnotationManager.registerOptionalParameterAnnotation(Optional.class)
        sandboxedLauncher.with {
            whitelistRegistry.registerObjectExistence(IItemStack.class)
            whitelistRegistry.registerMethod(BracketHandlerItem.class, "getItem")
            whitelistRegistry.registerMethod(BracketHandlerOre.class, "getOre")
            whitelistRegistry.registerMethod(BracketHandlerPotion.class, "getPotion")
            whitelistRegistry.registerMethod(BracketHandlerLiquid.class, "getLiquid")
            whitelistRegistry.registerMethod(BracketHandlerEntity.class, "getEntity")
            whitelistRegistry.registerMethod(BlockBracketHandler.class, "getBlock")
            whitelistRegistry.registerMethod(MaterialBracketHandler.class, "getBlockMaterial")
            whitelistRegistry.registerMethod(SoundEventBracketHandler.class, "getSoundEvent")
            whitelistRegistry.registerMethod(SoundTypeBracketHandler.class, "getSoundType")
            whitelistRegistry.registerMethod(CraftTweakerAPI.class, "getLogger")
            whitelistRegistry.registerField(CraftTweakerAPI.class, "recipes")

            // mixins
            whitelistRegistry.registerMethod(IIngredient.class, "multiply")
        }
    }

    private static void registerMixins(GroovySandboxedLauncher sandboxedLauncher) {
        sandboxedLauncher.launchWrapper.registerMixinProvider(new CrTMixinClasses())
    }
}
