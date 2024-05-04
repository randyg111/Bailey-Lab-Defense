package characters;
import abilities.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public abstract class Character
{
    private String name;
    private int hp;
    private Ability power;
    private BufferedImage image;
    protected boolean active;
    private int x;
    private int y;

    public Character()
    {

    }

    public Character(String name, int hp, Ability power, String imageName, int x, int y)
    {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.x = x;
        this.y = y;

        try{
            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            System.out.println(imageName + " image not found");
        }

        active = false;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void minusHp(int lose) {
        hp -= lose;
    }

    public int getDamage() {
        return power.damage;
    }

    public double getRate() {
        return power.rate;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(String name) throws IOException {
        image = ImageIO.read(new File(name));
    }

    /*
    public void activate() {
        active = true;
        Timer timer = new Timer(1000, new TimerListener());
        while (active) {

        }
        //animate()
    }

     */

    public void deactivate() {
        active = false;
    }

    public abstract void draw(Graphics2D gr);

}
