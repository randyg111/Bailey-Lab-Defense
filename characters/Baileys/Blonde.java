package characters.Baileys;

import characters.Officers.Officer;
import level.Level;

import java.awt.*;

public class Blonde extends Bailey {
    static final String name = "Blonde Bailey";
    static final int startingHp = 200;
    public static final String IMAGE_NAME = "blonde.png";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public Blonde(int x, int y, int w, int h) {
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }

    public void useAbility(Level level) {
        if(active) {
            walk();
        }
        else
        {
            Point p = level.getLoc(x, y, width, height);
            int c = p.y;
            int r = p.x;
            Officer officer = level.getOfficer(r, c);
            eat(officer);
        }
    }
}
