package LoginPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import admin.DeleteStudent;
import admin.addStudent;
import admin.displayList;
import admin.showStudent;
import admin.updateStudent;

class BtnPanel extends JPanel implements ActionListener{
	JButton stuadd,stuDetails,stuUpdate,showTable,stuDel;
	Statement st;
	Vector colHeads,data;
	
	
	public BtnPanel(Connection conn,Statement state){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		stuadd = new JButton("ADD STUDENT");
		stuDetails = new JButton("CHECK DETAILS");
		stuUpdate = new JButton("UPDATE DETAILS");
		showTable = new JButton("DISPLAY LIST");
		stuDel = new JButton("DELETE STUDENT");
		showTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				 try {
					ResultSet rec = state.executeQuery("SELECT * FROM Student;");
					ResultSetMetaData rsmd = rec.getMetaData();
					colHeads = new Vector();
					data = new Vector<>();
					for(int i = 1;i<=rsmd.getColumnCount();i++){
						colHeads.addElement(rsmd.getColumnName(i));//System.out.println("1\n");
					}
					while (rec.next()) {
						Vector row = new Vector(rsmd.getColumnCount());
						for (int i = 1; i <= rsmd.getColumnCount(); i++){
						row.addElement( rec.getObject(i) );
						}
						data.addElement( row );
						}
						rec.close();
						new displayList(data, colHeads);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		stuadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new addStudent(conn);
			}
		});
		stuDetails.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new showStudent(conn);
			}
		});
		stuUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new updateStudent(conn);
			}
		});
		stuDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeleteStudent(conn);
			}
		});
		add(stuadd);add(stuDetails);add(stuUpdate);add(showTable);add(stuDel);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	};

public class adminLogin extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public adminLogin(Connection conn,Statement state) {
		setTitle("ADMIN PAGE");
		
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		BtnPanel btnpanel = new BtnPanel(conn,state);
		
		add(btnpanel);
		setVisible(true);
	}

}
