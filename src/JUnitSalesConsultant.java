import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitSalesConsultant {
	SalesConsultant sc;

	@BeforeEach
	void setUp() throws Exception 
	{
		sc = new SalesConsultant("Joseph Isaac", "FT", 90000.0);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
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
		assertEquals(sc.organiseDocs(), true);
		System.out.println("Successfully completed the test");
	}
	
	@Test
	public void testSetID() throws Exception
	{
		assertEquals(sc.setID(), " ");
		System.out.println("Successfully completed the test");
	}
	
	


}

