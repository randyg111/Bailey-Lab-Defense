package characters.Officers;

import javax.swing.*;
import java.awt.*;

public class Emily extends Officer {
    static final String name = "Emily Lou";
    static final int startingHp = 300;
    static final String imageName = "emily";
    static final String abilityImageName = "pizza.jpg";
    static final int cost = 150;
    static final int d = 15;
    static final double r = .75;
    public Emily(int x, int y, int w, int h){
        super(name, startingHp, imageName, x, y, w, h, cost);
    }
    public void draw(Graphics2D gr)
    {

    }

    public void useAbility()
    {
        JButton button = new JButton();
    }
}
