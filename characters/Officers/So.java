package characters.Officers;

import java.awt.*;

public class So extends Officer {
    static final String name = "Alex So";
    static final int startingHp = 350;
    static final String imageName = "alexS";
    static final int cost = 100;
    static final int d = 25;
    static final double r = 1.5;
    public So(int x, int y){
        super(name, startingHp, imageName, x, y, cost);
    }
    public void draw(Graphics2D gr)
    {

    }
    public void useAbility()
    {

    }

}
