package characters.Baileys;

public class Glasses extends Bailey {
    static final String NAME = "Glasses Bailey";
    static final int STARTING_HP = 400;
    public static final String IMAGE_NAME = "images/glasses.png";
    static final int STARTING_SPEED = 10;
    static final int DAMAGE = 100;
    static final double RATE = 1;
    public Glasses(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, STARTING_SPEED, DAMAGE, RATE);
    }

    public void checkHp()
    {
        if(hp < STARTING_HP /2)
        {
            setImage("images/blonde.png");
            speed = 2* STARTING_SPEED;
            rate = 2* RATE;
        }
    }
}
