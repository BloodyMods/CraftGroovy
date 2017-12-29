package atm.bloodworkxgaming.craftgroovy.events;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.closures.CGClosure;
import atm.bloodworkxgaming.craftgroovy.closures.CGClosureList;
import groovy.lang.Closure;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class ClosureManager {
    public static final Comparator<CGClosure> CG_CLOSURE_COMPARATOR = (o1, o2) -> Integer.compare(o2.getPriority(), o1.getPriority());

    private static Map<String, CGClosureList<CGClosure>> closuresMap = new HashMap<>();

    public static void addClosureToMap(String eventName, CGClosure closure) {
        CGClosureList<CGClosure> list = closuresMap.getOrDefault(eventName, new CGClosureList<>(new ArrayList<>(), CG_CLOSURE_COMPARATOR));
        list.add(closure);

        closuresMap.put(eventName, list);
    }

    public static CGClosure addClosureToMap(String eventName, Closure closure) {
        CGClosure cgClosure = new CGClosure(closure);
        addClosureToMap(eventName, cgClosure);
        return cgClosure;
    }

    public static void runClosuresWithDelegate(Object delegate, String closureName) {
        runClosuresWithDelegate(delegate, closureName, null);
    }

    public static void runClosuresWithDelegate(Object delegate, String closureName, Predicate<CGClosure> shouldRun) {
        CGClosureList<CGClosure> closures = closuresMap.get(closureName);
        runClosuresWithDelegate(delegate, closures, shouldRun);
    }

    public static void runClosuresWithDelegate(Object delegate, CGClosureList<? extends CGClosure> closureList, Predicate<CGClosure> shouldRun) {
        if (closureList != null && closureList.getList() != null) {
            if (!closureList.isSorted()) closureList.sort();

            for (CGClosure cgClosure : closureList.getList()) {
                if (shouldRun == null || shouldRun.test(cgClosure)) {
                    Closure closure = cgClosure.getClosure();
                    Closure code = closure.rehydrate(delegate, closure.getOwner(), closure.getThisObject());
                    code.setResolveStrategy(Closure.DELEGATE_FIRST);

                    CraftGroovy.info("Running closure [" + closure.getClass() + " > " + delegate.getClass().getSimpleName() + "]");
                    CraftGroovy.sandboxedLauncher.runClosure(code);
                }
            }
        }
    }

    public static Map<String, CGClosureList<CGClosure>> getClosuresMap() {
        return closuresMap;
    }

    @Nullable
    public static CGClosureList<CGClosure> getClosuresList(String name) {
        return closuresMap.get(name);
    }

    public static void clearMap() {
        closuresMap.clear();
    }
}
