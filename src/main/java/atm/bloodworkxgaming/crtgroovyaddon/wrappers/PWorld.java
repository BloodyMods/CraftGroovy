package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.world.World;

public class PWorld extends ICGWrapper<World> {

    public PWorld(World world) {
        super(world);
    }

    @GSLWhitelistMember
    public PBiome getBiome(PBlockPos pos) {
        return new PBiome(internal.getBiome(pos.getInternal()));
    }

    @GSLWhitelistMember
    public boolean setBlockState(PBlockPos pos, PBlockState state) {
        return internal.setBlockState(pos.getInternal(), state.getInternal());
    }

    @GSLWhitelistMember
    public boolean isDaytime() {
        return internal.isDaytime();
    }

    @GSLWhitelistMember
    public long getWorldTime() {
        return internal.getWorldTime();
    }

    @GSLWhitelistMember
    public PBlockState getBlockState(PBlockPos pos) {
        return new PBlockState(internal.getBlockState(pos.getInternal()));
    }

    @GSLWhitelistMember
    public boolean canSeeSky(PBlockPos pos) {
        return internal.canSeeSky(pos.getInternal());
    }

    @GSLWhitelistMember
    public PBlockPos getSpawnPoint() {
        return new PBlockPos(internal.getSpawnPoint());
    }

    @GSLWhitelistMember
    public void setSpawnPoint(PBlockPos pos) {
        internal.setSpawnPoint(pos.getInternal());
    }

    @GSLWhitelistMember
    public void setToAir(PBlockPos pos) {
        internal.setBlockToAir(pos.getInternal());
    }
}