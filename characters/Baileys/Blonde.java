package characters.Baileys;

import level.Level;

public class Blonde extends Bailey {
    static final String name = "Blonde Bailey";
    static final int startingHp = 200;
    public static final String IMAGE_NAME = "blonde.png";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public Blonde(int x, int y, int w, int h) {
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed);
    }

    public void useAbility(Level level) {
        if(walking) {
            x -= 25;
        }
        else
        {
            System.out.println("STOPPED");
        }
    }
}
