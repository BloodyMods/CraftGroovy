package atm.bloodworkxgaming.craftgroovy.worldgen.worldgenTypes;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistConstructor;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.block.state.IBlockState;

import java.util.ArrayList;
import java.util.List;

@GSLWhitelistClass
@GSLWhitelistConstructor
public class FlowerWorldGenType extends BaseWorldgenType{
    @GSLWhitelistMember
    public List<IBlockState> whitelistedSoil = new ArrayList<>();

    @GSLWhitelistMember
    public int minFlowers = 4;
    @GSLWhitelistMember
    public int maxFlowers = 16;

    public FlowerWorldGenType(IBlockState blockState) {
        this.blockState = blockState;
    }

    public FlowerWorldGenType() {
        this.blockState = null;
    }
}
