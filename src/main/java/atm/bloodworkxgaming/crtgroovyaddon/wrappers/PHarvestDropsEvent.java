package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import crafttweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

import java.util.List;

public class PHarvestDropsEvent {

    public PWorld world;
    public PBlockPos pos;
    public PBlockState state;
    public int fortuneLevel;
    public float dropChance;
    private List<ItemStack> drops;
    public PPlayer harvester;
    public boolean isSilkTouching;

    public PHarvestDropsEvent(BlockEvent.HarvestDropsEvent e) {
        this.world = new PWorld(e.getWorld());
        this.pos = new PBlockPos(e.getPos());
        this.state = new PBlockState(e.getState());
        this.fortuneLevel = e.getFortuneLevel();
        this.dropChance = e.getDropChance();
        this.drops = e.getDrops();
        harvester = new PPlayer(e.getHarvester());
        isSilkTouching = e.isSilkTouching();
    }

    public boolean removeDrop(IItemStack ingredient) {
        return drops.removeIf(temp -> ItemStack.areItemsEqual((ItemStack) ingredient.getInternal(), temp));
    }

    public void addDrop(IItemStack ingredient) {
        drops.add((ItemStack) ingredient.getInternal());
    }

}