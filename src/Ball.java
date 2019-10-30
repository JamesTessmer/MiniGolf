//James Tessmer
//Lab 06
//Ball

/**
 * This is the main object the player interacts with.
 *
 */
public class Ball {

	Point2d previous;
	Point2d current;
	Vector2D currentVelocity;
	final double X_DECEL = .95, Y_DECEL = .95;
	
	public Ball(double x, double y) {
		current = new Point2d(x,y);
		previous = new Point2d(x,y);
	}
	
	public Point2d getPosition() {
		return current;
	}
	
	public void setPosition(Point2d loc) {
		current = loc;
	}
	
	public Vector2D getVelocity() {
		return currentVelocity;
	}
	
	public void setVelocity(Vector2D vec) {
		currentVelocity = vec;
	}
	
	public Point2d getLastPosition() {
		return previous;
	}
	
	public void setLastPosition(Point2d p) {
		previous = p;
	}
	
	public void move(double dt) {
		double x = currentVelocity.getX();
		double y = currentVelocity.getY();
		previous.setX(current.getX());
		previous.setY(current.getY());
		
		
		current.setX(previous.getX() + (x) + (X_DECEL*dt*dt));
		current.setY(previous.getY() + (y) + (Y_DECEL*dt*dt));
		
		currentVelocity.setX(x*X_DECEL);
		currentVelocity.setY(y*Y_DECEL);
		
	}
	
	public double getLastDistance() {
		Vector2D vec = current.sub(previous); //getting a vector for the distance
		return vec.size(); //the size of the vector should be the distance traveled
	}
	
}
