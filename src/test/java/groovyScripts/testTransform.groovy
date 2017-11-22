package groovyScripts
import crafttweaker.api.item.IIngredient
import crafttweaker.api.item.IItemStack
import crafttweaker.api.oredict.IOreDict
import crafttweaker.api.oredict.IOreDictEntry
import atm.bloodworkxgaming.craftgroovy.events.CGEventManager
import atm.bloodworkxgaming.craftgroovy.events.CGEventManager

CGEventManager.craftTweaker {
//packmode normal simplified
//modloaded overloaded


//      ==========================================================
    println(" =================== ATC OreDict (ores) =================== ");
    println(" ========================================================== ");

//====== Variables ======
//

//====== Unify ores into oredicts =======
//made by Ordinator 2017-JUL-08


    //SILVER
    ore("oreSilver").addItems([
            item("embers:ore_silver"),
            item("nmmlib:ore", 2),
            item("techreborn:ore", 13),
            item("thermalfoundation:ore", 2)
    ]);
    recipes.addShapeless("silverconvert", item("thermalfoundation:ore", 2)*2, [ore("oreSilver"), ore("oreSilver")]);


    //TIN
    ore("oreTin").addItems([
            item("embers:ore_tin"),
            item("nmmlib:ore", 1),
            item("techreborn:ore2", 1),
            item("thermalfoundation:ore", 1)
    ]);
    recipes.addShapeless("tinconvert", item("thermalfoundation:ore", 1)*2, [ore("oreTin"), ore("oreTin")]);


    //COPPER
    ore("oreCopper").addItems([
            item("embers:ore_copper"),
            item("nmmlib:ore"),
            item("techreborn:ore2"),
            item("thermalfoundation:ore")
    ]);
    recipes.addShapeless("copperconvert", item("thermalfoundation:ore")*2, [ore("oreCopper"), ore("oreCopper")]);


    //LEAD
    ore("oreLead").addItems([
            item("embers:ore_lead"),
            item("nmmlib:ore", 3),
            item("techreborn:ore", 12),
            item("thermalfoundation:ore", 3)
    ]);
    recipes.addShapeless("leadconvert", item("thermalfoundation:ore", 3)*2, [ore("oreLead"), ore("oreLead")]);


    //NICKEL
    ore("oreNickel").addItems([
            item("embers:ore_nickel"),
            item("nmmlib:ore", 4),
            item("thermalfoundation:ore", 5)
    ]);
    recipes.addShapeless("nickelconvert", item("thermalfoundation:ore", 5)*2, [ore("oreNickel"), ore("oreNickel")]);


    //ALUMINUM
    ore("oreAluminum").addItems([
            item("embers:ore_aluminum"),
            //item("techreborn:ore", 4),
            item("thermalfoundation:ore", 4)
    ]);
    ore("oreBauxite").addItems([
            item("embers:ore_aluminum"),
            item("techreborn:ore", 4),
            item("thermalfoundation:ore", 4)
    ]);
    recipes.addShapeless("aluminumconvert", item("thermalfoundation:ore", 4)*2, [ore("oreAluminum"), ore("oreAluminum")]);


    //IRIDIUM
    ore("oreIridium").addItems([
            item("techreborn:ore", 1),
            item("thermalfoundation:ore", 7)
    ]);
    recipes.addShapeless("iridiumconvert", item("thermalfoundation:ore", 7)*2, [ore("oreIridium"), ore("oreIridium")]);


    //PLATINUM-SHINY
    ore("orePlatinum").addItems([
            item("nmmlib:ore", 5),
            item("thermalfoundation:ore", 6)
    ]);
    recipes.addShapeless("platinumconvert", item("thermalfoundation:ore", 6)*2, [ore("orePlatinum"), ore("orePlatinum")]);


    //COAL
    ore("oreCoal").addItems([
            item("cyclicmagic:end_coal_ore"),
            item("cyclicmagic:nether_coal_ore"),
            item("minecraft:coal_ore")
    ]);
    recipes.addShapeless("coalconvert", item("minecraft:coal_ore")*2, [ore("oreCoal"), ore("oreCoal")]);


    //DIAMOND
    ore("oreDiamond").addItems([
            item("cyclicmagic:end_diamond_ore"),
            item("cyclicmagic:nether_diamond_ore"),
            item("minecraft:diamond_ore")
    ]);
    recipes.addShapeless("diamondconvert", item("minecraft:diamond_ore")*2, [ore("oreDiamond"), ore("oreDiamond")]);


    //EMERALD
    ore("oreEmerald").addItems([
            item("cyclicmagic:end_emerald_ore"),
            item("cyclicmagic:nether_emerald_ore"),
            item("minecraft:emerald_ore")
    ]);
    recipes.addShapeless("emeraldconvert", item("minecraft:emerald_ore")*2, [ore("oreEmerald"), ore("oreEmerald")]);


    //GAGIANITE
    /* --Ord (disabled section 12-JULY-2017)
    ore("oreGagianite").addItems([
        item("resourcefulcrops:ore"),
        item("resourcefulcrops:ore", 1)
    ]);
    recipes.addShapeless("gagianiteconvert", item("resourcefulcrops:ore")*2, [ore("oreGagianite"), ore("oreGagianite")]);
    */


    //DIMENSIONAL (RFTools)
    ore("oreDimensional").addItems([
            item("rftools:dimensional_shard_ore"),
            item("rftools:dimensional_shard_ore", 1),
            item("rftools:dimensional_shard_ore", 2)
    ]);
    recipes.addShapeless("dimensionalconvert", item("rftools:dimensional_shard_ore")*2, [ore("oreDimensional"), ore("oreDimensional")]);


    //URANIUM/YELLORIUM
    def uraniumOres = [
            item("bigreactors:brore")
    ] as IItemStack[];

    ore("oreYellorite").addItems(uraniumOres);
    ore("oreYellorium").addItems(uraniumOres);
    ore("oreUranium").addItems(uraniumOres);

    recipes.addShapeless("uraniumconvert", item("bigreactors:brore")*2, [ore("oreUranium"), ore("oreUranium")]);


    //REDSTONE
    ore("oreRedstone").addItems([
            item("cyclicmagic:end_redstone_ore"),
            item("cyclicmagic:nether_redstone_ore"),
            item("minecraft:redstone_ore")
    ]);
    recipes.addShapeless("redstoneconvert", item("minecraft:redstone_ore")*2, [ore("oreRedstone"), ore("oreRedstone")]);


    //NETHER QUARTZ
    ore("oreQuartz").addItems([
            item("embers:ore_quartz"),
            item("minecraft:quartz_ore")
    ]);
    recipes.addShapeless("netherquartzconvert", item("minecraft:quartz_ore")*2, [ore("oreQuartz"), ore("oreQuartz")]);


    //MANA-MITHRIL
    def mithrilOres = [
            item("nmmlib:ore", 6),
            item("thermalfoundation:ore", 8)
    ] as IItemStack[];

    ore("oreMithril").addItems(mithrilOres);
    ore("oreManaInfused").addItems(mithrilOres);

    recipes.addShapeless("manamithrilconvert", item("thermalfoundation:ore", 8)*2, [ore("oreMithril"), ore("oreMithril")]);


    //LAPIS
    ore("oreLapis").addItems([
            item("cyclicmagic:end_lapis_ore"),
            item("cyclicmagic:nether_lapis_ore"),
            item("minecraft:lapis_ore")
    ]);
    recipes.addShapeless("lapisconvert", item("minecraft:lapis_ore")*2, [ore("oreLapis"), ore("oreLapis")]);


    //IRON
    ore("oreIron").addItems([
            item("cyclicmagic:end_iron_ore"),
            item("cyclicmagic:nether_iron_ore"),
            item("minecraft:iron_ore")
    ]);
    recipes.addShapeless("ironconvert", item("minecraft:iron_ore")*2, [ore("oreIron"), ore("oreIron")]);


    //GOLD
    ore("oreGold").addItems([
            item("cyclicmagic:end_gold_ore"),
            item("cyclicmagic:nether_gold_ore"),
            item("minecraft:gold_ore")
    ]);
    recipes.addShapeless("goldconvert", item("minecraft:gold_ore")*2, [ore("oreGold"), ore("oreGold")]);


    //GEM PERIDOT
    ore("orePeridot").addItems([
            item("biomesoplenty:gem_ore", 2),
            item("techreborn:ore", 10)
    ]);
    recipes.addShapeless("peridotconvert", item("techreborn:ore", 10)*2, [ore("orePeridot"), ore("orePeridot")]);


    //GEM RUBY
    ore("oreRuby").addItems([
            item("biomesoplenty:gem_ore", 1),
            item("techreborn:ore", 2)
    ]);
    recipes.addShapeless("rubyconvert", item("techreborn:ore", 2)*2, [ore("oreRuby"), ore("oreRuby")]);


    //GEM SAPPHIRE
    ore("oreSapphire").addItems([
            item("biomesoplenty:gem_ore", 6),
            item("techreborn:ore", 3)
    ]);
    recipes.addShapeless("sapphireconvert", item("techreborn:ore", 3)*2, [ore("oreSapphire"), ore("oreSapphire")]);


    // Provide tooltips on how to make ingots from certain early-game dusts
    final def crCopperDust = item("crossroads:dustCopper");
    final def ic2GoldDust = item("ic2:dust", 7);
    final def rockhoundingCobaltDust = item("rockhounding_chemistry:chemicalDusts", 27);
    final def eIOCobaltDust = item("enderio:itemPowderIngot", 10);
    def nonFurnaceDust = [
            crCopperDust,
            ic2GoldDust,
            rockhoundingCobaltDust,
            eIOCobaltDust

    ] as IItemStack[];

    nonFurnaceDust.eachWithIndex { dust, int index ->
        dust.addTooltip(format.red("Cannot smelt using vanilla smelting, eg furnace. You must use Tinkers Construct Smeltery or other mechanism. Refer to JEI."));
    }

    for (index in 0 .. 122) {
        dust.addTooltip(format.red("Cannot smelt using vanilla smelting, eg furnace. You must use Tinkers Construct Smeltery or other mechanism. Refer to JEI."));
    }

    def miscItems = [
            item("minecraft:torch"),
            item("tconstruct:momsspagetti"),
            item("minecraft:stone")
    ] as IItemStack[];

    for (x in miscItems) {
        if (x != null | x == null) {
            recipes.remove(x);
        }
    }



//      ==========================================================
    println(" =================== Compressed Blocks  =================== ");
    println(" ========================================================== ");


    compressRecipes(
            ore("cobblestone"),
            item("minecraft:cobblestone", 0),
            item("overloaded:compressed_cobblestone", 0),
            item("overloaded:compressed_cobblestone", 1),
            item("overloaded:compressed_cobblestone", 2),
            item("overloaded:compressed_cobblestone", 3)
    );


    compressRecipes(
            ore("sand"),
            item("minecraft:sand", 0),
            item("overloaded:compressed_sand", 0),
            item("overloaded:compressed_sand", 1),
            item("overloaded:compressed_sand", 2),
            item("overloaded:compressed_sand", 3)
    );


    compressRecipes(
            ore("stone"),
            item("minecraft:stone", 0),
            item("overloaded:compressed_stone", 0),
            item("overloaded:compressed_stone", 1),
            item("overloaded:compressed_stone", 2),
            item("overloaded:compressed_stone", 3)
    );


    compressRecipes(
            ore("obsidian"),
            item("minecraft:obsidian", 0),
            item("overloaded:compressed_obsidian", 0),
            item("overloaded:compressed_obsidian", 1),
            item("overloaded:compressed_obsidian", 2),
            item("overloaded:compressed_obsidian", 3)
    );


    compressRecipes(
            ore("netherrack"),
            item("minecraft:netherrack", 0),
            item("overloaded:compressed_netherrack", 0),
            item("overloaded:compressed_netherrack", 1),
            item("overloaded:compressed_netherrack", 2),
            item("overloaded:compressed_netherrack", 3)
    );


    compressRecipes(
            ore("dirt"),
            item("minecraft:dirt", 0),
            item("overloaded:compressed_dirt", 0),
            item("overloaded:compressed_dirt", 1),
            item("overloaded:compressed_dirt", 2),
            item("overloaded:compressed_dirt", 3)
    );


    compressRecipes(
            ore("gravel"),
            item("minecraft:gravel", 0),
            item("overloaded:compressed_gravel", 0),
            item("overloaded:compressed_gravel", 1),
            item("overloaded:compressed_gravel", 2),
            item("overloaded:compressed_gravel", 3)
    );


    compressRecipes(
            ore("sandstone"),
            item("minecraft:sandstone", 0),
            item("overloaded:compressed_sandstone", 0),
            item("overloaded:compressed_sandstone", 1),
            item("overloaded:compressed_sandstone", 2),
            item("overloaded:compressed_sandstone", 3)
    );


    compressRecipes(
            item("minecraft:nether_brick", 0),
            item("minecraft:nether_brick", 0),
            item("overloaded:compressed_nether_brick", 0),
            item("overloaded:compressed_nether_brick", 1),
            item("overloaded:compressed_nether_brick", 2),
            item("overloaded:compressed_nether_brick", 3)
    );


    compressRecipes(
            ore("crafterWood"),
            item("minecraft:crafting_table", 0),
            item("overloaded:compressed_crafting_table", 0),
            item("overloaded:compressed_crafting_table", 1),
            item("overloaded:compressed_crafting_table", 2),
            item("overloaded:compressed_crafting_table", 3)
    );


    compressRecipes(
            ore("blockMagma"),
            item("minecraft:magma", 0),
            item("overloaded:compressed_magma", 0),
            item("overloaded:compressed_magma", 1),
            item("overloaded:compressed_magma", 2),
            item("overloaded:compressed_magma", 3)
    );


    compressRecipes(
            ore("blockMossy"),
            item("minecraft:mossy_cobblestone", 0),
            item("overloaded:compressed_mossy_cobblestone", 0),
            item("overloaded:compressed_mossy_cobblestone", 1),
            item("overloaded:compressed_mossy_cobblestone", 2),
            item("overloaded:compressed_mossy_cobblestone", 3)
    );


    compressRecipes(
            ore("blockSlime"),
            item("minecraft:slime", 0),
            item("overloaded:compressed_slime", 0),
            item("overloaded:compressed_slime", 1),
            item("overloaded:compressed_slime", 2),
            item("overloaded:compressed_slime", 3)
    );


    compressRecipes(
            ore("blockWool"),
            item("minecraft:wool", 0),
            item("overloaded:compressed_wool", 0),
            item("overloaded:compressed_wool", 1),
            item("overloaded:compressed_wool", 2),
            item("overloaded:compressed_wool", 3)
    );


    compressRecipes(
            ore("endstone"),
            item("minecraft:end_stone", 0),
            item("overloaded:compressed_end_stone", 0),
            item("overloaded:compressed_end_stone", 1),
            item("overloaded:compressed_end_stone", 2),
            item("overloaded:compressed_end_stone", 3)
    );


    compressRecipes(
            ore("logWood"),
            item("minecraft:log", 0),
            item("overloaded:compressed_log", 0),
            item("overloaded:compressed_log", 1),
            item("overloaded:compressed_log", 2),
            item("overloaded:compressed_log", 3)
    );


    compressRecipes(
            ore("blockSalt"),
            item("mekanism:saltblock", 0),
            item("overloaded:compressed_saltblock", 0),
            item("overloaded:compressed_saltblock", 1),
            item("overloaded:compressed_saltblock", 2),
            item("overloaded:compressed_saltblock", 3)
    );


    compressRecipes(
            ore("soulSand"),
            item("minecraft:soul_sand", 0),
            item("overloaded:compressed_soul_sand", 0),
            item("overloaded:compressed_soul_sand", 1),
            item("overloaded:compressed_soul_sand", 2),
            item("overloaded:compressed_soul_sand", 3)
    );


    compressRecipes(
            ore("blockRedstone"),
            item("minecraft:redstone_block", 0),
            item("overloaded:compressed_redstone_block", 0),
            item("overloaded:compressed_redstone_block", 1),
            item("overloaded:compressed_redstone_block", 2),
            item("overloaded:compressed_redstone_block", 3)
    );


    compressRecipes(
            ore("blockCoal"),
            item("minecraft:coal_block", 0),
            item("overloaded:compressed_coal_block", 0),
            item("overloaded:compressed_coal_block", 1),
            item("overloaded:compressed_coal_block", 2),
            item("overloaded:compressed_coal_block", 3)
    );


    compressRecipes(
            item("minecraft:sea_lantern", 0),
            item("minecraft:sea_lantern", 0),
            item("overloaded:compressed_sea_lantern", 0),
            item("overloaded:compressed_sea_lantern", 1),
            item("overloaded:compressed_sea_lantern", 2),
            item("overloaded:compressed_sea_lantern", 3)
    );


    compressRecipes(
            ore("glowstone"),
            item("minecraft:glowstone", 0),
            item("overloaded:compressed_glowstone", 0),
            item("overloaded:compressed_glowstone", 1),
            item("overloaded:compressed_glowstone", 2),
            item("overloaded:compressed_glowstone", 3)
    );


    compressRecipes(
            ore("blockGold"),
            item("minecraft:gold_block", 0),
            item("overloaded:compressed_gold_block", 0),
            item("overloaded:compressed_gold_block", 1),
            item("overloaded:compressed_gold_block", 2),
            item("overloaded:compressed_gold_block", 3)
    );


    compressRecipes(
            ore("blockIron"),
            item("minecraft:iron_block", 0),
            item("overloaded:compressed_iron_block", 0),
            item("overloaded:compressed_iron_block", 1),
            item("overloaded:compressed_iron_block", 2),
            item("overloaded:compressed_iron_block", 3)
    );


    compressRecipes(
            ore("blockQuartz"),
            item("minecraft:quartz_block", 0),
            item("overloaded:compressed_quartz_block", 0),
            item("overloaded:compressed_quartz_block", 1),
            item("overloaded:compressed_quartz_block", 2),
            item("overloaded:compressed_quartz_block", 3)
    );


    compressRecipes(
            ore("industrialTnt"),
            item("minecraft:tnt", 0),
            item("overloaded:compressed_tnt", 0),
            item("overloaded:compressed_tnt", 1),
            item("overloaded:compressed_tnt", 2),
            item("overloaded:compressed_tnt", 3)
    );


    compressRecipes(
            ore("blockDiamond"),
            item("minecraft:diamond_block", 0),
            item("overloaded:compressed_diamond_block", 0),
            item("overloaded:compressed_diamond_block", 1),
            item("overloaded:compressed_diamond_block", 2),
            item("overloaded:compressed_diamond_block", 3)
    );


    compressRecipes(
            ore("blockEmerald"),
            item("minecraft:emerald_block", 0),
            item("overloaded:compressed_emerald_block", 0),
            item("overloaded:compressed_emerald_block", 1),
            item("overloaded:compressed_emerald_block", 2),
            item("overloaded:compressed_emerald_block", 3)
    );


    compressRecipes(
            item("overloaded:nether_star_block", 0),
            item("overloaded:nether_star_block", 0),
            item("overloaded:compressed_nether_star_block", 0),
            item("overloaded:compressed_nether_star_block", 1),
            item("overloaded:compressed_nether_star_block", 2),
            item("overloaded:compressed_nether_star_block", 3)
    );


    compressRecipes(
            ore("blockLapis"),
            item("minecraft:lapis_block", 0),
            item("overloaded:compressed_lapis", 0),
            item("overloaded:compressed_lapis", 1),
            item("overloaded:compressed_lapis", 2),
            item("overloaded:compressed_lapis", 3)
    );


    compressRecipes(
            ore("blockOsmium"),
            item("mekanism:basicblock", 0),
            item("overloaded:compressed_osmium", 0),
            item("overloaded:compressed_osmium", 1),
            item("overloaded:compressed_osmium", 2),
            item("overloaded:compressed_osmium", 3)
    );


    compressRecipes(
            ore("blockSteel"),
            item("thermalfoundation:storage_alloy", 0),
            item("overloaded:compressed_steel", 0),
            item("overloaded:compressed_steel", 1),
            item("overloaded:compressed_steel", 2),
            item("overloaded:compressed_steel", 3)
    );


    compressRecipes(
            ore("blockApatite"),
            item("forestry:resource_storage", 0),
            item("overloaded:compressed_apatite", 0),
            item("overloaded:compressed_apatite", 1),
            item("overloaded:compressed_apatite", 2),
            item("overloaded:compressed_apatite", 3)
    );


    compressRecipes(
            ore("blockMarble"),
            item("chisel:marble2", 7),
            item("overloaded:compressed_marble", 0),
            item("overloaded:compressed_marble", 1),
            item("overloaded:compressed_marble", 2),
            item("overloaded:compressed_marble", 3)
    );


    compressRecipes(
            ore("blockCopper"),
            item("thermalfoundation:storage", 0),
            item("overloaded:compressed_copper", 0),
            item("overloaded:compressed_copper", 1),
            item("overloaded:compressed_copper", 2),
            item("overloaded:compressed_copper", 3)
    );


    compressRecipes(
            ore("blockTin"),
            item("thermalfoundation:storage", 1),
            item("overloaded:compressed_tin", 0),
            item("overloaded:compressed_tin", 1),
            item("overloaded:compressed_tin", 2),
            item("overloaded:compressed_tin", 3)
    );


    compressRecipes(
            ore("blockSilver"),
            item("thermalfoundation:storage", 2),
            item("overloaded:compressed_silver", 0),
            item("overloaded:compressed_silver", 1),
            item("overloaded:compressed_silver", 2),
            item("overloaded:compressed_silver", 3)
    );


    compressRecipes(
            ore("blockLead"),
            item("thermalfoundation:storage", 3),
            item("overloaded:compressed_lead", 0),
            item("overloaded:compressed_lead", 1),
            item("overloaded:compressed_lead", 2),
            item("overloaded:compressed_lead", 3)
    );


    compressRecipes(
            ore("blockAluminum"),
            item("thermalfoundation:storage", 4),
            item("overloaded:compressed_aluminum", 0),
            item("overloaded:compressed_aluminum", 1),
            item("overloaded:compressed_aluminum", 2),
            item("overloaded:compressed_aluminum", 3)
    );


    compressRecipes(
            ore("blockNickel"),
            item("thermalfoundation:storage", 5),
            item("overloaded:compressed_nickel", 0),
            item("overloaded:compressed_nickel", 1),
            item("overloaded:compressed_nickel", 2),
            item("overloaded:compressed_nickel", 3)
    );


    compressRecipes(
            ore("blockPlatinum"),
            item("thermalfoundation:storage", 6),
            item("overloaded:compressed_platinum", 0),
            item("overloaded:compressed_platinum", 1),
            item("overloaded:compressed_platinum", 2),
            item("overloaded:compressed_platinum", 3)
    );


    compressRecipes(
            ore("blockIridium"),
            item("thermalfoundation:storage", 7),
            item("overloaded:compressed_iridium", 0),
            item("overloaded:compressed_iridium", 1),
            item("overloaded:compressed_iridium", 2),
            item("overloaded:compressed_iridium", 3)
    );


    compressRecipes(
            ore("blockMithril"),
            item("thermalfoundation:storage", 8),
            item("overloaded:compressed_mana", 0),
            item("overloaded:compressed_mana", 1),
            item("overloaded:compressed_mana", 2),
            item("overloaded:compressed_mana", 3)
    );


    compressRecipes(
            item("actuallyadditions:block_misc", 2),
            item("actuallyadditions:block_misc", 2),
            item("overloaded:compressed_black_quartz", 0),
            item("overloaded:compressed_black_quartz", 1),
            item("overloaded:compressed_black_quartz", 2),
            item("overloaded:compressed_black_quartz", 3)
    );


    compressRecipes(
            ore("blockCobalt"),
            item("tconstruct:metal", 0),
            item("overloaded:compressed_cobalt", 0),
            item("overloaded:compressed_cobalt", 1),
            item("overloaded:compressed_cobalt", 2),
            item("overloaded:compressed_cobalt", 3)
    );


    compressRecipes(
            ore("blockArdite"),
            item("tconstruct:metal", 1),
            item("overloaded:compressed_ardite", 0),
            item("overloaded:compressed_ardite", 1),
            item("overloaded:compressed_ardite", 2),
            item("overloaded:compressed_ardite", 3)
    );


    compressRecipes(
            item("appliedenergistics2:quartz_block", 0),
            item("appliedenergistics2:quartz_block", 0),
            item("overloaded:compressed_certus", 0),
            item("overloaded:compressed_certus", 1),
            item("overloaded:compressed_certus", 2),
            item("overloaded:compressed_certus", 3)
    );


    compressRecipes(
            ore("blockDraconium"),
            item("draconicevolution:draconium_block", 0),
            item("overloaded:compressed_draconium", 0),
            item("overloaded:compressed_draconium", 1),
            item("overloaded:compressed_draconium", 2),
            item("overloaded:compressed_draconium", 3)
    );


    compressRecipes(
            ore("blockTungsten"),
            item("techreborn:storage", 10),
            item("overloaded:compressed_tungsten", 0),
            item("overloaded:compressed_tungsten", 1),
            item("overloaded:compressed_tungsten", 2),
            item("overloaded:compressed_tungsten", 3)
    );


    compressRecipes(
            ore("blockUranium"),
            item("immersiveengineering:storage", 5),
            item("overloaded:compressed_uranium", 0),
            item("overloaded:compressed_uranium", 1),
            item("overloaded:compressed_uranium", 2),
            item("overloaded:compressed_uranium", 3)
    );


//====== Fix EXU2 recipes ======
//
    recipes.addShapeless(item("minecraft:dirt")*9,[item("extrautils2:compresseddirt")]);
    recipes.addShapeless(item("minecraft:cobblestone")*9,[item("extrautils2:compressedcobblestone")]);
    recipes.addShapeless(item("minecraft:sand")*9,[item("extrautils2:compressedsand")]);
    recipes.addShapeless(item("minecraft:gravel")*9,[item("extrautils2:compressedgravel")]);
    recipes.addShapeless(item("minecraft:netherrack")*9,[item("extrautils2:compressednetherrack")]);



//====== Function for all crafting recipes ======
//
    function compressRecipes(
            oredInput as IIngredient, /* Oredict or item stack that can be compressed into 1x */
            basicItem as IItemStack,  /* Item that the 1x compressed is crafted BACK out into */
            comprSngl as IItemStack,  /* Compressed Block 1x */
            comprDoub as IItemStack,  /* Compressed Block 2x */
            comprTrip as IItemStack,  /* Compressed Block 3x */
            comprQuad as IItemStack   /* Compressed Block 4x */
    ) {

        // Cleanup any possible existing recipes (thoroughness)
        recipes.removeShapeless(comprSngl);
        recipes.removeShapeless(comprDoub);
        recipes.removeShapeless(comprTrip);
        recipes.removeShapeless(comprQuad);
        //recipes.removeShapeless(basicItem, [comprSngl]);
        //recipes.removeShapeless(oredInput, [comprSngl]);
        //recipes.removeShapeless(basicItem*9, [comprSngl]);
        //recipes.removeShapeless(oredInput*9, [comprSngl]);

        // Turn any compatable oredict into compressed block
        recipes.addShapeless(comprSngl, [
                oredInput, oredInput, oredInput,
                oredInput, oredInput, oredInput,
                oredInput, oredInput, oredInput
        ]);

        // Turn 1x compressed into 2x
        recipes.addShapeless(comprDoub, [
                comprSngl, comprSngl, comprSngl,
                comprSngl, comprSngl, comprSngl,
                comprSngl, comprSngl, comprSngl
        ]);

        // Turn 2x compressed into 3x
        recipes.addShapeless(comprTrip, [
                comprDoub, comprDoub, comprDoub,
                comprDoub, comprDoub, comprDoub,
                comprDoub, comprDoub, comprDoub
        ]);

        // Turn 3x compressed into 4x
        recipes.addShapeless(comprQuad, [
                comprTrip, comprTrip, comprTrip,
                comprTrip, comprTrip, comprTrip,
                comprTrip, comprTrip, comprTrip
        ]);

        // Turn compressed 1x block back into base item
        recipes.removeShapeless(basicItem*9, [comprSngl]);
        recipes.addShapeless(basicItem*9, [comprSngl]);

        // Turn compressed 2x block back into 1x compressed
        recipes.removeShapeless(comprSngl*9, [comprDoub]);
        recipes.addShapeless(comprSngl*9, [comprDoub]);

        // Turn compressed 3x block back into 2x compressed
        recipes.removeShapeless(comprDoub*9, [comprTrip]);
        recipes.addShapeless(comprDoub*9, [comprTrip]);

        // Turn compressed 4x block back into 3x compressed
        recipes.removeShapeless(comprTrip*9, [comprQuad]);
        recipes.addShapeless(comprTrip*9, [comprQuad]);
    }

}
