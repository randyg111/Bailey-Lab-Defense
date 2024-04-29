package characters.Baileys;
import abilities.PhoneAbility;

public class Phone extends Bailey {
    static final String name = "Blonde Bailey";
    static int hp = 200;
    static final String imageName = "Blonde";
    static int speed = 10;
    public Phone(){
        super(name, hp, new PhoneAbility(), imageName, speed);
    }
}