package characters.Baileys;
import abilities.GlassesAbility;

public class Glasses extends Bailey {
    static final String name = "Glasses Bailey";
    static int startingHp = 400;
    static final String imageName = "Glasses";
    static final int startingSpeed = 10;
    public Glasses(){
        super(name, startingHp, new GlassesAbility(), imageName, startingSpeed);
    }
}
