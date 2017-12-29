package atm.bloodworkxgaming.craftgroovy.closures;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CGCraftTweakerClosure extends CGClosure {
    private String loaderName;
    private List<String> packModes;

    public CGCraftTweakerClosure(Closure closure, String loaderName, List<String> packModes) {
        super(closure);
        this.loaderName = loaderName;
        this.packModes = packModes;
    }


    public String getLoaderName() {
        return loaderName;
    }

    @GSLWhitelistMember
    public CGCraftTweakerClosure setLoaderName(String loaderName) {
        this.loaderName = loaderName;
        return this;
    }

    public List<String> getPackModes() {
        return packModes;
    }

    @GSLWhitelistMember
    public CGCraftTweakerClosure addPackMode(String... packMode) {
        if (packModes == null) packModes = new ArrayList<>();
        Collections.addAll(packModes, packMode);
        return this;
    }

    @Override
    @GSLWhitelistMember
    public CGCraftTweakerClosure setPriority(int priority) {
        return (CGCraftTweakerClosure) super.setPriority(priority);
    }
}
