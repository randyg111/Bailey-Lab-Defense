package characters.Officers;
import abilities.AaronAbility;

public class Aaron extends Officer {
    static final String name = "Aaron Zhou";
    static final int startingHp = 0;
    static final String imageName = "aaron";
    static final int cost = 50;
    public Aaron(){
        super(name, startingHp, new AaronAbility(), imageName, cost);
    }
}
