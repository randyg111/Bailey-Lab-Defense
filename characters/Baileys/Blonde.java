package characters.Baileys;
import abilities.BasicAbility;

public class Blonde extends Bailey {
    static final String name = "Blonde Bailey";
    static int hp = 200;
    static final String imageName = "blonde";
    static int speed = 10;
    public Blonde(){
        super(name, hp, new BasicAbility(), imageName, speed);
    }
}
