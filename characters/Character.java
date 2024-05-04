package characters;
import abilities.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public abstract class Character{
    private String name;
    private int hp;
    private BufferedImage image;
    boolean active;
    protected int x;
    protected int y;

    public Character() {
        this.name = null;
        this.hp = 0;
        this.image = null;
        active = false;
    }

    public Character(String name, int hp, String imageName, int x, int y){
        this.name = name;
        this.hp = hp;
        this.x = x;
        this.y = y;
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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(String name) throws IOException {
        image = ImageIO.read(new File(name));
    }

    /*
    public void activate() {
        while(
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

    public abstract void useAbility();

}
