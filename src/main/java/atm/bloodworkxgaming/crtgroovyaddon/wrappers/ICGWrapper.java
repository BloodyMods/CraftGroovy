package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

public abstract class ICGWrapper<R> {
    protected R internal;

    public ICGWrapper(R internal) {
        this.internal = internal;
    }

    public R getInternal(){
        return internal;
    }
}
