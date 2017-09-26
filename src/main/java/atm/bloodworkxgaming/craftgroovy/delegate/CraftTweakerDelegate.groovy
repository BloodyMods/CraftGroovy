package atm.bloodworkxgaming.craftgroovy.delegate

import crafttweaker.CraftTweakerAPI
import crafttweaker.api.client.IClient
import crafttweaker.api.event.IEventManager
import crafttweaker.api.formatting.IFormatter
import crafttweaker.api.item.IItemStack
import crafttweaker.api.item.IItemUtils
import crafttweaker.api.oredict.IOreDict
import crafttweaker.api.oredict.IOreDictEntry
import crafttweaker.api.recipes.IFurnaceManager
import crafttweaker.api.recipes.IRecipeManager
import crafttweaker.api.server.IServer
import crafttweaker.api.vanilla.IVanilla
import crafttweaker.mc1120.brackets.BracketHandlerItem
import crafttweaker.mc1120.brackets.BracketHandlerOre
import crafttweaker.runtime.ILogger
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember

class CraftTweakerDelegate {
    @GSLWhitelistMember public IRecipeManager recipes = CraftTweakerAPI.recipes
    @GSLWhitelistMember public IFurnaceManager furnace = CraftTweakerAPI.furnace
    @GSLWhitelistMember public IOreDict oreDict = CraftTweakerAPI.oreDict
    @GSLWhitelistMember public IItemUtils itemUtils = CraftTweakerAPI.itemUtils
    @GSLWhitelistMember public IFormatter format = CraftTweakerAPI.format
    @GSLWhitelistMember public IClient client = CraftTweakerAPI.client
    @GSLWhitelistMember public IServer server = CraftTweakerAPI.server
    @GSLWhitelistMember public IEventManager events = CraftTweakerAPI.events
    @GSLWhitelistMember public IVanilla vanilla = CraftTweakerAPI.vanilla
    @GSLWhitelistMember public ILogger logger = CraftTweakerAPI.getLogger()

    @GSLWhitelistMember
    static IItemStack item(String name, int meta = 0){
        return BracketHandlerItem.getItem(name, meta)
    }
    @GSLWhitelistMember
    static IOreDictEntry ore(String name){
        return BracketHandlerOre.getOre(name)
    }

    /*static {
        BracketHandlerEntity.getEntity()
        BracketHandlerLiquid.getLiquid()
        BracketHandlerPotion.getPotion()
    }*/
}
