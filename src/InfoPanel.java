import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

//James Tessmer
//Lab 06
//InfoPanel

/**
 * This panel will hold the game statistics in labels and will update them via a handle on the game and a timer.
 *
 */

public class InfoPanel extends JPanel{

	Game game;
	int holeNum = 1;
	String holeTitle;
	int shots = 0;
	int totalShots = 0;
	
	JLabel title;
	JLabel currentHoleNum;
	JLabel shotsTaken;
	JLabel totalShotsTaken;
	
	public InfoPanel(Game game) {
		this.game = game;
		this.holeTitle = game.getCurrentHole().getTitle();
		
		Font font = new Font("Serif", Font.PLAIN, 45);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		title = new JLabel("Hole title: " + holeTitle);
		currentHoleNum = new JLabel("Hole number: " + Integer.toString(game.holeNum + 1));
		shotsTaken = new JLabel("Shots this hole: " + Integer.toString(game.shots));
		totalShotsTaken = new JLabel("Total shots taken: " + Integer.toString(game.totalShots));
		
		title.setFont(font);
		currentHoleNum.setFont(font);
		shotsTaken.setFont(font);
		totalShotsTaken.setFont(font);
		
		this.add(title);
		this.add(currentHoleNum);
		this.add(shotsTaken);
		this.add(totalShotsTaken);
		
		
	}
	
	public void updateStats() {
		title.setText("Hole title: " +game.getCurrentHole().getTitle());
		currentHoleNum.setText("Hole number: " + Integer.toString(game.holeNum + 1));
		shotsTaken.setText("Shots this hole: " + Integer.toString(game.shots));
		totalShotsTaken.setText("Total shots taken: " + Integer.toString(game.totalShots));
	}
}
