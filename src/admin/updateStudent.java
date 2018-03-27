package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class updateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Statement st;
	//PreparedStatement st;
	private String head,val;
	private int roll,j,cls;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public updateStudent(Connection conn) {
		setTitle("UPDATE DETAILS");
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClass = new JLabel("CLASS   :");
		lblClass.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblClass.setBounds(21, 11, 70, 14);
		contentPane.add(lblClass);
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 7, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblRoll = new JLabel("ROLL   :");
		lblRoll.setFont(new Font("Space Bd BT", Font.BOLD, 13));
		lblRoll.setBounds(21, 40, 70, 24);
		contentPane.add(lblRoll);
		
		JLabel lblHeader = new JLabel("HEADER(Name/Address/class/Subject/Username/Password):");
		lblHeader.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblHeader.setBounds(21, 75, 389, 24);
		contentPane.add(lblHeader);
		
		JLabel lblValue = new JLabel("VALUE :");
		lblValue.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblValue.setBounds(21, 158, 70, 14);
		contentPane.add(lblValue);
		
		textField = new JTextField();
		textField.setBounds(139, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 110, 110, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 154, 110, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.setFont(new Font("Starliner BTN", Font.ITALIC, 13));
		btnNewButton.setBounds(123, 203, 195, 47);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cls = Integer.parseInt(textField_3.getText().toString());
				roll = Integer.parseInt(textField.getText().toString());
				head = textField_1.getText().toString();System.out.println(head);
				val = textField_2.getText().toString();
				try {
				//	st = conn.prepareStatement("UPDATE Student SET "+head+"=? WHERE Roll="+roll+";",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					//st.executeUpdate("UPDATE Student SET "+head+"="+val+" WHERE Roll = "+roll+";");
					st = conn.createStatement();
//					System.out.println("\nUPDATE Student SET "+head+"=? WHERE Roll="+roll+";");
//					st.setString(1, val);
//					st.setString(1, val);
					int j = st.executeUpdate("UPDATE Student SET "+head+"='"+val+"' WHERE class="+cls+" AND Roll="+roll+";");
	//				rs.next();
	//				rs.updateString(head, val);
	//				rs.updateRow();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		
		
	}
}


