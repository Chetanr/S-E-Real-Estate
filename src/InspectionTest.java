import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InspectionTest {
	
	Inspection i;

	@Before
	public void setUp() throws Exception {
		i = new Inspection("123", "12:00 am", "2020/04/07");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(i.scheduleinspection(),true);
	}
	@Test 
	public void testincpectionschedule() throws Exception {
		
	}

}
