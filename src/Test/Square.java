package Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends FrameObject {

    private int x, y;
    private BufferedImage img;
    private int size;

    public Square(int size) {
        this(size, 0, 0);
    }

    public Square(int size, int x, int y) {
        this.x = x;
        this.y = y;
        this.size = size;
        img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = img.getGraphics();
        graphics.drawRect(0, 0, size, size);
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
        return img;
    }

    @Override
    public void onRecycle(Object... args) {
        super.onRecycle(args);

    }

}
