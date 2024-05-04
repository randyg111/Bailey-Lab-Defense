package characters.Officers;
import abilities.BasicAbility;

public class Randy extends Officer {
    static final String name = "Randy Guo";
    static final int startingHp = 8000;
    static final String imageName = "randy";
    static final int cost = 125;
    public Randy(int x, int y){
        super(name, startingHp, new BasicAbility(), imageName, x, y, cost);
    }
}
