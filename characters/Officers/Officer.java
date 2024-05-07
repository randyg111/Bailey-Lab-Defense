package characters.Officers;
import characters.Baileys.Bailey;
import characters.Character;
import level.Level;
import level.LevelPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.Buffer;

public abstract class Officer extends Character {
    int cost;
    public Officer(){
        super();
    }
    public Officer(String name, int hp, String image, int x, int y, int w, int h, int cost, int d, double r) {
        super(name, hp, image, x, y, w, h, d, r);
        this.cost = cost;
    }

    public int getCost(){
        return cost;
    }
    public void checkHp()
    {

    }
}
