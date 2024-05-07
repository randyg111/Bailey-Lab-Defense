package level;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import characters.Officers.*;
import characters.Baileys.*;
import characters.Character;

public class Level extends JComponent {
    private static Officer[][] grid;
    private static final int ROWS = 5;
    private static final int COLS = 9;
    private static final List<Bailey>[] baileys = new List[ROWS];
    private static List<Rectangle> boxes;
    private static List<BufferedImage> officers;
    private static List<Pizza> pizzas;
    private static List<Bullet> bullets;
    private static Pizza displayPizza;
    private static int numPizza;
    private static Timer timer = new Timer();
    private static final int VERTICAL_OFFSET = 25;
    private static final int HORIZONTAL_OFFSET = 20;
    private static final int BOX_WIDTH = 200;
    private static final int BOX_HEIGHT = 100;
    private static final int BOX_OFFSET = 10;
    private static final int SHOCK_WIDTH = 100;
    private static final String INSUFFICIENT = "Not Enough Pizza!";
    private static String display = "";
    private static final int DISPLAY_SIZE = 36;
    private static final int PRICE_SIZE = 24;
    private static final int PIZZA_VALUE = 25;
    private static boolean gameOver;
    private static Rectangle restart;
    private static Rectangle mainMenu;
    static boolean[] pressed = new boolean[2];
    static Shockwave[] shockwave;

    private static final Officer[] arr = {new Aaron(0, 0, 1, 1), new Emily(0,0,1,1),
            new Kho(0,0,1,1), new Randy(0,0,1,1), new So(0,0,1,1), new Zheng(0,0,1,1)};
    static boolean[] selected = new boolean[arr.length];

    public Level()
    {
        grid = new Officer[ROWS][COLS];
        for(int row = 0; row < ROWS; row++)
            baileys[row] = new ArrayList<>();
        boxes = new ArrayList<>();
        officers = new ArrayList<>();
        pizzas = new ArrayList<>();
        bullets = new ArrayList<>();
        gameOver = false;
        numPizza = 75;
        officers.add(getScaledImage(Aaron.IMAGE_NAME));
        officers.add(getScaledImage(Emily.IMAGE_NAME));
        officers.add(getScaledImage(Kho.IMAGE_NAME));
        officers.add(getScaledImage(Randy.IMAGE_NAME));
        officers.add(getScaledImage(So.IMAGE_NAME));
        officers.add(getScaledImage(Zheng.IMAGE_NAME));
        int pizzaX = BOX_OFFSET + BOX_WIDTH/2 - Pizza.WIDTH/2;
        displayPizza = new Pizza(pizzaX, BOX_OFFSET, BOX_OFFSET);
        for(int i = 0; i < 6; i++)
        {
            boxes.add(new Rectangle(BOX_OFFSET, (i+1)*(BOX_HEIGHT+BOX_OFFSET) + BOX_OFFSET, BOX_WIDTH, BOX_HEIGHT));
        }
        addMouseListener(new ClickListener());
        spawnBaileys();
        spawnPizzas();
    }

    public void spawnBaileys(){
        Timer timer = new Timer();

        for(int wave = 0; wave < 2; wave++) {
            timer.schedule(new StageTask(.5, 0, 0, 0, 0, 0), 10000 + wave * 10000);
            timer.schedule(new StageTask(.5, .2, 0, 0, 0, 0), 30000 + wave * 10000);
            timer.schedule(new StageTask(.5, .2, .2, 0, 0, 0), 50000 + wave * 10000);
            timer.schedule(new StageTask(.6, .2, .2, .2, 0, 0), 70000 + wave * 10000);
            timer.schedule(new StageTask(.7, .2, .2, .2, .2, 0), 90000 + wave * 10000);
            timer.schedule(new StageTask(.8, .3, .3, .2, .2, .2), 110000 + wave * 10000);
        }

    }

    public void spawnPizzas()
    {
        new javax.swing.Timer(10000, e -> {
            int dx = (int) (Math.random() * (getWidth() - getLeftWidth() - HORIZONTAL_OFFSET - Pizza.WIDTH)) + getLeftWidth();
            int dy = (int) (Math.random() * (getHeight() - 2 * VERTICAL_OFFSET - Pizza.HEIGHT)) + VERTICAL_OFFSET;
            pizzas.add(new Pizza(dx, -Pizza.HEIGHT, dy));
        }).start();
    }

