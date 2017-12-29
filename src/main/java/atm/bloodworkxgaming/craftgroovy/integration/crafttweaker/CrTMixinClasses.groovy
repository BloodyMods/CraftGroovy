package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker

import crafttweaker.api.item.IIngredient
import crafttweaker.api.item.IItemStack
import crafttweaker.api.oredict.IOreDictEntry
import crafttweaker.api.recipes.IRecipeAction
import crafttweaker.api.recipes.IRecipeFunction
import crafttweaker.api.recipes.IRecipeManager
import crafttweaker.mc1120.brackets.BracketHandlerItem
import de.bloodworkxgaming.groovysandboxedlauncher.compilercustomizer.IMixinProvider

class CrTMixinClasses implements IMixinProvider {
    @Override
    void mixIn() {
        IRecipeManager.metaClass.addShaped { IItemStack out, List<List<IIngredient>> ingred, IRecipeFunction recipeFunction = null, IRecipeAction recipeAction = null ->
            def recipeManager = delegate as IRecipeManager
            recipeManager.addShaped(out, ingred as IIngredient[][], recipeFunction, recipeAction)
        }

        IRecipeManager.metaClass.addShaped { String name, IItemStack out, List<List<IIngredient>> ingred, IRecipeFunction recipeFunction = null, IRecipeAction recipeAction = null ->
            def recipeManager = delegate as IRecipeManager
            recipeManager.addShaped(name, out, ingred as IIngredient[][], recipeFunction, recipeAction)
        }

        IRecipeManager.metaClass.addShapeless { String name, IItemStack out, List<IIngredient> ingred, IRecipeFunction recipeFunction = null, IRecipeAction recipeAction = null ->
            def recipeManager = delegate as IRecipeManager
            recipeManager.addShapeless(name, out, ingred as IIngredient[], recipeFunction, recipeAction)
        }

        IRecipeManager.metaClass.addShapeless { IItemStack out, List<IIngredient> ingred, IRecipeFunction recipeFunction = null, IRecipeAction recipeAction = null ->
            def recipeManager = delegate as IRecipeManager
            recipeManager.addShapeless(out, ingred as IIngredient[], recipeFunction, recipeAction)
        }

        IOreDictEntry.metaClass.addItems { List<IItemStack> items ->
            def oredictEntry = delegate as IOreDictEntry
            oredictEntry.addItems(items as IItemStack[])
        }

        IItemStack.metaClass.power { int p ->
            def item = delegate as IItemStack

            return BracketHandlerItem.getItem(item.definition.name, p)
        }
    }
}
