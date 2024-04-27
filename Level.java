import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Level extends JComponent {
    private Graphic[][] grid;
    public Level()
    {
        grid = new Graphic[5][9];
    }
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        try {
            BufferedImage image = ImageIO.read(new File("pizza.jpg"));
            g.drawImage(image, 100, 100, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

