import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

public class GolfCourseHoleTest {

	/*
	 * Testing file reader
	 */
	@Test
	public void test() {
		File file = new File("GolfCourse.txt");
		LinkedList<GolfCourseHole> list = new LinkedList<GolfCourseHole>();
		
		list = GolfCourseHole.readGolfCourse(file);
		
		GolfCourseHole hole = list.get(0);
		
		assertEquals(2,hole.getObstacles().size());
		assertEquals(20,hole.getTee().getX(),0.00001);
	}

}
