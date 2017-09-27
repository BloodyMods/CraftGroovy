package atm.bloodworkxgaming.craftgroovy.events;

import atm.bloodworkxgaming.craftgroovy.CraftGroovy;
import atm.bloodworkxgaming.craftgroovy.delegate.CGClosure;
import groovy.lang.Closure;

import java.util.*;

public class ClosureManager {
    public static final Comparator<CGClosure> CG_CLOSURE_COMPARATOR = (o1, o2) -> Integer.compare(o2.getPriority(), o1.getPriority());

     private static Map<String, List<CGClosure>> closuresMap = new HashMap<>();

    public static void addClosureToMap(String eventName, CGClosure closure){
        List<CGClosure> list = closuresMap.getOrDefault(eventName, new ArrayList<>());
        list.add(closure);
        list.sort(CG_CLOSURE_COMPARATOR);

        closuresMap.put(eventName, list);
    }

    public static CGClosure addClosureToMap(String eventName, Closure closure){
        CGClosure cgClosure = new CGClosure(closure);
        addClosureToMap(eventName, cgClosure);
        return cgClosure;
    }

    public static void runClosuresWithDelegate(Object delegate, String closureName) {
        List<CGClosure> closures = closuresMap.get(closureName);
        runClosuresWithDelegate(delegate, closures);
    }

    public static void runClosuresWithDelegate(Object delegate, List<? extends CGClosure> cgClosures) {
        if (cgClosures != null){
            for (CGClosure cgClosure : cgClosures) {
                Closure closure = cgClosure.getClosure();
                Closure code = closure.rehydrate(delegate, closure.getOwner(), closure.getThisObject());
                code.setResolveStrategy(Closure.DELEGATE_FIRST);

                CraftGroovy.sandboxedLauncher.runClosure(code);
            }
        }
    }

    public static Map<String, List<CGClosure>> getClosuresMap() {
        return closuresMap;
    }

    public static List<CGClosure> getClosuresList(String name) {
        return closuresMap.getOrDefault(name, Collections.emptyList());
    }

    public static void clearMap(){
        closuresMap.clear();
    }
}
