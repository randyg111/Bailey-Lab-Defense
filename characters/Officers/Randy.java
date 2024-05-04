package characters.Officers;

import java.awt.*;

public class Randy extends Officer {
    static final String name = "Randy Guo";
    static final int startingHp = 8000;
    static final String imageName = "randy.png";
    static final int cost = 125;
    public Randy(int x, int y, int w, int h){
        super(name, startingHp, imageName, x, y, w, h, cost);
    }
    public void useAbility()
    {

    }
}
