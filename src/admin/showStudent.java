package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;

class Query extends JPanel{
	JLabel roll,cls;
	JTextField text,text_1;
	JButton btn;
	Statement st;
	public JScrollPane jsp;
	private Vector colHeads,rowDetails,row;
	int j=0;
	private JTable stuDetails;
	public Query(Connection conn){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true);
		cls = new JLabel("ENTER CLASS:");
		text_1 = new JTextField();
		roll = new JLabel("ENTER ROLL:");
		text = new JTextField();
		text.setBounds(139, 7, 86, 20);
		btn = new JButton("GO");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "HIT MAXIMIZE");
				try{
					st = conn.createStatement();
					ResultSet rst = st.executeQuery("SELECT * FROM Student");
					ResultSetMetaData rsmd = rst.getMetaData();
					//String query = "SELECT * FROM Student WHERE class = "+Integer.parseInt(text_1.getText().toString())+"AND Roll = "+Integer.parseInt(text.getText().toString())+";";
					colHeads = new Vector();
					//rowDetails = new Object[1][rsmd.getColumnCount()];
					for(int i = 1;i<=rsmd.getColumnCount();i++){
						colHeads.addElement(rsmd.getColumnName(i)); 
					}
				//System.out.println(query);
				ResultSet rst1 = st.executeQuery("SELECT * FROM Student WHERE class = "+Integer.parseInt(text_1.getText().toString())+" AND Roll = "+Integer.parseInt(text.getText().toString())+";");
				ResultSetMetaData rsmd1 = rst1.getMetaData();
				rst1.next();
				System.out.println(rsmd1.getColumnCount());
				
				rowDetails = new Vector(rsmd.getColumnCount());
				row = new Vector();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					rowDetails.addElement(rst1.getObject(i));
				
				}
				row.addElement(rowDetails);
				stuDetails = new JTable(row,colHeads);
				jsp = new JScrollPane(stuDetails);
				add(jsp);
				//setVisible(true);
				}catch(SQLException e){
					e.printStackTrace();
				}
				
			}
		});
		add(cls);
		add(text_1);
		add(roll);
		add(text);
		add(btn);
	}
}




public class showStudent extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public showStudent(Connection conn) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		Query query = new Query(conn);
		getContentPane().add(query);
		setVisible(true);
		
	}

}
