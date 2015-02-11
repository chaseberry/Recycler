package Test;

import Recycler.Recyclable;

import java.awt.image.BufferedImage;

public abstract class FrameObject extends Recyclable {

    protected int x, y;

    public FrameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public FrameObject() {
        this(0, 0);
    }

    public abstract void tick();

    public abstract BufferedImage getImage();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
