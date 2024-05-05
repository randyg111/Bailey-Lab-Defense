package characters.Officers;
import level.Level;

public class Aaron extends Officer {
    static final String name = "Aaron Zhou";
    static final int startingHp = 100;
    public static final String IMAGE_NAME = "aaron.png";
    public static final int COST = 50;
    private static final int DAMAGE = 350;
    private static final double RATE = 2;
    public Aaron(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, COST);
    }
    public void useAbility(Level level)
    {

    }
}
