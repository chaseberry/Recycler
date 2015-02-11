package Recycler;

public abstract class Recyclable {

    private boolean safeToRecycle = false;

    /**
     * Tells the Recycler.Recycler watching this object that it can recycle this.
     */
    public void setToRecycle() {
        safeToRecycle = true;
    }

    /**
     * @return true if the object is ready to be recycled, false otherwise.
     */
    public boolean isSafeToRecycle() {
        return safeToRecycle;
    }

    /**
     * Called by the recycler to let the object know it has been recycled. Supplied with the args
     * passed to getRecyclable to 're-init' this object.
     *
     * @param args The arguments passed to the object to 're-init'
     */
    public void onRecycle(Object... args) {
        safeToRecycle = false;
    }

}
