package characters.Officers;
import abilities.SoAbility;
public class So extends Officer {
    static final String name = "Alex So";
    static final int startingHp = 350;
    static final String imageName = "alexS";
    static final int cost = 100;
    public So(){
        super(name, startingHp, new SoAbility(), imageName, cost);
    }

}
