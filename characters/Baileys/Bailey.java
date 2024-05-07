package characters.Baileys;
import characters.Character;
import characters.Officers.Officer;
import level.Level;
import level.LevelPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Bailey extends Character {
    protected int speed;

    public Bailey(){
        super();
    }
    public Bailey(String name, int hp, String image, int x, int y, int w, int h, int speed, int d, double r) {
        super(name, hp, image, x, y, w, h, d, r);
        this.speed = speed;
        if(LevelPlayer.LEVEL != null && !name.equals("Shockwave"))
            start();
    }

    public void eat(Officer officer)
    {
        officer.minusHp(damage);
        if(officer.getHp() <= 0)
            start();
    }

    public void startEat()
    {
        timer = new Timer((int) (1000/rate), new TimerListener(LevelPlayer.LEVEL));
        timer.start();
    }

    public void walk()
    {
        x -= speed;
    }

    public boolean isWalking()
    {
        return active;
    }
    public void useAbility(Level level) {
        if(active) {
            walk();
        }
        else
        {
            Point p = level.getLoc(this);
            int c = p.y;
            int r = p.x;
            Officer officer = level.getOfficer(r, c);
            if(officer != null)
                eat(officer);
        }
    }
}
