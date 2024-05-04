import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelPlayer {
    private static Timer timer;
    private static int numPizza = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bailey Lab Defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        frame.setBackground(Color.gray);
        Level level = new Level();
        frame.add(level);

        ImageIcon pizzaImage = new ImageIcon("pizza.jpg");
        JButton testbutton = new JButton(pizzaImage);
        testbutton.setBounds(50, 50, 100, 100);
        frame.add(testbutton);
        testbutton.addActionListener(new pizzaListener());
        frame.setLayout(null);


        frame.setVisible(true);

        timer = new Timer(1000, new TimerListener(level));
        timer.start();
    }

    static class TimerListener implements ActionListener
    {
        private final Level level;

        public TimerListener(Level level)
        {
            this.level = level;
        }

        /**
         *  Advances the race whenever the timer goes off
         *  @param event the event for this timer
         */
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == timer)
            {
                System.out.println("TEST");
            }
        }
    }

    static class pizzaListener implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            JButton button = (JButton) event.getSource();
            addPizza(50);
            button.setVisible(false);
            System.out.println(numPizza);

        }
    }
    public static void addPizza(int num){
        numPizza += num;
    }

    public static void minusPizza(int num){
        numPizza -= num;
    }



}

