package characters.Officers;
import level.Level;

public class Randy extends Officer {
    public static final String NAME = "Randy Guo";
    static final int startingHp = 8000;
    public static final String IMAGE_NAME = "randy.png";
    public static final int COST = 125;
    public Randy(int x, int y, int w, int h){
        super(NAME, startingHp, IMAGE_NAME, x, y, w, h, COST);
    }
    public void useAbility(Level level)
    {

    }
}
