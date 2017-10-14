package atm.bloodworkxgaming.craftgroovy.integration.packmode;

import io.sommers.packmode.api.PackModeAPI;
import net.minecraftforge.fml.common.Loader;

import java.util.List;

public class PackModeChecker {
    public static String getPackMode() {
        return PackModeAPI.getInstance().getCurrentPackMode();
    }

    public static boolean shouldLoad(List<String> packModes) {
        return !Loader.isModLoaded("packmode") || packModes == null || packModes.size() == 0 || packModes.contains(getPackMode());
    }
}
