package correct;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TriangleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testScalene() {
		assertEquals("", new TriangleSides(5,12,13).reportTriangleType(), TriangleSides.TriangleType.SCALENE);
	}

}
