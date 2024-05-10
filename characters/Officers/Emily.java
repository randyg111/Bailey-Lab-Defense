package characters.Officers;
import characters.Baileys.Bailey;
import level.Level;

import java.util.Timer;
import java.util.TimerTask;

public class Emily extends Officer {
    public static final String NAME = "Emily Lou";
    static final int STARTING_HP = 300;
    public static final String IMAGE_NAME = "images/emilyInactive.png";
    public static final int COST = 150;
    static final int DAMAGE = 15;
    static final double RATE = .75;
    public Emily(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, COST, DAMAGE, RATE);
    }

    public void useAbility(Level level)
    {
        setImage("images/emilyActive.png");
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                setImage("images/emilyInactive.png");
            }
        }, 1000);
        Bailey bailey = level.getNearestBailey(this);
        if(bailey != null)
            bailey.minusHp(damage);
    }
}
