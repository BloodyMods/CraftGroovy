package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker

import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.wrapper.RecipeManagerWrapper
import crafttweaker.CraftTweakerAPI
import crafttweaker.api.client.IClient
import crafttweaker.api.data.IData
import crafttweaker.api.entity.IEntityDefinition
import crafttweaker.api.event.IEventManager
import crafttweaker.api.formatting.IFormatter
import crafttweaker.api.item.IItemStack
import crafttweaker.api.item.IItemUtils
import crafttweaker.api.liquid.ILiquidStack
import crafttweaker.api.oredict.IOreDict
import crafttweaker.api.oredict.IOreDictEntry
import crafttweaker.api.potions.IPotion
import crafttweaker.api.recipes.IFurnaceManager
import crafttweaker.api.server.IServer
import crafttweaker.api.vanilla.IVanilla
import crafttweaker.mc1120.brackets.*
import crafttweaker.mc1120.data.NBTConverter
import crafttweaker.runtime.ILogger
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.nbt.JsonToNBT

@CompileStatic
class CraftTweakerDelegate {
    @GSLWhitelistMember
    public static RecipeManagerWrapper recipes = new RecipeManagerWrapper(CraftTweakerAPI.recipes)
    @GSLWhitelistMember
    public static IFurnaceManager furnace = CraftTweakerAPI.furnace
    @GSLWhitelistMember
    public static IOreDict oreDict = CraftTweakerAPI.oreDict
    @GSLWhitelistMember
    public static IItemUtils itemUtils = CraftTweakerAPI.itemUtils
    @GSLWhitelistMember
    public static IFormatter format = CraftTweakerAPI.format
    @GSLWhitelistMember
    public static IClient client = CraftTweakerAPI.client
    @GSLWhitelistMember
    public static IServer server = CraftTweakerAPI.server
    @GSLWhitelistMember
    public static IEventManager events = CraftTweakerAPI.events
    @GSLWhitelistMember
    public static IVanilla vanilla = CraftTweakerAPI.vanilla
    @GSLWhitelistMember
    public static ILogger logger = CraftTweakerAPI.getLogger()

    @GSLWhitelistMember
    static IItemStack item(String name, int meta = 0) {
        return BracketHandlerItem.getItem(name, meta)
    }

    @GSLWhitelistMember
    static IOreDictEntry ore(String name) {
        return BracketHandlerOre.getOre(name)
    }

    @GSLWhitelistMember
    static ILiquidStack liquid(String name) {
        BracketHandlerLiquid.getLiquid(name)
    }

    @GSLWhitelistMember
    static ILiquidStack fluid(String name) {
        BracketHandlerLiquid.getLiquid(name)
    }

    @GSLWhitelistMember
    static IEntityDefinition entity(String name) {
        BracketHandlerEntity.getEntity(name)
    }

    @GSLWhitelistMember
    static IPotion potion(String name) {
        BracketHandlerPotion.getPotion(name)
    }

    @GSLWhitelistMember
    static IData nbt(String string) {
        NBTConverter.from(JsonToNBT.getTagFromJson(string), true)
    }
}
