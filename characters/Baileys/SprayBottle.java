package characters.Baileys;
import abilities.SprayBottleAbility;
import java.awt.*;

public class SprayBottle extends Bailey {
    static final String name = "Spray Bottle Bailey";
    static final int startingHp = 200;
    static final String imageName = "sprayBottle";
    static final int startingSpeed = 10;
    public SprayBottle(int x, int y){
        super(name, startingHp, imageName, startingSpeed, x, y);
    }

    public void useAbility() {

    }

    public void draw(Graphics2D gr){

    }
}
