package characters.Baileys;
import characters.Character;

import javax.swing.*;

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

}
