package menuItemFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


class Headcan extends JPanel{
	JLabel jlab;
	ImageIcon ii;
	public Headcan(){
		setLayout(new FlowLayout());
		ii = new ImageIcon("G:\\workspace\\cmc\\general.png");
		jlab = new JLabel("CANTEEN",ii,JLabel.CENTER);
		jlab.setFont(new Font("Comic Sans MS",Font.BOLD,16));
		jlab.setForeground(Color.BLUE);
		setBackground(Color.WHITE);
		add(jlab);
	} 
}

class Bodycan extends JPanel{
	JLabel content;
	public Bodycan(){
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		content = new JLabel(new ImageIcon("C:\\Users\\Devroop Kar\\Pictures\\Screenshots\\Screenshot (205).png"));
		
		add(content);
	}
}




public class Canteen extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Canteen() {
		setVisible(true);
		//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 543, 364);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		Headcan headcan = new Headcan();
		Bodycan bodycan = new Bodycan();
		add(headcan);
		add(bodycan);
	}

}
