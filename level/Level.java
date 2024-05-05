package level;

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

import characters.Officers.*;
import characters.Baileys.*;

public class Level extends JComponent {
    private static Officer[][] grid;
    private static final int ROWS = 5;
    private static final int COLS = 9;
    private static List<Bailey>[] baileys = new List[ROWS];
    private static List<Rectangle> boxes = new ArrayList<>();
    private static List<BufferedImage> officers = new ArrayList<>();
    private static List<Pizza> pizzas = new ArrayList<>();
    private static List<Bullet> bullets = new ArrayList<>();
    private static Pizza displayPizza;
    static boolean[] selected = new boolean[6];
    private static int numPizza = 75;
    private static final int VERTICAL_OFFSET = 25;
    private static final int HORIZONTAL_OFFSET = 20;
    private static final int BOX_WIDTH = 200;
    private static final int BOX_HEIGHT = 100;
    private static final int BOX_OFFSET = 10;
    private static Officer[] arr = {new Aaron(0, 0, 1, 1), new Emily(0,0,1,1),
            new Kho(0,0,1,1), new So(0,0,1,1), new Randy(0,0,1,1), new Zheng(0,0,1,1)};
    public Level()
    {
        grid = new Officer[ROWS][COLS];
        for(int row = 0; row < ROWS; row++)
            baileys[row] = new ArrayList<>();
        officers.add(getScaledImage(Aaron.IMAGE_NAME));
        officers.add(getScaledImage(Emily.IMAGE_NAME));
        officers.add(getScaledImage(Kho.IMAGE_NAME));
        officers.add(getScaledImage(Randy.IMAGE_NAME));
        officers.add(getScaledImage(So.IMAGE_NAME));
        officers.add(getScaledImage(Zheng.IMAGE_NAME));
        displayPizza = new Pizza(BOX_OFFSET + BOX_WIDTH/2 - Pizza.WIDTH/2, BOX_OFFSET);
        for(int i = 0; i < 6; i++)
        {
            boxes.add(new Rectangle(BOX_OFFSET, (i+1)*(BOX_HEIGHT+BOX_OFFSET) + BOX_OFFSET, BOX_WIDTH, BOX_HEIGHT));
        }
        addMouseListener(new ClickListener());
    }
    public void testZombie() {
        int w = getWidth();
        int s2 = getS2();
        Dimension scale = getDimension(Blonde.IMAGE_NAME, new Dimension(w, s2));
        for(int i = 0; i < 5; i++) {
            baileys[i].add(new Blonde(1500, i*s2 + 25, scale.width, scale.height));
        }
    }
    public void addBullet(Bullet b)
    {
        bullets.add(b);
    }
    public void addPizza(Pizza p)
    {
        pizzas.add(p);
    }
    public void testPizza() {
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

        displayPizza.draw(g);
        g.setFont(new Font("Comic Sans", Font.BOLD, 36));
        g.drawString(Integer.toString(numPizza), displayPizza.x + BOX_OFFSET, displayPizza.y + Pizza.HEIGHT + 3*BOX_OFFSET);

        g.setFont(new Font("Comic Sans", Font.PLAIN, 24));
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
            g.drawString(Integer.toString(arr[i].getCost()), box.x + BOX_OFFSET, box.y + box.height - BOX_OFFSET);
        }

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if(grid[row][col] != null && grid[row][col].isDead())
                    grid[row][col] = null;

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
        for (int row = 0; row < ROWS; row++) {
            if (!baileys[row].isEmpty() && baileys[row].get(0).x < w) {
                for (int col = 0; col < COLS; col++) {
                    if (grid[row][col] != null && grid[row][col].getName().equals("Alex So"))
                        grid[row][col].start();
                }
            }
            for (int i = baileys[row].size()-1; i >= 0; i--) {
                Bailey bailey = baileys[row].get(i);
                if(bailey.isDead())
                {
                    baileys[row].remove(i);
                    continue;
                }
                Point p = getLoc(bailey.x, bailey.y, bailey.width, bailey.height);
                int c = p.y;
                int r = p.x;
                if (bailey.isWalking() && r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] != null) {
                    bailey.stop();
                    bailey.startEat();
                }
                bailey.draw(g);
            }
        }

        for (int i = bullets.size()-1; i >= 0; i--)
        {
            Bullet bullet = bullets.get(i);
            bullet.draw(g);
            Point p = getLoc(bullet.x, bullet.y, bullet.width, bullet.height);
            Rectangle bulletRect = new Rectangle(bullet.x, bullet.y, bullet.width, bullet.height);
            for(Bailey bailey : baileys[p.x])
            {
                Rectangle rect = new Rectangle(bailey.x, bailey.y, bailey.width, bailey.height);
                if(rect.intersects(bulletRect))
                {
                    bullets.remove(i);
                    bailey.minusHp(bullet.getDamage());
                }
            }
        }

        for (Pizza pizza : pizzas)
            pizza.draw(g);
    }

    public int getS1()
    {
        return (getWidth()-(BOX_WIDTH+2*HORIZONTAL_OFFSET))/COLS;
    }

    public int getS2()
    {
        return (getHeight()-2*VERTICAL_OFFSET)/ROWS;
    }

    public Officer getOfficer(int r, int c)
    {
        return grid[r][c];
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

    public Point getLoc(int x, int y, int width, int height)
    {
        int c = (x + width/2 - 220) / getS1();
        int r = (y + height/2 - 25) / getS2();
        return new Point(r, c);
    }

    private Officer getOfficer(int i, int x, int y, Dimension bounds)
    {
        switch(i) {
            case 0:
                Dimension d = getDimension(Aaron.IMAGE_NAME, bounds);
                return new Aaron(x + bounds.width/2 - d.width/2, y + bounds.height/2 - d.height/2, d.width, d.height);
            case 1:
                d = getDimension(Emily.IMAGE_NAME, bounds);
                return new Emily(x + bounds.width/2 - d.width/2, y + bounds.height/2 - d.height/2, d.width, d.height);
            case 2:
                d = getDimension(Kho.IMAGE_NAME, bounds);
                return new Kho(x + bounds.width/2 - d.width/2, y + bounds.height/2 - d.height/2, d.width, d.height);
            case 3:
                d = getDimension(Randy.IMAGE_NAME, bounds);
                return new Randy(x + bounds.width/2 - d.width/2, y + bounds.height/2 - d.height/2, d.width, d.height);
            case 4:
                d = getDimension(So.IMAGE_NAME, bounds);
                return new So(x + bounds.width/2 - d.width/2, y + bounds.height/2 - d.height/2, d.width, d.height);
            case 5:
                d = getDimension(Zheng.IMAGE_NAME, bounds);
                return new Zheng(x + bounds.width/2 - d.width/2, y + bounds.height/2 - d.height/2, d.width, d.height);
        }
        return null;
    }

    public class ClickListener extends MouseAdapter {
        int curr = -1;
        public void mousePressed(MouseEvent e) {
            for (int i = pizzas.size()-1; i >= 0; i--)
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
                            if (rect.contains(e.getPoint())) {
                                grid[row][col] = getOfficer(curr, rect.x, rect.y, rect.getSize());
                                numPizza -= grid[row][col].getCost();
                            }
                        }
                    }
                }
                selected[curr] = false;
                curr = -1;
                repaint();
            }
            else
            {
                for (int i = 0; i < boxes.size(); i++)
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

}

