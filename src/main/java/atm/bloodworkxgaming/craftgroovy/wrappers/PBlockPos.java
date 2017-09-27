package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistConstructor;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.util.math.BlockPos;

@GSLWhitelistConstructor
public class PBlockPos extends ICGWrapper<BlockPos> {

    public PBlockPos(BlockPos pos) {
        super(pos);
    }

    public PBlockPos(int x, int y, int z) {
        super(new BlockPos(x, y, z));
    }

    /**
     * Gets the X coordinate.
     */
    @GSLWhitelistMember
    public int getX() {
        return internal.getX();
    }

    /**
     * Gets the Y coordinate.
     */
    @GSLWhitelistMember
    public int getY() {
        return internal.getY();
    }

    /**
     * Gets the Z coordinate.
     */
    @GSLWhitelistMember
    public int getZ() {
        return internal.getZ();
    }

    /**
     * Add the given coordinates to the coordinates of this BlockPos
     */
    @GSLWhitelistMember
    public PBlockPos add(int x, int y, int z) {
        return new PBlockPos(internal.add(x, y, z));
    }
}
