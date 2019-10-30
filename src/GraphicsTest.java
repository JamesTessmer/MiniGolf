import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsTest extends JPanel{

	Polygon2d poly;
	public GraphicsTest() {
		JFrame frame = new JFrame();
		frame.add(this);
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		Point2d p1 = new Point2d(200,200);
		Point2d p2 = new Point2d(200,300);
		Point2d p5 = new Point2d(450,450);
		Point2d p3 = new Point2d(400,400);
		Point2d p4 = new Point2d(400,200);
		
		Polygon2d poly = new Polygon2d();
		poly.addPoint(p1);
		poly.addPoint(p2);
		poly.addPoint(p3);
		poly.addPoint(p5);
		poly.addPoint(p4);
		poly.addPoint(p1);
		
		this.poly = poly;
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		poly.drawOn(g, true, Color.GREEN);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphicsTest graph = new GraphicsTest();
		graph.setVisible(true);
		
		
	}
	
	
}
