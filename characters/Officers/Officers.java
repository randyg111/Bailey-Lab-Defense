package characters.Officers;
import abilities.*;
import characters.Character;

public abstract class Officers extends Character {
    int cost;
    public Officers(){
        super();
    }
    public Officers(String name, int hp, Ability power, String image, int cost) {
        super(name, hp, power, image);
        this.cost = cost;
    }

    public int getCost(){
        return cost;
    }
}
