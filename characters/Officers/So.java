package characters.Officers;
import level.Bullet;
import level.Level;

public class So extends Officer {
    public static final String NAME = "Alex So";
    static final int STARTING_HP = 350;
    public static final String IMAGE_NAME = "images/soInactive.png";
    public static final int COST = 100;
    static final int DAMAGE = 25;
    static final double RATE = 5;
    public So(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, COST, DAMAGE, RATE);
    }
    public void useAbility(Level level)
    {
        int bulletX = x + width;
        int bulletY = y + height/4;
        level.addBullet(new Bullet(bulletX, bulletY));
    }

}
