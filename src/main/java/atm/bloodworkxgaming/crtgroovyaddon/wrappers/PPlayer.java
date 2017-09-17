package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.item.MCItemStack;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.GameType;

public class PPlayer {

    private EntityPlayer player;

    public PPlayer(EntityPlayer player) {
        this.player = player;
    }

    @GSLWhitelistMember
    public IItemStack getHeldMain() {
        return new MCItemStack(player.getHeldItem(EnumHand.MAIN_HAND));
    }

    @GSLWhitelistMember
    public IItemStack getHeldOffHand() {
        return new MCItemStack(player.getHeldItem(EnumHand.OFF_HAND));
    }

    @GSLWhitelistMember
    public double getMotionX() {
        return player.motionX;
    }

    @GSLWhitelistMember
    public double getMotionY() {
        return player.motionY;
    }

    @GSLWhitelistMember
    public double getMotionZ() {
        return player.motionZ;
    }

    @GSLWhitelistMember
    public String getDisplayName() {
        return player.getDisplayNameString();
    }

    @GSLWhitelistMember
    public void setGameType(String type) {
        switch (type.toLowerCase()) {
            case "survival":
                player.setGameType(GameType.SURVIVAL);
                break;
            case "creative":
                player.setGameType(GameType.CREATIVE);
                break;
            case "adventure":
                player.setGameType(GameType.ADVENTURE);
                break;
            case "spectator":
                player.setGameType(GameType.SPECTATOR);
                break;
            default:
                break;
        }
    }

    @GSLWhitelistMember
    public boolean isSneaking(){
        return player.isSneaking();
    }

}