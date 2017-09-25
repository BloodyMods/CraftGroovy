package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;


public class PBlockState extends ICGWrapper<IBlockState> {

    protected PBlockState(IBlockState state) {
        super(state);
    }

    @GSLWhitelistMember
    public PBlock getBlock() {
        return new PBlock(internal.getBlock());
    }

    /**
     * Returns the registryname:meta
     * eg: minecraft:wool:3
     */
    @GSLWhitelistMember
    public String getIdentifier(){
        ResourceLocation reg = internal.getBlock().getRegistryName();
        return (reg == null ? "INVALID_NAME" : reg.toString()) + ":" + internal.getBlock().getMetaFromState(internal);
    }
}
