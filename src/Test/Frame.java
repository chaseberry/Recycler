package Test;

import Recycler.Recycler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Frame extends JFrame {

    ArrayList<FrameObject> objects = new ArrayList<FrameObject>();
    Timer timer;
    int objectsAdded = 0;
    private final int frameSpeed = 20;
    Recycler<FrameObject> frameObjectRecycler = new Recycler<FrameObject>(FrameObject.class);
    Random r;

    public Frame() {
        r = new Random();
        setSize(500, 500);
        setVisible(true);
        setLocation(40, 40);
        setTitle("Recycling");
        for (int z = 0; z < 5; z++) {
            Square sq = new ColoredSquare(4 * (z + 1), 50 * (z + 1), z * 40);
            objects.add(sq);
        }
        objectsAdded = 5;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int z = 0; z < objects.size(); z++) {
                    objects.get(z).tick();
                    if (objects.get(z).getY() > getHeight()) {
                        frameObjectRecycler.recycle(objects.remove(z));
                        if (objectsAdded < 100) {
                            objects.add(frameObjectRecycler.getRecyclable(ColoredSquare.class,
                                    r.nextInt(50), r.nextInt(500), r.nextInt(50)));
                            objects.add(frameObjectRecycler.getRecyclable(ColoredSquare.class,
                                    r.nextInt(50), r.nextInt(500), r.nextInt(50)));
                            objectsAdded++;
                        } else {
                            objects.add(frameObjectRecycler.getRecyclable(ColoredSquare.class,
                                    r.nextInt(50), r.nextInt(500), r.nextInt(50)));
                        }
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
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics drawing = img.getGraphics();
        for (FrameObject obj : objects) {
            drawing.drawImage(obj.getImage(), obj.getX(), obj.getY(), null);
        }
        g.drawImage(img, 0, 0, null);
    }

    public static void main(String[] args) {
        new Frame();
    }

}
