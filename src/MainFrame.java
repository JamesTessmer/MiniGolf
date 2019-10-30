import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

//James Tessmer
//Lab 06
//MainFrame
/**
 * The main frame that holds all panels used for the mini golf game. This object also initializes all parts of the game
 *
 */
public class MainFrame extends JFrame{

	
	MainPanel gamePanel;
	DisplayPanel displayPanel;
	InfoPanel statsPanel;
	MainPanel buttonPanel;
	ArtPanel artPanel;
	LinkedList<GolfCourseHole> gch;
	Game game;
	GolfCourseHole currentHole;
	JButton quit;
	JButton newGame;
	JButton nextHole;
	
	
	public MainFrame(String str) {
		super("Super Putter Mini Golf");
		
		this.setLayout(new BorderLayout());
		/* 
		 * Creating panels to add to frame
		 */
		MainPanel gamePanel = new MainPanel();
		ArtPanel artPanel = new ArtPanel();
		artPanel.setPreferredSize(new Dimension(200,1000));
		displayPanel = new DisplayPanel(statsPanel); //display panel will display the game
		gamePanel.add(displayPanel);
		
		/*
		 * creating panels inside the gamePanel
		 */
		
		gamePanel.setLayout(new GridLayout(2,1));
		MainPanel infoPanel = new MainPanel(); //this will hold info and buttons in 2 panels
		
		
		
		/*
		 * adding panels to info panel
		 */
		gch = GolfCourseHole.readGolfCourse(new File(str));
		game = new Game(gch);
		game.getBall().setPosition(game.getCurrentHole().getTee());
		
		
		displayPanel.setGame(game);
		
		
		this.currentHole = game.getCurrentHole();
		displayPanel.setGCH(gch.get(0));
		
		statsPanel = new InfoPanel(game);
		buttonPanel = new MainPanel();
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(statsPanel, BorderLayout.CENTER);
		infoPanel.add(buttonPanel, BorderLayout.SOUTH);
		gamePanel.add(infoPanel);
		
		displayPanel.setP(statsPanel);
		
		
		quit = new JButton();
		quit.setText("Quit");
		
		nextHole = new JButton();
		nextHole.setText("Next Hole");
		
		nextHole.addActionListener(new NextHoleHelper());
		quit.addActionListener(new QuitHelper());
		
		
//		newGame = new JButton();
//		newGame.setText("New Game");
//		newGame.addActionListener(new NewGameHelper());
		
//		buttonPanel.add(newGame);
		buttonPanel.add(quit);
		buttonPanel.add(nextHole);
		displayPanel.setNextHole(nextHole);
		
		
		this.add(artPanel,BorderLayout.WEST);
		this.add(gamePanel,BorderLayout.CENTER);
		
		/*
		 * Testing placement of panels
		 */
		
		Color custom = new Color(255,150,150);
		artPanel.setBackground(Color.BLACK);
		displayPanel.setBackground(custom);
		statsPanel.setBackground(custom);
		buttonPanel.setBackground(custom);
	
		
		this.setSize(1000,1000);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame frame = new MainFrame("GolfCourse.txt");
		frame.setVisible(true);
	}

	
	private class NextHoleHelper implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(game.holeNum == game.gch.size() - 2) { //turns the button off if you're moving to the last hole on the course
				nextHole.setEnabled(false);
			}
			
			/*
			 * updates the info and hole graphic
			 */
			game.nextHole();
			currentHole = game.getCurrentHole();
			statsPanel.updateStats();
			displayPanel.currentH = currentHole;
			game.getBall().setPosition(game.getCurrentHole().getTee());
			game.setShots(0);
			repaint();
			statsPanel.repaint();
		}
	}
	
	private class QuitHelper implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class NewGameHelper implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	
	
}
