import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Landlordtest {
	Landlord l;

	@Before
	public void setUp() throws Exception {
		l = new Landlord("miad", "nasim", "miad@gmail.com", "sef 12");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		assertEquals(l.addYourProperty);
	}
	@Test
	public void testaddProperty() throws Exception {
		
	}
	@Test
	public void listProperty() throws Exception {
		
	}

}
