package characters.Baileys;
import abilities.SprayBottleAbility;

public class SprayBottle extends Bailey {
    static final String name = "Spray Bottle Bailey";
    static final int startingHp = 200;
    static final String imageName = "sprayBottle";
    static final int startingSpeed = 10;
    public SprayBottle(){
        super(name, startingHp, new SprayBottleAbility(), imageName, startingSpeed);
    }
}
