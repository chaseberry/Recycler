package Recycler;

import java.util.LinkedList;

public class Recycler<RecyclableObject extends Recyclable> {

    private LinkedList<RecyclableObject> recyclables;
    private Class recyclableClass;

    /**
     * Creates a Recycler.Recycler with MIN_RECYCLABLES and the given class.
     * This class is used to create a new object if none are present to recycle.
     *
     * @param cls The class of the Object to Recycle. Must have a blank default constructor
     */
    public Recycler(Class cls) {
        recyclables = new LinkedList<RecyclableObject>();
        recyclableClass = cls;
    }

    public void recycle(RecyclableObject obj) {
        recyclables.push(obj);
    }

    /**
     * Gets a recycled object if present, or will create and return a new one if none are set to recycle.
     *
     * @param args Arguments passed to the objects onRecycle method to re-init with data.
     * @return An object that was recycled or newly created, or null if no default constructor was found
     */
    public RecyclableObject getRecyclable(Object... args) {
        return getRecyclable(recyclableClass, args);
    }

    /**
     * Gets a recycled object if present, or will create and return a new one.
     *
     * @param cls  The class of the Object to Recycle. Must have a blank default constructor
     *             Use this method if you want to create a child class of some parent
     * @param args Arguments passed to the objects onRecycle method to re-init with data.
     * @return An object that was recycled or newly created, or null if no default constructor was found
     */
    public RecyclableObject getRecyclable(Class cls, Object... args) {
        if (!recyclables.isEmpty()) {
            RecyclableObject obj = recyclables.pop();
            obj.onRecycle(args);
            return obj;
        }
        try {
            RecyclableObject obj = (RecyclableObject) cls.newInstance();
            obj.onRecycle(args);
            recyclables.add(obj);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
