package characters.Baileys;

public class Id extends Bailey {
    static final String NAME = "Id Bailey";
    static final int STARTING_HP = 600;
    public static final String IMAGE_NAME = "images/id.png";
    static final int STARTING_SPEED = 2;
    static final int DAMAGE = 100;
    static final double RATE = 1;
    public Id(int x, int y, int w, int h) {
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, STARTING_SPEED, DAMAGE, RATE);
    }

    public void checkHp()
    {
        if(hp < STARTING_HP /2)
        {
            setImage("images/blonde.png");
        }
    }
}
