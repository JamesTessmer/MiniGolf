//James Tessmer
//Lab 06
//Line2d

/**
 * Holds the methods needed for line behavior in the mini golf game. Lines can be created from either 2 points or 
 * a point and a vector. 
 */
public class Line2d {

	protected Point2d point;
	protected Vector2D vec;
	
	/**
	 * Takes the two given points and assigns one as the start point of the line and uses the other to calculate
	 * a vector for the line
	 */
	public Line2d(Point2d start, Point2d end) {
		point = start;
		vec = new Vector2D(end.getX()-start.getX(),end.getY()-start.getY());
	}
	
	
	public Line2d(Point2d start, Vector2D vector) {
		point = start;
		vec = vector;
	}
	
	/**
	 * uses the given T to solve for the a point on the line using the parametric equation.
	 */
	public Point2d getPointAt(double t) {
		double x = vec.getX();
		double y = vec.getY();
		/*
		 * calculating values to add to current x and y
		 */
		x = x*t;
		y = y*t;
		
		/*
		 * creating the new point using adjusted values
		 */
		Point2d end = new Point2d(point.getX() + x, point.getY() + y);
		
		return end;
		
	}
	
	/**
	 * Returns the starting point of the line
	 */
	public Point2d getStartPoint() {
		return point;
	}
	
	
	/**
	 * Returns the end point of the line (where t=1) by calling getPointAt
	 */
	public Point2d getEndPoint() {
		return this.getPointAt(1);
	}

	/**
	 * Returns the time at which 2 lines interest, or if they're parallel it throws a ParallelException
	 */
	public double intersectTime(Line2d other) throws ParallelException{
		/*
		 * creating variables used in calculations
		 */
		double t;
		Vector2D dp = other.vec.CCwPerp();
		double x = other.getEndPoint().getX() - point.getX();
		double y = other.getEndPoint().getY() - point.getY();
		Vector2D c = new Vector2D(x,y);
		Vector2D b = this.vec;
		
		/*
		 * checking to see if points are parallel
		 */
		
		if(dp.dotProduct(b) == 0) {
			throw new ParallelException("Lines are parallel");
		}
		
		//calculating intercept time
		t = (dp.dotProduct(c)/dp.dotProduct(b));
		return t;
	}
	
	/**
	 * Returns the CCW perpendicular vector the current line
	 */
	public Vector2D getCcwPerp() {
		return vec.CCwPerp();
	}
	
	public Vector2D getCwPerp() {
		return vec.cwPerp();
	}
	
	/**
	 * returns the vector and point in string form, used for testing.
	 */
	public String toString() {
		String str ="";
		str += vec.toString();
		str += " point x:" + point.getX() + " point y:" + point.getY();
		return str;
	}

	/*
	 * Getters and setters generated using eclipse
	 */

	public Point2d getPoint() {
		return point;
	}


	public void setPoint(Point2d point) {
		this.point = point;
	}


	public Vector2D getVec() {
		return vec;
	}


	public void setVec(Vector2D vec) {
		this.vec = vec;
	}
	
}
	