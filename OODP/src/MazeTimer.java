import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


/** 
 * 
 * @author heeseok
 *
 */
public class MazeTimer extends JFrame{
	JLabel labelTimer;
	Timer timer = new Timer();
	float sec;
	String time;
	
	public MazeTimer(float lastTime) {
		super("Timer");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		this.setLocation(175, 160);
		
		labelTimer = new JLabel();
		labelTimer.setFont(new Font("GOTHIC", Font.BOLD, 20));
		labelTimer.setHorizontalAlignment(NORMAL);
		
		startTimer(lastTime);
		
		add(labelTimer);
		setSize(150, 100);
		setVisible(true);
	}
	
	private void startTimer(float lastSec) {
		sec = lastSec;
		timer.cancel();
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				time = String.format("%.2f", sec);
				labelTimer.setText(" " + time + "sec");
				sec = (float) (sec + 0.01);
			}
		}, 0, 10);
	}
	
	public float saveTimer() {
		timer.cancel();
//		this.dispose();
		return sec;
	}

}