    public void spawn(double blondeRate, double redHeadRate, double idRate,
                      double glassesRate, double sprayRate, double phoneRate){

        if(Math.random() < blondeRate)
        {
            Bailey b = spawnBailey(0);
            baileys[getLoc(b).x].add(b);
        }
        if(Math.random() < redHeadRate)
        {
            Bailey b = spawnBailey(1);
            baileys[getLoc(b).x].add(b);
        }
        if(Math.random() < idRate)
        {
            Bailey b = spawnBailey(2);
            baileys[getLoc(b).x].add(b);
        }
        if(Math.random() < glassesRate)
        {
            Bailey b = spawnBailey(3);
            baileys[getLoc(b).x].add(b);
        }
        if(Math.random() < sprayRate)
        {
            Bailey b = spawnBailey(4);
            baileys[getLoc(b).x].add(b);
        }
        if(Math.random() < phoneRate)
        {
            Bailey b = spawnBailey(5);
            baileys[getLoc(b).x].add(b);
        }
    }

    public Bailey spawnBailey(int type)
    {
        int w = getWidth();
        int s2 = getS2();
        int row = (int) (Math.random()*ROWS);
        switch(type)
        {
            case 0:
                Dimension d = getDimension(Blonde.IMAGE_NAME, new Dimension(w, s2));
                return new Blonde(w, row*s2 + VERTICAL_OFFSET, d.width, d.height);
            case 1:
                d = getDimension(RedHead.IMAGE_NAME, new Dimension(w, s2));
                return new RedHead(w, row*s2 + VERTICAL_OFFSET, d.width, d.height);
            case 2:
                d = getDimension(Id.IMAGE_NAME, new Dimension(w, s2));
                return new Id(w, row*s2 + VERTICAL_OFFSET, d.width, d.height);
            case 3:
                d = getDimension(Glasses.IMAGE_NAME, new Dimension(w, s2));
                return new Glasses(w, row*s2 + VERTICAL_OFFSET, d.width, d.height);
            case 4:
                d = getDimension(SprayBottle.IMAGE_NAME, new Dimension(w, s2));
                return new SprayBottle(w, row*s2 + VERTICAL_OFFSET, d.width, d.height);
            case 5:
                d = getDimension(Phone.IMAGE_NAME, new Dimension(w, s2));
                return new Phone(w, row*s2 + VERTICAL_OFFSET, d.width, d.height);
        }
        return null;
    }


    public void addBullet(Bullet b)
    {
        bullets.add(b);
    }
    public void addPizza(Pizza p)
    {
        pizzas.add(p);
    }
    public List<Bailey>[] getBaileys()
    {
        return baileys;
    }
    public Bailey getNearestBailey(Officer officer)
    {
        Point p = getLoc(officer);
        Bailey nearest = null;
        for (int i = 0; i < baileys[p.x].size(); i++)
        {
            if (baileys[p.x].get(i).x >= officer.x) {
                nearest = baileys[p.x].get(i);
                break;
            }
        }
        return nearest;
    }
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        int w = getWidth();
        int h = getHeight();

        displayPizza.draw(g);
        g.setFont(new Font("Comic Sans", Font.BOLD, DISPLAY_SIZE));
        g.drawString(Integer.toString(numPizza), displayPizza.x + BOX_OFFSET, displayPizza.y + Pizza.HEIGHT + 3*BOX_OFFSET);

        g.setFont(new Font("Comic Sans", Font.PLAIN, PRICE_SIZE));
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
                Rectangle rect = getRectangle(row, col);
                g.setColor(Color.lightGray);
                g.fill(rect);
                g.setColor(Color.black);
                g.draw(rect);

                Officer officer = grid[row][col];
                if(officer != null && officer.isDead())
                    grid[row][col] = null;

