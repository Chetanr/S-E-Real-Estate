import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.AfterClass;
import org.junit.BeforeClass;


class SaleTest {
	

	Sale s;
	Reply r;
	Reply v;
	Sale k;
	Reply m;
	Reply n;
	
	
	@BeforeEach
	void setup() throws Exception
	{
         k= new Sale("PRO001", "unison", "kensington", "15000", "1000", "vendor1");
		 s = new Sale("PRID009", "address", "flat", "10000", "Vendor");
		 r= new Reply("PRID009", "20000", "Buyer1");
		 v=new Reply("PRID009", "20000", "Buyer2");
		 m=new Reply("PRID009", "14000", "Buyer3");
		 n=new Reply("PRID009", "9000", "Buyer4");
		
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		
	}

	@Test
	void test() {
		
		s.negotiationReply(r);
		System.out.println("Success");
	}
	
	@Test //Positive Junit Test case
	void test1(){
		
		k.auctionReply(v);
		System.out.println("Now check");
	}
	
	@Test //Negative Junit Test case
	void test2(){
		
		k.auctionReply(m);
		System.out.println("Alternate path");
	}
	@Test //Negative Junit Test case
	void test3(){
		
		s.negotiationReply(n);
		System.out.println("LEss than offer value");
	}
}
