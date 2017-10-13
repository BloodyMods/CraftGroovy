package atm.bloodworkxgaming.craftgroovy;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

@Config(modid = CraftGroovy.MODID)
public class CGConfig {
        private static Property customScriptPaths;
        // private static Property acceptedModes;

        private static Configuration configuration;

        @SuppressWarnings("ResultOfMethodCallIgnored")
        public static void init(File suggestedConfigurationFile) {
            if (!suggestedConfigurationFile.exists()) {
                suggestedConfigurationFile.mkdir();
            }

            configuration = new Configuration(suggestedConfigurationFile);
            configuration.load();

            // customScriptPath = configuration.get("general", "customScriptPath", "");
            customScriptPaths = configuration.get("general", "customScriptPaths", new String[] {"scripts/"});
            configuration.save();
        }

        /*public static void setPackMode(String newPackMode) {
            packMode.set(newPackMode);
            configuration.save();
        }

        public static String getPackMode() {
            return packMode.getString();
        }
*/
        public static String[] getCustomScriptPaths() {
            return customScriptPaths.getStringList();
        }

}
