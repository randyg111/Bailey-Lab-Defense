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
    private Timer walkTimer;
    private boolean walking;

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
        {
            stop();
            startWalk();
        }
    }

    public void checkRange(Level level)
    {
        Point p = level.getLoc(this);
        int c = p.y;
        int r = p.x;
        if (isWalking() && level.containsOfficer(r, c)) {
            stopWalk();
            start();
        }
    }

    public void startWalk()
    {
        walking = true;
        walkTimer = new Timer(WALKING_RATE, new WalkListener(LevelPlayer.LEVEL));
        walkTimer.start();
    }

    public void stopWalk()
    {
        walking = false;
        walkTimer.stop();
    }

    public void walk()
    {
        x -= speed;
    }

    public boolean isWalking()
    {
        return walking;
    }
    public void useAbility(Level level) {
        Point p = level.getLoc(this);
        int c = p.y;
        int r = p.x;
        Officer officer = level.getOfficer(r, c);
        if(officer != null)
            eat(officer);
        else {
            stop();
            startWalk();
        }
    }

    public void checkHp()
    {

    }

    protected class WalkListener implements ActionListener
    {
        private final Level level;

        public WalkListener(Level level)
        {
            this.level = level;
        }

        public void actionPerformed(ActionEvent event)
        {
            Bailey.this.walk();
            level.repaint();
        }
    }
}
