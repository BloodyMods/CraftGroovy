package atm.bloodworkxgaming.craftgroovy.wrappers

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.world.World

@CompileStatic
class PWorld extends ICGWrapper<World> {

    PWorld(World world) {
        super(world)
    }

    @GSLWhitelistMember
    PBiome getBiome(PBlockPos pos) {
        return new PBiome(internal.getBiome(pos.getInternal()))
    }

    @GSLWhitelistMember
    boolean setBlockState(PBlockPos pos, PBlockState state) {
        return internal.setBlockState(pos.getInternal(), state.getInternal())
    }

    @GSLWhitelistMember
    boolean isDaytime() {
        return internal.isDaytime()
    }

    @GSLWhitelistMember
    long getWorldTime() {
        return internal.getWorldTime()
    }

    @GSLWhitelistMember
    PBlock getBlockAt(PBlockPos pos = new PBlockPos(0,0,0), int x, int y, int z) {
        return new PBlock(internal.getBlockState(pos.internal.add(x, y, z)).block)
    }

    @GSLWhitelistMember
    PBlock getBlockAt(PBlockPos pos) {
        return new PBlock(internal.getBlockState(pos.internal).block)
    }

    @GSLWhitelistMember
    PBlockState getBlockStateAt(PBlockPos pos = new PBlockPos(0,0,0), int x, int y, int z) {
        return new PBlockState(internal.getBlockState(pos.internal.add(x, y, z)))
    }

    @GSLWhitelistMember
    PBlockState getBlockStateAt(PBlockPos pos) {
        return new PBlockState(internal.getBlockState(pos.internal))
    }

    @GSLWhitelistMember
    boolean canSeeSky(PBlockPos pos) {
        return internal.canSeeSky(pos.getInternal())
    }

    @GSLWhitelistMember
    PBlockPos getSpawnPoint() {
        return new PBlockPos(internal.getSpawnPoint())
    }

    @GSLWhitelistMember
    void setSpawnPoint(PBlockPos pos) {
        internal.setSpawnPoint(pos.getInternal())
    }

    @GSLWhitelistMember
    void setToAir(PBlockPos pos) {
        internal.setBlockToAir(pos.getInternal())
    }
}