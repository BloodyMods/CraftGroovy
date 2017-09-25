package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

import java.util.List;

public class PHarvestDropsEvent {

    public PWorld world;
    public PBlockPos pos;
    public PBlockState state;
    public int fortuneLevel;
    public float dropChance;
    public PPlayer harvester;
    public boolean isSilkTouching;
    private List<ItemStack> drops;

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

    public boolean removeDrop(PItemStack ingredient) {
        return drops.removeIf(temp -> ItemStack.areItemsEqual(ingredient.getInternal(), temp));
    }

    public void addDrop(PItemStack ingredient) {
        drops.add(ingredient.getInternal());
    }

}