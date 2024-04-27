package characters.Officers;
import abilities.RandyAbility;

public class Randy extends Officers{
    static final String name = "Randy Guo";
    static final int hp = 8000;
    static final String imageName = "randy";
    static final int cost = 125;
    public Randy(){
        super(name, hp, new RandyAbility(), imageName, cost);
    }
}
