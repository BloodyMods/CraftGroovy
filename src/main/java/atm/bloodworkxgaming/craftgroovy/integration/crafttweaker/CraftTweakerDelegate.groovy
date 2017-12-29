package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker

import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.dsl.CrTItemProp
import atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.wrapper.RecipeManagerWrapper
import atm.bloodworkxgaming.craftgroovy.integration.zenScript.FakeZenTokener
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
import crafttweaker.zenscript.GlobalRegistry
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import groovy.transform.CompileStatic
import net.minecraft.nbt.JsonToNBT
import org.apache.commons.lang3.reflect.FieldUtils
import stanhebben.zenscript.ZenParsedFile
import stanhebben.zenscript.expression.Expression
import stanhebben.zenscript.expression.ExpressionCallStatic
import stanhebben.zenscript.type.ZenType
import stanhebben.zenscript.type.natives.IJavaMethod
import stanhebben.zenscript.type.natives.JavaMethod
import stanhebben.zenscript.util.ZenPosition

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
    static CrTItemProp getItem() {
        new CrTItemProp()
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
    static Object bracket(String arg) {
        def tokens = FakeZenTokener.getTokensFromString(arg)
        def zen = GlobalRegistry.resolveBracket(FakeZenTokener.globalEnv, tokens)

        def pos = new ZenPosition(new ZenParsedFile("bracketHelperFile.zs", "BracketHelberFile", FakeZenTokener.fakeZenTokener, FakeZenTokener.globalEnv), 1, 1, "bracketHelberFile.zs")
        def exp = zen?.instance(pos)

        if (exp instanceof ExpressionCallStatic) {
            def zenMethod = FieldUtils.readField(exp, "method", true) as IJavaMethod
            def arguments = FieldUtils.readField(exp, "arguments", true) as Expression[]

            List<Object> argList = []
            arguments.eachWithIndex { Expression entry, int i ->

                try {
                    def val = FieldUtils.readField(entry, "value", true)

                    switch (entry.getType()) {
                        case ZenType.INT:
                            val = val as int
                            break
                        case ZenType.LONG:
                            val = val as long
                            break
                        case ZenType.BOOL:
                            val = val as boolean
                            break
                        case ZenType.BYTE:
                            val = val as byte
                            break
                        case ZenType.FLOAT:
                            val = val as float
                            break
                        case ZenType.DOUBLE:
                            val = val as double
                            break
                    }

                    argList.add(val)
                } catch (NoSuchFieldException e) {
                    println "No such field: value in $entry"
                    e.printStackTrace()
                }
            }

            if (zenMethod instanceof JavaMethod) {
                def method = zenMethod.getMethod()
                def ret = method.invoke(null, argList as Object[])

                println ret
                return ret
            }
        }


        return null
    }

    @GSLWhitelistMember
    static IData nbt(String string) {
        NBTConverter.from(JsonToNBT.getTagFromJson(string), true)
    }
}
