package characters.Baileys;
import characters.Character;
import characters.Officers.Officer;
import level.Level;
import level.LevelPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Bailey extends Character {
    protected int speed;
    protected boolean walking;
    protected int damage;
    protected int rate;

    public Bailey(){
        super();
    }
    public Bailey(String name, int hp, String image, int x, int y, int w, int h, int speed, int d, int r) {
        super(name, hp, image, x, y, w, h);
        this.speed = speed;
        damage = d;
        rate = r;
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
        timer = new Timer(1000/rate, new TimerListener(LevelPlayer.LEVEL));
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

}
