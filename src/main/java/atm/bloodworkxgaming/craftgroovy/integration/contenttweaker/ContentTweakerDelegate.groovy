package atm.bloodworkxgaming.craftgroovy.integration.contenttweaker

import com.teamacronymcoders.base.materialsystem.MaterialException
import com.teamacronymcoders.contenttweaker.modules.materials.CTMaterialSystem
import com.teamacronymcoders.contenttweaker.modules.materials.materials.IMaterial
import com.teamacronymcoders.contenttweaker.modules.materials.materials.IMaterialBuilder
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember


class ContentTweakerDelegate {
    @GSLWhitelistMember
    static IMaterial MaterialBuilder(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = IMaterialBuilder) Closure closure) {
        def builder = CTMaterialSystem.materialBuilder
        builder.with closure
        return builder.build()
    }

    @GSLWhitelistMember
    static IMaterialBuilder getMaterialBuilder() {
        return CTMaterialSystem.materialBuilder
    }

    @GSLWhitelistMember
    static IMaterial MaterialBuilder(Map<String, Object> map) {
        def builder = CTMaterialSystem.materialBuilder

        def effect = map.getOrDefault("hasEffect", false)
        if (effect instanceof Boolean) {
            builder.hasEffect = effect
        } else {
            throw new MaterialException("Wrong type of hasEffect given")
        }

        def color = map.get("color")
        if (color instanceof Integer) {
            builder.color = (int) color
        } else {
            throw new MaterialException("No Color given")
        }

        def name = map.get("name")
        if (name instanceof String) {
            builder.name = name
        } else {
            throw new MaterialException("No Name given")
        }

        return builder.build()
    }
}
