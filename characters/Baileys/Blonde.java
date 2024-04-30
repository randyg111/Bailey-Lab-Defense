package characters.Baileys;
import abilities.BasicAbility;

public class Blonde extends Bailey {
    static final String name = "Blonde Bailey";
    static final int startingHp = 200;
    static final String imageName = "blonde";
    static final int startingSpeed = 10;
    public Blonde(){
        super(name, startingHp, new BasicAbility(), imageName, startingSpeed);
    }
}
