//James Tessmer
//Lab 06
//Vector2D

/**
 * Contains all the operations used in vector interactions. Provides the base for more complex methods
 * and classes in the mini golf game.
 *
 */
public class Vector2D {

	
	

	protected double x,y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * adds this vector and an given vector to yield a new vector
	 */
	public Vector2D add(Vector2D other) {
		double newX;
		double newY;
		newX = this.x + other.x;
		newY = this.y + other.y;
		
		return new Vector2D(newX,newY);
	}
	
	/**
	 * Subtracts given vector from current vector, then returns the new vector
	 */
	public Vector2D sub(Vector2D other) {
		double newX;
		double newY;
		newX = this.x - other.x;
		newY = this.y - other.y;
		
		return new Vector2D(newX, newY);
	}
	
	/**
	 * Multiplies current vector by the given scale then returns the new vector
	 */
	public Vector2D scalarMult(int num) {
		double newX;
		double newY;
		newX = x*num;
		newY = y*num;
		
		return new Vector2D(newX, newY);
	}
	
	/**
	 * multiplies the current vector by the given vector as a dot product then returns the new vector
	 */
	public double dotProduct(Vector2D other) {
		return (this.x * other.x) + (this.y * other.y);
	}
	
	/**
	 * Calculates the current vectors magnitude
	 */
	public double size() {
		return Math.sqrt((x*x) + (y*y));
	}
	
	/**
	 * Calculates the unit vector of the current vector and returns it as a vector
	 */
	public Vector2D unitVector() {
		double unitX = x/this.size();
		double unitY = y/this.size();
		
		return new Vector2D(unitX,unitY);
	}
	
	/**
	 * returns the clockwise perpendicular vector of the current vector
	 */
	public Vector2D cwPerp() {
		return new Vector2D(y,-x);
	}
	
	/**
	 * returns the counter-clockwise perpendicular vector of the current vector
	 */
	public Vector2D CCwPerp() {
		return new Vector2D(-y,x);
	}
	
	/**
	 * Returns the x and Y in a string, used for testing
	 */
	public String toString() {
		String str = "current x: " + x +", current y " + y;
		return str;
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
}

