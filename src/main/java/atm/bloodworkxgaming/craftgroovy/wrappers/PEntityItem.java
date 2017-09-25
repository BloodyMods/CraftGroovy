package atm.bloodworkxgaming.craftgroovy.wrappers;

import net.minecraft.entity.item.EntityItem;

public class PEntityItem {

    private EntityItem internalItem;

    public PEntityItem(EntityItem item) {
        this.internalItem = item;
    }
}
