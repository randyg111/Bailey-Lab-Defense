package characters.Baileys;
import java.awt.*;

public class Glasses extends Bailey {
    static final String name = "Glasses Bailey";
    static int startingHp = 400;
    static final String imageName = "Glasses";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public Glasses(int x, int y, int w, int h){
        super(name, startingHp, imageName, startingSpeed, x, y, w, h);
    }

    public void useAbility() {

    }
}
