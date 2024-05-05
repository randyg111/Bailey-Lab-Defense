package characters.Baileys;
import level.Level;

public class Phone extends Bailey {
    static final String name = "Blonde Bailey";
    static int startingHp = 200;
    public static final String IMAGE_NAME = "Blonde";
    static final int startingSpeed = 5;
    static final int d = 200;
    static final int r = 3;
    public Phone(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }

    @Override
    public void useAbility(Level level) {

    }

}