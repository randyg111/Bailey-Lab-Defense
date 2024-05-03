package characters.Officers;
import abilities.EmilyAbility;

public class Emily extends Officer {
    static final String name = "Emily Lou";
    static final int startingHp = 300;
    static final String imageName = "emily";
    static final int cost = 150;
    public Emily(){
        super(name, startingHp, new EmilyAbility(), imageName, cost);
    }
}
