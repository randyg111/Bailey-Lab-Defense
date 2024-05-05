package characters.Baileys;

import characters.Officers.Officer;
import level.Level;

import java.awt.*;

public class Id extends Bailey {
    static final String name = "Id Bailey";
    static final int startingHp = 600;
    public static final String IMAGE_NAME = "id.png";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public Id(int x, int y, int w, int h) {
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }
}
