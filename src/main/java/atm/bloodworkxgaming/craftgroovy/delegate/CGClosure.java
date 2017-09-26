package atm.bloodworkxgaming.craftgroovy.delegate;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import groovy.lang.Closure;
import groovy.transform.CompileStatic;

import java.util.Comparator;

@CompileStatic
public class CGClosure {
    public static final Comparator<CGClosure> CG_CLOSURE_COMPARATOR = (o1, o2) -> Integer.compare(o2.priority, o1.priority);

    @GSLWhitelistMember
    private int priority = 0;
    private Closure closure;

    public CGClosure(Closure closure) {
        this.closure = closure;
    }

    public Closure getClosure() {
        return closure;
    }

    public int getPriority() {
        return priority;
    }

    @GSLWhitelistMember
    public CGClosure setPriority(int priority) {
        this.priority = priority;
        return this;
    }
}
