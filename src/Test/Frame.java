package Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Frame extends JFrame {

    ArrayList<FrameObject> objects = new ArrayList<FrameObject>();
    Timer timer;

    public Frame() {
        setSize(500, 500);
        setVisible(true);
        setLocation(40, 40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (FrameObject obj : objects) {
                    obj.tick();
                }
                repaint();
            }
        }, 20, 20);
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
