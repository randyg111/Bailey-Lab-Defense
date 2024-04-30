package characters.Baileys;
import abilities.BasicAbility;

public class RedHead extends Bailey {
    static final String name = "RedHead Bailey";
    static final int startingHp = 400;
    static final String imageName = "redhead";
    static final int startingSpeed = 10;
    public RedHead(){
        super(name, startingHp, new BasicAbility(), imageName, startingSpeed);
    }
}
