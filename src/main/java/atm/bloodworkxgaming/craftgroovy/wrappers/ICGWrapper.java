package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;

public abstract class ICGWrapper<R> {
    protected R internal;

    public ICGWrapper(R internal) {
        this.internal = internal;
    }

    public R getInternal() {
        return internal;
    }

    @Override
    @GSLWhitelistMember
    public String toString() {
        return internal.toString();
    }

    @Override
    @GSLWhitelistMember
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ICGWrapper<?> that = (ICGWrapper<?>) o;

        return internal != null ? internal.equals(that.internal) : that.internal == null;
    }

    @Override
    @GSLWhitelistMember
    public int hashCode() {
        return internal != null ? internal.hashCode() : 0;
    }

    @GSLWhitelistMember
    public boolean isNull() {
        return internal == null;
    }
}
