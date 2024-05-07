package characters.Baileys;
import level.Level;

public class Phone extends Bailey {
    static final String name = "Phone Bailey";
    static int startingHp = 200;
    public static final String IMAGE_NAME = "phone.png";
    static final int startingSpeed = 5;
    static final int d = 200;
    static final double r = 3;
    public Phone(int x, int y, int w, int h){
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