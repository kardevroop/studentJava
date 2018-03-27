package panelClasses;


import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class RightPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	JLabel picLabel;
	ImageIcon image;
	public RightPanel(){
		image = new ImageIcon("G:\\workspace\\cmc\\quote.jpg");	//adding an image on the left
		picLabel = new JLabel("",image,JLabel.TRAILING);
		add(picLabel);
		}

}
