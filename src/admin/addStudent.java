package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class addStudent extends JFrame {

	private JPanel contentPane;
	Statement st;
	String name,addr,user,pass,subject,cls;
	/**
	 * Create the frame.
	 */
	public addStudent(Connection conn) {
		setTitle("ENTER DETAILS");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		
	
		JLabel name_lab = new JLabel("Name:");
		JTextField txt_name = new JTextField(20);
		JLabel addr_lab = new JLabel("Address:");
		JTextField txt_addr = new JTextField(30);
		JLabel Class = new JLabel("class:");
		JTextField txt_class = new JTextField(5);
		JLabel sub = new JLabel("Subject:");
		JTextField txt_sub = new JTextField(10);
		JLabel usern = new JLabel("Username:");
		JTextField txt_user = new JTextField(10);
		JLabel passw = new JLabel("Password:");
		JTextField txt_pass = new JTextField(10);
		JButton btn = new JButton("GO");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name = txt_name.getText();
				addr = txt_addr.getText();
				cls = txt_class.getText();
				user = txt_user.getText();
				pass = txt_pass.getText();
				subject = txt_sub.getText();
			try{	
				st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("SELECT * FROM Student");
				rs.moveToInsertRow();
				rs.updateString("Name", name);
				rs.updateString("Address", addr);
				rs.updateString("class", cls);
				rs.updateString("Subject", subject);
				rs.updateString("Username", user);
				rs.updateString("Password", pass);
				rs.insertRow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		add(name_lab);
		add(txt_name);
		add(addr_lab);
		add(txt_addr);
		add(Class);
		add(txt_class);
		add(sub);
		add(txt_sub);
		add(usern);
		add(txt_user);
		add(passw);
		add(txt_pass);
		add(btn);
		setVisible(true);
}

		
	}


