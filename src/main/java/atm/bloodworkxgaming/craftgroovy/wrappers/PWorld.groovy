package atm.bloodworkxgaming.craftgroovy.wrappers

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.entity.item.EntityItem
import net.minecraft.util.EnumParticleTypes
import net.minecraft.util.SoundCategory
import net.minecraft.world.World

import javax.annotation.Nullable

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
    PBlock getBlockAt(PBlockPos pos = new PBlockPos(0, 0, 0), int x, int y, int z) {
        return new PBlock(internal.getBlockState(pos.internal.add(x, y, z)).block)
    }

    @GSLWhitelistMember
    PBlock getBlockAt(PBlockPos pos) {
        return new PBlock(internal.getBlockState(pos.internal).block)
    }

    @GSLWhitelistMember
    PBlockState getBlockStateAt(PBlockPos pos = new PBlockPos(0, 0, 0), int x, int y, int z) {
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

    @GSLWhitelistMember
    boolean getIsRemote() {
        return internal.isRemote
    }

    @GSLWhitelistMember
    void spawnParticle(EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int ... parameters) {
        if (isRemote) {
            internal.spawnParticle(particleType, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed, parameters)
        }
    }

    @GSLWhitelistMember
    void playSound(@Nullable PPlayer player = null, PBlockPos pos, PSoundEvent soundIn, SoundCategory category, float volume, float pitch) {
        internal.playSound(player?.internal, pos.internal, soundIn.internal, category, volume, pitch)
    }

    @GSLWhitelistMember
    void playSound(@Nullable PPlayer player = null, double x, double y, double z, PSoundEvent soundIn, SoundCategory category, float volume, float pitch) {
        internal.playSound(player?.internal, x, y, z, soundIn.internal, category, volume, pitch)
    }

    @GSLWhitelistMember
    void playSound(double x, double y, double z, PSoundEvent soundIn, SoundCategory category, float volume, float pitch, boolean distanceDelay) {
        internal.playSound(x, y, z, soundIn.internal, category, volume, pitch, distanceDelay)
    }

    @GSLWhitelistMember
    void playRecord(PBlockPos blockPositionIn, PSoundEvent soundEventIn) {
        internal.playRecord(blockPositionIn.internal, soundEventIn.internal)
    }

    @GSLWhitelistMember
    void spawnItemInWorld(PItemStack itemStack, PBlockPos pos, double velX = 0, double velY = 0, double velZ = 0) {
        spawnItemInWorld(itemStack, pos.x + 0.5, pos.y + 0.5, pos.z + 0.5, velX, velY, velZ)
    }

    @GSLWhitelistMember
    void spawnItemInWorld(PItemStack itemStack, double x, double y, double z, double velX = 0, double velY = 0, double velZ = 0) {
        if (!internal.isRemote) {
            def item = new EntityItem(internal, x, y, z, itemStack.internal)
            item.setVelocity(velX, velY, velZ)
            internal.spawnEntity(item)
        }
    }
}