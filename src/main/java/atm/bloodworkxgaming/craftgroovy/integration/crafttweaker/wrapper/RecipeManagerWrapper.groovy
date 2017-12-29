package atm.bloodworkxgaming.craftgroovy.integration.crafttweaker.wrapper

import atm.bloodworkxgaming.craftgroovy.wrappers.AbstractICGWrapper
import crafttweaker.api.item.IIngredient
import crafttweaker.api.item.IItemStack
import crafttweaker.api.recipes.ICraftingRecipe
import crafttweaker.api.recipes.IRecipeAction
import crafttweaker.api.recipes.IRecipeFunction
import crafttweaker.api.recipes.IRecipeManager
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember

@GSLWhitelistClass
class RecipeManagerWrapper extends AbstractICGWrapper<IRecipeManager> {
    RecipeManagerWrapper(IRecipeManager internal) {
        super(internal)
    }

    /**
     * Returns all crafting recipes.
     *
     * @return all crafting recipes
     */
    @GSLWhitelistMember
    List<ICraftingRecipe> getAll() {
        return internal.getAll()
    }

    /**
     * Returns all crafting recipes resulting in the given ingredient.
     *
     * @param ingredient ingredient to find
     *
     * @return crafting recipes for the given item(s)
     */
    @GSLWhitelistMember
    List<ICraftingRecipe> getRecipesFor(IIngredient ingredient) {
        return internal.getRecipesFor(ingredient)
    }

    /**
     * Adds a shaped recipe.
     *
     * @param recipeName (Optional) recipe name
     * @param output recipe output
     * @param ingredients (Optional) recipe ingredients
     * @param function (Optional) recipe function
     * @param action (Optional) recipe action
     */
    @GSLWhitelistMember
    void addShaped(String recipeName = null, IItemStack output, List<List<IIngredient>> ingredients, IRecipeFunction function = null, IRecipeAction action = null) {
        if (recipeName == null) {
            internal.addShaped(output, ingredients as IIngredient[][], function, action)
        } else {
            internal.addShaped(recipeName, output, ingredients as IIngredient[][], function, action)
        }
    }

    /**
     * Adds a mirrored shaped recipe.
     *
     * @param output recipe output
     * @param ingredients recipe ingredients
     * @param function (optional)  recipe function
     */
    @GSLWhitelistMember
    void addShapedMirrored(String recipeName = null, IItemStack output, List<List<IIngredient>> inputs, IRecipeFunction iRecipeFunction = null, IRecipeAction iRecipeAction = null) {
        if (recipeName == null) {
            internal.addShapedMirrored(output, inputs as IIngredient[][], iRecipeFunction, iRecipeAction)
        } else {
            internal.addShapedMirrored(recipeName, output, inputs as IIngredient[][], iRecipeFunction, iRecipeAction)
        }
    }

    /**
     * Adds a shapeless recipe.
     *
     * @param output recipe output
     * @param ingredients recipe ingredients
     * @param function recipe function (optional)
     */
    @GSLWhitelistMember
    void addShapeless(String recipeName = null, IItemStack output, List<IIngredient> inputs, IRecipeFunction iRecipeFunction = null, IRecipeAction iRecipeAction = null) {
        if (recipeName == null) {
            internal.addShapeless(output, inputs as IIngredient[], iRecipeFunction, iRecipeAction)
        } else {
            internal.addShapeless(recipeName, output, inputs as IIngredient[], iRecipeFunction, iRecipeAction)
        }
    }

    /**
     * Removes all crafting recipes in the game
     *
     * @return amount of recipes removed.
     */
    @GSLWhitelistMember
    void removeAll() {
        internal.removeAll()
    }

    /**
     * Removes all crafting recipes crafting the specified item.
     *
     * @param output recipe output pattern
     *
     */
    @GSLWhitelistMember
    void remove(IIngredient output, boolean nbtMatch = false) {
        internal.remove(output, nbtMatch)
    }

    /**
     * Removes the recipe with the given registry name
     *
     * @param recipeName : RegistryName of the recipe
     */
    @GSLWhitelistMember
    void removeByRecipeName(String recipeName) {
        internal.removeByRecipeName(recipeName)
    }

    /**
     * Removes all recipe which match the given regex String
     *
     * @param regexString : Regex String to match to
     */
    @GSLWhitelistMember
    void removeByRegex(String regexString) {
        internal.removeByRegex(regexString)
    }

    /**
     * Removes shaped recipes.
     *
     * @param output recipe output
     * @param ingredients recipe ingredients
     *
     */
    @GSLWhitelistMember
    void removeShaped(IIngredient output, List<List<IIngredient>> ingredients = null) {
        internal.removeShaped(output, ingredients as IIngredient[][])
    }

    /**
     * Removes shapeless recipes.
     *
     * @param output recipe output
     * @param ingredients recipe ingredients
     * @param wildcard if the recipe may contain other ingredients too, besides
     *                    the ones specified
     *
     */
    @GSLWhitelistMember
    void removeShapeless(IIngredient output, List<IIngredient> ingredients, boolean wildcard = false) {
        internal.removeShapeless(output, ingredients as IIngredient[], wildcard)
    }

    /**
     * Performs a crafting with the specified ingredients. Returns null if no
     * crafting recipe exists.
     *
     * @param contents crafting inventory contents
     *
     * @return crafting result, or null
     */
    @GSLWhitelistMember
    IItemStack craft(List<List<IItemStack>> iItemStacks) {
        return internal.craft(iItemStacks as IItemStack[][])
    }
}
