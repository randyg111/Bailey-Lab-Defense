package characters.Baileys;
import level.Level;

public class RedHead extends Bailey {
    static final String name = "RedHead Bailey";
    static final int startingHp = 400;
    public static final String IMAGE_NAME = "redHead.png";
    static final int startingSpeed = 10;
    static final int d = 100;
    static final double r = 1;
    public RedHead(int x, int y, int w, int h){
        super(name, startingHp, IMAGE_NAME, x, y, w, h, startingSpeed, d, r);
    }

//    public void useAbility(Level level) {
//
//    }

    public void checkHp()
    {
        if(hp < startingHp/2)
        {
            setImage("blonde.png");
        }
    }
}
