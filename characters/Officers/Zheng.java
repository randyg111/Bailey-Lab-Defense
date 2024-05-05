package characters.Officers;
import characters.Baileys.Bailey;
import level.Level;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.List;

public class Zheng extends Officer {
    public static final String NAME = "Alex Zheng";
    static final int startingHp = 100;
    public static final String IMAGE_NAME = "zheng.png";
    public static final int COST = 150;
    static final int d = 1800;
    static final double r = 1.5;
    public Zheng(int x, int y, int w, int h){
        super(NAME, startingHp, IMAGE_NAME, x, y, w, h, COST, d, r);
        start();
    }
    public void useAbility(Level level)
    {
        Point p = level.getLoc(x, y, width, height);
        Rectangle rect = level.getRectangle(p.x, p.y);
        int s = level.getS1();
        List<Bailey>[] baileys = level.getBaileys();
        if(p.x > 0)
        {
            for (Bailey bailey : baileys[p.x-1])
            {
                if(bailey.x >= rect.x-s && bailey.x <= rect.x+2*s)
                    bailey.minusHp(damage);
            }
        }
        for (Bailey bailey : baileys[p.x])
        {
            if(bailey.x >= rect.x-s && bailey.x <= rect.x+2*s)
                bailey.minusHp(damage);
        }
        if(p.x < baileys.length-1)
        {
            for (Bailey bailey : baileys[p.x+1])
            {
                if(bailey.x >= rect.x-s && bailey.x <= rect.x+2*s)
                    bailey.minusHp(damage);
            }
        }
        hp = 0;
    }
}
