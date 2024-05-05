package characters.Officers;
import level.Level;

public class Randy extends Officer {
    static final String name = "Randy Guo";
    static final int startingHp = 8000;
    public static final String IMAGE_NAME = "randy.png";
    static final int cost = 125;
    public Randy(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, cost);
    }
    public void useAbility(Level level)
    {

    }
}
