import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{

    JButton timerButton;
    JButton stopwatchButton;
    JButton alarmButton;

    JLabel label;

    Timer clockTimer;

    MyFrame()
    {
        label = new JLabel(Main.worldClock());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Comic Sans", Font.BOLD, 15));

        timerButton = new JButton("Timer");
        timerButton.addActionListener(this);

        stopwatchButton = new JButton("Stopwatch");
        stopwatchButton.addActionListener(this);

        alarmButton = new JButton("Alarm");
        alarmButton.addActionListener(this);

        this.setTitle("Clock");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 150);
        this.setLayout(new GridLayout(2, 3, 10, 0));
        this.setVisible(true);
        this.add(new JLabel());
        this.add(label);
        this.add(new JLabel());
        this.add(timerButton);
        this.add(stopwatchButton);
        this.add(alarmButton);

        clockTimer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                label.setText(Main.worldClock());
            }
        });
        clockTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == timerButton)
        {
            System.out.println("Timer button works");
        }
        if (e.getSource() == stopwatchButton)
        {
            System.out.println("Stopwatch button works");
        }
        if (e.getSource() == alarmButton)
        {
            System.out.println("Alarm button works");
        }
    }
}