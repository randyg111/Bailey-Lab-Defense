package characters.Baileys;
import characters.Character;
import level.Level;
import level.LevelPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Bailey extends Character {
    protected int speed;
    protected boolean walking;
    protected Timer timer;

    public Bailey(){
        super();
    }
    public Bailey(String name, int hp, String image, int x, int y, int w, int h, int speed) {
        super(name, hp, image, x, y, w, h);
        this.speed = speed;
        walking = true;
        timer = new Timer(1000, new TimerListener(LevelPlayer.LEVEL));
        timer.start();
    }

    public void start()
    {
        walking = true;
        timer.start();
    }
    public void stop()
    {
        walking = false;
        timer.stop();
    }

    class TimerListener implements ActionListener
    {
        private final Level level;

        public TimerListener(Level level)
        {
            this.level = level;
        }

        /**
         *  Advances the race whenever the timer goes off
         *  @param event the event for this timer
         */
        public void actionPerformed(ActionEvent event)
        {
            Bailey.this.useAbility(level);
            level.repaint();
        }
    }
}
