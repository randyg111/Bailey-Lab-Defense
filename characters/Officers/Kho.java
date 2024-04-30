package characters.Officers;
import abilities.KhoAbility;

public class Kho extends Officers{
    static final String name = "Khosraw Azizi";
    static final int startingHp = 300;
    static final String imageName = "kho";
    static final int cost = 50;
    public Kho(){
        super(name, startingHp, new KhoAbility(), imageName, cost);
    }
}
