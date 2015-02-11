package Test;

import Recycler.Recycler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Frame extends JFrame {

    ArrayList<FrameObject> objects = new ArrayList<FrameObject>();
    Timer timer;
    private final int frameSpeed = 20;
    Recycler<FrameObject> frameObjectRecucler = new Recycler<FrameObject>(10, FrameObject.class);

    public Frame() {
        setSize(500, 500);
        setVisible(true);
        setLocation(40, 40);
        objects.add(new Square(40, 50, 10));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int z = 0; z < objects.size(); z++) {
                    objects.get(z).tick();
                    if (objects.get(z).getY() > getHeight()) {
                        objects.remove(z);
                    }
                }
                repaint();
            }
        }, frameSpeed, frameSpeed);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        for (FrameObject obj : objects) {
            g.drawImage(obj.getImage(), obj.getX(), obj.getY(), null);
        }
    }

    public static void main(String[] args) {
        new Frame();
    }

}
