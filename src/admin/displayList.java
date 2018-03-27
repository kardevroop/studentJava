package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class displayList extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public displayList(Vector data,Vector colHeads) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTable table = new JTable(data, colHeads);
		TableColumn col;
		for (int i = 0; i < table.getColumnCount(); i++) {
		col = table.getColumnModel().getColumn(i);
		col.setMaxWidth(250);
		}
		JScrollPane scrollPane = new JScrollPane( table );
		add( scrollPane );
		setVisible(true);
	}

}
