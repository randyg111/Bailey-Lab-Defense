package characters.Baileys;
import level.Level;
import java.awt.*;

public class Phone extends Bailey {
    static final String name = "Blonde Bailey";
    static int startingHp = 200;
    static final String imageName = "Blonde";
    static final int startingSpeed = 5;
    static final int d = 200;
    static final double r = 3;
    public Phone(int x, int y, int w, int h){
        super(name, startingHp, imageName, x, y, w, h, startingSpeed);
    }

    @Override
    public void useAbility(Level level) {

    }

}