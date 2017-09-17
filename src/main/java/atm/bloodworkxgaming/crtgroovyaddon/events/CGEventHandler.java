package atm.bloodworkxgaming.crtgroovyaddon.events;

import atm.bloodworkxgaming.crtgroovyaddon.CrTGroovyAddon;
import atm.bloodworkxgaming.crtgroovyaddon.delegate.BreakEventDelegate;
import atm.bloodworkxgaming.crtgroovyaddon.wrappers.PBreakEvent;
import groovy.lang.Closure;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CGEventHandler {



    public static void printDebugToAll(World world, String message) {
        if (message.length() > 0) {
            world.getPlayers(EntityPlayer.class, entityPlayer -> true).forEach(player ->
                    player.sendMessage(new TextComponentString(message)));
        }
    }

    @SubscribeEvent
    public void breakEvent(BlockEvent.BreakEvent e) {
        System.out.println(" break event called");
        for (Closure closure : EventManager.getBlockBreakClosures()) {
            BreakEventDelegate delegate = new BreakEventDelegate(new PBreakEvent(e));
            Closure code = closure.rehydrate(delegate, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            System.out.println("code = " + code);

            System.out.println("Thread.currentThread() = " + Thread.currentThread());

            CrTGroovyAddon.sandboxedLauncher.runClosure(code);
        }
    }

    /*
    @SubscribeEvent
    public void harvestDropsEvent(BlockEvent.HarvestDropsEvent e) {
        Sandbox.runFunctionAll("harvestDropsEvent", new PHarvestDropsEvent(e));
    }

    @SubscribeEvent
    public void placeEvent(BlockEvent.PlaceEvent e) {
        Sandbox.runFunctionAll("placeEvent", new PPlaceEvent(e));
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


    @SubscribeEvent
    public static void registerCrafting(RegistryEvent.Register<IRecipe> e ){
        CrTGroovyAddon.sandboxedLauncher.runFunctionAll("registerCrafting", e);

        System.out.println("register Crafting got reached " + e);

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        // breakEvent.getRegistry().register(new FirstBlock());
        System.out.println("Test Block thingy " + event);

    }



    /*
    @SubscribeEvent
    public void cropGrowEvent(BlockEvent.CropGrowEvent e) {
        for (Map.Entry<String, Object[]> entry : Pony.cropGrowEvent.entrySet()) {
            String result = Pony.nashorn.executeFunction(entry.getKey(), e);
            printDebugToAll(e.getWorld(),result);
        }
    }*/
}