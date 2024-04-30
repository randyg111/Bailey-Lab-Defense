package characters.Officers;
import abilities.ZhengAbility;

public class Zheng extends Officers{
    static final String name = "Alex Zheng";
    static final int startingHp = 0;
    static final String imageName = "zheng";
    static final int cost = 150;
    public Zheng(){
        super(name, startingHp, new ZhengAbility(), imageName, cost);
    }
}
