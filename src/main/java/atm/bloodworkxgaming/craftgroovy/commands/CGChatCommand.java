package atm.bloodworkxgaming.craftgroovy.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import java.util.*;

/**
 * @author BloodWorkXGaming
 */
public class CGChatCommand extends CommandBase {

    private static final List<String> aliases = new ArrayList<>();
    private static final Map<String, CraftGroovyCommand> craftGroovyCommands = new TreeMap<>();

    static {
        aliases.add("cg");
    }

    public static void register(FMLServerStartingEvent ev) {
        Commands.registerCommands();
        ev.registerServerCommand(new CGChatCommand());
    }

    public static void sendUsage(ICommandSender sender) {
        sender.sendMessage(SpecialMessagesChat.EMPTY_TEXTMESSAGE);

        for (Map.Entry<String, CraftGroovyCommand> entry : craftGroovyCommands.entrySet()) {
            for (ITextComponent s : entry.getValue().getDescription()) {
                sender.sendMessage(s);
            }
            sender.sendMessage(SpecialMessagesChat.EMPTY_TEXTMESSAGE);
        }
    }

    public static void registerCommand(CraftGroovyCommand command) {
        craftGroovyCommands.put(command.getSubCommandName(), command);
    }

    @Override
    public String getName() {
        return "craftgroovy";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        StringBuilder sb = new StringBuilder();

        sb.append("/bd ");

        String[] commands = new String[craftGroovyCommands.keySet().size()];
        craftGroovyCommands.keySet().toArray(commands);

        for (int i = 0; i < commands.length; i++) {
            sb.append(commands[i]);
            if (i != commands.length - 1)
                sb.append(" | ");

        }

        return sb.toString();
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length <= 0) {
            sender.sendMessage(new TextComponentString(getUsage(sender)));
            return;
        }

        if (craftGroovyCommands.containsKey(args[0])) {
            if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
                craftGroovyCommands.get(args[0]).executeCommand(server, sender, ArrayUtils.subarray(args, 1, args.length));
            } else {
                craftGroovyCommands.get(args[0]).executeCommand(server, sender, ArrayUtils.subarray(args, 1, args.length));
            }
        } else {
            sender.sendMessage(SpecialMessagesChat.getClickableCommandMessage("\u00A7cNo such command! \u00A76[Click to show help]", "/bt help", true));
        }
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        Set<String> keys = craftGroovyCommands.keySet();
        List<String> currentPossibleCommands = new ArrayList<>();

        if (args.length <= 0) {
            return new ArrayList<>(keys);
        }

        // First sub-command
        if (args.length == 1) {
            for (String cmd : keys) {
                if (cmd.startsWith(args[0])) {
                    currentPossibleCommands.add(cmd);
                }
            }
            return currentPossibleCommands;
        }

        // gives subcommands of the subcommand
        // each has to implement on it's own for special requirements
        CraftGroovyCommand subCommand = craftGroovyCommands.get(args[0]);
        if (subCommand != null) {
            return subCommand.getSubSubCommand(server, sender, ArrayUtils.subarray(args, 1, args.length), targetPos);

        }

        // returns empty by default
        return currentPossibleCommands;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 4;
    }
}
