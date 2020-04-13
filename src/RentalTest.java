import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalTest 
{
	Rental r;

	@BeforeEach
	void setUp() throws Exception 
	{
		r = new Rental (6, 1, 6, 0, 50000.0, "Software Engineer", "RMIT");
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
	}

	@Test
	public void test() throws Exception
	{
		assertEquals(r.getIncome(), 50000);
		System.out.println("Successfully completed the test");
		
	}
	
	@Test
	public void testcalculateMgmtFee() throws Exception
	{
		assertEquals(r.calculateMgmtFee(2), r.getManagementFee());
	}
	
	@Test
	public void testpayAdvance() throws Exception
	{
		fail("payAdvance() Method not yet implemented");
	}
	
	@Test
	public void testnegotiateOffer() throws Exception
	{
		fail("negotiateOffer() Method not yet implemented");
	}


}
