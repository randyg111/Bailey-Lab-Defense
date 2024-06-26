package level;

import characters.Baileys.Bailey;

public class Water extends Bailey {
    static final String name = "Water";
    static final int startingHp = 1;
    public static final String IMAGE_NAME = "images/water.png";
    static final int startingSpeed = 4;
    static final int d = 25;
    static final double r = 0.1;
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;
    private int dx;
    private int dy;
    private double sin;
    private double cos;
    public Water(int x, int y, int dx, int dy) {
        super(name, startingHp, IMAGE_NAME, x, y, WIDTH, HEIGHT, startingSpeed, d, r);
        this.dx = dx;
        this.dy = dy;
        double hypot = Math.hypot(x - dx, dy - y);
        sin = (dy - y)/hypot;
        cos = (x - dx)/hypot;
    }

    public void walk()
    {
        if(x > dx) {
            y += sin * speed;
            x -= cos * speed;
        }
        else
        {
            stopWalk();
            hp = 0;
        }
    }

    public void useAbility(Level level) {

    }
}
