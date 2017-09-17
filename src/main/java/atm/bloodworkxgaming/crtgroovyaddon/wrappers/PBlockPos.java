package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.util.math.BlockPos;

public class PBlockPos extends ICGWrapper<BlockPos>{

    public PBlockPos(BlockPos pos){
        super(pos);
    }

    public PBlockPos(int x, int y, int z){
        super(new BlockPos(x,y,z));
    }

    @GSLWhitelistMember
    public int getX(){
        return internal.getX();
    }

    @GSLWhitelistMember
    public int getY(){
        return internal.getY();
    }

    @GSLWhitelistMember
    public int getZ(){
        return internal.getZ();
    }

    @Override
    public String toString() {
        return internal.toString();
    }
}
