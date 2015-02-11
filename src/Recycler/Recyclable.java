package Recycler;

public interface Recyclable {

    /**
     * Called by the recycler to let the object know it has been recycled. Supplied with the args
     * passed to getRecyclable to 're-init' this object.
     *
     * @param args The arguments passed to the object to 're-init'
     */
    public abstract void onRecycle(Object... args);

}
