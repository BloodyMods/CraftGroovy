package atm.bloodworkxgaming.craftgroovy.wrappers

import groovy.transform.CompileStatic
import net.minecraft.entity.Entity

@CompileStatic
class PEntity extends AbstractICGWrapper<Entity> {
    PEntity(Entity internal) {
        super(internal)
    }
}
