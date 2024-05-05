package level;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import characters.Character;
import characters.Officers.*;
import characters.Baileys.*;

public class Level extends JComponent {
    private static Character[][] grid;
    private static final int ROWS = 5;
    private static final int COLS = 9;
    private static Queue<Bailey>[] baileys = new Queue[ROWS];
    private static List<Rectangle> boxes = new ArrayList<>();
    private static List<BufferedImage> officers = new ArrayList<>();
    public Level()
    {
        grid = new Character[ROWS][COLS];
        for(int row = 0; row < ROWS; row++)
            baileys[row] = new LinkedList<>();
        officers.add(getScaledImage(Aaron.IMAGE_NAME));
        officers.add(getScaledImage(Emily.IMAGE_NAME));
        officers.add(getScaledImage(Kho.IMAGE_NAME));
        officers.add(getScaledImage(Randy.IMAGE_NAME));
        officers.add(getScaledImage(So.IMAGE_NAME));
        officers.add(getScaledImage(Zheng.IMAGE_NAME));
        for(int i = 0; i < 6; i++)
        {
            boxes.add(new Rectangle(10, i*110 + 25, 200, 100));
        }
    }
    public void addZombie() {
        baileys[0].add(new Blonde(500, 500, 100, 100));
    }
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        int w = getWidth();
        int h = getHeight();
        int s1 = (w-240)/COLS;
        int s2 = (h-50)/ROWS;

//        grid[1][1] = new Aaron(1*s2+25, 1*s1+25, s2, s1);
//        grid[0][2] = new So(2*s2+25, 0*s1+25, s2, s1);
//        grid[3][4] = new Zheng(4*s2+25, 3*s1+25, s2, s1);
//        grid[4][7] = new Emily(7*s2+25, 4*s1+25, s2, s1);
//        grid[2][8] = new Kho(8*s2+25, 2*s1+25, s2, s1);
//        grid[0][5] = new Randy(5*s2+25, 0*s1+25, s2, s1);

        for (int i = 0; i < 6; i++)
        {
            Rectangle box = boxes.get(i);
            BufferedImage officer = officers.get(i);
            g.setColor(Color.lightGray);
            g.fill(box);
            g.setColor(Color.black);
            g.draw(box);
            int x = box.x + box.width/2 - officer.getWidth()/2;
            int y = box.y + box.height/2 - officer.getHeight()/2;
            g.drawImage(officer, x, y, null);
        }

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if (grid[row][col] == null)
                {
                    Rectangle rect = new Rectangle(col*s1 + 220, row*s2 + 25, s1, s2);
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
        for (int row = 0; row < ROWS; row++)
            for (Bailey bailey : baileys[row])
                bailey.draw(g);
    }

    public static BufferedImage getScaledImage(String imageName) {

        try {
            BufferedImage image = ImageIO.read(new File(imageName));
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            int boundWidth = 200;
            int boundHeight = 100;
            int newWidth = originalWidth;
            int newHeight = originalHeight;

            if (originalWidth > boundWidth) {
                newWidth = boundWidth;
                newHeight = (newWidth * originalHeight) / originalWidth;
            }

            if (newHeight > boundHeight) {
                newHeight = boundHeight;
                newWidth = (newHeight * originalWidth) / originalHeight;
            }

            BufferedImage resized = new BufferedImage(newWidth, newHeight, image.getType());
            Graphics2D g = resized.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(image, 0, 0, newWidth, newHeight, 0, 0, image.getWidth(),
                    image.getHeight(), null);
            g.dispose();

            return resized;
        } catch (IOException e) {
            throw new RuntimeException();
        }

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

