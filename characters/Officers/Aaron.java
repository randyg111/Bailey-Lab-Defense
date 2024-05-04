package characters.Officers;
import abilities.AaronAbility;

public class Aaron extends Officer {
    static final String name = "Aaron Zhou";
    static final int startingHp = 0;
    static final String imageName = "aaron";
    static final int cost = 50;
    private static final int DAMAGE = 350;
    private static final double RATE = 2;
    public Aaron(int x, int y){
        super(name, startingHp, new AaronAbility(), imageName, x, y, cost);
    }
}
