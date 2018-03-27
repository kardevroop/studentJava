package alerts;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Alert extends JFrame implements ActionListener {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Alert() {
		setTitle("ERROR");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		ImageIcon ii = new ImageIcon("G:\\workspace\\cmc\\alert.png");
		JLabel lblNewLabel = new JLabel("",ii,JLabel.TRAILING);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 24, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 34, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -77, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblErrorWrong = new JLabel("ERROR ! Wrong Username or Password");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -18, SpringLayout.WEST, lblErrorWrong);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblErrorWrong, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblErrorWrong, 148, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblErrorWrong, 0, SpringLayout.EAST, contentPane);
		lblErrorWrong.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		contentPane.add(lblErrorWrong);
		
		JButton btnNewButton = new JButton("CANCEL");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblErrorWrong, -31, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 185, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -90, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 113, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -61, SpringLayout.SOUTH, contentPane);
		btnNewButton.setFont(new Font("Papyrus", Font.PLAIN, 13));
		Image image = new ImageIcon("G:\\workspace\\cmc\\cancel.png").getImage();
		btnNewButton.setIcon(new ImageIcon(image));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//this.dispose();
	}
}
