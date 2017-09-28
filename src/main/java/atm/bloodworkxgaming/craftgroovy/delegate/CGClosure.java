package atm.bloodworkxgaming.craftgroovy.delegate;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import groovy.lang.Closure;
import groovy.transform.CompileStatic;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Comparator;

@CompileStatic
public class CGClosure {
    @GSLWhitelistMember
    private int priority = 0;
    private Side side;
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

    public Side getSide() {
        return side;
    }

    @GSLWhitelistMember
    public CGClosure setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    @GSLWhitelistMember
    public CGClosure clientOnly(){
        side = Side.CLIENT;
        return this;
    }

    @GSLWhitelistMember
    public CGClosure serverOnly(){
        side = Side.SERVER;
        return this;
    }


}
