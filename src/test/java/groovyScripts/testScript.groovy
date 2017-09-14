package groovyScripts

import crafttweaker.CraftTweakerAPI
import crafttweaker.api.item.IIngredient

import static crafttweaker.CraftTweakerAPI.logCommand
import static crafttweaker.CraftTweakerAPI.logger
import static crafttweaker.CraftTweakerAPI.recipes
import static crafttweaker.mc1120.brackets.BracketHandlerItem.getItem

println "Hi I am a test script"

def coal = getItem("minecraft:coal", 0)
def iron = getItem("minecraft:iron_ingot", 0)
println coal.anyAmount()

Class<?> bla = IIngredient

recipes.addShaped(coal.amount(20), [[coal], [coal]] as IIngredient[][])
recipes.addShapeless(coal.amount(10), [coal, coal, iron, iron] as IIngredient[], null, null)


logger.logError"blablalbla"
logger.logWarning("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")

