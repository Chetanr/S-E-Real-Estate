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
		r = new Rental (6, 1, 6, 0, 50000.0);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
	}

	
	
//	@Test
//	public void testcalculateMgmtFee() throws Exception
//	{
//		assertEquals(r.calculateMgmtFee(2, 1000), r.getManagementFee());
//		System.out.println(r.getManagementFee());
//	}
	
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
	
	
	@Test
	public void testfinaliseOffer() throws Exception
	{
		assertEquals(r.acceptOffer(), true);
		System.out.println("Offer is accepted");
	}
	
	
	


}
