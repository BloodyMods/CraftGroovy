package atm.bloodworkxgaming.craftgroovy.closures;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CGContentTweakerClosure extends CGClosure {
    private List<String> packModes;

    public CGContentTweakerClosure(Closure closure, List<String> packModes) {
        super(closure);
        this.packModes = packModes;
    }

    public List<String> getPackModes() {
        return packModes;
    }

    @GSLWhitelistMember
    public CGContentTweakerClosure addPackMode(String... packMode) {
        if (packModes == null) packModes = new ArrayList<>();
        Collections.addAll(packModes, packMode);
        return this;
    }

    @Override
    @GSLWhitelistMember
    public CGContentTweakerClosure setPriority(int priority) {
        return (CGContentTweakerClosure) super.setPriority(priority);
    }
}
