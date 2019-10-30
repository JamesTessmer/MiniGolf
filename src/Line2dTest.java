import static org.junit.Assert.*;

import org.junit.Test;

public class Line2dTest {
	
	/*
	 * Testing constructor
	 */
	@Test
	public void constructorTest() {
		Point2d start = new Point2d(0,0);
		Point2d end = new Point2d(10,0);
		Line2d line = new Line2d(start,end);
		
		assertTrue(line.getVec() != null);
		assertTrue(line.getPoint() == start);
	}
	
	@Test
	public void constructorVecTest() {
		Point2d start = new Point2d(0,0);
		Vector2D vec = new Vector2D(10,0);
		Line2d line = new Line2d(start,vec);
		
		assertTrue(line.getVec() == vec);
		assertTrue(line.getPoint() == start);
	}
	
	/*
	 * Testing getPointAt
	 */
	
	@Test
	public void getPointAtTest() {
		Point2d start = new Point2d(0,0);
		Vector2D vec = new Vector2D(10,0);
		Line2d line = new Line2d(start,vec);
		
		Point2d newPoint = line.getPointAt(.5);
		assertEquals(5,newPoint.getX(),0.00001);
		assertEquals(0,newPoint.getY(),0.00001);
	}
	
	@Test
	public void getPointAllZeroTest() {
		Point2d start = new Point2d(0,0);
		Vector2D vec = new Vector2D(0,0);
		Line2d line = new Line2d(start,vec);
		
		Point2d newPoint = line.getPointAt(.5);
		assertEquals(0,newPoint.getX(),0.00001);
		assertEquals(0,newPoint.getY(),0.00001);
	}
	
	@Test
	public void getPointAtBothMovement() {
		Point2d start = new Point2d(0,0);
		Vector2D vec = new Vector2D(10,10);
		Line2d line = new Line2d(start,vec);
		
		Point2d newPoint = line.getPointAt(.1);
		assertEquals(1,newPoint.getX(),0.00001);
		assertEquals(1,newPoint.getY(),0.00001);
	}
	
	/*
	 * 
	 */
	

	/*
	 * Testing intersectTime
	 */
	@Test
	public void intersectTimeTest() throws ParallelException{
		Point2d start = new Point2d(0,0);
		Point2d end = new Point2d(10,0);
		Line2d line = new Line2d(start,end);
		
		Point2d otherStart = new Point2d(5,5);
		Point2d otherEnd = new Point2d(5,-5);
		Line2d other = new Line2d(otherStart,otherEnd);
	
		double t = -1;
		
		try {
			t = line.intersectTime(other);
		} catch (ParallelException e){
			e.toString();
		}
		
		assertTrue(t >= 0);
	}
	
	@Test
	public void intersectTimeParallelTest() throws ParallelException{
		Point2d start = new Point2d(0,0);
		Point2d end = new Point2d(10,0);
		Line2d line = new Line2d(start,end);
		
		Point2d otherStart = new Point2d(0,5);
		Point2d otherEnd = new Point2d(10,5);
		Line2d other = new Line2d(otherStart,otherEnd);
	
		double t = -1;
		boolean thrown = false;
		
		try {
			t = line.intersectTime(other);
		} catch (ParallelException e){
			e.toString();
			thrown = true;
		}
		
		assertTrue(thrown);
	
	}
	
	@Test
	public void intersectTimeSkewTest() throws ParallelException{
		Point2d start = new Point2d(0,0);
		Point2d end = new Point2d(10,0);
		Line2d line = new Line2d(start,end);
		
		Point2d otherStart = new Point2d(1,1);
		Point2d otherEnd = new Point2d(2,-2);
		Line2d other = new Line2d(otherStart,otherEnd);
	
		double t = -1;

		
		try {
			t = line.intersectTime(other);
		} catch (ParallelException e){
			e.toString();
		}
		
		assertTrue(t>=0);
	}
	
	

}
