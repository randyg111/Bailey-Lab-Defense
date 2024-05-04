package characters.Officers;
import characters.Character;

import java.nio.Buffer;

public abstract class Officer extends Character {
    int cost;
    public Officer(){
        super();
    }
    public Officer(String name, int hp, String image, int x, int y, int w, int h, int cost) {
        super(name, hp, image, x, y, w, h);
        this.cost = cost;
    }

    public int getCost(){
        return cost;
    }

}
