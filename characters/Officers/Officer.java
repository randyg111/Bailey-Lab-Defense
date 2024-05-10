package characters.Officers;
import characters.Baileys.Bailey;
import characters.Character;
import level.Level;
import level.LevelPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.Buffer;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Officer extends Character {
    int cost;
    boolean done;
    public Officer(){
        super();
    }
    public Officer(String name, int hp, String image, int x, int y, int w, int h, int cost, int d, double r) {
        super(name, hp, image, x, y, w, h, d, r);
        this.cost = cost;
        done = false;
    }

    public int getCost(){
        return cost;
    }

    public boolean isDone()
    {
        return done;
    }
    public void checkHp()
    {
        if(isDead())
        {
            setImage(imageName.replaceAll("Inactive|Active", "Dead"));
            Timer time = new Timer();
            time.schedule(new TimerTask() {
                @Override
                public void run() {
                    done = true;
                }
            }, 1500);
        }
    }
}
