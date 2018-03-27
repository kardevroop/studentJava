package mainActivity;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import panelClasses.CenterPanel;
import panelClasses.HeaderPanel;
import panelClasses.LeftPanel;
import panelClasses.RightPanel;

public class Database extends JApplet {
	Connection conn;
	public Statement st;
	public Database() {
		init();
	}

	/**
	 * Create the applet.
	 */
	public void init(){
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					makeGUI();					//calling main gui function 
				}
			});
		}catch(Exception e){
			System.out.println("Cant create GUI because of "+e);
		}
	}
	private void makeGUI() {
		setSize(900,500);
		getContentPane().setLayout(new BorderLayout());
		try {
			conn = DriverManager.getConnection("jdbc:ucanaccess://G:\\workspace\\cmc\\Database1.accdb");
		JOptionPane.showMessageDialog(null, "Connection Successful!");			//establishing connection with ms access database
		st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HeaderPanel hdr = new HeaderPanel();				//adding all the design panels of the home page
		LeftPanel lft = new LeftPanel(conn,st);
		RightPanel right = new RightPanel();
		CenterPanel center = new CenterPanel(conn,st);
		JScrollPane scroll = new JScrollPane(center);
		//center.setSize(200, 100);
		getContentPane().add(hdr,BorderLayout.NORTH);
		getContentPane().add(lft,BorderLayout.WEST);
		getContentPane().add(right,BorderLayout.EAST);
		getContentPane().add(scroll,BorderLayout.CENTER);
		
//		try {
//			st.close();
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		try {
		//	JOptionPane.showMessageDialog(null,"Disconnected");
			st.close();							//closing the connection at program termination
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
