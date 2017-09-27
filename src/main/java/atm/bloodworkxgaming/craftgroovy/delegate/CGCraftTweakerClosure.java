package atm.bloodworkxgaming.craftgroovy.delegate;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import groovy.lang.Closure;

public class CGCraftTweakerClosure extends CGClosure {
    private String loaderName;
    private String packMode;

    public CGCraftTweakerClosure(Closure closure, String loaderName, String packMode) {
        super(closure);
        this.loaderName = loaderName;
        this.packMode = packMode;
    }


    public String getLoaderName() {
        return loaderName;
    }

    public String getPackMode() {
        return packMode;
    }

    @GSLWhitelistMember
    public CGCraftTweakerClosure setLoaderName(String loaderName) {
        this.loaderName = loaderName;
        return this;
    }

    @GSLWhitelistMember
    public CGCraftTweakerClosure setPackMode(String packMode) {
        this.packMode = packMode;
        return this;
    }

    @Override
    @GSLWhitelistMember
    public CGCraftTweakerClosure setPriority(int priority) {
        return (CGCraftTweakerClosure) super.setPriority(priority);
    }
}
