package level;

import characters.Baileys.Bailey;
import characters.Officers.Officer;
import level.Level;

import java.awt.*;

public class Bullet extends Bailey {
    static final String name = "Bullet";
    static final int startingHp = 1;
    public static final String IMAGE_NAME = "bullet.png";
    static final int startingSpeed = -50;
    static final int d = 25;
    static final double r = 0.1;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    public Bullet(int x, int y) {
        super(name, startingHp, IMAGE_NAME, x, y, WIDTH, HEIGHT, startingSpeed, d, r);
    }

    public void useAbility(Level level) {
        walk();
    }
}
