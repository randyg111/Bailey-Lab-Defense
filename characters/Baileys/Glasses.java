package characters.Baileys;
import abilities.GlassesAbility;

import java.awt.*;

public class Glasses extends Bailey {
    static final String name = "Glasses Bailey";
    static int startingHp = 400;
    static final String imageName = "Glasses";
    static final int startingSpeed = 10;
    public Glasses(int x, int y){
        super(name, startingHp, imageName, startingSpeed, x, y);
    }


    public void useAbility() {

    }

    public void draw(Graphics2D gr){

    }
}
