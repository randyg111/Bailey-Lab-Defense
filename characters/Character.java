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

public abstract class Character{
    String name;
    int hp;
    Ability power;
    BufferedImage image;
    protected boolean active;

    public Character() {
        this.name = null;
        this.hp = 0;
        this.power = null;
        this.image = null;
        active = false;
    }

    public Character(String name, int hp, Ability power, String imageName){
        this.name = name;
        this.hp = hp;
        this.power = power;
        try{
            image = ImageIO.read(new File(imageName));
        } catch (IOException e){
            System.out.println(imageName + "image not found");
        }

        active = false;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void loseHp(int lose) {
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

    //public abstract void draw(Graphics2D gr);

}
