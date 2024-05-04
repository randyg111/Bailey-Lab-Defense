package characters.Baileys;
import java.awt.*;
import level.Level;

public class RedHead extends Bailey {
    static final String name = "RedHead Bailey";
    static final int startingHp = 400;
    static final String imageName = "redhead";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public RedHead(int x, int y, int w, int h){
        super(name, startingHp, imageName, x, y, w, h, startingSpeed);
    }

    public void useAbility(Level level) {

    }

}
