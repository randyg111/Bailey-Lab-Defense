package level;

import characters.Baileys.Bailey;

public class Pizza extends Bailey {
    public static final int WIDTH = 104;
    public static final int HEIGHT = 65;
    public static final String IMAGE_NAME = "images/pizza.png";
    private static final String NAME = "Pizza";
    private static final int STARTING_HP = 0;
    private static final int DAMAGE = 0;
    private static final double RATE = 0.25;
    private static final int STARTING_SPEED = 4;
    private final int dy;

    public Pizza(int x, int y, int dy)
    {
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, WIDTH, HEIGHT, STARTING_SPEED, DAMAGE, RATE);
        this.dy = dy;
    }

    public void useAbility(Level level)
    {
        if (y < dy)
        {
            y += speed;
        }
        else
        {
            stop();
        }
    }

}

