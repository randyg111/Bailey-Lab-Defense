package characters.Officers;
import level.Level;

public class Emily extends Officer {
    public static final String NAME = "Emily Lou";
    static final int startingHp = 300;
    public static final String IMAGE_NAME = "emily.png";
    static final String abilityImageName = "pizza.jpg";
    public static final int COST = 150;
    static final int d = 15;
    static final double r = .75;
    public Emily(int x, int y, int w, int h){
        super(NAME, startingHp, IMAGE_NAME, x, y, w, h, COST);
    }

    public void useAbility(Level level)
    {

    }
}
