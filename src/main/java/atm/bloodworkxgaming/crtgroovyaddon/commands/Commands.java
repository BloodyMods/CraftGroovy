package atm.bloodworkxgaming.crtgroovyaddon.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static atm.bloodworkxgaming.crtgroovyaddon.commands.SpecialMessagesChat.getClickableCommandMessage;
import static atm.bloodworkxgaming.crtgroovyaddon.commands.SpecialMessagesChat.getNormalMessage;

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

    }
}
