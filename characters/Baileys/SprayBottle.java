package characters.Baileys;
import level.Level;
import level.Water;

public class SprayBottle extends Bailey {
    static final String NAME = "Spray Bottle Bailey";
    static final int STARTING_HP = 200;
    public static final String IMAGE_NAME = "images/sprayBottle.png";
    static final int STARTING_SPEED = 2;
    static final int DAMAGE = 200;
    static final double RATE = 3;

    public SprayBottle(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, STARTING_SPEED, DAMAGE, RATE);
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
        if(hp < STARTING_HP /2)
        {
            setImage("images/blonde.png");
        }
    }
}
