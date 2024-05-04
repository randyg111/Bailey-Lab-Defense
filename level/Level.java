package level;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import characters.Character;
import characters.Officers.*;
import characters.Baileys.*;

public class Level extends JComponent {
    private static Character[][] grid;
    private static final int ROWS = 5;
    private static final int COLS = 9;
    private static HashMap<Integer, Character> characterMap = new HashMap<>();
    private static Queue<Bailey>[] baileys = new Queue[ROWS];
    public Level(int w, int h)
    {
        grid = new Character[ROWS][COLS];
        System.out.println(w+" "+h);
        int s1 = (h-50)/ROWS;
        int s2 = (w-50)/COLS;
        grid[1][1] = new Aaron(1*s2+25, 1*s1+25, s2, s1);
        grid[0][2] = new So(2*s2+25, 0*s1+25, s2, s1);
        grid[3][4] = new Zheng(4*s2+25, 3*s1+25, s2, s1);
        grid[4][7] = new Emily(7*s2+25, 4*s1+25, s2, s1);
        grid[2][8] = new Kho(8*s2+25, 2*s1+25, s2, s1);
        grid[0][5] = new Randy(5*s2+25, 0*s1+25, s2, s1);
        baileys[0] = new LinkedList<>();
//        baileys[0].add(new Blonde(500, 500, s2, s1));
    }
    public void paintComponent(Graphics gr) {
        System.out.println(getWidth()+" "+getHeight());
        System.out.println("TEST");
        Graphics2D g = (Graphics2D) gr;
        int w = getWidth();
        int h = getHeight();
        int s1 = (h-50)/ROWS;
        int s2 = (w-50)/COLS;


        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if (grid[row][col] == null)
                {
                    Rectangle rect = new Rectangle(col*s2 + 25, row*s1 + 25, s2, s1);
                    g.setColor(Color.lightGray);
                    g.fill(rect);
                    g.setColor(Color.black);
                    g.draw(rect);
                }
                else
                {
                    grid[row][col].draw(g);
                }
            }
        }
//        baileys[0].peek().draw(g);
//        System.out.println(characterMap);
    }

    public static HashMap<Integer, Character> getCharacterMap()
    {
        return characterMap;
    }

    public class ClickListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            e.getLocationOnScreen();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    static class TimerListener implements ActionListener
    {
        private final Level level;

        public TimerListener(Level level)
        {
            this.level = level;
        }

        /**
         *  Advances the race whenever the timer goes off
         *  @param event the event for this timer
         */
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() instanceof Timer)
            {
                switch (((Timer) event.getSource()).getActionCommand()) {
                    case "test":
                        System.out.println("TEST");
                        break;
                }
            }
        }
    }
}
