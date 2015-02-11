package Test;

import Recycler.Recyclable;

import java.awt.image.BufferedImage;

/**
 * Created by chase on 2/11/15.
 */
public abstract class FrameObject extends Recyclable {

    public abstract void tick();

    public abstract BufferedImage getImage();

}
