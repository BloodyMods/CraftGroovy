package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.world.World;

public class PWorld {

    protected World world;

    public PWorld(World world) {
        this.world = world;
    }

    @GSLWhitelistMember
    public PBiome getBiome(PBlockPos pos) {
        return new PBiome(world.getBiome(pos.pos));
    }

    @GSLWhitelistMember
    public boolean setBlockState(PBlockPos pos, PBlockState state) {
        return world.setBlockState(pos.pos, state.state);
    }

    @GSLWhitelistMember
    public boolean isDaytime() {
        return world.isDaytime();
    }

    @GSLWhitelistMember
    public long getWorldTime() {
        return world.getWorldTime();
    }

    @GSLWhitelistMember
    public PBlockState getBlockState(PBlockPos pos) {
        return new PBlockState(world.getBlockState(pos.pos));
    }

    @GSLWhitelistMember
    public boolean canSeeSky(PBlockPos pos) {
        return world.canSeeSky(pos.pos);
    }

    @GSLWhitelistMember
    public PBlockPos getSpawnPoint() {
        return new PBlockPos(world.getSpawnPoint());
    }

    @GSLWhitelistMember
    public void setSpawnPoint(PBlockPos pos) {
        world.setSpawnPoint(pos.pos);
    }

    @GSLWhitelistMember
    public void setToAir(PBlockPos pos){
        world.setBlockToAir(pos.pos);
    }
}