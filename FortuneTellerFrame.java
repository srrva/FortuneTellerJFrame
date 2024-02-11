import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {


    public FortuneTellerFrame() {

        JPanel mainPnl, topPnl, centerPnl, bottomPnl;  // constructor

        JLabel titleLbl = new JLabel("Fortune Teller");
        JButton quitBtn = new JButton("Quit");
        JButton fortBtn = new JButton("Read a fortune!");

        TextArea textArea = new TextArea(15, 80);
        JScrollPane scroller = new JScrollPane(textArea);
        QuitListener listener = new QuitListener();
        ImageIcon imageIcon = new ImageIcon("/Users/camdynrandolph/IdeaProjects/FortuneTeller/src/universe.png");
        JLabel imageLabel = new JLabel(imageIcon);

        // Create a JPanel for the top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(imageLabel, BorderLayout.CENTER);

        // Add other components or panels to the frame if needed

        // Set the top panel to the frame
        getContentPane().add(topPanel, BorderLayout.NORTH);


        quitBtn.addActionListener(listener);

        setTitle("Fortune Reader");

        mainPnl = new JPanel();     // making all the panels
        topPnl = new JPanel();
        centerPnl = new JPanel();
        centerPnl.add(scroller);
        bottomPnl = new JPanel();

        class ItemListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem;

                newItem = JOptionPane.showInputDialog(mainPnl, "Item", "Enter an Item");

                if (newItem.length() > 0)
                    textArea.append(newItem + "\n");

            }
        }

        add(mainPnl);                           // panels run like north, center, south, east, west(i think)
        mainPnl.setLayout(new BorderLayout());

        mainPnl.add(topPnl, BorderLayout.NORTH);
        topPnl.add(titleLbl);

        mainPnl.add(centerPnl, BorderLayout.CENTER);
        fortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] fortunes={"You will soon discover that your spirit animal is a caffeinated sloth.","Your future holds a high-stakes game of rock-paper-scissors with destiny.","Your socks will develop a strong desire for independence. Let them go.","You will be mistaken for a celebrity. Enjoy the VIP treatment while it lasts.","A flock of rebellious pigeons will appoint you as their leader.","You will become the world champion of air guitar. The trophy is invisible, but prestigious.","Remember that even small gestures of kindness can make a big difference.","Continue to lead by example, showing compassion and empathy in all that you do","Stay humble, for it is the path to inner peace and contentment.","Your modesty will speak volumes about your character. Let it shine.","Your quiet strength will guide others through turbulent times.","Hard work and perseverance will lead you to success, one step at a time.","Your words carry the weight of wisdom. Speak softly, but with purpose.","Just as the oak tree grows strong from its humble beginnings, so too shall you flourish with humility and resilience.","In the journey of life, remember to stay humble, but hungry for knowledge."};
                Random rnd = new Random();
                int randomNumber = rnd.nextInt(fortunes.length);
                System.out.println(fortunes[randomNumber]);


                textArea.append(fortunes[randomNumber] + "\n");
            }
        });


        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        bottomPnl.setLayout(new GridLayout(1, 2));
        bottomPnl.add(fortBtn);
        bottomPnl.add(quitBtn);

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
