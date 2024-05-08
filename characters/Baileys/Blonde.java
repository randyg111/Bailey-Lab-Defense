package characters.Baileys;

public class Blonde extends Bailey {
    static final String NAME = "Blonde Bailey";
    static final int STARTING_HP = 200;
    public static final String IMAGE_NAME = "images/blonde.png";
    static final int STARTING_SPEED = 10;
    static final int DAMAGE = 50; //used to be 100
    static final double RATE = 1;
    public Blonde(int x, int y, int w, int h) {
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, STARTING_SPEED, DAMAGE, RATE);
    }

    public void checkHp()
    {

    }
}
