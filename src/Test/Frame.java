package Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by chase on 2/11/15.
 */
public class Frame extends JFrame {

    ArrayList<FrameObject> objects = new ArrayList<FrameObject>();


    public Frame() {
        setSize(500, 500);
        setVisible(true);
        setLocation(40, 40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (FrameObject obj : objects) {
            g.drawImage(obj.getImage(), obj.getX(), obj.getY(), null);
        }
    }

    public static void main(String[] args) {
        new Frame();
    }

}
