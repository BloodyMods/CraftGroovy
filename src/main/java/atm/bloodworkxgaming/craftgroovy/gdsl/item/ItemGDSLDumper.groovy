package atm.bloodworkxgaming.craftgroovy.gdsl.item

import atm.bloodworkxgaming.craftgroovy.CraftGroovy

class ItemGDSLDumper {
    static void dumpItems(File f){
        PrintWriter writer = null
        try {
            writer = new PrintWriter(f)







        } catch (Exception e){
            CraftGroovy.error("Errored while gdsling items", e)
            writer?.flush()
            writer?.close()
        }
    }
}
