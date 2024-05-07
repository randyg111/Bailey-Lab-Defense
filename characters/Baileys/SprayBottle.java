package characters.Baileys;
import level.Level;
import level.Mobile;
import level.Water;

public class SprayBottle extends Bailey {
    static final String name = "Spray Bottle Bailey";
    static final int startingHp = 200;
    public static final String IMAGE_NAME = "sprayBottle.png";
    static final int startingSpeed = 10;
    static final int d = 200;
    static final double r = 3;

    public SprayBottle(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }

    public void useAbility(Level level) {
        walk();
        int waterX = x + width/2;
        int waterY = y + height/2;
        level.addWater(new Water(waterX, waterY, waterX - level.getS1(), waterY - level.getS2()));
        level.addWater(new Water(waterX, waterY, waterX - level.getS1(), waterY));
        level.addWater(new Water(waterX, waterY, waterX - level.getS1(), waterY + level.getS2()));
    }

    public void checkHp()
    {
        if(hp < startingHp/2)
        {
            setImage("blonde.png");
        }
    }
}
