package atm.bloodworkxgaming.craftgroovy.worldgen.worldgenTypes;

import atm.bloodworkxgaming.craftgroovy.wrappers.PBlockState;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseWorldgenType {
    @GSLWhitelistMember
    public List<Integer> whitelistDimensions = new ArrayList<>();
    @GSLWhitelistMember
    public List<Integer> blacklistDimensions = new ArrayList<>();

    @GSLWhitelistMember
    public List<Biome> whitelistBiomes = new ArrayList<>();
    @GSLWhitelistMember
    public List<Biome> blacklistBiomes = new ArrayList<>();

    @GSLWhitelistMember
    public int maxHeight = 255;
    @GSLWhitelistMember
    public int minHeight = 0;

    @GSLWhitelistMember
    public IBlockState blockState;

    public void setBlockState(PBlockState blockState) {
        this.blockState = blockState.getInternal();
    }
}
