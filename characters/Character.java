package characters;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import level.Level;

public abstract class Character{
    protected String name;
    protected int hp;
    protected Image image;
    boolean active;
    public int x;
    public int y;
    public int width;
    public int height;

    public Character() {
        this.name = null;
        this.hp = 0;
        this.image = null;
        active = false;
    }

    public Character(String name, int hp, String imageName, int x, int y, int width, int height){
        this.name = name;
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        try{
            image = ImageIO.read(new File(imageName));
            image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } catch (IOException e){
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

    public Image getImage() {
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

    public void draw(Graphics2D gr)
    {
        gr.drawImage(image, x, y, null);
    }

    public abstract void useAbility(Level level);

}
