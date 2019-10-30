import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Polygon2dTest {

	
	/*
	 * Testing get edges
	 */
	@Test
	public void getEdgesTest() {
		Point2d p1 = new Point2d(0,0);
		Point2d p2 = new Point2d(1,1);
		Point2d p3 = new Point2d(-1,1);
		
		Polygon2d poly = new Polygon2d();
		poly.addPoint(p1);
		poly.addPoint(p2);
		poly.addPoint(p3);
		LinkedList list = poly.getEdges();
		
		assertEquals(3,list.size());
	}
	
	@Test
	public void getEdgesNoPointsTest() {
		Polygon2d poly = new Polygon2d();
		LinkedList list = poly.getEdges();
		
		assertEquals(0,list.size());
	}

	@Test
	public void getEdgesOnePointTest() {
		Polygon2d poly = new Polygon2d();
		Point2d p1 = new Point2d(1,1);
		poly.addPoint(p1);
		
		LinkedList list = poly.getEdges();
		
		assertEquals(1,list.size());
	}
	
}
