package characters.Baileys;
import level.Level;
import level.Mobile;

public class Phone extends Bailey {
    static final String NAME = "Phone Bailey";
    static final int STARTING_HP = 200;
    public static final String IMAGE_NAME = "images/phone.png";
    static final int STARTING_SPEED = 1;
    static final int DAMAGE = 200;
    static final double RATE = 3;
    public Phone(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, STARTING_SPEED, DAMAGE, RATE);
    }

    public void useAbility(Level level) {
        walk();
        int mobileX = x;
        int mobileY = y;
        level.addMobile(new Mobile(mobileX, mobileY, mobileX - 3*level.getS1()));
    }

    public void checkHp()
    {
        if(hp < STARTING_HP /2)
        {
            setImage("images/blonde.png");
        }
    }

}