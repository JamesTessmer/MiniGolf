import java.util.LinkedList;

//James Tessmer
//Lab 06
//Game

/**
 * This class holds information about the state of the Mini Golf Game such as current hole, number of strokes, etc.
 *
 */
public class Game {
	LinkedList<GolfCourseHole> gch;
	GolfCourseHole currentH;
	int holeNum = 0;
	int shots,totalShots;
	Ball ball;
	
	
	public Game(LinkedList<GolfCourseHole> gch) {
		this.gch = gch;
		this.currentH = gch.get(holeNum);
		shots = 0;
		totalShots = 0;
		ball = new Ball(currentH.getTee().getX(), currentH.getTee().getX());	
	}
	
	public GolfCourseHole getCurrentHole() {
		return currentH;
	}
	
	public void nextHole() {
		holeNum++;
		this.currentH = gch.get(holeNum);
	}
	
	public void nextFrame() throws GameOverException, BallInCupException, BallAtRestException {
		ball.move(1/15); // 1/15th of a second
		double d = ball.getLastDistance();
		checkCollisions();
		
		if(this.isBallInCup() == true) {
			if(this.isGameOver() == true) {
				throw new GameOverException("Game is over!");
			} else {
				throw new BallInCupException("Moving to the next level!");
			}
		}//end of outer if
		
		if(d < 2) {
			throw new BallAtRestException();
		}
	}
	
	/**
	 * Checks for collisions by checking to see if the ball collides with any walls in t = 1 or less and then rebounds the ball if needed.
	 */
	public void checkCollisions() {
		Line2d path = new Line2d(ball.getLastPosition(), ball.getPosition());
		LinkedList<Line2d> edges = currentH.edges();
		//System.out.println(edges.size());
		Line2d wall = null;
		double timeObj = 2;
		
		for(int i = 0; i < edges.size(); i++) {
			/*
			 * Collecting collision times and making sure they occur within 1 unit of time
			 */
			try {
				double temp = path.intersectTime(edges.get(i));
				
				if(temp < 1 && temp > 0 ) {
					//System.out.println("Detected a valid ball on wall collision");
					double temp2 = edges.get(i).intersectTime(path);
					if(temp2 < 1 && temp2 > 0) {
						if(timeObj > temp2) {
							//System.out.println("Detected a valid wall on ball collision");
							timeObj = temp2;
							wall = edges.get(i);
						}
					}
				}
				
			} catch (ParallelException e) {
				//System.out.println("parallel line detected");
				continue;
			}
			
			
		}//end for
		
		/*
		 * checking to see if the ball actually collided with anything
		 */
		if(wall == null) {
			//System.out.println("null wall");
			return;
		}
		
		
		double speed = ball.getVelocity().size();
		//calculating the impact point and incident vector
		
		Point2d impact = new Point2d(ball.getPosition().getX() + (timeObj*ball.getVelocity().getX()), ball.getPosition().getY() + (timeObj*ball.getVelocity().getY()));
		Vector2D c = new Vector2D(impact.getX() - ball.getLastPosition().getX(), impact.getY() - ball.getLastPosition().getY());
		
		/*
		 * determining unit normal vector of the wall
		 */
		Vector2D nn = wall.getCcwPerp().unitVector();
		/*
		 * deriving reflection vector
		 */
		Vector2D r = new Vector2D(c.getX() - (2*(c.dotProduct(nn)*nn.getX())), c.getY() - (2*(c.dotProduct(nn)*nn.getY())));
		
		/*
		 * left over time after collision
		 */
		double t = 1 - timeObj;
		/*
		 * updating ball's position after collision and inputting new velocity vector
		 */
		ball.setPosition(new Point2d(impact.getX()+(r.getX()*t), impact.getY()+(r.getY()*t)));
		Vector2D nR = r.unitVector().scalarMult((int) speed);
		ball.setVelocity(nR);
		
		/*
		 * Recur the method to check and see if new vector would collide with a wall 
		 */
		
		checkCollisions();
		
	}
	
	/**
	 * checks to see if the ball is within a certain distance of the cup.
	 * 
	 */
	public boolean isBallInCup() {
		/*
		 * If the ball is within 10 units sq of the cup the game is considered over
		 */
		if(ball.getPosition().getX() > currentH.getCup().getX() -10 && ball.getPosition().getX() < currentH.getCup().getX() +10) {
			if(ball.getPosition().getY() > currentH.getCup().getY() -10 && ball.getPosition().getY() < currentH.getCup().getY() +10) {
				return true;
			}		
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the player is currently on the last hole in the course
	 */
	public boolean isGameOver() {
		if(currentH.getHoleNum() == gch.size() ) {
			return true;
		} else {
			return false;
		}
		
	}

	public int getHoleNum() {
		return holeNum;
	}

	public void setHoleNum(int holeNum) {
		this.holeNum = holeNum;
	}

	public int getShots() {
		return shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}

	public int getTotalShots() {
		return totalShots;
	}

	public void setTotalShots(int totalShots) {
		this.totalShots = totalShots;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}
	
	
}
