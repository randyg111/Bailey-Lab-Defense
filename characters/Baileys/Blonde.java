package characters.Baileys;
import abilities.BasicAbility;

import java.awt.*;

public class Blonde extends Bailey {
    static final String name = "Blonde Bailey";
    static final int startingHp = 200;
    static final String imageName = "blonde";
    static final int startingSpeed = 10;
    public Blonde(int x, int y){
        super(name, startingHp, imageName, startingSpeed, x, y);
    }

    public void useAbility() {

    }

    public void draw(Graphics2D gr){

    }
}
