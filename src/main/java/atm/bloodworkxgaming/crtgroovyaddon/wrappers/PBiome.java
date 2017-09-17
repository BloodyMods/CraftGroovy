package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PBiome extends ICGWrapper<Biome> {
    PBiome(Biome biome) {
        super(biome);
    }

    @SideOnly(Side.CLIENT)
    public String getName() {
        return internal.getBiomeName();
    }
}