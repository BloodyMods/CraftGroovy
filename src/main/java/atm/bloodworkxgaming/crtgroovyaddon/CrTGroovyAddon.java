package atm.bloodworkxgaming.crtgroovyaddon;

import atm.bloodworkxgaming.crtgroovyaddon.commands.CGChatCommand;
import atm.bloodworkxgaming.crtgroovyaddon.events.CGEventHandler;
import atm.bloodworkxgaming.crtgroovyaddon.logger.ConsoleLogger;
import atm.bloodworkxgaming.crtgroovyaddon.logger.FileLogger;
import atm.bloodworkxgaming.crtgroovyaddon.logger.ILogger;
import atm.bloodworkxgaming.crtgroovyaddon.mixins.MixinClasses;
import atm.bloodworkxgaming.crtgroovyaddon.wrappers.WrapperWhitelister;
import com.teamacronymcoders.contenttweaker.modules.materials.MaterialPartBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.BlockBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.materials.MaterialBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundEventBracketHandler;
import com.teamacronymcoders.contenttweaker.modules.vanilla.resources.sounds.SoundTypeBracketHandler;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.recipes.IRecipeManager;
import crafttweaker.mc1120.brackets.*;
import crafttweaker.mc1120.item.MCItemStack;
import crafttweaker.zenscript.GlobalRegistry;
import crafttweaker.zenscript.IBracketHandler;
import de.bloodworkxgaming.groovysandboxedlauncher.defaults.WhitelistDefaults;
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.AnnotationManager;
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.GroovySandboxedLauncher;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import stanhebben.zenscript.annotations.*;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mod(modid = CrTGroovyAddon.MODID, name = "CrTGroovyAddon", version = CrTGroovyAddon.VERSION, dependencies = "after:crafttweaker; after:contenttweaker")
public class CrTGroovyAddon {
    public static final String MODID = "crtgroovyaddon";
    public static final String VERSION = "0.1";

    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
    public static final File LOG_FILE = new File("logs/crtgroovyaddon" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".log");
    public static List<ILogger> loggers = new ArrayList<>();

    static {
        loggers.add(new FileLogger("crtgroovyaddon.log"));
        loggers.add(new ConsoleLogger());
    }

    public static GroovySandboxedLauncher sandboxedLauncher;

    /**
     * Error handling
     */
    public static void info(String s) {
        for (ILogger logger : loggers) {
            logger.logInfo(s);
        }
    }

    public static void warn(String s) {
        for (ILogger logger : loggers) {
            logger.logWarning(s);
        }
    }

    public static void error(String s) {
        for (ILogger logger : loggers) {
            logger.logError(s);
        }
    }


    public static void error(String s, Exception e) {
        for (ILogger logger : loggers) {
            logger.logError(s, e);
        }
    }

    public static void logCommand(String message) {
        for (ILogger logger : loggers) {
            logger.logCommand(message);
        }
    }

    public static void logCommandChat(ICommandSender sender, ITextComponent message) {
        sender.sendMessage(message);
        for (ILogger logger : loggers) {
            logger.logCommand(message.getUnformattedText());
        }
    }

    @EventHandler
    public void construction(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(new CGEventHandler());

        sandboxedLauncher = new GroovySandboxedLauncher();

        sandboxedLauncher.scriptPathConfig.registerScriptPathRoots("D:\\Users\\jonas\\Documents\\GitHub\\CrTGroovyAddon\\src\\test\\java\\groovyScripts");

        WhitelistDefaults.registerWhitelistMethodDefaults(sandboxedLauncher.whitelistRegistry);
        sandboxedLauncher.whitelistRegistry.registerObjectExistence(IItemStack.class);

        AnnotationManager.registerMemberWhitelistingAnnotation(ZenSetter.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenGetter.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenMethod.class);
        AnnotationManager.registerMemberWhitelistingAnnotation(ZenMethodStatic.class);

        AnnotationManager.registerOptionalParameterAnnotation(Optional.class);

        sandboxedLauncher.launchWrapper.registerMixinProvider(new MixinClasses());

        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerItem.class, "getItem");
        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerOre.class, "getOre");
        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerPotion.class, "getPotion");
        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerLiquid.class, "getLiquid");
        sandboxedLauncher.whitelistRegistry.registerMethod(BracketHandlerEntity.class, "getEntity");


        sandboxedLauncher.whitelistRegistry.registerMethod(BlockBracketHandler.class, "getBlock");
        sandboxedLauncher.whitelistRegistry.registerMethod(MaterialBracketHandler.class, "getBlockMaterial");
        sandboxedLauncher.whitelistRegistry.registerMethod(SoundEventBracketHandler.class, "getSoundEvent");
        sandboxedLauncher.whitelistRegistry.registerMethod(SoundTypeBracketHandler.class, "getSoundType");


        sandboxedLauncher.whitelistRegistry.registerMethod(CraftTweakerAPI.class, "getLogger");
        sandboxedLauncher.whitelistRegistry.registerField(CraftTweakerAPI.class, "recipes");

        WrapperWhitelister.registerWrappers(sandboxedLauncher.whitelistRegistry);

        sandboxedLauncher.whitelistRegistry.invertObjectWhitelist();
        sandboxedLauncher.importModifier.addStaticStars("java.lang.Math");


        sandboxedLauncher.initSandbox();
        sandboxedLauncher.loadScripts();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        sandboxedLauncher.runFunctionAll("preinit", event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Loading init of crt groovy");
        sandboxedLauncher.runAllScripts();
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent ev) {

        // registering the command
        CGChatCommand.register(ev);
    }


    @NetworkCheckHandler
    public boolean matchModVersion(Map<String, String> remoteVersions, Side side) {
        return true;
    }
}
