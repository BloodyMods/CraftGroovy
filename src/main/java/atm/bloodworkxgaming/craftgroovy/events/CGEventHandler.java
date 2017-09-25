package atm.bloodworkxgaming.craftgroovy.events;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
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
        for (Closure closure : CGEventManager.getBlockBreakClosures()) {
            PBreakEvent delegate = new PBreakEvent(e);
            Closure code = closure.rehydrate(delegate, this, this);
            code.setResolveStrategy(Closure.DELEGATE_FIRST);

            CraftGroovy.sandboxedLauncher.runClosure(code);
        }
    }

    @SubscribeEvent
    public void placeEvent(BlockEvent.PlaceEvent e){
        for (Closure closure : CGEventManager.getBlockPlaceClosures()) {
            PPlaceEvent delegate = new PPlaceEvent(e);
            Closure code = closure.rehydrate(delegate, this, this);
            code.setResolveStrategy(Closure.DELEGATE_FIRST);

            CraftGroovy.sandboxedLauncher.runClosure(code);
        }
    }

    @SubscribeEvent
    public void onPlayerInteractEvent(RightClickBlock event){
        if (!event.getWorld().isRemote){
            if (event.getHand() == EnumHand.MAIN_HAND){ //TODO: let user select hand to make the actions
                for (Closure closure : CGEventManager.getRightClickBlockClosures()) {
                    PRightClickBlock delegate = new PRightClickBlock(event);
                    Closure code = closure.rehydrate(delegate, this, this);
                    code.setResolveStrategy(Closure.DELEGATE_FIRST);

                    CraftGroovy.sandboxedLauncher.runClosure(code);
                }
            }
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
        CraftGroovy.sandboxedLauncher.runFunctionAll("registerCrafting", e);

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