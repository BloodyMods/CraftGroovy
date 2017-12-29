package atm.bloodworkxgaming.craftgroovy.integration.packmode;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import io.sommers.packmode.api.PackModeAPI;
import net.minecraftforge.fml.common.Loader;

import java.util.List;

public class PackModeChecker {
    @GSLWhitelistMember
    public static String getPackMode() {
        if (Loader.isModLoaded("packmode")) {
            return PackModeAPI.getInstance().getCurrentPackMode();
        } else {
            return "PACKMODE_NOT_INSTALLED";
        }
    }

    @GSLWhitelistMember
    public static boolean shouldLoad(List<String> packModes) {
        return !Loader.isModLoaded("packmode") || packModes == null || packModes.size() == 0 || packModes.contains(getPackMode());
    }
}
