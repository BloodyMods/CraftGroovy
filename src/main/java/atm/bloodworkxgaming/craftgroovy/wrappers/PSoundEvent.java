package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistConstructor;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

@GSLWhitelistClass
@GSLWhitelistConstructor
public class PSoundEvent extends AbstractICGWrapper<SoundEvent> {
    public PSoundEvent(SoundEvent internal) {
        super(internal);
    }

    public PSoundEvent(String name) {
        super(SoundEvent.REGISTRY.getObject(new ResourceLocation(name)));
    }

    @GSLWhitelistMember
    public static PSoundEvent getSoundByName(String id) {
        SoundEvent sound = SoundEvent.REGISTRY.getObject(new ResourceLocation(id));

        if (sound == null) {
            return null;
        } else {
            return new PSoundEvent(sound);
        }
    }

    @GSLWhitelistMember
    public String getSoundName() {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            return internal.getSoundName().toString();
        } else {
            return "INVALID_SIDE";
        }
    }


}
