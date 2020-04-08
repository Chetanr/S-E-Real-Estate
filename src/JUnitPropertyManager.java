import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitPropertyManager {
	PropertyManager pm;

	@BeforeEach
	void setUp() throws Exception 
	{
		pm = new PropertyManager("Joseph Isaac", "FT", 90000.0);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
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
	public void testSetID() throws Exception
	{
		assertEquals(pm.setID(), " ");
		System.out.println("Successfully completed the test");
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
		assertEquals(pm.checkReport(), true);
		System.out.println("Successfully completed the test");
	}
	
	@Test
	public void testReviewAppl() throws Exception
	{
		assertEquals(pm.reviewApplication(), true);
		System.out.println("Successfully completed the test");
	}
	
	


}


