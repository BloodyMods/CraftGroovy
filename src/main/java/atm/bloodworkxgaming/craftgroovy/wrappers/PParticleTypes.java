package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.util.EnumParticleTypes;

public enum PParticleTypes {
    @GSLWhitelistMember
    EXPLOSION_NORMAL(EnumParticleTypes.EXPLOSION_NORMAL),
    @GSLWhitelistMember
    EXPLOSION_LARGE(EnumParticleTypes.EXPLOSION_LARGE),
    @GSLWhitelistMember
    EXPLOSION_HUGE(EnumParticleTypes.EXPLOSION_HUGE),
    @GSLWhitelistMember
    FIREWORKS_SPARK(EnumParticleTypes.FIREWORKS_SPARK),
    @GSLWhitelistMember
    WATER_BUBBLE(EnumParticleTypes.WATER_BUBBLE),
    @GSLWhitelistMember
    WATER_SPLASH(EnumParticleTypes.WATER_SPLASH),
    @GSLWhitelistMember
    WATER_WAKE(EnumParticleTypes.WATER_WAKE),
    @GSLWhitelistMember
    SUSPENDED(EnumParticleTypes.SUSPENDED),
    @GSLWhitelistMember
    SUSPENDED_DEPTH(EnumParticleTypes.SUSPENDED_DEPTH),
    @GSLWhitelistMember
    CRIT(EnumParticleTypes.CRIT),
    @GSLWhitelistMember
    CRIT_MAGIC(EnumParticleTypes.CRIT_MAGIC),
    @GSLWhitelistMember
    SMOKE_NORMAL(EnumParticleTypes.SMOKE_NORMAL),
    @GSLWhitelistMember
    SMOKE_LARGE(EnumParticleTypes.SMOKE_LARGE),
    @GSLWhitelistMember
    SPELL(EnumParticleTypes.SPELL),
    @GSLWhitelistMember
    SPELL_INSTANT(EnumParticleTypes.SPELL_INSTANT),
    @GSLWhitelistMember
    SPELL_MOB(EnumParticleTypes.SPELL_MOB),
    @GSLWhitelistMember
    SPELL_MOB_AMBIENT(EnumParticleTypes.SPELL_MOB_AMBIENT),
    @GSLWhitelistMember
    SPELL_WITCH(EnumParticleTypes.SPELL_WITCH),
    @GSLWhitelistMember
    DRIP_WATER(EnumParticleTypes.DRIP_WATER),
    @GSLWhitelistMember
    DRIP_LAVA(EnumParticleTypes.DRIP_LAVA),
    @GSLWhitelistMember
    VILLAGER_ANGRY(EnumParticleTypes.VILLAGER_ANGRY),
    @GSLWhitelistMember
    VILLAGER_HAPPY(EnumParticleTypes.VILLAGER_HAPPY),
    @GSLWhitelistMember
    TOWN_AURA(EnumParticleTypes.TOWN_AURA),
    @GSLWhitelistMember
    NOTE(EnumParticleTypes.NOTE),
    @GSLWhitelistMember
    PORTAL(EnumParticleTypes.PORTAL),
    @GSLWhitelistMember
    ENCHANTMENT_TABLE(EnumParticleTypes.ENCHANTMENT_TABLE),
    @GSLWhitelistMember
    FLAME(EnumParticleTypes.FLAME),
    @GSLWhitelistMember
    LAVA(EnumParticleTypes.LAVA),
    @GSLWhitelistMember
    FOOTSTEP(EnumParticleTypes.FOOTSTEP),
    @GSLWhitelistMember
    CLOUD(EnumParticleTypes.CLOUD),
    @GSLWhitelistMember
    REDSTONE(EnumParticleTypes.REDSTONE),
    @GSLWhitelistMember
    SNOWBALL(EnumParticleTypes.SNOWBALL),
    @GSLWhitelistMember
    SNOW_SHOVEL(EnumParticleTypes.SNOW_SHOVEL),
    @GSLWhitelistMember
    SLIME(EnumParticleTypes.SLIME),
    @GSLWhitelistMember
    HEART(EnumParticleTypes.HEART),
    @GSLWhitelistMember
    BARRIER(EnumParticleTypes.BARRIER),
    @GSLWhitelistMember
    ITEM_CRACK(EnumParticleTypes.ITEM_CRACK),
    @GSLWhitelistMember
    BLOCK_CRACK(EnumParticleTypes.BLOCK_CRACK),
    @GSLWhitelistMember
    BLOCK_DUST(EnumParticleTypes.BLOCK_DUST),
    @GSLWhitelistMember
    WATER_DROP(EnumParticleTypes.WATER_DROP),
    @GSLWhitelistMember
    ITEM_TAKE(EnumParticleTypes.ITEM_TAKE),
    @GSLWhitelistMember
    MOB_APPEARANCE(EnumParticleTypes.MOB_APPEARANCE),
    @GSLWhitelistMember
    DRAGON_BREATH(EnumParticleTypes.DRAGON_BREATH),
    @GSLWhitelistMember
    END_ROD(EnumParticleTypes.END_ROD),
    @GSLWhitelistMember
    DAMAGE_INDICATOR(EnumParticleTypes.DAMAGE_INDICATOR),
    @GSLWhitelistMember
    SWEEP_ATTACK(EnumParticleTypes.SWEEP_ATTACK),
    @GSLWhitelistMember
    FALLING_DUST(EnumParticleTypes.FALLING_DUST),
    @GSLWhitelistMember
    TOTEM(EnumParticleTypes.TOTEM),
    @GSLWhitelistMember
    SPIT(EnumParticleTypes.SPIT);

    EnumParticleTypes internal;

    PParticleTypes(EnumParticleTypes internal) {
        this.internal = internal;
    }

    public EnumParticleTypes getInternal() {
        return internal;
    }
}
