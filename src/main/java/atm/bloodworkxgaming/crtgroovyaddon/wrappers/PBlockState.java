package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.block.state.IBlockState;


public class PBlockState extends ICGWrapper<IBlockState>{

    protected PBlockState(IBlockState state){
        super(state);
    }

    @GSLWhitelistMember
    public PBlock getBlock(){
        return new PBlock(internal.getBlock());
    }
}
