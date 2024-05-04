package level;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;

import characters.Character;
import characters.Officers.*;

public class Level extends JComponent {
    private Character[][] grid;
    private static final int ROWS = 5;
    private static final int COLS = 9;
    public Level()
    {
        grid = new Character[ROWS][COLS];
    }
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        int w = getWidth();
        int h = getHeight();
        int s1 = (h-50)/ROWS;
        int s2 = (w-50)/COLS;

        grid[1][1] = new Aaron(1*s2+25, 1*s1+25, s2, s1);
        grid[0][2] = new So(2*s2+25, 0*s1+25, s2, s1);
        grid[3][4] = new Zheng(4*s2+25, 3*s1+25, s2, s1);
        grid[4][7] = new Emily(7*s2+25, 4*s1+25, s2, s1);
        grid[2][8] = new Kho(8*s2+25, 2*s1+25, s2, s1);
        grid[0][5] = new Randy(5*s2+25, 0*s1+25, s2, s1);
        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if (grid[row][col] == null)
                {
                    Rectangle rect = new Rectangle(col*s2 + 25, row*s1 + 25, s2, s1);
                    g.setColor(Color.lightGray);
                    g.fill(rect);
                    g.setColor(Color.black);
                    g.draw(rect);
                }
                else
                {
                    grid[row][col].draw(g);
                }
            }
        }

    }

    public Location mouseClicked(MouseEvent e){
            return (Location) e.getLocationOnScreen();
    }
}

