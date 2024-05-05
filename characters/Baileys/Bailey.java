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
    protected Timer timer;
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

    public void start()
    {
        timer = new Timer(500, new TimerListener(LevelPlayer.LEVEL));
        walking = true;
        timer.start();
    }
    public void stop()
    {
        walking = false;
        timer.stop();
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
        return walking;
    }

    class TimerListener implements ActionListener
    {
        private final Level level;

        public TimerListener(Level level)
        {
            this.level = level;
        }

        public void actionPerformed(ActionEvent event)
        {
            Bailey.this.useAbility(level);
            level.repaint();
        }
    }
}
