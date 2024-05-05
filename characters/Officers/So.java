package characters.Officers;
import level.Level;

public class So extends Officer {
    static final String name = "Alex So";
    static final int startingHp = 350;
    public static final String IMAGE_NAME = "so.png";
    public static final int COST = 100;
    static final int d = 25;
    static final double r = 1.5;
    public So(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, COST);
    }
    public void useAbility(Level level)
    {

    }

}
