package atm.bloodworkxgaming.craftgroovy.worldgen.worldgenTypes;

public interface CGWorldGenerationEvent<T extends BaseWorldgenType> {
    boolean generateWorld(T worldGenTypeObject);
}
