package panelClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.*;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;

import menuItemFrames.Art;
import menuItemFrames.Auditorium;
import menuItemFrames.Canteen;
import menuItemFrames.General;
import menuItemFrames.Lab;
import menuItemFrames.Library;
import menuItemFrames.Medical;
import menuItemFrames.Rules;
import menuItemFrames.SchoolTime;
import menuItemFrames.SchoolUniform;
import menuItemFrames.Yoga;

class Contact extends JFrame{
	JLabel phone;
	JLabel email;
	JButton back ;
	public Contact(){
		setSize(200, 200);
		setLayout(new FlowLayout());
		//setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		phone = new JLabel("PHONE: 9192631770");
		email = new JLabel("EMAIL: xyz@hotmail.com");
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		add(phone);add(email);add(back);
		setVisible(true);
	}
}

class MenuPanel extends JPanel implements MenuListener{
	JMenuBar jmb ;
	public MenuPanel(){
		jmb = new JMenuBar();								//creating menu bar for menu options
		JMenu home = new JMenu("HOME");
		jmb.add(home);
		JMenu infrastructure = new JMenu("INFRASTRUCTURE");
		JMenuItem gen = new JMenuItem("General");			//adding menu items
		JMenuItem medic  = new JMenuItem("Medical Room");
		JMenuItem audit = new JMenuItem("Auditorium");
		JMenuItem lib = new JMenuItem("Library");
		JMenuItem lab = new JMenuItem("Laboratory");
		JMenuItem canteen = new JMenuItem("Canteen");
		infrastructure.add(gen);
		infrastructure.add(medic);
		infrastructure.add(audit);
		infrastructure.add(lib);
		infrastructure.add(lab);
		infrastructure.add(canteen);
		jmb.add(infrastructure);
		gen.addActionListener(new ActionListener() {			//adding all action event listeners for the menu items
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				General general = new General();
				
			}
		});
		medic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Medical medical = new Medical();
			}
		});
		audit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Auditorium();
			}
		});
		lib.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Library();
			}
		});
		lab.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Lab();
			}
		});
		canteen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Canteen();
			}
		});
		JMenu academics = new JMenu("ACADEMICS");
		JMenuItem time =new JMenuItem("School Timings");
		JMenuItem uniform = new JMenuItem("School Uniform");
		JMenuItem rules = new JMenuItem("Rules & Regulations");
		//JMenuItem faculty = new JMenuItem("Faculty");
		JMenuItem calendar = new JMenuItem("Academic Calendar");
		academics.add(time);
		academics.add(uniform);
		academics.add(rules);
		//academics.add(faculty);
		academics.add(calendar);
		jmb.add(academics);
		time.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SchoolTime sct = new SchoolTime();
			}
		});
		uniform.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SchoolUniform();
			}
		});
		rules.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Rules();
			}
		});
		JMenu co_curr = new JMenu("CO-CURRICULAR");
		JMenuItem yoga = new JMenuItem("Yoga");
		//JMenuItem aba = new JMenuItem("Abacus");
		JMenuItem art = new JMenuItem("Art & Craft");
		co_curr.add(yoga);
	//	co_curr.add(aba);
		co_curr.add(art);
		jmb.add(co_curr);
		yoga.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Yoga();
			}
		});
		art.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Art();
			}
		});
		JMenu ab_us = new JMenu("ABOUT US");
		JMenuItem hist = new JMenuItem("History");
	//	JMenuItem found = new JMenuItem("Foundation");
		ab_us.add(hist);
	//	ab_us.add(found);
		jmb.add(ab_us);
		JMenu contact = new JMenu("CONTACT US");
		jmb.add(contact);
		contact.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == contact){
					new Contact();
				}
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == contact){
					new Contact();
				}
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(jmb);
	}
	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	}
	
class Share extends JPanel{
	JLabel jlab,jlab1,jlab2;
	ImageIcon ii,ii1,ii2;
	public Share(){
		setBackground(Color.ORANGE);
		setLayout(new FlowLayout());
		ii=new ImageIcon("G:\\workspace\\cmc\\facebook-icon.png");
		jlab = new JLabel("",ii,JLabel.TRAILING);
		ii1=new ImageIcon("G:\\workspace\\cmc\\Twitter-icon.png");
		jlab1 = new JLabel("",ii1,JLabel.TRAILING);
		ii2=new ImageIcon("G:\\workspace\\cmc\\google-plus-icon.png");
		jlab2 = new JLabel("",ii2,JLabel.TRAILING);
		add(jlab);add(jlab1);add(jlab2);
	}
}



public class HeaderPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	ImageIcon ii;
	JLabel head;
	MenuPanel mp;
	Share sh;
	public HeaderPanel() {
		setBackground(Color.ORANGE);
		setLayout(new BorderLayout());
		mp = new MenuPanel();
		sh = new Share();
		ii = new ImageIcon("G:\\workspace\\cmc\\download.jpg");
		head = new JLabel("   SIR ASHUTOSH MUKHERJEE MEMORIAL SCHOOL",ii,JLabel.CENTER);
		head.setFont(new Font("Comic Sans MS",Font.BOLD,25));
		head.setForeground(Color.RED);
		add(head,BorderLayout.WEST);
		add(mp,BorderLayout.SOUTH);
		add(sh,BorderLayout.EAST);
	}

}


