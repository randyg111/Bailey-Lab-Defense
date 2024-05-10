package characters.Officers;
import level.Level;
import level.LevelPlayer;
import level.Pizza;

import java.util.Timer;
import java.util.TimerTask;

public class Kho extends Officer {
    public static final String NAME = "Khosraw Azizi";
    static final int STARTING_HP = 300;
    public static final String IMAGE_NAME = "images/khoInactive.png";
    public static final int COST = 50;
    static final int DAMAGE = 0;
    static final double RATE = 24;
    public Kho(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, COST, DAMAGE, RATE);
        if(LevelPlayer.LEVEL != null)
            start();
    }
    public void useAbility(Level level)
    {
        setImage("images/khoActive.png");
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                setImage("images/khoInactive.png");
            }
        }, 1000);
        int pizzaX = x + (int) (Math.random() * 101) - 50;
        int pizzaY = y + (int) (Math.random() * 101) - 50;
        level.addPizza(new Pizza(pizzaX, pizzaY, pizzaY));
    }
}
