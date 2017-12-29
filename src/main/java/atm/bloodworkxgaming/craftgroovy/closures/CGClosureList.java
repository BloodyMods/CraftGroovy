package atm.bloodworkxgaming.craftgroovy.closures;

import atm.bloodworkxgaming.craftgroovy.events.ClosureManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CGClosureList<T extends CGClosure> {
    private List<T> list;
    private boolean sorted = false;
    private Comparator<? super T> comparator;

    public CGClosureList(List<T> list, Comparator<? super T> comparator) {
        this.list = list;
        this.comparator = comparator;
    }

    public CGClosureList(List<T> list) {
        this.list = list;
        this.comparator = ClosureManager.CG_CLOSURE_COMPARATOR;
    }

    public CGClosureList() {
        this.list = new ArrayList<>();
        this.comparator = ClosureManager.CG_CLOSURE_COMPARATOR;
    }

    public CGClosureList(Comparator<? super T> comparator) {
        this.list = new ArrayList<>();
        this.comparator = comparator;
    }

    public List<T> getList() {
        return list;
    }

    public boolean add(T cgClosure) {
        sorted = false;
        return list.add(cgClosure);
    }

    public boolean addAll(Collection<T> c) {
        sorted = false;
        return list.addAll(c);
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    public void sort() {
        list.sort(comparator);
        sorted = true;
    }
}
