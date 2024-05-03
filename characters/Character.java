package characters;
import abilities.*;
import java.awt.event.ActionListener;
import java.util.*;

public abstract class Character implements Traits {
    String name;
    int hp;
    Ability power;
    String imageName;
    protected boolean active;
    public Character(){
        this.name = null;
        this.hp = 0;
        this.power = null;
        this.imageName = null;
        active = false;
    }

    public Character(String name, int hp, Ability power, String image){
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.imageName = image;
        active = false;
    }

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public void loseHp(int lose){
        hp -= lose;
    }

    public int getDamage(){
        return power.damage;
    }

    public double getRate(){
        return power.rate;
    }

    public String getImageName(){
        return imageName;
    }

    public void setImageName(String name){
        imageName = name;
    }

    public void activate(){
        active = true;
        Timer timer = new Timer(1000, new TimerListener());
        while(active){

        }
        animate()
    }

    public class TimerListener implements ActionListener {

    }

    public void deactivate(){
        active = false;
    }
}
