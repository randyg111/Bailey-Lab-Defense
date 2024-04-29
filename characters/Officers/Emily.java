package characters.Officers;
import abilities.EmilyAbility;

public class Emily extends Officers{
    static final String name = "Emily Lou";
    static int hp = 300;
    static final String imageName = "emily";
    static final int cost = 150;
    public Emily(){
        super(name, hp, new EmilyAbility(), imageName, cost);
    }
}
