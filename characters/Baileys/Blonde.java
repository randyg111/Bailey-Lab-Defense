package characters.Baileys;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import level.Level;

import javax.swing.*;

public class Blonde extends Bailey {
    static final String name = "Blonde Bailey";
    static final int startingHp = 200;
    static final String imageName = "blonde.png";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public Blonde(int x, int y, int w, int h) {
        super(name, startingHp, imageName, x, y, w, h, startingSpeed);
    }

    public void useAbility(Level level) {
        System.out.println(x);
        if(walking) {
            x -= 100;
        }
    }
}
