package level;

import level.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class LevelPlayer {
    private static int numPizza = 0;
    public static Level LEVEL;

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Bailey Lab Defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        frame.getContentPane().setBackground(Color.gray);

//        ImageIcon pizzaImage = new ImageIcon("pizza.jpg");
//        JButton testbutton = new JButton(pizzaImage);
//        testbutton.setBounds(50, 50, 100, 100);
//        frame.add(testbutton);
//        testbutton.addActionListener(new PizzaListener());
//        frame.setLayout(null);


        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
//        frame.setSize((int) bounds.getWidth(), (int) bounds.getHeight());

        LEVEL = new Level((int) bounds.getWidth(), (int) bounds.getHeight());
        frame.add(LEVEL);
        frame.setVisible(true);

        Timer timer = new Timer(1000, new TimerListener(LEVEL));
        timer.setActionCommand("test");
//        timer.start();
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
            if (event.getSource() instanceof Timer)
            {
                switch (((Timer) event.getSource()).getActionCommand()) {
                    case "test":
                        System.out.println("TEST");
                        break;
                }
            }
        }
    }

    static class PizzaListener implements ActionListener{
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
