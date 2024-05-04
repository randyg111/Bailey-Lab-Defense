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
        int s1 = (w-50)/5;
        int s2 = (h-50)/9;

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if (grid[row][col] == null)
                {
                    g.setColor(Color.gray);
                    g.fill(new Rectangle(row*s1 + 25, col*s2 + 25, s1, s2));
                }
                else
                {
                    grid[row][col].draw(g);
                }
            }
        }
    }
}

