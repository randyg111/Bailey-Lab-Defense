package characters.Officers;

import java.awt.*;

public class Emily extends Officer {
    static final String name = "Emily Lou";
    static final int startingHp = 300;
    static final String imageName = "emily";
    static final int cost = 150;
    static final int d = 15;
    static final double r = .75;
    public Emily(int x, int y){
        super(name, startingHp, imageName, x, y, cost);
    }
    public void draw(Graphics2D gr)
    {

    }
    public void useAbility()
    {

    }
}
