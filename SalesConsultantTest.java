
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SalesConsultantTest 
{
	SalesConsultant sc1;
	SalesConsultant sc2;
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
		System.out.println("Before each method");
		sc1 = new SalesConsultant("James Isaac", "PT", 0, 25);  //Part Time employee
	}

	@After
	public void tearDown() throws Exception 
	{
		System.out.println("After each method");
	}
	
	@Test
	public void testCommission() throws Exception
	{
		fail("commission() Method not yet implemented");
	}

	@Test
	public void testAdvertiseProperty() throws Exception
	{
		fail("advertiseProperty() Method not yet implemented");
	}

	@Test
	public void testLiaseVendor() throws Exception
	{
		fail("liaseVendor() Method not yet implemented");
	}

	@Test
	public void testConductInsp() throws Exception
	{
		fail("conductInspection() Method not yet implemented");
	}

	@Test
	public void testNegotiate() throws Exception
	{
		fail("negotiate() Method not yet implemented");
	}


	@Test
	public void testOrganiseDocs() throws Exception
	{
		fail("organiseDocs() Method not yet implemented");
	}

	@Test
	public void testSetID() throws Exception
	{
		fail("setID() Method not yet implemented");
	}




}




