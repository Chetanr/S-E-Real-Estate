import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
public class testLogin {

	static ArrayList<login> loginList = new ArrayList<login>();
	
	 @Before
     public void executedBeforeEach() {
		 loginList.add(new login("1000001", "Test10000"));
		 loginList.add(new login("1000002", "Test20000"));
		 loginList.add(new login("1000003", "Test30000"));
		 loginList.add(new login("1000004", "Test40000"));
		 loginList.add(new login("1000005", "Test50000"));
		 
         System.out.println("@Before: executedBeforeEach");
     }
	
	@Test
	public void testPassword() {
		assertEquals("Test20000", loginList.get(1).getPassword());
	}

	@Test
	public void testWrongPassword() {
		assertEquals("Test20000", loginList.get(2).getPassword());
	}
	
	@Test
	public void testVerifyUser() {
		assertTrue( loginList.get(1).verify("1000002", "Test20000"));
	}

	@Test
	public void testVerifyWrongUser() {
		assertTrue(loginList.get(2).verify("1000003", "Test20000"));
	}
	
}
