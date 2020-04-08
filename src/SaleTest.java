import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


class SaleTest {
	
	Sale s;
	
	@BeforeEach
	void setup() throws Exception
	{
		s=new Sale("RMIT","12","2",4.50,300000.0,"08/04/2020");
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		
	}
	
	@Test
	void test1() throws Exception {
		assertEquals(s.manageinspection(),true);
		System.out.println("success");
		
	}
	@Test
	void test() throws Exception {
		assertEquals(s.getproperty_sellingprice(),300000.0);
		System.out.println("success");
		
		}
	@Test
	void testnegotiateoffer() throws Exception
	{
		fail(" negotiateoffer() Method not yet implemented");
	}
	
	@Test
	void testfinaliseOffer() throws Exception
	{
		fail(" finaliseOffer() Method not yet implemented");
	}
	
	@Test
	void testwithdrawoffer() throws Exception
	{
		fail(" withdrawoffer() Method not yet implemented");
	}
	
	@Test
	void testmanageinspection() throws Exception
	{
		fail(" manageinspection() Method not yet implemented");
	}
	
	@Test
	void testmanage_failedauction() throws Exception
	{
		fail(" manage_failedauction() Method not yet implemented");
	}
	
	@Test
	void testmanagecontract() throws Exception
	{
		fail(" managecontract() Method not yet implemented");
	}
	
	

}
