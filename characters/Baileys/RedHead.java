package characters.Baileys;
import abilities.BasicAbility;

public class RedHead extends Bailey {
    static final String name = "RedHead Bailey";
    static int hp = 400;
    static final String imageName = "redhead";
    static int speed = 10;
    public RedHead(){
        super(name, hp, new BasicAbility(), imageName, speed);
    }
}
