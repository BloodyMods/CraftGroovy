package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

public abstract class ICGWrapper<R> {
    protected R internal;

    public ICGWrapper(R internal) {
        this.internal = internal;
    }

    public R getInternal() {
        return internal;
    }

    @Override
    public String toString() {
        return internal.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ICGWrapper<?> that = (ICGWrapper<?>) o;

        return internal != null ? internal.equals(that.internal) : that.internal == null;
    }

    @Override
    public int hashCode() {
        return internal != null ? internal.hashCode() : 0;
    }
}
