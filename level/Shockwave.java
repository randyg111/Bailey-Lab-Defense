package level;

import characters.Baileys.Bailey;

public class Shockwave extends Bailey {
    static final String name = "Shockwave";
    static final int startingHp = 1;
    public static final String IMAGE_NAME = "images/shockwave.png";
    static final int startingSpeed = -50;
    static final int d = 1000;
    static final double r = 0.1;
    public Shockwave(int x, int y, int w, int h) {
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }

    public void useAbility(Level level) {
        walk();
    }
}
