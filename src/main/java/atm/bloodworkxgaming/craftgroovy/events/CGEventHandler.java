package atm.bloodworkxgaming.craftgroovy.events;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.delegate.CGClosure;
import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.CraftTweakerDelegate;
import atm.bloodworkxgaming.craftgroovy.wrappers.PBreakEvent;
import atm.bloodworkxgaming.craftgroovy.wrappers.PPlaceEvent;
import atm.bloodworkxgaming.craftgroovy.wrappers.PRightClickBlock;
import groovy.lang.Closure;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class CGEventHandler {
    public static final List<CGClosure> blockBreakClosures = new ArrayList<>();
    public static final List<CGClosure> blockPlaceClosures = new ArrayList<>();
    public static final List<CGClosure> rightClickBlockClosures = new ArrayList<>();
    public static final List<CGClosure> rightClickBlockOffhandClosures = new ArrayList<>();
    public static final List<CGClosure> craftTweakerDelegates = new ArrayList<>();

    public void clearAllClosureLists() {
        blockBreakClosures.clear();
        blockPlaceClosures.clear();
        rightClickBlockOffhandClosures.clear();
        rightClickBlockClosures.clear();
    }


    public static void printDebugToAll(World world, String message) {
        if (message.length() > 0) {
            world.getPlayers(EntityPlayer.class, entityPlayer -> true).forEach(player ->
                    player.sendMessage(new TextComponentString(message)));
        }
    }

    @SubscribeEvent
    public void breakEvent(BlockEvent.BreakEvent e) {
        runClosuresWithDelegate(new PBreakEvent(e), blockBreakClosures);
    }

    @SubscribeEvent
    public void placeEvent(BlockEvent.PlaceEvent e) {
        runClosuresWithDelegate(new PPlaceEvent(e), blockPlaceClosures);
    }

    @SubscribeEvent
    public void onPlayerInteractEvent(RightClickBlock event) {
        if (event.getHand() == EnumHand.MAIN_HAND) {
            runClosuresWithDelegate(new PRightClickBlock(event), rightClickBlockClosures);
        }

        if (event.getHand() == EnumHand.OFF_HAND) {
            runClosuresWithDelegate(new PRightClickBlock(event), rightClickBlockOffhandClosures);
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
        runClosuresWithDelegate(new CraftTweakerDelegate(), craftTweakerDelegates);
    }

    private void runClosuresWithDelegate(Object delegate, List<CGClosure> closures) {
        closures.sort(CGClosure.CG_CLOSURE_COMPARATOR);

        for (CGClosure cgClosure : closures) {
            Closure closure = cgClosure.getClosure();
            Closure code = closure.rehydrate(delegate, closure.getOwner(), closure.getThisObject());
            code.setResolveStrategy(Closure.DELEGATE_FIRST);

            CraftGroovy.sandboxedLauncher.runClosure(code);
        }
    }

}