                if (officer != null)
                {
                    if(officer.getName().equals("Aaron Zhou"))
                    {
                        Bailey bailey = getNearestBailey(officer);
                        if(bailey != null && bailey.x - officer.x <= getS1()) {
                            officer.useAbility(this);
                        }
                        else
                            officer.draw(g);
                    }
                    else if(officer.getName().equals("Emily Lou"))
                    {
                        Bailey bailey = getNearestBailey(officer);
                        if(bailey != null && bailey.x - officer.x <= 2*getS1()) {
                            if(!officer.isActive())
                                officer.start();
                        }
                        else if(officer.isActive())
                        {
                            officer.stop();
                        }
                        officer.draw(g);
                    }
                    else if (officer.isDead())
                    {
                        grid[row][col] = null;
                    }
                    else
                    {
                        officer.draw(g);
                    }
                }
            }
        }

        if(shockwave == null && getS2() > 0)
        {
            shockwave = new Shockwave[ROWS];
            for(int i = 0; i < ROWS; i++)
            {
                Dimension d = getDimension(Shockwave.IMAGE_NAME, new Dimension(SHOCK_WIDTH, getS2()));
                shockwave[i] = new Shockwave(BOX_WIDTH+HORIZONTAL_OFFSET + SHOCK_WIDTH/2 - d.width/2,
                        i*getS2() + VERTICAL_OFFSET + getS2()/2 - d.height/2,
                        d.width, d.height);
            }
        }

        for (int i = 0; i < ROWS; i++)
        {
            if(shockwave == null || shockwave[i] == null)
                continue;
            Shockwave shock = shockwave[i];
            if(shock.x > w)
            {
                shockwave[i] = null;
                continue;
            }
            shock.draw(g);
            Rectangle shockRect = new Rectangle(shock.x, shock.y, shock.width, shock.height);
            for(Bailey bailey : baileys[i])
            {
                Rectangle rect = new Rectangle(bailey.x, bailey.y, bailey.width, bailey.height);
                if(rect.intersects(shockRect))
                {
                    if(!shock.isActive())
                        shock.start();
                    bailey.minusHp(shock.getDamage());
                }
            }
        }

        for (int row = 0; row < ROWS; row++) {
            if (!baileys[row].isEmpty() && baileys[row].get(0).x < w) {
                for (int col = 0; col < COLS; col++) {
                    Officer officer = grid[row][col];
                    if (officer != null && officer.getName().equals("Alex So")
                            && !officer.isActive())
                        officer.start();
                }
            }
            else
            {
                for (int col = 0; col < COLS; col++) {
                    Officer officer = grid[row][col];
                    if (officer != null && officer.getName().equals("Alex So")
                            && officer.isActive())
                        officer.stop();
                }
            }
            for (int i = baileys[row].size()-1; i >= 0; i--) {
                Bailey bailey = baileys[row].get(i);
                if(bailey.isDead())
                {
                    baileys[row].remove(i);
                    continue;
                }
                Point p = getLoc(bailey);
                int c = p.y;
                int r = p.x;
                if (bailey.isWalking() && r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] != null) {
                    bailey.stop();
                    bailey.startEat();
                }
                if (bailey.x < BOX_WIDTH+HORIZONTAL_OFFSET)
                {
                    gameOver = true;
                }
                bailey.draw(g);
            }

        }

        for (int i = bullets.size()-1; i >= 0; i--)
        {
            Bullet bullet = bullets.get(i);
            if(bullet.x > w)
            {
                bullets.remove(i);
                continue;
            }
            bullet.draw(g);
            Point p = getLoc(bullet);
            Rectangle bulletRect = new Rectangle(bullet.x, bullet.y, bullet.width, bullet.height);
            for(Bailey bailey : baileys[p.x])
            {
                Rectangle rect = new Rectangle(bailey.x, bailey.y, bailey.width, bailey.height);
                if(rect.intersects(bulletRect))
                {
                    bullets.remove(i);
                    bailey.minusHp(bullet.getDamage());
                    break;
                }
            }
        }

        for (Pizza pizza : pizzas)
            pizza.draw(g);

        if(!display.isEmpty()){
            g.setColor(Color.red);
            g.setFont(new Font("Comic Sans", Font.BOLD, DISPLAY_SIZE));
            g.drawString(INSUFFICIENT, w / 2 - 50, h / 8);
            timer.schedule(new MessageTask(), 2000);
        }

        if(gameOver)
        {
            Rectangle rect = new Rectangle(0, 0, w, h);
            g.setColor(new Color(0f, 0f, 0f, 0.5f));
            g.fill(rect);

            Rectangle monitor = new Rectangle(w/2 - 100, h/2 - 100, 200, 200);
            g.setColor(Color.darkGray);
            g.fill(monitor);

            Rectangle screen = new Rectangle(w/2 - 90, h/2 - 90, 180, 180);
            g.setColor(Color.black);
            g.fill(screen);

            g.setColor(Color.green);
            g.setFont(new Font("Mono", Font.PLAIN, 18));
            g.drawString("BAILEYS FOUND", w/2 - 70, h/2 - 60);
            g.drawString("YOUR LAB!", w/2 - 50, h/2 - 30);

            restart = new Rectangle(w/2 - 80, h/2 + 40, 70, 40);
            if(pressed[0])
                g.setColor(Color.darkGray);
            else
                g.setColor(Color.gray);
            g.fill(restart);

            mainMenu = new Rectangle(w/2 + 10, h/2 + 40, 70, 40);
            if(pressed[1])
                g.setColor(Color.darkGray);
            else
                g.setColor(Color.gray);
            g.fill(mainMenu);

            g.setColor(Color.green);
            g.setFont(new Font("Mono", Font.PLAIN, 12));
            g.drawString("Try Again", w/2 - 75, h/2 + 65);
            g.drawString("Main Menu", w/2 + 15, h/2 + 65);
        }
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

    private int getLeftWidth()
    {
        return BOX_WIDTH + HORIZONTAL_OFFSET + SHOCK_WIDTH + BOX_OFFSET;
    }

    public Rectangle getRectangle(int r, int c)
    {
        int w = getWidth();
        int h = getHeight();
        int s1 = (w-(getLeftWidth()+HORIZONTAL_OFFSET))/COLS;
        int s2 = (h-2*VERTICAL_OFFSET)/ROWS;
        int x = c*s1 + getLeftWidth();
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
            System.out.println(imageName+" image not found");
            throw new RuntimeException();
        }
    }

    public static BufferedImage getScaledImage(String imageName) {

        try {
            BufferedImage image = ImageIO.read(new File(imageName));
            Dimension newDimension = getDimension(imageName, new Dimension(BOX_WIDTH, BOX_HEIGHT));
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

    public Point getLoc(Character character)
    {
        int c = (character.x + character.width/2 - getLeftWidth()) / getS1();
        int r = (character.y + character.height/2 - VERTICAL_OFFSET) / getS2();
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
            if(gameOver)
            {
                if(restart.contains(e.getPoint())) {
                    pressed[0] = true;
                    repaint();
                }
                else if(mainMenu.contains(e.getPoint())) {
                    pressed[1] = true;
                    repaint();
                }
                return;
            }
            for (int i = pizzas.size()-1; i >= 0; i--)
            {
                Pizza pizza = pizzas.get(i);
                Rectangle rect = new Rectangle(pizza.x, pizza.y, Pizza.WIDTH, Pizza.HEIGHT);
                if(rect.contains(e.getPoint()))
                {
                    pizzas.remove(i);
                    numPizza += PIZZA_VALUE;
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
                                if(arr[curr].getCost() <= numPizza){
                                    grid[row][col] = getOfficer(curr, rect.x, rect.y, rect.getSize());
                                    numPizza -= grid[row][col].getCost();
                                } else {
                                    timer.cancel();
                                    timer = new Timer();
                                    display = INSUFFICIENT;
                                }
                            }
                        }
                    }
                }
                int prev = curr;
                selected[curr] = false;
                curr = -1;
                for (int i = 0; i < boxes.size(); i++)
                {
                    if (boxes.get(i).contains(e.getPoint()))
                    {
                        if(prev != i) {
                            curr = i;
                            selected[i] = true;
                        }
                    }
                }
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
        public void mouseReleased(MouseEvent e)
        {
            if(!gameOver)
                return;
            if(pressed[0] && restart.contains(e.getPoint())) {
                System.out.println("RESTART");
                restart();
            }
            else if(pressed[1] && mainMenu.contains(e.getPoint())) {
                System.out.println("MAIN MENU");
            }
            Arrays.fill(pressed, false);
            repaint();
        }
    }

    private void restart()
    {
        grid = new Officer[ROWS][COLS];
        for(int row = 0; row < ROWS; row++)
            baileys[row] = new ArrayList<>();
        boxes = new ArrayList<>();
        officers = new ArrayList<>();
        pizzas = new ArrayList<>();
        bullets = new ArrayList<>();
        gameOver = false;
        numPizza = 75;
        officers.add(getScaledImage(Aaron.IMAGE_NAME));
        officers.add(getScaledImage(Emily.IMAGE_NAME));
        officers.add(getScaledImage(Kho.IMAGE_NAME));
        officers.add(getScaledImage(Randy.IMAGE_NAME));
        officers.add(getScaledImage(So.IMAGE_NAME));
        officers.add(getScaledImage(Zheng.IMAGE_NAME));
        int pizzaX = BOX_OFFSET + BOX_WIDTH/2 - Pizza.WIDTH/2;
        displayPizza = new Pizza(pizzaX, BOX_OFFSET, BOX_OFFSET);
        for(int i = 0; i < 6; i++)
        {
            boxes.add(new Rectangle(BOX_OFFSET, (i+1)*(BOX_HEIGHT+BOX_OFFSET) + BOX_OFFSET, BOX_WIDTH, BOX_HEIGHT));
        }
        shockwave = new Shockwave[ROWS];
        for(int i = 0; i < ROWS; i++)
        {
            Dimension d = getDimension(Shockwave.IMAGE_NAME, new Dimension(SHOCK_WIDTH, getS2()));
            shockwave[i] = new Shockwave(BOX_WIDTH+HORIZONTAL_OFFSET + SHOCK_WIDTH/2 - d.width/2,
                    i*getS2() + VERTICAL_OFFSET + getS2()/2 - d.height/2,
                    d.width, d.height);
        }
        spawnBaileys();
        spawnPizzas();
    }

    public static class MessageTask extends TimerTask{
        public void run() {
            display = "";
        }
    }


    public class StageTask extends TimerTask{
        double bR;
        double rHR;
        double idR;
        double gR;
        double sR;
        double pR;
        public StageTask(double r1, double r2, double r3, double r4, double r5, double r6){
            bR = r1;
            rHR = r2;
            idR = r3;
            gR = r4;
            sR = r5;
            pR = r6;
        }
        public void run() {
            spawn(bR, rHR, idR, gR, sR, pR);
        }

    }

}

