package characters.Baileys;
import abilities.PhoneAbility;

public class Phone extends Bailey {
    static final String name = "Blonde Bailey";
    static int startingHp = 200;
    static final String imageName = "Blonde";
    static int startingSpeed = 5;
    public Phone(){
        super(name, startingHp, new PhoneAbility(), imageName, startingSpeed);
    }
}