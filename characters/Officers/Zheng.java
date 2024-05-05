package characters.Officers;
import level.Level;

public class Zheng extends Officer {
    static final String name = "Alex Zheng";
    static final int startingHp = 0;
    public static final String IMAGE_NAME = "zheng.png";
    public static final int COST = 150;
    static final int d = 1800;
    static final double r = 3;
    public Zheng(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, COST);
    }
    public void useAbility(Level level)
    {

    }
}
