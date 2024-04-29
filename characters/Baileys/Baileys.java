package characters.Baileys;
import abilities.*;
import characters.*;
import characters.Character;

public abstract class Baileys extends Character {
    int speed;

    public Baileys(){
        super();
    }
    public Baileys(String name, int hp, Ability power, String image, int speed) {
        super(name, hp, power, image);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
