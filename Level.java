import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import characters.Character;

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
}

