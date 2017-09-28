package atm.bloodworkxgaming.craftgroovy;

import atm.bloodworkxgaming.craftgroovy.commands.CGChatCommand;
import atm.bloodworkxgaming.craftgroovy.events.CGEventHandler;
import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.CrTIntegration;
import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.CraftTweakerLauncher;
import atm.bloodworkxgaming.craftgroovy.logger.ConsoleLogger;
import atm.bloodworkxgaming.craftgroovy.logger.FileLogger;
import atm.bloodworkxgaming.craftgroovy.wrappers.WrapperWhitelister;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.mc1120.network.MessageCopyClipboard;
import de.bloodworkxgaming.groovysandboxedlauncher.defaults.WhitelistDefaults;
import de.bloodworkxgaming.groovysandboxedlauncher.logger.ILogger;
import de.bloodworkxgaming.groovysandboxedlauncher.sandbox.GroovySandboxedLauncher;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = CraftGroovy.MODID, name = "Craft Groovy", version = CraftGroovy.VERSION, dependencies = "after:crafttweaker; after:contenttweaker", acceptedMinecraftVersions = "[1.12, 1.13)")
public class CraftGroovy {
    public static final String MODID = "craftgroovy";
    public static final String VERSION = "0.1";

    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
    public static final List<ILogger> loggers = new ArrayList<>();
    public static final CGEventHandler cgEventHandler = new CGEventHandler();
    public static final GroovySandboxedLauncher sandboxedLauncher = new GroovySandboxedLauncher();;

    private static int ID = -1;

    static {
        // Setting up the logging for GSL and for this mod
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger("craftgroovy.log");

        loggers.add(fileLogger);
        loggers.add(consoleLogger);

        GroovySandboxedLauncher.LOG_MANAGER.clearLoggers();
        GroovySandboxedLauncher.LOG_MANAGER.registerLogger(fileLogger);
        GroovySandboxedLauncher.LOG_MANAGER.registerLogger(consoleLogger);

        // Registering hte CopyMessage to the Network
        NETWORK.registerMessage(MessageCopyClipboard.class, MessageCopyClipboard.class, ++ID, Side.CLIENT);
    }

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
        MinecraftForge.EVENT_BUS.register(cgEventHandler);

        sandboxedLauncher.registerResetEvent(eventObject -> cgEventHandler.clearAllClosureLists());

        sandboxedLauncher.scriptPathConfig.registerScriptPathRoots("D:\\Users\\jonas\\Documents\\GitHub\\CrTGroovyAddon\\src\\test\\java\\groovyScripts");

        WhitelistDefaults.registerWhitelistMethodDefaults(sandboxedLauncher.whitelistRegistry);
        WrapperWhitelister.registerWrappers(sandboxedLauncher.whitelistRegistry);

        sandboxedLauncher.whitelistRegistry.registerField(EnumParticleTypes.class, "*");

        sandboxedLauncher.whitelistRegistry.invertObjectWhitelist();
        sandboxedLauncher.importModifier.addStaticStars("java.lang.Math");

        // Different Mod Integrations
        if (Loader.isModLoaded("crafttweaker")) {
            CrTIntegration.registerCrTCompat(sandboxedLauncher);
        }

        sandboxedLauncher.initSandbox();
        sandboxedLauncher.loadScripts();
        sandboxedLauncher.runAllScripts();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // sandboxedLauncher.runFunctionAll("preinit", event);
        if (Loader.isModLoaded("crafttweaker")){
            CraftTweakerLauncher.registerToEvent();
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        info("--- Running CraftTweaker Closures --- ");
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent ev) {
        // registering the command
        CGChatCommand.register(ev);
    }
}
