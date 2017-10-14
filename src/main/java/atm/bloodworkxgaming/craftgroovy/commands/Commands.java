package atm.bloodworkxgaming.craftgroovy.commands;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static atm.bloodworkxgaming.craftgroovy.commands.SpecialMessagesChat.*;

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

        CGChatCommand.registerCommand(new CraftGroovyCommand("help") {
            @Override
            public void executeCommand(MinecraftServer server, ICommandSender sender, String[] args) {
                CGChatCommand.sendUsage(sender);
            }

            @Override
            protected void init() {
                setDescription(getClickableCommandMessage("\u00A72/ct help", "/ct help", true), getNormalMessage(" \u00A73Prints out the this help page"));
            }
        });

        CGChatCommand.registerCommand(new CraftGroovyCommand("run") {
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

        CGChatCommand.registerCommand(new CraftGroovyCommand("hand") {
            @Override
            public void executeCommand(MinecraftServer server, ICommandSender sender, String[] args) {
                if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();

                    ItemStack item = player.getHeldItemMainhand();

                    ResourceLocation reg = item.getItem().getRegistryName();
                    int meta = item.getMetadata();
                    String colorfulName = "item(\"" + ChatFormatting.DARK_GREEN + reg + ChatFormatting.RESET + "\"" + (meta != 0 ? "," + ChatFormatting.AQUA + meta : "") + ChatFormatting.RESET + ")";

                    String name = "item(\"" + reg + "\"" + (meta != 0 ? "," + meta : "") + ")";

                    if (item.hasTagCompound()) {
                        String nbt = String.valueOf(item.getTagCompound());
                        nbt = nbt.replace("'", "\\'");

                        name += ".withTag(nbt('" + nbt + "'))";
                        colorfulName += ".withTag(nbt('" + ChatFormatting.GOLD + nbt + ChatFormatting.RESET + "'))";
                    }

                    ClipboardHelper.copyStringPlayer(player, name);
                    sender.sendMessage(getCopyMessage(colorfulName, name));
                }
            }

            @Override
            protected void init() {
                setDescription(getClickableCommandMessage("\u00A72/ct hand", "/ct hand", true), getNormalMessage(" \u00A73Copies the item in your hand"));
            }
        });

        CGChatCommand.registerCommand(new CraftGroovyCommand("copy") {

            @Override
            protected void init() {
                setDescription(getClickableCommandMessage("\u00A72/ct copy", "/ct copy", false), getNormalMessage(" \u00A73Copies the provided string behind it"));
            }

            @Override
            public void executeCommand(MinecraftServer server, ICommandSender sender, String[] args) {
                ClipboardHelper.copyCommandRun(sender, args);
            }
        });
    }
}
