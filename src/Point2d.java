//James Tessmer
//Lab 06
//Point2d

/**
 * Point2d contains all the methods needed for a point used in the mini golf game. Methods return Vectors used by the game.
 * 
 */
public class Point2d {

	protected double x,y;
	
	public Point2d(double x,double y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * Getters and setters generated using eclipse
	 */
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Subtracts a given point from the current point and uses the difference to create and return a vector.
	 */
	public Vector2D sub(Point2d other) {
		double newY = this.y - other.y;
		double newX = this.x - other.x;
		
		return new Vector2D(newX, newY);
	}
	
	/**
	 * Adds a given point to the current point and uses the difference to create a and return a vector.
	 */
	public Vector2D add(Point2d other) {
		double newY = this.y + other.y;
		double newX = this.x + other.x;
		
		return new Vector2D(newX, newY);
	}
	
}
