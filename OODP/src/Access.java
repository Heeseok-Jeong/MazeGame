import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Access
{
	public static final int PassWord = 1234;
	
	public Access() {
		Dimension dim = new Dimension(400, 150);
		
		JFrame frame = new JFrame("PW");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		JTextField textfield = new JTextField();
		
		JLabel label = new JLabel("Enter The PassWord");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(textfield.getText()) == PassWord) {
					new MazeMapMaker();
					frame.setVisible(false);					
				}
				else {
					new Access();
				}
			}
		});
		
		frame.add(textfield, BorderLayout.CENTER);
		frame.add(label, BorderLayout.NORTH);
		frame.add(button, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new MainMenu();
	}
}