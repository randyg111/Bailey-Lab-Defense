package characters.Officers;
import characters.Baileys.Bailey;
import javafx.animation.PathTransition;
import level.Level;

import java.util.Timer;
import java.util.TimerTask;

public class Aaron extends Officer {
    public static final String NAME = "Aaron Zhou";
    static final int STARTING_HP = 1000;
    public static final String IMAGE_NAME = "images/aaronInactive.png";
    public static final int COST = 50;
    private static final int DAMAGE = 600; //used to be 350
    private static final double RATE = 2;
    public Aaron(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, COST, DAMAGE, RATE);
    }
    public void useAbility(Level level) {
        Bailey bailey = level.getNearestBailey(this);
        bailey.minusHp(damage);
        hp = 0;
    }
}
