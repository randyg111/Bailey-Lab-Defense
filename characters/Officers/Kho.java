package characters.Officers;

import java.awt.*;

public class Kho extends Officer {
    static final String name = "Khosraw Azizi";
    static final int startingHp = 300;
    static final String imageName = "kho";
    static final int cost = 50;
    static final int d = 0;
    static final double r = 24;
    public Kho(int x, int y){
        super(name, startingHp, imageName, x, y, cost);
    }
    public void draw(Graphics2D gr)
    {

    }
    public void useAbility()
    {

    }
}
