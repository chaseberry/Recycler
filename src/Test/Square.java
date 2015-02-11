package Test;

import java.awt.image.BufferedImage;

public class Square extends FrameObject {

    private int x, y;

    public Square() {
        this(0, 0);
    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void tick() {
        y += 1;
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    @Override
    public void onRecycle(Object... args) {
        super.onRecycle(args);

    }

}
