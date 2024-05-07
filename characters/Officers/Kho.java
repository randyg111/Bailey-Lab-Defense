package characters.Officers;
import level.Level;
import level.LevelPlayer;
import level.Pizza;

public class Kho extends Officer {
    public static final String NAME = "Khosraw Azizi";
    static final int startingHp = 300;
    public static final String IMAGE_NAME = "kho.png";
    public static final int COST = 50;
    static final int d = 0;
    static final double r = 24;
    public Kho(int x, int y, int w, int h){
        super(NAME, startingHp, IMAGE_NAME, x, y, w, h, COST, d, r);
        if(LevelPlayer.LEVEL != null)
            start();
    }
    public void useAbility(Level level)
    {
        int pizzaX = x + (int) (Math.random() * 101) - 50;
        int pizzaY = y + (int) (Math.random() * 101) - 50;
        level.addPizza(new Pizza(pizzaX, pizzaY, pizzaY));
    }
}
