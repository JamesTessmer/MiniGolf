import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//James Tessmer
//Lab 06
//DisplayPanel

/**
 * This panel is held inside a main panel and displays the polygons and ball used to play the 
 * mini golf game. This panel just knows how to paint the current golf course hole and take in a new one.
 *
 */
public class DisplayPanel extends JPanel implements ActionListener {
	
	GolfCourseHole currentH;
	Point point1 = new Point(0,0);
	Point point2 = new Point(0,0);
	Game game;
	InfoPanel p;
	Timer tim;
	boolean ballMoving = false;
	JLabel gameOver = new JLabel();
	JButton nextHole;
	
	public DisplayPanel(InfoPanel p) {
		this.setPreferredSize(new Dimension(800,500));
		this.addMouseListener(new GolfMainListener());
		this.addMouseMotionListener(new GolfMainListener());
		this.p = p;
		tim = new Timer(1000/15, this);
		
		this.add(gameOver);
	}
	
	public void setGCH(GolfCourseHole h) {
		this.currentH = h;
 	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		currentH.drawOn(g);
		g.setColor(Color.RED);
		g.drawLine((int)point1.getX(),(int) point1.getY(), (int)point2.getX(), (int)point2.getY());
		g.setColor(Color.white);
		g.fillOval( (int) game.getBall().getPosition().getX()-5, (int) game.getBall().getPosition().getY()-5, 10, 10);
		
	}
	
	private class GolfMainListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(ballMoving == false) {
				//System.out.println("Mouse pressed");
				point1 = arg0.getPoint();
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(ballMoving == false) {
				game.setShots(game.getShots()+ 1);
				game.setTotalShots(game.getTotalShots() + 1);
				p.updateStats();
				//System.out.println("Mouse released");
				point2 = arg0.getPoint();
				Vector2D velocity = new Vector2D((point1.getX() - point2.getX())/4, (point1.getY() - point2.getY())/4); 
				game.getBall().setVelocity(velocity);
				//TODO check this if things look wonky with movement
			
				tim.start();
				ballMoving = true;
				
			
				point2.setLocation(0,0);
				point1.setLocation(0,0);
				p.repaint();
			}
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(ballMoving == false)	{
				//System.out.println("Mouse dragged");
				point2 = arg0.getPoint();
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void setP(InfoPanel p) {
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			game.nextFrame();
		} catch (GameOverException c) {
			tim.stop();
			gameOver.setFont(new Font("serif",Font.PLAIN,40));
			gameOver.setText("                                         Game Over");//spaces to make sure the text shows up in the right place
			ballMoving = true;
			repaint();
		} catch (BallInCupException c) {
			tim.stop();
			game.nextHole();
			currentH = game.getCurrentHole();
			game.setShots(0);
			game.getBall().setPosition(game.getCurrentHole().getTee());
			if(currentH.getHoleNum() == game.gch.size()) {
				nextHole.setEnabled(false);
			}
			
			p.updateStats();
			ballMoving = false;
			repaint();
		
		} catch (BallAtRestException c) {
			tim.stop();
			ballMoving = false;
			//System.out.println("ball at rest");
		}
		
		repaint();
		
	}
	
	public void setNextHole(JButton b) {
		nextHole = b;
	}
}
