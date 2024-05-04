package characters.Baileys;
import java.awt.*;
import level.Level;

public class SprayBottle extends Bailey {
    static final String name = "Spray Bottle Bailey";
    static final int startingHp = 200;
    static final String imageName = "sprayBottle";
    static final int startingSpeed = 10;
    static final int d = 200;
    static final double r = 3;

    public SprayBottle(int x, int y, int w, int h){
        super(name, startingHp, imageName, x, y, w, h, startingSpeed);
    }

    public void useAbility(Level level) {

    }
}
