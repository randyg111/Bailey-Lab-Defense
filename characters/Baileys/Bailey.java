package characters.Baileys;
import abilities.*;
import characters.Character;

public abstract class Bailey extends Character {
    int speed;

    public Bailey(){
        super();
    }
    public Bailey(String name, int hp, Ability power, String image, int speed) {
        super(name, hp, power, image);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
