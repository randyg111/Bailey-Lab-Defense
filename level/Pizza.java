package level;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;

public class Pizza  {
    public int x;
    public int y;
    public static final int WIDTH = 104;
    public static final int HEIGHT = 65;
    public static final String IMAGE_NAME = "pizza.png";
    private Image image;

    public Pizza(int x, int y)
    {
        this.x = x;
        this.y = y;
        try{
            image = ImageIO.read(new File(IMAGE_NAME));
            image = image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
        } catch (IOException e){
            System.out.println(IMAGE_NAME + " image not found");
        }
    }

    public void draw(Graphics2D gr)
    {
        gr.drawImage(image, x, y, null);
    }

}

