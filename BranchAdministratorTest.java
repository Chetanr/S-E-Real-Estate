import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BranchAdministratorTest 
{
	BranchAdministrator ba1;
	BranchAdministrator ba2;
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
	
		ba1 = new BranchAdministrator("James Isaac", "PT", 0, 25);  //Part Time employee
		ba2 = new BranchAdministrator("John Lever", "FT", 2000, 0); //Full time employee
		bm = new BranchManager("Branch Manager", "FT", 5000, 0);
	}
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("After each method");
	}
	
	//Calculate salary for Part time Employees
	@Test
	public void testCalculateSalary()  throws Exception
	{
		ba1.enterHours(bm);      //Entering hours as 10
		ba1.calculateSalary();
		assertEquals(ba1.getSalary(), 250);
		System.out.println("Test successful");
	}

	//Calculate salary for Full time Employees
	@Test
	public void testCalculateSalary1()  throws Exception
	{
		ba2.enterHours(bm);      //Entering hours as 10
		ba2.calculateSalary();
		assertEquals(ba2.getSalary(), 2000);
		System.out.println("Test successful");
	}
	

	
	@Test
	public void testCollectRent() throws Exception
	{
		fail("collectRent() Method not yet implemented");
		
	}

	@Test
	public void testCreditAmt() throws Exception
	{
		fail("creditAmount() Method not yet implemented");
		
	}

	@Test
	public void testSetID() throws Exception
	{
		fail("setID() Method not yet implemented");
	}
	
	@Test
	public void testPayroll() throws Exception
	{
		fail("payroll() Method not yet implemented");
		
	}

	
	@Test
	public void testScanDoc() throws Exception
	{
		fail("scanDoc() Method not yet implemented");
	}
	
	@Test
	public void testReceiveDoc() throws Exception
	{
		fail("receiveDoc() not yet implemented");
	}
}
