import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitBranchManager {
	BranchManager bm;

	@BeforeEach
	void setUp() throws Exception 
	{
		bm = new BranchManager("Joseph Isaac", "FT", 90000.0);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testAssignEmployee() throws Exception
	{
		Employee e2 = null;
		assertEquals(bm.assignEmployee(), e2);
		System.out.println("Successfully completed the test");
		
	}
	
	@Test
	public void testApproveSalary() throws Exception
	{
		assertEquals(bm.approveSalary(), true);
		System.out.println("Successfully completed the test");
	}
	
	@Test
	public void testSetID() throws Exception
	{
		assertEquals(bm.setID(), " ");
		System.out.println("Successfully completed the test");
	}
	
	


}
