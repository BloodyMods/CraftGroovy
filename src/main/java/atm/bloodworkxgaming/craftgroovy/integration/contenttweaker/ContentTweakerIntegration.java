package atm.bloodworkxgaming.craftgroovy.integration.contenttweaker;

import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.BlockBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundEventBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler;
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.GroovySandboxedLauncher;

public class ContentTweakerIntegration {
    public static void whitelistClasses(GroovySandboxedLauncher sandboxedLauncher){
        sandboxedLauncher.whitelistRegistry.registerMethod(BlockBracketHandler.class, "getBlock");
        sandboxedLauncher.whitelistRegistry.registerMethod(MaterialBracketHandler.class, "getBlockMaterial");
        sandboxedLauncher.whitelistRegistry.registerMethod(SoundEventBracketHandler.class, "getSoundEvent");
        sandboxedLauncher.whitelistRegistry.registerMethod(SoundTypeBracketHandler.class, "getSoundType");
    }
}
