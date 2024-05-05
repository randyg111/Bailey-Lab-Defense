package characters.Baileys;
import level.Level;

public class Glasses extends Bailey {
    static final String name = "Glasses Bailey";
    static int startingHp = 400;
    public static final String IMAGE_NAME = "Glasses";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public Glasses(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }

    public void useAbility(Level level) {

    }
}
