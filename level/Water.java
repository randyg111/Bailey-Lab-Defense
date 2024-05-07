package level;

import characters.Baileys.Bailey;
import characters.Officers.Officer;
import level.Level;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Water extends Bailey {
    static final String name = "Water";
    static final int startingHp = 1;
    public static final String IMAGE_NAME = "water.png";
    static final int startingSpeed = 50;
    static final int d = 25;
    static final double r = 0.1;
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;
    private int dx;
    private int dy;
    public Water(int x, int y, int dx, int dy) {
        super(name, startingHp, IMAGE_NAME, x, y, WIDTH, HEIGHT, startingSpeed, d, r);
        this.dx = dx;
        this.dy = dy;
    }

    public void useAbility(Level level) {
        if(x > dx) {
            walk();
            y += (dy - y)/(x - dx) * speed;
        }
        else
        {
            stop();
            hp = 0;
        }
    }
}
