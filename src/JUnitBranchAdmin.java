import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitBranchAdmin {
	BranchAdministrator ba;

	@BeforeEach
	void setUp() throws Exception 
	{
		ba = new BranchAdministrator("Joseph Isaac", "FT", 90000.0);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
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
		assertEquals(ba.setID(), " ");
		System.out.println("Successfully completed the test");
	}
	
	@Test
	public void testPayroll() throws Exception
	{
		fail("payroll() Method not yet implemented");
		
	}

	
	@Test
	public void testScanDoc() throws Exception
	{
		assertEquals(ba.scanDoc(), true);
		System.out.println("Successfully completed the test");
	}
	
	@Test
	public void testReceiveDoc() throws Exception
	{
		assertEquals(ba.receiveDoc(), true);
		System.out.println("Successfully completed the test");
	}
	
	


}



