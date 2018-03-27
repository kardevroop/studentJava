package panelClasses;

import java.lang.*;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import LoginPage.studentLogin;
import alerts.Alert;
import treeframes.FeeStruct;
import treeframes.SchoolTransport;

class Studentlogin extends JPanel implements ActionListener{
	JButton b1;
	  JTextField uname;
	  JPasswordField pass;
	  Statement state;
	  Boolean is_user = false;
	  Boolean logged_in = false;
	public Studentlogin(Connection conn,Statement st){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		JLabel head = new JLabel("STUDENT LOGIN");
//		add(head);
		 Label unamep=new Label("Username: ", Label.LEFT);
		   Label passp=new Label("Password: ", Label.LEFT);
		   uname = new JTextField(12);
		    pass = new JPasswordField(8);
		    b1 = new JButton("LOGIN");state = st;
		    b1.addActionListener(this);
		    add(unamep);add(uname);
		    add(passp);add(pass);
		    add(b1);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		try{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://G:\\workspace\\cmc\\Database1.accdb");
//			JOptionPane.showMessageDialog(null, "Connection Successful!");
//			Statement st = conn.createStatement();
            ResultSet rec = state.executeQuery("SELECT Username, Password, Roll FROM Student;");
            while (rec.next()) {
                String x = uname.getText();	//getting student username from database
                String y = pass.getText();	//same for password
                 
     //           JOptionPane.showMessageDialog(null,TokenCheck(rec.getString("Username").toString()));
      //          JOptionPane.showMessageDialog(null,TokenCheck(rec.getString("Password").toString()));
                if (x.equals/*(TokenCheck*/(rec.getString("Username").toString()))/*)*/ {		//validating login
                    if (y.equals/*(TokenCheck*/(rec.getString("Password").toString()))/*)*/ {
                        JOptionPane.showMessageDialog(null,"Logged in!");
                        new studentLogin(state,Integer.parseInt(rec.getString("Roll").toString()),y);
                        logged_in = true;is_user = true;
                        break;
                    } else {
                    	//JOptionPane.showMessageDialog(null,"Password did not match username!");
                    	//new Alert();
                    	//break;
                    	logged_in = false;
                    }
                } else {
                	//JOptionPane.showMessageDialog(null,"Username did not match the database");
                	//new Alert();
                	//break;
                	is_user = false;
                }
                
            }
            if(!logged_in || !is_user){
            	new Alert();
            }
//            if(!is_user){
//            	new Alert();
//            }
//            st.close();
//            conn.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
		private String TokenCheck(String str){
			 StringTokenizer strtoken = new StringTokenizer(str,"<>");
		        String []token = new String[3];
		        int i=0;
		        while(strtoken.hasMoreTokens()){
		            token[i++] = strtoken.nextToken();
		        }
			return token[1];
		}
}
class Options extends JPanel implements TreeSelectionListener{
	JTree tree;									//creating a tree for extra information
	public Options(){
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("OTHERS");		//adding the tree nodes
		DefaultMutableTreeNode adm = new DefaultMutableTreeNode("ADMISSION");
		DefaultMutableTreeNode app = new DefaultMutableTreeNode("APPLY ONLINE");
		adm.add(app);
		DefaultMutableTreeNode ad_date = new DefaultMutableTreeNode("ADMISSION DATE");
		//DefaultMutableTreeNode frm = new DefaultMutableTreeNode("ADMISSION FORM");
		DefaultMutableTreeNode fee = new DefaultMutableTreeNode("FEE STRUCTURE");
		adm.add(ad_date);
		//adm.add(frm);
		adm.add(fee);
		top.add(adm);
		DefaultMutableTreeNode top2 = new DefaultMutableTreeNode("STUDENT'S FORUM");
		DefaultMutableTreeNode top3 = new DefaultMutableTreeNode("SCHOOL TRANSPORT");
		DefaultMutableTreeNode top4 = new DefaultMutableTreeNode("DOWNLOAD");
		top.add(top2);
		top.add(top3);
		top.add(top4);
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeSelectionListener() {		//adding the action listeners
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        tree.getLastSelectedPathComponent();
				selecion(node);
			}

			private void selecion(DefaultMutableTreeNode node) {
				// TODO Auto-generated method stub
				switch(node.getUserObject().toString()){
					case "APPLY ONLINE":JFrame jfrm = new JFrame("Application Form"); 
										JOptionPane.showMessageDialog(jfrm, "ADMISSIONS CLOSED FOR NOW");
										break;
					case "ADMISSION DATE":JOptionPane.showMessageDialog(null, "INFORMATION NOT AVAILABLE");
											break;
					//case "ADMISSION FORM":break;
					case "FEE STRUCTURE":new FeeStruct();
						break;
					case "SCHOOL TRANSPORT":new SchoolTransport();
						break;
					case "DOWNLOAD":JOptionPane.showMessageDialog(null, "NO NEW ANNOUNCEMENTS");
					break;
				}
			}
		});
		JScrollPane jsp = new JScrollPane(tree);
		add(jsp);
	}
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

public class LeftPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public LeftPanel(Connection conn,Statement st) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Options op = new Options();
		Studentlogin stu = new Studentlogin(conn,st);
		add(op);
		stu.setBorder(BorderFactory.createTitledBorder("STUDENT LOGIN"));
		add(stu);
	}

}
