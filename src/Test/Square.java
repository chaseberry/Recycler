package Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends FrameObject {

    private BufferedImage img;

    public Square() {
        this(10);
    }

    public Square(int size) {
        this(size, 0, 0);
    }

    public Square(int size, int x, int y) {
        super(x, y);
        setImg(size);
    }

    private void setImg(int size) {
        img = new BufferedImage(size + 1, size + 1, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = img.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, size, size);
    }

    @Override
    public void tick() {
        y += 2;
    }

    @Override
    public BufferedImage getImage() {
        return img;
    }

    @Override
    public void onRecycle(Object... args) {
        setImg(Integer.parseInt(String.valueOf(args[0])));
        this.x = Integer.parseInt(String.valueOf(args[1]));
        this.y = Integer.parseInt(String.valueOf(args[2]));
    }

}
