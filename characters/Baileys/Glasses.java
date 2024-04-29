package characters.Baileys;
import abilities.GlassesAbility;

public class Glasses extends Baileys{
    static final String name = "Glasses Bailey";
    static int hp = 400;
    static final String imageName = "Glasses";
    static int speed = 10;
    public Glasses(){
        super(name, hp, new GlassesAbility(), imageName, speed);
    }
}
