package characters.Officers;
import characters.Baileys.Bailey;
import level.Level;
import level.LevelPlayer;

import java.awt.*;
import java.util.List;

public class Zheng extends Officer {
    public static final String NAME = "Alex Zheng";
    static final int STARTING_HP = 1000;
    public static final String IMAGE_NAME = "images/zhengInactive.png";
    public static final int COST = 150;
    static final int DAMAGE = 1800;
    static final double RATE = 1.5;
    public Zheng(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, COST, DAMAGE, RATE);
        if(LevelPlayer.LEVEL != null)
            start();
    }
    public void useAbility(Level level)
    {
        Point p = level.getLoc(this);
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
