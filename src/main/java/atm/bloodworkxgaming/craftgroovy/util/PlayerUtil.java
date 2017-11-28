package atm.bloodworkxgaming.craftgroovy.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PlayerUtil {

    public static NBTTagCompound getPersistedTag(EntityPlayer player, String modName) {
        NBTTagCompound persistTag;
        NBTTagCompound modTag;
        NBTTagCompound tag = player.getEntityData();
        if (tag.hasKey("PlayerPersisted")) {
            persistTag = tag.getCompoundTag("PlayerPersisted");
        } else {
            persistTag = new NBTTagCompound();
            tag.setTag("PlayerPersisted", persistTag);
        }
        if (persistTag.hasKey(modName)) {
            modTag = persistTag.getCompoundTag(modName);
        } else {
            modTag = new NBTTagCompound();
            persistTag.setTag(modName, modTag);
        }

        return modTag;
    }

}
