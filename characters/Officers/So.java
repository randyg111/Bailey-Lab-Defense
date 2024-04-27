package characters.Officers;
import abilities.SoAbility;
public class So extends Officers{
    static final String name = "Alex So";
    static final int hp = 350;
    static final String imageName = "alexS";
    static final int cost = 100;
    public So(){
        super(name, hp, new SoAbility(), imageName, cost);
    }

}
