import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BranchManagerTest 
{
	BranchManager bm;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		System.out.println("BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		System.out.println("AfterClass");
	}

	@Before
	public void setUp() throws Exception 
	{
	
		bm = new BranchManager("Branch Manager", "FT", 5000, 0);
	}
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("After each method");
	}
	@Test
	public void testApproveHours() throws HourException
	{
		assertTrue(bm.approveHours(10));
		System.out.println("Test approve hours passed");
	}
	
	@Test (expected = HourException.class)
	public void testApproveHours1() throws HourException
	{
		assertTrue(bm.approveHours(-10));
	}
	
	@Test
	public void testSetID() throws Exception
	{
		fail("testSetID() Method not yet implemented");
	}
	
	@Test
	public void testAssignEmployee() throws Exception
	{
		fail("testAssignEmployee() Method not yet implemented");
		
	}

}
