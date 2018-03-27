package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int cls,roll,res;
	Statement st;
	/**
	 * Create the frame.
	 */
	public DeleteStudent(Connection conn) {
		setTitle("SET DETAILS");
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClass = new JLabel("CLASS    :");
		lblClass.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblClass.setBounds(72, 64, 89, 41);
		contentPane.add(lblClass);
		
		textField = new JTextField();
		textField.setBounds(181, 64, 158, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRoll = new JLabel("ROLL     :");
		lblRoll.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblRoll.setBounds(72, 116, 71, 32);
		contentPane.add(lblRoll);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 112, 158, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Starliner BTN", Font.BOLD, 13));
		btnNewButton.setBounds(150, 185, 117, 41);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cls = Integer.parseInt(textField.getText().toString());
				roll = Integer.parseInt(textField_1.getText().toString());
				try {
					st = conn.createStatement();
					res = st.executeUpdate("DELETE FROM Student WHERE class = "+cls+" AND Roll = "+roll+";");
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
