package characters.Baileys;
import level.Level;

public class SprayBottle extends Bailey {
    static final String name = "Spray Bottle Bailey";
    static final int startingHp = 200;
    public static final String IMAGE_NAME = "sprayBottle";
    static final int startingSpeed = 10;
    static final int d = 200;
    static final double r = 3;

    public SprayBottle(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }

    public void useAbility(Level level) {

    }
}
