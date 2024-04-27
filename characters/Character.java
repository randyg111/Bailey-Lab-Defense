package characters;
import abilities.*;
public abstract class Character implements Traits {
    String name;
    int hp;
    Ability power;
    String imageName;
    public Character(){
        this.name = null;
        this.hp = 0;
        this.power = null;
        this.imageName = null;
    }

    public Character(String name, int hp, Ability power, String image){
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.imageName = image;
    }

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
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
}
