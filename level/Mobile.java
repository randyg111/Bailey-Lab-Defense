package level;

import characters.Baileys.Bailey;

public class Mobile extends Bailey {
    static final String name = "Mobile";
    static final int startingHp = 1;
    public static final String IMAGE_NAME = "images/mobile.png";
    static final int startingSpeed = 50;
    static final int d = 25;
    static final double r = 0.1;
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;
    private int dx;
    public Mobile(int x, int y, int dx) {
        super(name, startingHp, IMAGE_NAME, x, y, WIDTH, HEIGHT, startingSpeed, d, r);
        this.dx = dx;
    }

    public void useAbility(Level level) {
        if(x > dx)
            walk();
        else
        {
            stop();
            hp = 0;
        }
    }
}
