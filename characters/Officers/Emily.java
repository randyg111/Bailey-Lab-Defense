package characters.Officers;
import characters.Baileys.Bailey;
import level.Level;

public class Emily extends Officer {
    public static final String NAME = "Emily Lou";
    static final int startingHp = 300;
    public static final String IMAGE_NAME = "emily.png";
    public static final int COST = 150;
    static final int d = 15;
    static final double r = .75;
    public Emily(int x, int y, int w, int h){
        super(NAME, startingHp, IMAGE_NAME, x, y, w, h, COST, d, r);
    }

    public void useAbility(Level level)
    {
        Bailey bailey = level.getNearestBailey(this);
        bailey.minusHp(damage);
    }
}
