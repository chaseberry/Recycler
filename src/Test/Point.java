package Test;

import Recycler.Recyclable;

/**
 * Created by chase on 2/11/15.
 */
public class Point extends Recyclable {

    private int x = 0, y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    @Override
    public void onRecycle(Object... args) {
        super.onRecycle(args);
        this.x = Integer.parseInt(String.valueOf(args[0]));
        this.y = Integer.parseInt(String.valueOf(args[1]));
    }
}
