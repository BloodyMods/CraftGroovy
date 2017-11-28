package atm.bloodworkxgaming.craftgroovy.events;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.closures.CGClosure;
import atm.bloodworkxgaming.craftgroovy.closures.CGContentTweakerClosure;
import atm.bloodworkxgaming.craftgroovy.closures.CGCraftTweakerClosure;
import atm.bloodworkxgaming.craftgroovy.closures.CGInitInventoryClosure;
import atm.bloodworkxgaming.craftgroovy.delegate.InitialInventoryDelegate;
import atm.bloodworkxgaming.craftgroovy.util.PlayerUtil;
import atm.bloodworkxgaming.craftgroovy.wrappers.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class CGEventHandler {
    public static final List<CGCraftTweakerClosure> craftTweakerDelegates = new ArrayList<>();
    public static final List<CGContentTweakerClosure> contentTweakerDelegates = new ArrayList<>();

    public static void printDebugToAll(World world, String message) {
        if (message.length() > 0) {
            world.getPlayers(EntityPlayer.class, entityPlayer -> true).forEach(player ->
                    player.sendMessage(new TextComponentString(message)));
        }
    }

    public void clearAllClosureLists() {
        ClosureManager.clearMap();
    }

    @SubscribeEvent
    public void breakEvent(BlockEvent.BreakEvent e) {
        ClosureManager.runClosuresWithDelegate(new PBreakEvent(e), CGEventNames.CG_BLOCK_BREAK.name());
    }

    @SubscribeEvent
    public void placeEvent(BlockEvent.PlaceEvent e) {
        ClosureManager.runClosuresWithDelegate(new PPlaceEvent(e), CGEventNames.CG_BLOCK_PLACE.name());
    }

    @SubscribeEvent
    public void itemPickUp(EntityItemPickupEvent e) {
        ClosureManager.runClosuresWithDelegate(new PEntityItemPickupEvent(e), CGEventNames.CG_ITEM_PICKUP.name());
    }

    @SubscribeEvent
    public void onPlayerInteractEvent(RightClickBlock event) {
        if (event.getHand() == EnumHand.MAIN_HAND) {
            ClosureManager.runClosuresWithDelegate(new PRightClickBlock(event), CGEventNames.CG_RIGHTCLICK_BLOCK_MAINHAND.name());
        }

        if (event.getHand() == EnumHand.OFF_HAND) {
            ClosureManager.runClosuresWithDelegate(new PRightClickBlock(event), CGEventNames.CG_RIGHTCLICK_BLOCK_OFFHAND.name());
        }
    }

    @SubscribeEvent
    public void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        if (!event.getEntity().world.isRemote && event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            NBTTagCompound tag = PlayerUtil.getPersistedTag(player, CraftGroovy.MODID);

            // Gives starting items to player
            boolean hasTag = tag.getBoolean("HasStartingItems");

            ClosureManager.runClosuresWithDelegate(new InitialInventoryDelegate(new PPlayer(player), hasTag), CGEventNames.CG_INITIAL_INVENTORY.name(), cgClosure -> {
                if (cgClosure instanceof CGInitInventoryClosure){
                    CGInitInventoryClosure cgi = (CGInitInventoryClosure) cgClosure;
                    return !hasTag || cgi.shouldRunAnyways;
                }else {
                    return true;
                }
            });

            player.inventoryContainer.detectAndSendChanges();
            tag.setBoolean("HasStartingItems", true);

            /*
            if (!tag.getBoolean("HasStartingItems")) {

                player.inventory.addItemStackToInventory(StackReferences.guideBook);

                for (String startingItem : ModConfig.STARTING_ITEMS) {
                    String[] split = startingItem.split(":");
                    if (split.length == 4){
                        try {
                            ItemStack stack = new ItemStack(Item.getByNameOrId(split[0] + ":" + split[1]), Integer.valueOf(split[3]), Integer.valueOf(split[2]));
                            player.inventory.addItemStackToInventory(stack);
                        }catch (Exception e){
                            CraftGroovy.warn("Could not add starting item " + startingItem);
                        }
                    }


                }


            }*/

            // greets player
            /*if (!ModConfig.WELCOME_MESSSAGE.equals("_"))
                player.sendStatusMessage(new TextComponentString(ModConfig.WELCOME_MESSSAGE));*/
        }
    }


    /*
    @SubscribeEvent
    public void harvestDropsEvent(BlockEvent.HarvestDropsEvent e) {
        Sandbox.runFunctionAll("harvestDropsEvent", new PHarvestDropsEvent(e));
    }

    @SubscribeEvent
    public void multiPlaceEvent(BlockEvent.MultiPlaceEvent e) {
        Sandbox.runFunctionAll("multiPlaceEvent", new PMultiPlaceEvent(e));
    }

    @SubscribeEvent
    public void neighborNotifyEvent(BlockEvent.NeighborNotifyEvent e) {
        Sandbox.runFunctionAll("neighborNotifyEvent", new PNeighborNotifyEvent(e));
    }

    @SubscribeEvent
    public void createFluidSourceEvent(BlockEvent.CreateFluidSourceEvent e) {
        Sandbox.runFunctionAll("createFluidSourceEvent", new PCreateFluidSourceEvent(e));
    }

    @SubscribeEvent
    public void itemPickupEvent(EntityItemPickupEvent e) {
        Sandbox.runFunctionAll("itemPickupEvent", new PEntityItemPickupEvent(e));
    }

    @SubscribeEvent
    public void clientChatEvent(ClientChatEvent e){
        Sandbox.runFunctionAll("clientChatEvent",new PClientChatEvent(e));
    }*/
}