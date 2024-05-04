package characters.Officers;

import java.awt.*;

public class So extends Officer {
    static final String name = "Alex So";
    static final int startingHp = 350;
    static final String imageName = "so.png";
    static final int cost = 100;
    static final int d = 25;
    static final double r = 1.5;
    public So(int x, int y, int w, int h){
        super(name, startingHp, imageName, x, y, w, h, cost);
    }
    public void useAbility()
    {

    }

}
