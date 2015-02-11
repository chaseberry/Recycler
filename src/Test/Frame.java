package Test;

import javax.swing.*;

/**
 * Created by chase on 2/11/15.
 */
public class Frame extends JFrame {

    public Frame() {
        setSize(500, 500);
        setVisible(true);
        setLocation(40, 40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Frame();
    }

}
