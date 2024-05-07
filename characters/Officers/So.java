package characters.Officers;
import level.Bullet;
import level.Level;

public class So extends Officer {
    public static final String NAME = "Alex So";
    static final int startingHp = 350;
    public static final String IMAGE_NAME = "so.png";
    public static final int COST = 100;
    static final int d = 25;
    static final double r = 2.5;
    public So(int x, int y, int w, int h){
        super(NAME, startingHp, IMAGE_NAME, x, y, w, h, COST, d, r);
    }
    public void useAbility(Level level)
    {
        int bulletX = x + width;
        int bulletY = y + height/4;
        level.addBullet(new Bullet(bulletX, bulletY));
    }

}
