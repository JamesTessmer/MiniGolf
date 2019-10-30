import static org.junit.Assert.*;

import org.junit.Test;

public class Point2dTest {

	/*
	 * Testing point2d
	 */
	@Test
	public void constructorTest() {
		Point2d point = new Point2d(5,10);
		
		assertEquals(5,point.getX());
		assertEquals(10,point.getY());
	}
	
	/*
	 * Testing add
	 */
	
	@Test
	public void addTest() {
		Point2d point = new Point2d(5,10);
		Point2d add = new Point2d(3,4);
		
		Vector2D vec = point.add(add);
		
		assertEquals(8,vec.getX(),0.00001);
		assertEquals(14,vec.getY(),0.00001);
	}
	
	@Test
	public void addNegativeTest() {
		Point2d point = new Point2d(5,10);
		Point2d add = new Point2d(-3,-4);
		
		Vector2D vec = point.add(add);
		
		assertEquals(2,vec.getX(),0.00001);
		assertEquals(6,vec.getY(),0.00001);
	}
	
	@Test
	public void firstNegativeTest() {
		Point2d point = new Point2d(-5,-10);
		Point2d add = new Point2d(3,4);
		
		Vector2D vec = point.add(add);
		
		assertEquals(-2,vec.getX(),0.00001);
		assertEquals(-6,vec.getY(),0.00001);
	}

	/*
	 * Testing sub
	 */
	
	@Test
	public void subTest() {
		Point2d point = new Point2d(5,10);
		Point2d sub = new Point2d(3,4);
		
		Vector2D vec = point.sub(sub);
		
		assertEquals(2,vec.getX(),0.00001);
		assertEquals(6,vec.getY(),0.00001);
	}
	
	@Test
	public void subNegTest() {
		Point2d point = new Point2d(5,10);
		Point2d sub = new Point2d(-3,-4);
		
		Vector2D vec = point.sub(sub);
		
		assertEquals(8,vec.getX(),0.00001);
		assertEquals(14,vec.getY(),0.00001);
	}
	
	@Test
	public void subInitialNegativeTest() {
		Point2d point = new Point2d(-5,-10);
		Point2d sub = new Point2d(3,4);
		
		Vector2D vec = point.sub(sub);
		
		assertEquals(-8,vec.getX(),0.00001);
		assertEquals(-14,vec.getY(),0.00001);
	}
	
	
}
