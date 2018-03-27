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



class Headrule extends JPanel{
	JLabel jlab;
	ImageIcon ii;
	public Headrule(){
		setLayout(new FlowLayout());
		ii = new ImageIcon("G:\\workspace\\cmc\\general.png");
		jlab = new JLabel("RULES AND REGULATION",ii,JLabel.CENTER);
		jlab.setFont(new Font("Comic Sans MS",Font.BOLD,16));
		jlab.setForeground(Color.BLUE);
		setBackground(Color.WHITE);
		add(jlab);
	} 
}

class Bodyrule extends JPanel{
	JLabel content;
	public Bodyrule(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		content = new JLabel(new ImageIcon("C:\\Users\\Devroop Kar\\Pictures\\Screenshots\\Screenshot (219).png"));
		add(content);
	}
}





public class Rules extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Rules() {
		setVisible(true);
		//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 543, 838);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		Headrule headrule = new Headrule();
		Bodyrule bodyrule = new Bodyrule();
		getContentPane().add(headrule);
		getContentPane().add(bodyrule);
	}

}
