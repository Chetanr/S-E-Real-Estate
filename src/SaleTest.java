import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.AfterClass;
import org.junit.BeforeClass;


class SaleTest {
	
	Sale s ;
	Property p;
	Customer c;
	Customer c2;
	Customer c3;
	
	
	@BeforeEach
	void setup() throws Exception
	{
		 s = new Sale("PRID009", "address", 3, 2, 2, "flat", "fantastic4", "propertyOwnerID");
		 p =new Sale("PRID001", "address", 2, 2, 2, "flat", "tenant_name", "CUST007");
		//Property p1=new Sale("PRID002", "address", 2, 2, 2, "apartment", "tenant_name", "CUST008");
		 c =new Customer("CUS001", "Pavan", "KA", "pavan.7185@gmail.com", "password",1100000, "occupation", "present_employer");
		 c2=new Customer("CUS002", "kunz", "p", "kunal@gmail.com", "password",1200000, "occupation", "present_employer");
		 c3=new Customer("CUS003", "Gagz", "p", "gagz@gmail.com", "password",1300000, "occupation", "present_employer");
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		
	}
	
	@Test //Positive Junit Test case
	void test1() throws Exception {
		
		s.propertyreply(c,p,260000);
		System.out.println("success");
	}
		
	@Test  //Positive Junit Test Case
	void test2() throws Exception {
			
    s.propertyreply(c2,p,280000);
    System.out.println("**Customer 2 with higer bid is given the property/n**");	
	}
	
	@Test  //Negative Junit Test Case
	void test3() throws Exception {
    s.propertyreply(c2,p,0);
    System.out.println("**Auction continues**");	
	}
	
	@Test  //Negative Junit Test Case
	void test4() throws Exception {
    s.propertyreply(c3,p,225000);
    System.out.println("**Auction won by customer 3 with 10000 less asking price of the previous value**");	
	}
	
}
	
