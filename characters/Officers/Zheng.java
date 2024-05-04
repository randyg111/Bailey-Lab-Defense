package characters.Officers;

import java.awt.*;

public class Zheng extends Officer {
    static final String name = "Alex Zheng";
    static final int startingHp = 0;
    static final String imageName = "zheng";
    static final int cost = 150;
    static final int d = 1800;
    static final double r = 3;
    public Zheng(int x, int y){
        super(name, startingHp, imageName, x, y, cost);
    }
    public void draw(Graphics2D gr)
    {

    }
    public void useAbility()
    {

    }
}
