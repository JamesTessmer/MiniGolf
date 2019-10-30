import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

//James Tessmer
//Lab06
//GolfCourseHole

/**
 * Uses all the 2d classes to assemble a golf course hole including boundaries, obstacles and a hole. Holes are 
 * created from a text file using a buffered reader
 *
 */
public class GolfCourseHole {

	private int holeNum;
	private String title;
	private Point2d cup;
	private Point2d tee;
	LinkedList<Polygon2d> obstacles;
	LinkedList<Line2d> edges;
	Polygon2d border = new Polygon2d();
	
	/**
	 * Initializes the edges and obstacles list
	 */
	public GolfCourseHole() {
		obstacles = new LinkedList<Polygon2d>();
		edges = new LinkedList<Line2d>();
	}

	/*
	 * getters and setters generated using eclipse
	 */
	
	public Point2d getCup() {
		return cup;
	}

	public void setCup(Point2d cup) {
		this.cup = cup;
	}

	public Point2d getTee() {
		return tee;
	}

	public void setTee(Point2d tee) {
		this.tee = tee;
	}

	public LinkedList<Polygon2d> getObstacles() {
		return obstacles;
	}

	public void setObstacles(LinkedList<Polygon2d> obstacles) {
		this.obstacles = obstacles;
	}

	public LinkedList<Line2d> getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Line2d> edges) {
		this.edges = edges;
	}

	public Polygon2d getBorder() {
		return border;
	}

	public void setBorder(Polygon2d border) {
		this.border = border;
	}

	
	
	public int getHoleNum() {
		return holeNum;
	}

	public void setHoleNum(int holeNum) {
		this.holeNum = holeNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Generates a linked list of all the edges present on the current hole.
	 */
	public LinkedList<Line2d> edges(){
		LinkedList<Line2d> edges = new LinkedList<Line2d>();
		
		/*
		 * gettings edges from all the obstacles and the border
		 */
		edges.addAll(border.getEdges());
		
		for(int i = 0;i<obstacles.size();i++) {
			edges.addAll(obstacles.get(i).getEdges());
		}
		
		return edges;
	}
	
	public void addObstacle(Polygon2d p) {
		obstacles.add(p);
	}
	
	/**
	 * returns the number of obstacles and edges
	 */
	public String toString() {
		String str = "";
		str += "num edges:" + edges.size() + " num obstacles:" + obstacles.size();
		return str;
	}
	
	public LinkedList<Polygon2d> getAllPolygons(){
		LinkedList<Polygon2d> polys = new LinkedList<Polygon2d>();
		polys.addAll(obstacles);
		polys.add(border);
		return polys;
	}
	
	/**
	 * Reads through the given file and uses that file to construct a golf course made of multiple golf holes.
	 * Files must be formatted a specific way
	 */
	public static LinkedList<GolfCourseHole> readGolfCourse(File f){
		LinkedList<GolfCourseHole> holes = new LinkedList<GolfCourseHole>();
		
		/*reader and reading first line
		 *Creating buffered reader
		 */  
		
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader(f));
			String line = "Should not be printed";
			
			/*
			 * initiating while loop
			 */
			
			while(line != null) {
				line = r.readLine();
				/*
				 * hole number and title
				 */
				GolfCourseHole temp = new GolfCourseHole();
				String[] numTitle = line.split(" ");
				temp.setHoleNum(Integer.parseInt(numTitle[0]));
				
				String title ="";
				for(int i = 1; i<numTitle.length;i++) {
					title += numTitle[i] + " ";
				}
				temp.setTitle(title);
	
				/*
				 * Setting container
				 */
				line = r.readLine();
				String[] containerString = line.split("[|]");
				for(int i = 0;i<containerString.length;i++) {
					String[] coords = containerString[i].split("[ ]");
					Point2d point = new Point2d(Integer.parseInt(coords[0]),Integer.parseInt(coords[1]));
					temp.border.addPoint(point);
					
				}
				
				/*
				 * creating the tee and cup locations
				 */
				
				Point2d tee;
				Point2d cup;
				
				line=r.readLine();
				String[] teeLocation = line.split("[ ]");
				tee = new Point2d(Integer.parseInt(teeLocation[0]),Integer.parseInt(teeLocation[1]));
				temp.setTee(tee);
				
				line = r.readLine();
				String[] cupLocation = line.split("[ ]");
				cup = new Point2d(Integer.parseInt(cupLocation[0]),Integer.parseInt(cupLocation[1]));
				temp.setCup(cup);
				
				/*
				 * getting number of obstacles and setting obstacles
				 */
				
				line=r.readLine();
				int n = Integer.parseInt(line);
				for(int i = 0; i < n;i++) {
					line = r.readLine();
					String[] obstacleCoords = line.split("[|]");
					Polygon2d poly = new Polygon2d();
					for(int p = 0; p < obstacleCoords.length; p++) {
						String[] coords = obstacleCoords[p].split(" ");
						Point2d point = new Point2d(Integer.parseInt(coords[0]),Integer.parseInt(coords[1]));
						poly.addPoint(point);
					}//end of inner for
					temp.addObstacle(poly);
				}//end of outer for
				
				/*
				 * adding the completed hole to the list and pushing reader to next hole
				 */
				holes.add(temp);
				line =r.readLine();
				
			}//end of while
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				r.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * finally returning the list
		 */
		return holes;
	}//end of method
	
	/**
	 * draws all the polygons needed for hole
	 */
	public void drawOn(Graphics g) {
		/*
		 * Drawing the green
		 */
		border.drawOn(g, true, Color.green);
		
		/*
		 * drawing the obstacles
		 */
		
		for(int i = 0; i <obstacles.size();i++) {
			obstacles.get(i).drawOn(g, true, Color.GRAY);
		}
		
		/*
		 * drawing the hole
		 */
		g.setColor(Color.black);
		g.fillOval((int) cup.getX()-7, (int) cup.getY()-7, 15, 15);
	}
	
}
