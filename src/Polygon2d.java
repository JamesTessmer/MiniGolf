import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.LinkedList;

//James Tessmer
//lab 06
//Polygon2d
/**
 * This class uses point2d objects to create polygons in a linklist. Polygons are used to both draw obstacles and
 * the green as well as to create edges used to find collisions.
 *
 */
public class Polygon2d {
	
	protected LinkedList<Point2d> points;
	
	/**
	 * Initializes the linked list that will contain the points of the polygon
	 */
	public Polygon2d() {
		points = new LinkedList<Point2d>();
	}

	
	
	
	/**
	 * Returns the point at the given index
	 */
	public Point2d getPoint(int i) {
		return points.get(i);
	}
	
	
	/**
	 * Adds the given point to the 
	 */
	public void addPoint(Point2d point) {
		points.add(point);
	}
	
	/**
	 * Returns a linked list of all the edges in the current polygon
	 */
	public LinkedList<Line2d> getEdges(){
		LinkedList<Line2d> edges = new LinkedList<Line2d>();
		
		/*
		 * creating the edges and adding them to the linked list
		 */
		for(int i = 0; i<points.size();i++) {
			int nextPoint = i+1;
			if(nextPoint > points.size() - 1) { //if I is the last point in the list the next point defaults to the first point
				nextPoint = 0;
			}
			
			//creating and adding the line
			Line2d temp = new Line2d(points.get(i), points.get(nextPoint));
			edges.add(temp);
		}//end of for
		
		return edges;
	}
	
	/**
	 * Draws the current polygon by creating java points from our point2d class
	 */
	public void drawOn(Graphics g,boolean filled, Color c) {
		Polygon temp = new Polygon();
		
		/*
		 * creating and adding the points to the polygon
		 */
		
			for(int i = 0; i<points.size();i++) {
				temp.addPoint((int) points.get(i).getX(),(int) points.get(i).getY());
				
			}//end of for
			
			g.setColor(c);
			if(filled == true) {
				g.fillPolygon(temp);
			} else {
				g.drawPolygon(temp);
			}
	}
	
	
	
}
