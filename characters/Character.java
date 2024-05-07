package characters;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.swing.Timer;

import characters.Baileys.Bailey;
import characters.Officers.Kho;
import level.Level;
import level.LevelPlayer;

public abstract class Character{
    protected String name;
    protected int hp;
    protected Image image;
    protected boolean active;
    public int x;
    public int y;
    public int width;
    public int height;
    protected Timer timer;
    protected int damage;
    protected double rate;

    public Character() {
        this.name = null;
        this.hp = 0;
        this.image = null;
        active = false;
    }

    public Character(String name, int hp, String imageName, int x, int y, int width, int height, int d, double r){
        this.name = name;
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        damage = d;
        rate = r;
        try{
            image = ImageIO.read(new File(imageName));
            image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } catch (IOException e){
            System.out.println(imageName + " image not found");
        }

        active = false;
    }

    public void start()
    {
        if(LevelPlayer.LEVEL == null) {
            System.out.println("Level is null: "+name);
            return;
        }
        timer = new Timer((int) (1000*rate), new TimerListener(LevelPlayer.LEVEL));
        active = true;
        timer.start();
    }
    public void stop()
    {
        active = false;
        timer.stop();
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void minusHp(int lose) {
        hp -= lose;
        checkHp();
    }

    public int getDamage()
    {
        return damage;
    }

    public boolean isDead()
    {
        return hp <= 0;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(String name) {
        try{
            image = ImageIO.read(new File(name));
            Dimension d = Level.getDimension(name, new Dimension(width, height));
            image = image.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
        } catch (IOException e){
            System.out.println(name + " image not found");
        }
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D gr)
    {
        gr.drawImage(image, x, y, null);
    }

    public boolean isActive()
    {
        return active;
    }

    public abstract void useAbility(Level level);

    public abstract void checkHp();

//    static int num = 0;
    protected class TimerListener implements ActionListener
    {
        private final Level level;

        public TimerListener(Level level)
        {
            this.level = level;
        }

        public void actionPerformed(ActionEvent event)
        {
//            System.out.println(++num);
            Character.this.useAbility(level);
            level.repaint();
        }
    }
}
