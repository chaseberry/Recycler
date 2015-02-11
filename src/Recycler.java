import java.util.ArrayList;

public class Recycler<RecyclableObject extends Recyclable> {

    public static final int MIN_RECYCLABLES = 100;

    private ArrayList<RecyclableObject> recyclables;
    private Class recyclableClass;

    /**
     * Create a Recycler with given min number and the given class
     * This class is used to create a new object if none are present to recycle.
     *
     * @param minRecyclables
     * @param cls
     */
    public Recycler(int minRecyclables, Class cls) {
        recyclables = new ArrayList<RecyclableObject>(minRecyclables);
        recyclableClass = cls;
    }

    /**
     * Creates a Recycler with MIN_RECYCLABLES and the given class.
     * This class is used to create a new object if none are present to recycle.
     *
     * @param cls The class of the Object to Recycle. Must have a blank default constructor
     */
    public Recycler(Class cls) {
        this(MIN_RECYCLABLES, cls);
    }

    /**
     * Adds an object to this Recycler to be tracked.
     * Useful for creating an object with a constructor.
     *
     * @param obj The object to track
     */
    public void trackRecyclable(RecyclableObject obj) {
        recyclables.add(obj);
    }

    /**
     * Gets a recycled object if present, or will create and return a new one if none are set to recycle.
     *
     * @param args Arguments passed to the objects onRecycle method to re-init with data.
     * @return An object that was recycled or newly created, or null if no default constructor was found
     */
    public RecyclableObject getRecyclable(Object... args) {
        for (RecyclableObject r : recyclables) {
            if (r.isSafeToRecycle()) {
                r.recycle(args);
                return r;
            }
        }
        try {
            RecyclableObject obj = (RecyclableObject) recyclableClass.newInstance();
            obj.recycle(args);
            recyclables.add(obj);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
