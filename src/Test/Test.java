package Test;

import Recycler.Recycler;

/**
 * Created by chase on 2/11/15.
 */
public class Test {

    public static void main(String[] args) {
        Recycler<Point> pointRecycler = new Recycler<Point>(Point.class);
        Point p1 = new Point(0, 1);
        System.out.println("p1: " + p1);
        System.out.println("p1 address: " + p1.hashCode());

        pointRecycler.recycle(p1);

        Point p2 = pointRecycler.getRecyclable(5, 12);
        System.out.println("p2: " + p2);
        System.out.println("p2 address: " + p2.hashCode());

        Point p3 = pointRecycler.getRecyclable(2, 2);
        System.out.println("p3: " + p3);
        System.out.println("p3 address: " + p3.hashCode());

        System.out.println("p1: " + p1);
        new Frame();
        new FrameWithoutRecycling();
    }

}
