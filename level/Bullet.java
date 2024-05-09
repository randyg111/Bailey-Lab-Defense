package level;

import characters.Baileys.Bailey;

public class Bullet extends Bailey {
    static final String name = "Bullet";
    static final int startingHp = 1;
    public static final String IMAGE_NAME = "images/CrashGrader.png";
    static final int startingSpeed = -10;
    static final int d = 50;
    static final double r = 0.1;
    private static final int WIDTH = 152;
    private static final int HEIGHT = 46;
    public Bullet(int x, int y) {
        super(name, startingHp, IMAGE_NAME, x, y, WIDTH, HEIGHT, startingSpeed, d, r);
    }

    public void useAbility(Level level) {
        walk();
    }
}
