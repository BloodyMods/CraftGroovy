package atm.bloodworkxgaming.craftgroovy.events;

import atm.bloodworkxgaming.craftgroovy.delegate.CGCraftTweakerClosure;
import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.CraftTweakerDelegate;
import atm.bloodworkxgaming.craftgroovy.wrappers.PBreakEvent;
import atm.bloodworkxgaming.craftgroovy.wrappers.PEntityItemPickupEvent;
import atm.bloodworkxgaming.craftgroovy.wrappers.PPlaceEvent;
import atm.bloodworkxgaming.craftgroovy.wrappers.PRightClickBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class CGEventHandler {
    public static final List<CGCraftTweakerClosure> craftTweakerDelegates = new ArrayList<>();

    public void clearAllClosureLists() {
        ClosureManager.clearMap();
    }


    public static void printDebugToAll(World world, String message) {
        if (message.length() > 0) {
            world.getPlayers(EntityPlayer.class, entityPlayer -> true).forEach(player ->
                    player.sendMessage(new TextComponentString(message)));
        }
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

    public void runCraftTweakerClosure() {
        ClosureManager.runClosuresWithDelegate(new CraftTweakerDelegate(), craftTweakerDelegates);
    }
}