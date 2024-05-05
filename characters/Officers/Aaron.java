package characters.Officers;
import characters.Baileys.Bailey;
import level.Level;

import java.awt.*;

public class Aaron extends Officer {
    public static final String NAME = "Aaron Zhou";
    static final int startingHp = 100;
    public static final String IMAGE_NAME = "aaron.png";
    public static final int COST = 50;
    private static final int DAMAGE = 350;
    private static final double RATE = 2;
    public Aaron(int x, int y, int w, int h){
        super(NAME, startingHp, IMAGE_NAME, x, y, w, h, COST, DAMAGE, RATE);
    }
    public void useAbility(Level level)
    {
        Bailey bailey = level.getNearestBailey(this);
        bailey.minusHp(damage);
    }
}
