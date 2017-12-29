package groovyScripts

import atm.bloodworkxgaming.craftgroovy.events.CGEventManager
import crafttweaker.api.item.IItemStack
import groovy.transform.Field

@Field
static IItemStack iron

@Field
static IItemStack coal

CGEventManager.craftTweaker {
    iron = item("minecraft:iron_ingot")
    coal = item("minecraft:coal")
}.setPriority(100)