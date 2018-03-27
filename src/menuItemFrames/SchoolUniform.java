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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;



class Headuni extends JPanel{
	JLabel jlab;
	ImageIcon ii;
	public Headuni(){
		setLayout(new FlowLayout());
		ii = new ImageIcon("G:\\workspace\\cmc\\general.png");
		jlab = new JLabel("SCHOOL UNIFORM",ii,JLabel.CENTER);
		jlab.setFont(new Font("Comic Sans MS",Font.BOLD,16));
		jlab.setForeground(Color.BLUE);
		setBackground(Color.WHITE);
		add(jlab);
	} 
}

class Bodyuni extends JPanel{
	JLabel content;
	public Bodyuni(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		content = new JLabel(new ImageIcon("C:\\Users\\Devroop Kar\\Pictures\\Screenshots\\Screenshot (231).png"));
		JLabel content1 = new JLabel(new ImageIcon("C:\\Users\\Devroop Kar\\Pictures\\Screenshots\\Screenshot (232).png"));
		JLabel content2 = new JLabel(new ImageIcon("C:\\Users\\Devroop Kar\\Pictures\\Screenshots\\Screenshot (233).png"));
		JLabel content3 = new JLabel(new ImageIcon("C:\\Users\\Devroop Kar\\Pictures\\Screenshots\\Screenshot (234).png"));
	
		add(content);add(content1);add(content2);add(content3);
	}
}




public class SchoolUniform extends JFrame {

	private JPanel contentPane;
	JScrollPane jsp;

	/**
	 * Create the frame.
	 */
	public SchoolUniform() {
		setVisible(true);
		//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 543, 838);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		Headuni headuni = new Headuni();
		Bodyuni bodyuni = new Bodyuni();
		getContentPane().add(headuni);
		getContentPane().add(bodyuni);
//		jsp = new JScrollPane(contentPane);
//		add(jsp);
	}

}
