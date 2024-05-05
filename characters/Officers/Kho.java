package characters.Officers;
import level.Level;

public class Kho extends Officer {
    static final String name = "Khosraw Azizi";
    static final int startingHp = 300;
    public static final String IMAGE_NAME = "kho.png";
    static final int cost = 50;
    static final int d = 0;
    static final double r = 24;
    public Kho(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, cost);
    }
    public void useAbility(Level level)
    {

    }
}
