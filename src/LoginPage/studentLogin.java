package LoginPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class studentLogin extends JFrame {

	private JPanel contentPane;
	private JTable stuDetails;
	private Statement state;
	private Vector colHeads,rowDetails,row;
	int j=0;
	/**
	 * Create the frame.
	 */
	public studentLogin(Statement st,int username,String password) {
		setTitle("YOUR PAGE");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setBackground(Color.WHITE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		state = st;
		try {
			ResultSet rst = st.executeQuery("SELECT * FROM Student");
			ResultSetMetaData rsmd = rst.getMetaData();
			System.out.println(rsmd.getColumnName(1)+"\n");
			colHeads = new Vector();
			//rowDetails = new Object[1][rsmd.getColumnCount()];
			for(int i = 1;i<=rsmd.getColumnCount();i++){
				colHeads.addElement(rsmd.getColumnName(i)); 
			}
			String query = "SELECT * FROM Student WHERE Roll = "+username+";";
		
			System.out.println(query);
			ResultSet rst1 = st.executeQuery(query);
			ResultSetMetaData rsmd1 = rst1.getMetaData();
			rst1.next();
			System.out.println(rsmd1.getColumnCount());
			//while(rst1.next()){
			//rowDetails[1][j] = rst1.getString(j+1);++j;
			//}
			//Object[][] rowDetails = {{rst1.getString(1), rst1.getString(2), rst1.getString(3), rst1.getString(4), rst1.getString(5), rst1.getString(6), rst1.getString(7)}};
			rowDetails = new Vector(rsmd.getColumnCount());
			row = new Vector();
			for(int i=1;i<=rsmd.getColumnCount();i++){
				rowDetails.addElement(rst1.getObject(i));
			
			}
			row.addElement(rowDetails);
			stuDetails = new JTable(row,colHeads);
			JScrollPane jsp = new JScrollPane(stuDetails);
			add(jsp);
			setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
