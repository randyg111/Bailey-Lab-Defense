package characters.Baileys;
import java.awt.*;
import level.Level;

public class Blonde extends Bailey {
    static final String name = "Blonde Bailey";
    static final int startingHp = 200;
    static final String imageName = "blonde";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public Blonde(int x, int y, int w, int h){
        super(name, startingHp, imageName, x, y, w, h, startingSpeed);
    }

    public void useAbility(Level level) {
        if(walking) {

        } else {

        }
    }

}
