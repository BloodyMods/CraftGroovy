package atm.bloodworkxgaming.craftgroovy.delegate

import atm.bloodworkxgaming.craftgroovy.gdsl.item.CGItemProp
import atm.bloodworkxgaming.craftgroovy.wrappers.PBlock
import atm.bloodworkxgaming.craftgroovy.wrappers.PBlockState
import atm.bloodworkxgaming.craftgroovy.wrappers.PItem
import atm.bloodworkxgaming.craftgroovy.wrappers.PItemStack
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.item.Item

@CompileStatic
trait MCInWorldObjects {
    /**
     * Gets the Item from the given name
     */
    @GSLWhitelistMember
    PItem createItem(String name) {
        return new PItem(Item.getByNameOrId(name))
    }

    /**
     * Makes a ItemStack from the given Item
     * @param Item to make the stack from
     * @param meta meta of item
     * @param count amount of the stack
     * @return the stack
     */
    @GSLWhitelistMember
    PItemStack createItemStack(PItem item, int meta = 0, int count = 1) {
        def itemStack = new PItemStack(item.internal, meta)
        itemStack.count = count
        return itemStack
    }

    /**
     * Makes a ItemStack from the given Item
     * @param Item to make the stack from
     * @param meta meta of item
     * @param count amount of the stack
     * @return the stack
     */
    @GSLWhitelistMember
    PItemStack createItemStack(String itemName, int meta = 0, int count = 1) {
        def itemStack = new PItemStack(itemName, meta)
        itemStack.count = count
        return itemStack
    }

    /**
     * Gets the block with the given name
     * @param name name of the block
     * @return the Block
     */
    @GSLWhitelistMember
    PBlock createBlock(String name) {
        return PBlock.getBlockFromName(name)
    }

    /**
     * Creates a blockstate which can be 'placed' in the world
     * @param name name of the block
     * @param meta meta of the state
     * @return the BlockState
     */
    @GSLWhitelistMember
    PBlockState createBlockState(String name, int meta = 0) {
        return PBlock.getBlockFromName(name).getStateFromMeta(meta)
    }

    /**
     * Creates a blockstate which can be 'placed' in the world
     * @param block the block
     * @param meta meta of the state
     * @return the BlockState
     */
    @GSLWhitelistMember
    PBlockState createBlockState(PBlock block, int meta = 0) {
        return block.getStateFromMeta(meta)
    }

    @GSLWhitelistMember
    CGItemProp getCreateItem() {return new CGItemProp()}
}