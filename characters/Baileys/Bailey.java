package characters.Baileys;
import characters.Character;

public abstract class Bailey extends Character {
    protected int speed;
    protected boolean walking;

    public Bailey(){
        super();
    }
    public Bailey(String name, int hp, String image, int x, int y, int w, int h, int speed) {
        super(name, hp, image, x, y, w, h);
        this.speed = speed;
        walking = true;
    }



}
