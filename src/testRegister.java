import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testRegister {
	static ArrayList<register> registerList = new ArrayList<register>();
	 @Before
     public void executedBeforeEach() {
		 registerList.add(new register("1000001", "Test1", "test1@test.com", "test1 test1", "1"));
		 registerList.add(new register("1000002", "Test2", "test2@test.com", "test2 test2", "2"));
		 registerList.add(new register("1000003", "Test3", "test3@test.com", "test3 test3", "3"));
		 registerList.add(new register("1000004", "Test4", "test4@test.com", "test4 test4", "1"));
		 registerList.add(new register("1000005", "Test5", "test5@test.com", "test5 test5", "1"));
		 
         System.out.println("@Before: executedBeforeEach");
     }
	 
	@Test
	public void testId() {
		assertEquals("1000002", registerList.get(1).getId());
	}

	@Test
	public void testwrongId() {
		assertEquals("1000003", registerList.get(1).getId());
	}
	
	@Test
	public void testUserType() {
		assertEquals("2", registerList.get(1).getUserType());
	}

	@Test
	public void testWrongUserType() {
		assertEquals("1", registerList.get(1).getUserType());
	}
	
}
