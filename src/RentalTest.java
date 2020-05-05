import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
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

	
	//positive test case for calculating management fee with 5% offer and 2 properties
	@Test
	public void testcalculateMgmtFee1() throws Exception
	{
		assertEquals(3534.0, r.calculateMgmtFee(2, 50000));
		System.out.println(r.getManagementFee());
	}
	
	
	//positive test case for calculating management fee with 5% offer and 1 property
	@Test
	public void testcalculateMgmtFee2() throws Exception
	{
		assertEquals(3800.0, r.calculateMgmtFee(1, 50000));
		System.out.println(r.getManagementFee());
	}
	
	/*negative test case for calculating management fee with 5% offer and 1 property
	  When the user enter an invalid input in negotiating management fee */
	@Test
	public void testcalculateMgmtFee3() throws Exception
	{
		
		r.calculateMgmtFee(2, 50000);
		assertEquals(true, r.isException());
	}
		
	//negative test case for calculating management fee with 5% offer and 1 property
//	@Test
//	public void testcalculateMgmtFee4() throws Exception
//	{
//		assertEquals(3500.0, r.calculateMgmtFee(1, 50000));
//		System.out.println("Wrong output");
//	}
	
//	@Test
//	public void testpayAdvance() throws Exception
//	{
//		fail("payAdvance() Method not yet implemented");
//	}
//	
//	@Test
//	public void testnegotiateOffer() throws Exception
//	{
//		fail("negotiateOffer() Method not yet implemented");
//	}
//	
//	
//	@Test
//	public void testfinaliseOffer() throws Exception
//	{
//		assertEquals(r.acceptOffer(), true);
//		System.out.println("Offer is accepted");
//	}
	
	
	


}
