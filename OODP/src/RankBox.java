import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author heeseok
 *
 */
public class RankBox {
	String name;
	
	public RankBox(float time) {
		Dimension dim = new Dimension(400, 150);
		
		JFrame frame = new JFrame("Rank");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		JTextField textfield = new JTextField();
		
		JLabel label = new JLabel("Enter Your Name");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = textfield.getText();
				System.out.println("name : " + name + ", time : " + time);
				new Ranking(name, time);
				frame.setVisible(false);
			}
		});
		
		frame.add(textfield, BorderLayout.CENTER);
		frame.add(label, BorderLayout.NORTH);
		frame.add(button, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}

}
