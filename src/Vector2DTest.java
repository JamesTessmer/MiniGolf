import static org.junit.Assert.*;

import org.junit.Test;

public class Vector2DTest {

	/*
	 * Testing constructor
	 */
	@Test
	public void constructorTest() {
		Vector2D vec = new Vector2D(10,5.8);
		
		assertEquals(10.0,vec.getX(),0.00001);
		assertEquals(5.8,vec.getY(),0.00001);
	}

	/*
	 * Testing addition
	 */
	
	@Test
	public void addTest() {
		Vector2D vec = new Vector2D(10,5);
		Vector2D add = new Vector2D(2,3);
		
		Vector2D sum = vec.add(add);
		assertEquals(12,sum.getX(), 0.00001);
		assertEquals(8,sum.getY(),0.00001);
	}
	
	@Test
	public void addNegativesTest() {
		Vector2D vec = new Vector2D(10,5);
		Vector2D add = new Vector2D(-2,-3);
		
		Vector2D sum = vec.add(add);
		assertEquals(8,sum.getX(), 0.00001);
		assertEquals(2,sum.getY(),0.00001);
	}
	
	@Test
	public void addTwoNegativesTest() {
		Vector2D vec = new Vector2D(-10,-5);
		Vector2D add = new Vector2D(-2,-3);
		
		Vector2D sum = vec.add(add);
		assertEquals(-12,sum.getX(), 0.00001);
		assertEquals(-8,sum.getY(),0.00001);
	}
	
	/*
	 * Testing subtraction
	 */
	
	@Test
	public void subTest() {
		Vector2D vec = new Vector2D(10,5);
		Vector2D sub = new Vector2D(2,3);
		
		Vector2D sum = vec.sub(sub);
		assertEquals(8,sum.getX(), 0.00001);
		assertEquals(2,sum.getY(),0.00001);
	}
	
	@Test
	public void subNegativeTest() {
		Vector2D vec = new Vector2D(10,5);
		Vector2D sub = new Vector2D(-2,-3);
		
		Vector2D sum = vec.sub(sub);
		assertEquals(12,sum.getX(), 0.00001);
		assertEquals(8,sum.getY(),0.00001);
	}
	
	@Test
	public void subTwoNegativesTest() {
		Vector2D vec = new Vector2D(-10,-5);
		Vector2D sub = new Vector2D(-2,-3);
		
		Vector2D sum = vec.sub(sub);
		assertEquals(-8,sum.getX(), 0.00001);
		assertEquals(-2,sum.getY(),0.00001);
	}
	
	/*
	 * Testing Scalar multiplication
	 */
	
	@Test
	public void scalMultTest() {
		Vector2D vec = new Vector2D(10,5.2);
		Vector2D product = vec.scalarMult(5);
		
		assertEquals(50,product.getX(),0.00001);
		assertEquals(26,product.getY(),0.00001);
		
	}
	
	@Test
	public void scalMultZeroTest() {
		Vector2D vec = new Vector2D(10,5.2);
		Vector2D product = vec.scalarMult(0);
		
		assertEquals(0,product.getX(),0.00001);
		assertEquals(0,product.getY(),0.00001);
	}
	
	@Test
	public void scalMultNegativeTest() {
		Vector2D vec = new Vector2D(10,5.2);
		Vector2D product = vec.scalarMult(-1);
		
		assertEquals(-10,product.getX(),0.00001);
		assertEquals(-5.2,product.getY(),0.00001);
	}
	
	/* 
	 * Testing dot product
	 */
	
	@Test
	public void dotProductTest() {
		Vector2D vec = new Vector2D(10,5);
		Vector2D mult = new Vector2D(2,3);
		
		double product = vec.dotProduct(mult);
		assertEquals(35,product,0.00001);
	}
	
	@Test
	public void dotProductNegTest() {
		Vector2D vec = new Vector2D(10,5);
		Vector2D mult = new Vector2D(-2,-3);
		
		double product = vec.dotProduct(mult);
		assertEquals(-35,product,0.00001);
	}
	
	@Test
	public void dotProductXnegTest() {
		Vector2D vec = new Vector2D(10,5);
		Vector2D mult = new Vector2D(-2,3);
		
		double product = vec.dotProduct(mult);
		assertEquals(-5,product,0.00001);
	}
	
	@Test
	public void dotProductYnegTest() {
		Vector2D vec = new Vector2D(10,5);
		Vector2D mult = new Vector2D(2,-3);
		
		double product = vec.dotProduct(mult);
		assertEquals(5,product,0.00001);
	}
	
	/*
	 * Testing size
	 */
	
	@Test
	public void sizeTest() {
		Vector2D vec = new Vector2D(3,4);
		
		double size = vec.size();
		assertEquals(5,size,0.00001);
	}
	
	@Test
	public void sizeNegTest() {
		Vector2D vec = new Vector2D(-3,-4);
		
		double size = vec.size();
		assertEquals(5,size,0.00001);
	}
	
	/*
	 * unit vector test
	 */
	
	@Test
	public void unitVectorTest() {
		Vector2D vec = new Vector2D(5,10);
		
		Vector2D unit= vec.unitVector();
		assertEquals(5/11.18034,unit.getX(),0.00001);
		assertEquals(10/11.18034,unit.getY(),0.00001);
	}
	
	@Test
	public void unitVectorNegTest() {
		Vector2D vec = new Vector2D(-5,-10);
		
		Vector2D unit= vec.unitVector();
		assertEquals(-5/11.18034,unit.getX(),0.00001);
		assertEquals(-10/11.18034,unit.getY(),0.00001);
	}
	
	/*
	 * Testing Perp finders
	 */
	
	@Test
	public void cwPerpTest() {
		Vector2D vec = new Vector2D(5,10);
		
		Vector2D perp = vec.cwPerp();
		assertEquals(-5,perp.getY(),0.00001);
		assertEquals(10,perp.getX(),0.00001);
	}
	
	@Test
	public void counterCwPerpTest() {
		Vector2D vec = new Vector2D(5,10);
		
		Vector2D perp = vec.CCwPerp();
		assertEquals(5,perp.getY(),0.00001);
		assertEquals(-10,perp.getX(),0.00001);
	}
	
}
