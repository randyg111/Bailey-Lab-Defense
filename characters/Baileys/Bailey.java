package characters.Baileys;
import characters.Character;

public abstract class Bailey extends Character {
    int speed;

    public Bailey(){
        super();
    }
    public Bailey(String name, int hp, String image, int x, int y, int w, int h, int speed) {
        super(name, hp, image, x, y, w, h);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
    public void addSpeed(int add){
        speed += add;
    }

}
