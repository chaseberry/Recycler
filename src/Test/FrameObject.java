package Test;

import Recycler.Recyclable;

import java.awt.image.BufferedImage;

/**
 * Created by chase on 2/11/15.
 */
public abstract class FrameObject extends Recyclable {

    protected int x, y;

    public FrameObject(int x, int y) {
        this.x = x;
        this.y = y;
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
