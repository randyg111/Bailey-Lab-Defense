package characters.Baileys;
import abilities.SprayBottleAbility;

public class SprayBottle extends Bailey {
    static final String name = "Spray Bottle Bailey";
    static int hp = 200;
    static final String imageName = "sprayBottle";
    static int speed = 10;
    public SprayBottle(){
        super(name, hp, new SprayBottleAbility(), imageName, speed);
    }
}
