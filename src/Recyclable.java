/**
 * Created by chase on 2/11/15.
 */
public abstract class Recyclable {

    private boolean safeToRecycle = false;

    protected void setToRecycle() {
        safeToRecycle = true;
    }

    public boolean isSafeToRecycle() {
        return safeToRecycle;
    }

    public void recycle(Object... args) {
        safeToRecycle = false;
    }

}
