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
    private static final int WALKING_RATE = 50;

    public Bailey(){
        super();
    }
    public Bailey(String name, int hp, String image, int x, int y, int w, int h, int speed, int d, double r) {
        super(name, hp, image, x, y, w, h, d, r);
        this.speed = speed;
        if(LevelPlayer.LEVEL != null && !name.equals("Shockwave"))
            startWalk();
    }

    public void eat(Officer officer)
    {
        officer.minusHp(damage);
        if(officer.getHp() <= 0)
            startWalk();
    }

    public void startWalk()
    {
        active = false;
        timer = new Timer(WALKING_RATE, new TimerListener(LevelPlayer.LEVEL));
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
        if(!active) {
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
            else
                start();
        }
    }

    public void checkHp()
    {

    }
}
