package treeframes;

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


class Headtrans extends JPanel{
	JLabel jlab;
	ImageIcon ii;
	public Headtrans(){
		setLayout(new FlowLayout());
		ii = new ImageIcon("G:\\workspace\\cmc\\general.png");
		jlab = new JLabel("SCHOOL TRANSPORT",ii,JLabel.CENTER);
		jlab.setFont(new Font("Comic Sans MS",Font.BOLD,16));
		jlab.setForeground(Color.BLUE);
		setBackground(Color.WHITE);
		add(jlab);
	} 
}

class Bodytrans extends JPanel{
	JLabel content;
	public Bodytrans(){
		setLayout(new FlowLayout());
		JLabel content1 = new JLabel(new ImageIcon("C:\\Users\\Devroop Kar\\Pictures\\Screenshots\\Screenshot (202).png"));
		//content = new JLabel(new ImageIcon("C:\\Users\\Devroop Kar\\Pictures\\Screenshots\\Screenshot (235).png"));
		add(content1);
		//add(content);
	}
}





public class SchoolTransport extends JFrame {

	private JPanel contentPane;
	JScrollPane jsp;

	/**
	 * Create the frame.
	 */
	public SchoolTransport() {
		setVisible(true);
		//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 543, 364);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		Headtrans headtrans = new Headtrans();
		Bodytrans bodytrans = new Bodytrans();
		getContentPane().add(headtrans);
		getContentPane().add(bodytrans);
		
		
	}

}
