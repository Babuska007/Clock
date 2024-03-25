import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main Menu");
		
		JLabel label = new JLabel();
		label.setText("World Clock");
		
		new MyFrame();
		
		label.setHorizontalTextPosition(JLabel.CENTER);//set text CENTER of image icon
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("MV Boli", Font.BOLD, 20));
		label.setVerticalAlignment(JLabel.TOP);//set vertical position
		label.setHorizontalAlignment(JLabel.CENTER);//set horizontal position

		JButton button = new JButton();
		button.setBounds(200,100,100,50);
		button.setVisible(true);
		
		//stopwatch();

	}
	
	static void stopwatch()
	{
		int currentTime = 55;
		while(true)
		{
			int seconds = currentTime%60;
			int minutes = (currentTime/60)%60;
			int hours = currentTime/3600;
			
			System.out.println(formatDecimals(hours, minutes, seconds));
			
			currentTime++;
			delayTimeBySeconds(1);
		}
	}
	static String worldClock()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}
	static void timer()
	{
		try (Scanner scanner = new Scanner(System.in)) {
			int timerInput = scanner.nextInt();
			if(timerInput <= 86400 && timerInput >= 0)
			{
				for(int i = timerInput; i>0; i--)
				{
					int seconds = i%60;
					int minutes = (i/60)%60;
					int hours = i/3600;
					
					System.out.println(formatDecimals(hours, minutes, seconds));
					
					delayTimeBySeconds(1);
					
				}
				System.out.println("00:00:00");
				System.out.println("Time is up!");
				main(null);
			}
			else if(timerInput < 0 || timerInput > 86400)
			{
				System.out.println("Pick a number between 0 and 86400");
				timer();
			}
			else
			{
				return;
			}
		}
	}
	static void outputTimerMessage()
	{
		System.out.println("Set timer duration (in seconds): ");
		timer();
	}
	static String formatDecimals(int hours, int minutes, int seconds)
	{
		DecimalFormat df = new DecimalFormat("00");
		return df.format(hours)+":"+df.format(minutes)+":"+df.format(seconds);
	}
	static void delayTimeBySeconds(int seconds)
	{
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}