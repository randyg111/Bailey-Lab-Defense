package characters.Officers;

import java.awt.*;

public class Aaron extends Officer {
    static final String name = "Aaron Zhou";
    static final int startingHp = 0;
    static final String imageName = "aaron.png";
    static final int cost = 50;
    private static final int DAMAGE = 350;
    private static final double RATE = 2;
    public Aaron(int x, int y, int w, int h){
        super(name, startingHp, imageName, x, y, w, h, cost);
    }
    public void useAbility()
    {

    }
}
