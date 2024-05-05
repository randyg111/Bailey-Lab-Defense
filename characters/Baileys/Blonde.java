package characters.Baileys;

import characters.Officers.Officer;
import level.Level;

public class Blonde extends Bailey {
    static final String name = "Blonde Bailey";
    static final int startingHp = 200;
    public static final String IMAGE_NAME = "blonde.png";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final int r = 1;
    public Blonde(int x, int y, int w, int h) {
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }

    public void useAbility(Level level) {
        if(walking) {
            walk();
        }
        else
        {
            int c = (x + width/2 - 220) / level.getS1();
            int r = (y + height/2 - 25) / level.getS2();
            Officer officer = level.getGrid()[r][c];
            eat(officer);
        }
    }
}
