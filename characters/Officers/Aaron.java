package characters.Officers;
import characters.Baileys.Bailey;
import javafx.animation.PathTransition;
import level.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Aaron extends Officer {
    public static final String NAME = "Aaron Zhou";
    static final int STARTING_HP = 1000;
    public static final String IMAGE_NAME = "images/aaronInactive.png";
    public static final int COST = 50;
    private static final int DAMAGE = 600; //used to be 350
    private static final double RATE = 2;
    public Aaron(int x, int y, int w, int h){
        super(NAME, STARTING_HP, IMAGE_NAME, x, y, w, h, COST, DAMAGE, RATE);
    }
    public void useAbility(Level level) {
        Bailey bailey = level.getNearestBailey(this);
        setImage("images/aaronActive.png");
        Timer time = new Timer();
        javax.swing.Timer jump = new javax.swing.Timer(100, e -> y -= 2);
        javax.swing.Timer moveX = new javax.swing.Timer(200, e -> x++);
        javax.swing.Timer fall = new javax.swing.Timer(100, e -> y += 2);
        jump.start();
        moveX.start();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                jump.stop();
                fall.start();
            }
        }, 1000);
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                moveX.stop();
                fall.stop();
                bailey.minusHp(damage);
                done = true;
            }
        }, 2000);
        hp = 0;
    }
}
