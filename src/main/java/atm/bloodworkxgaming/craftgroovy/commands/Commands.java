package atm.bloodworkxgaming.craftgroovy.commands;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static atm.bloodworkxgaming.craftgroovy.commands.SpecialMessagesChat.getClickableCommandMessage;
import static atm.bloodworkxgaming.craftgroovy.commands.SpecialMessagesChat.getNormalMessage;

/**
 * @author BloodWorkXGaming
 */
public class Commands {
    public static final NumberFormat df = DecimalFormat.getInstance();
    static {
        df.setMinimumFractionDigits(1);
        df.setMaximumFractionDigits(3);
    }


    static void registerCommands() {
        
        CGChatCommand.registerCommand(new CraftTweakerCommand("help") {
            @Override
            public void executeCommand(MinecraftServer server, ICommandSender sender, String[] args) {
                CGChatCommand.sendUsage(sender);
            }
            
            @Override
            protected void init() {
                setDescription(getClickableCommandMessage("\u00A72/ct help", "/ct help", true), getNormalMessage(" \u00A73Prints out the this help page"));
            }
        });

        CGChatCommand.registerCommand(new CraftTweakerCommand("run") {
            @Override
            public void executeCommand(MinecraftServer server, ICommandSender sender, String[] args) {
                CraftGroovy.sandboxedLauncher.loadScripts();
                CraftGroovy.sandboxedLauncher.runAllScripts();
            }

            @Override
            protected void init() {
                setDescription(getClickableCommandMessage("\u00A72/ct run", "/ct run", true), getNormalMessage(" \u00A73Reruns the scripts"));
            }
        });

    }
}
