package characters.Officers;
import level.Level;

import java.util.Timer;
import java.util.TimerTask;

public class Randy extends Officer {
    public static final String NAME = "Randy Guo";
    static final int STARTING_HP = 4000;
    public static final String IMAGE_NAME = "images/randyInactive.png";
    public static final int COST = 125;
    private static final int DAMAGE = 0;
    private static final double RATE = 1;
    public Randy(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, COST, DAMAGE, RATE);
    }
    public void useAbility(Level level)
    {

    }
    public void checkHp()
    {
        if(isDead())
        {
            setImage("images/randyDead.png");
            Timer time = new Timer();
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    done = true;
                }
            }, 1500);
        }
        else if(hp < STARTING_HP/3)
        {
            setImage("images/randyDamaged.png");
        }
        else if(hp < 2*STARTING_HP/3)
        {
            setImage("images/randySlightlyDamaged.png");
        }
    }
}
