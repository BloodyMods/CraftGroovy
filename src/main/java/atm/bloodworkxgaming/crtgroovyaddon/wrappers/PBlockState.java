package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.block.state.IBlockState;


public class PBlockState {

    protected IBlockState state;

    protected PBlockState(IBlockState state){
        this.state = state;
    }

    @GSLWhitelistMember
    public PBlock getBlock(){
        return new PBlock(state.getBlock());
    }
}
