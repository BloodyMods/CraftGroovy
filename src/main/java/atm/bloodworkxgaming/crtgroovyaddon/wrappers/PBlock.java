package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import net.minecraft.block.Block;

public class PBlock extends ICGWrapper<Block> {

    public PBlock(Block block){
        super(block);
    }

    public PBlockState getDefaultState(){
        return new PBlockState(internal.getDefaultState());
    }
}
