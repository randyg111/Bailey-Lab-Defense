package characters.Baileys;
import abilities.PhoneAbility;

import java.awt.*;

public class Phone extends Bailey {
    static final String name = "Blonde Bailey";
    static int startingHp = 200;
    static final String imageName = "Blonde";
    static int startingSpeed = 5;
    public Phone(int x, int y){
        super(name, startingHp, imageName, startingSpeed, x, y);
    }

    @Override
    public void useAbility() {

    }

    public void draw(Graphics2D gr){

    }
}