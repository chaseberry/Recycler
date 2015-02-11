import java.util.ArrayList;

public class Recycler<RecyclableObject extends Recyclable> {

    public static final int MIN_RECYCLABLES = 100;

    private ArrayList<RecyclableObject> recyclables;
    private Class recyclableClass;

    public Recycler(int minRecyclables, Class cls) {
        recyclables = new ArrayList<RecyclableObject>(minRecyclables);
        recyclableClass = cls;
    }

    public Recycler(Class cls) {
        this(MIN_RECYCLABLES, cls);
    }

    public void trackRecyclable(RecyclableObject obj) {
        recyclables.add(obj);
    }

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
