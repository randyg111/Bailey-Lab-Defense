package level;

import javax.swing.*;
import java.awt.*;

public class LevelPlayer {
    public static Level LEVEL = new Level();

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Bailey Lab Defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        frame.getContentPane().setBackground(Color.gray);

        frame.add(LEVEL);
        frame.setVisible(true);
        Thread.sleep(2000);
        LEVEL.testZombie();
        LEVEL.testPizza();
    }
}

