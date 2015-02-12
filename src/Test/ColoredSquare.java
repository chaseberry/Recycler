package Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by chase on 2/12/15.
 */
public class ColoredSquare extends Square {

    public ColoredSquare() {
        super(10);
    }

    public ColoredSquare(int size, int x, int y) {
        super(size, x, y);
    }

    @Override
    protected void setImg(int size) {
        Random r = new Random();
        img = new BufferedImage(size + 1, size + 1, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = img.getGraphics();
        graphics.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        graphics.fillRect(0, 0, size, size);
    }
}
