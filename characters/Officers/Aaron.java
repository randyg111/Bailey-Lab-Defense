package characters.Officers;
import abilities.AaronAbility;

public class Aaron extends Officers{
    static final String name = "Aaron Zhao";
    static final int hp = 0;
    static final String imageName = "aaron";
    static final int cost = 50;
    public Aaron(){
        super(name, hp, new AaronAbility(), imageName, cost);
    }
}
