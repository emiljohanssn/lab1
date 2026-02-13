public interface Storage<C extends Cars> {
    void load(C car);
    C unload();
}