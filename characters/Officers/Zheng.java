package characters.Officers;
import abilities.ZhengAbility;

public class Zheng extends Officer {
    static final String name = "Alex Zheng";
    static final int startingHp = 0;
    static final String imageName = "zheng";
    static final int cost = 150;
    public Zheng(int x, int y){
        super(name, startingHp, new ZhengAbility(), imageName, x, y, cost);
    }
}
