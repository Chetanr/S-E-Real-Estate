import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertyManagerTest 
{
	PropertyManager pm;
	
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
	
		pm = new PropertyManager("pm001", "welcome123","Joseph Isaac", "FT", 90000.0, 0.0);
	}
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("After each method");
	}

	@Test
	public void testAdvertiseProperty() throws Exception
	{
		fail("advertiseProperty() Method not yet implemented");
		
	}

	@Test
	public void testConductInsp() throws Exception
	{
		fail("conductInspection() Method not yet implemented");
		
	}
	
	@Test
	public void testOrganiseWork() throws Exception
	{
		fail("organisework() Method not yet implemented");
		
	}
	
	@Test
	public void testPayBill() throws Exception
	{
		fail("payBill() Method not yet implemented");
		
	}
	
	@Test
	public void testDeductFee() throws Exception
	{
		fail("deductFee() Method not yet implemented");
		
	}
	
	@Test
	public void testCheckReport() throws Exception
	{
		fail("checkReport() Method not yet implemented");
	}
	
	@Test
	public void testReviewAppl() throws Exception
	{
		fail("reviewAppl() Method not yet implemented");
	}
	

}
