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
    private static Officer[][] grid;
    private static final int ROWS = 5;
    private static final int COLS = 9;
    private static Queue<Bailey>[] baileys = new Queue[ROWS];
    private static List<Rectangle> boxes = new ArrayList<>();
    private static List<BufferedImage> officers = new ArrayList<>();
    private static List<Pizza> pizzas = new ArrayList<>();
    static boolean[] selected = new boolean[6];
    private static int numPizza = 75;
    private static final int VERTICAL_OFFSET = 25;
    private static final int HORIZONTAL_OFFSET = 20;
    private static final int BOX_WIDTH = 200;
    private static final int BOX_HEIGHT = 100;
    private static final int BOX_OFFSET = 10;
    public Level()
    {
        grid = new Officer[ROWS][COLS];
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
            boxes.add(new Rectangle(BOX_OFFSET, i*(BOX_HEIGHT+BOX_OFFSET) + VERTICAL_OFFSET, BOX_WIDTH, BOX_HEIGHT));
        }
        addMouseListener(new ClickListener());
    }
    public void addZombie() {
        int w = getWidth();
        int h = getHeight();
        int s1 = (w-(BOX_WIDTH+2*HORIZONTAL_OFFSET))/COLS;
        int s2 = (h-2*VERTICAL_OFFSET)/ROWS;
        Dimension scale = getDimension(Blonde.IMAGE_NAME, new Dimension(w, s2));
        for(int i = 0; i < 5; i++) {
            baileys[i].add(new Blonde(1900, i*s2 + 25, scale.width, scale.height));
        }
    }
    public void addPizza() {
        int w = getWidth();
        int h = getHeight();
        for(int i = 0; i < 5; i++) {
            int x = (int) (Math.random() * (w-240)) + 220;
            int y = (int) (Math.random() * (h - 50)) + 25;
            pizzas.add(new Pizza(x, y));
        }
    }
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        int w = getWidth();
        int h = getHeight();
        int s1 = (w-(BOX_WIDTH+2*HORIZONTAL_OFFSET))/COLS;
        int s2 = (h-2*VERTICAL_OFFSET)/ROWS;

        for (int i = 0; i < boxes.size(); i++)
        {
            Rectangle box = boxes.get(i);
            BufferedImage officer = officers.get(i);
            if(selected[i])
                g.setColor(Color.darkGray);
            else
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
                    Rectangle rect = getRectangle(row, col);
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
            {
                int c = (bailey.x + bailey.width/2 - 220) / s1;
                int r = (bailey.y + bailey.height/2 - 25) / s2;
                if(bailey.isWalking() && r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] != null)
                {
                    bailey.stop();
                }
                bailey.draw(g);
            }

        for (Pizza pizza : pizzas)
            pizza.draw(g);
    }

    public Rectangle getRectangle(int r, int c)
    {
        int w = getWidth();
        int h = getHeight();
        int s1 = (w-(BOX_WIDTH+2*HORIZONTAL_OFFSET))/COLS;
        int s2 = (h-2*VERTICAL_OFFSET)/ROWS;
        int x = c*s1 + BOX_WIDTH + HORIZONTAL_OFFSET;
        int y = r*s2 + VERTICAL_OFFSET;
        return new Rectangle(x, y, s1, s2);
    }

    public static Dimension getDimension(String imageName, Dimension bounds)
    {
        try {
            BufferedImage image = ImageIO.read(new File(imageName));
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            int boundWidth = bounds.width;
            int boundHeight = bounds.height;
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

            return new Dimension(newWidth, newHeight);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static BufferedImage getScaledImage(String imageName) {

        try {
            BufferedImage image = ImageIO.read(new File(imageName));
            Dimension newDimension = getDimension(imageName, new Dimension(200, 100));
            int newWidth = newDimension.width;
            int newHeight = newDimension.height;

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

    private Officer getOfficer(int i, int x, int y, Dimension bounds)
    {
        switch(i) {
            case 0:
                Dimension d = getDimension(Aaron.IMAGE_NAME, bounds);
                return new Aaron(x, y, d.width, d.height);
            case 1:
                d = getDimension(Emily.IMAGE_NAME, bounds);
                return new Emily(x, y, d.width, d.height);
            case 2:
                d = getDimension(Kho.IMAGE_NAME, bounds);
                return new Kho(x, y, d.width, d.height);
            case 3:
                d = getDimension(Randy.IMAGE_NAME, bounds);
                return new Randy(x, y, d.width, d.height);
            case 4:
                d = getDimension(So.IMAGE_NAME, bounds);
                return new So(x, y, d.width, d.height);
            case 5:
                d = getDimension(Zheng.IMAGE_NAME, bounds);
                return new Zheng(x, y, d.width, d.height);
        }
        return null;
    }

    public class ClickListener extends MouseAdapter {
        int curr = -1;
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < pizzas.size(); i++)
            {
                Pizza pizza = pizzas.get(i);
                Rectangle rect = new Rectangle(pizza.x, pizza.y, Pizza.WIDTH, Pizza.HEIGHT);
                if(rect.contains(e.getPoint()))
                {
                    pizzas.remove(i);
                    numPizza += 50;
                    repaint();
                    return;
                }
            }

            if(curr != -1)
            {
                for (int row = 0; row < ROWS; row++)
                {
                    for (int col = 0; col < COLS; col++)
                    {
                        if (grid[row][col] == null)
                        {
                            Rectangle rect = getRectangle(row, col);
                            if (rect.contains(e.getPoint()))
                                grid[row][col] = getOfficer(curr, rect.x, rect.y, rect.getSize());
                        }
                    }
                }
                selected[curr] = false;
                curr = -1;
                repaint();
            }
            else
            {
                for (int i = 0; i < 6; i++)
                {
                    if (boxes.get(i).contains(e.getPoint()))
                    {
                        curr = i;
                        selected[i] = true;
                    }
                }
                repaint();
            }
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

