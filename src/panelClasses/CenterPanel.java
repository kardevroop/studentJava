package panelClasses;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import LoginPage.adminLogin;
import layout.WrapLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import alerts.Alert;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;

class Images extends JPanel{
	JLabel jlab,jlab1,jlab2,jlab3,jlab4;
	ImageIcon ii,ii1,ii2,ii3,ii4;
	public Images(){
		setLayout(new FlowLayout());
		ii = new ImageIcon("G:\\workspace\\cmc\\school1.jpg");
		jlab = new JLabel("",ii,JLabel.TRAILING);
		ii1 = new ImageIcon("G:\\workspace\\cmc\\school2.jpg");
		jlab1 = new JLabel("",ii1,JLabel.TRAILING);
		ii2 = new ImageIcon("G:\\workspace\\cmc\\school3.jpg");
		jlab2 = new JLabel("",ii2,JLabel.TRAILING);
		ii3 = new ImageIcon("G:\\workspace\\cmc\\school4.jpg");
		jlab3 = new JLabel("",ii3,JLabel.TRAILING);
		
		add(jlab);add(jlab1);add(jlab2);add(jlab3);
	}
}

class Para extends JPanel{
	JLabel para;
	public Para(){

		JLabel background = new JLabel(new ImageIcon("G:\\workspace\\cmc\\blur1.jpg"));
		add(background);
		background.setLayout(new FlowLayout());
		//setBackground(Color.CYAN);
		para = new JLabel("FRUIT FOR THOUGHT");
		para.setFont(new Font("Castellar",Font.BOLD,28));
		background.add(para);
	}
}

class MainTab extends JPanel{
	public MainTab(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Images images = new Images();
		Para para = new Para();
		add(images);
		add(para);
		
	}
}

class AdminTab extends JPanel implements ActionListener{
	  Button b1;
	  TextField uname,pass;
	public AdminTab(Connection conn,Statement state){
		   
		   Label unamep=new Label("Username: ", Label.RIGHT);	
		   Label passp=new Label("Password: ", Label.LEFT);
		   uname = new TextField(12);			//username entry field for the admin
		    pass = new TextField(8);			//password entry field for the admin
		    pass.setEchoChar('*');				//to mask the password field
		    
		    b1=new Button("Enter");
		    GridBagLayout gbag = new GridBagLayout();
		    GridBagConstraints gbc = new GridBagConstraints();
		    setLayout(gbag);
		    gbc.weighty=1.0;
		    gbc.anchor = GridBagConstraints.EAST;
		    gbc.gridwidth=GridBagConstraints.RELATIVE;
		    gbag.setConstraints(unamep,gbc);
		    add(unamep);
		    gbc.gridwidth=GridBagConstraints.REMAINDER;
		    gbag.setConstraints(uname,gbc);
		    add(uname);
		    gbc.gridwidth=GridBagConstraints.RELATIVE;
		    gbag.setConstraints(passp,gbc);
		    add(passp);
		    gbc.gridwidth=GridBagConstraints.REMAINDER;
		    gbag.setConstraints(pass,gbc);
		    add(pass);
		    gbc.anchor= GridBagConstraints.CENTER;
		    gbag.setConstraints(b1,gbc);
		    b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(uname.getText().equals("admin") && pass.getText().equals("admin")){
						new adminLogin(conn,state);		//checking the admin username and password and directing to admin page
					}else{
						Alert alert = new Alert();	//alert in case of incorrect entry
						alert.setVisible(true);
					}
				}
			});
		    b1.setName("Enter");
		    add(b1);
		    
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

public class CenterPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CenterPanel(Connection conn,Statement state) {
		setLayout(new FlowLayout());
		//setPreferredSize(new Dimension(1150, 300));
		JTabbedPane jtp = new JTabbedPane();			//creating a tabbed pane
		panelClasses.MainTab mainTab = new MainTab();	//the main student portal
		jtp.addTab("STUDENT PORTAL",mainTab);
		//mainTab.setLayout(new MigLayout("", "[]", "[]"));
		jtp.addTab("ADMINISTRATOR", new AdminTab(conn,state));	//admin access portal
		add(jtp, "name_1689451197545571"); 
	}

}
