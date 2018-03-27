package connection;
import javax.swing.*;
import java.sql.*;

public class DbmsConnector {
	//Connection conn;
	public  DbmsConnector() {
	// TODO Auto-generated constructor stub
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:HOD_DATA");
			JOptionPane.showMessageDialog(null, "Connection Successful!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
