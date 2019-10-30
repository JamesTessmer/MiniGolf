import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//James Tessmer
//Lab 06
//Art Panel

/**
 * this panel only contains the decorative image on the side of the UI
 *
 */
public class ArtPanel extends JPanel {

	public ArtPanel() {
		
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		ImageIcon imgIcon = new ImageIcon("GolfImage.png");
		g.drawImage(imgIcon.getImage(), -30, 0, null);
		g.drawImage(imgIcon.getImage(), -30, 300, null);
		g.drawImage(imgIcon.getImage(), -30, 600, null);
		g.drawImage(imgIcon.getImage(), -30, 900, null);
		
		
	}
}
