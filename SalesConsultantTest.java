
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SalesConsultantTest 
{
	SalesConsultant salesConsultant;
	Sale sale;

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
		System.out.println("Before each method");
		salesConsultant = new SalesConsultant("sc001", "welcome123","James Isaac", "PT", 0, 25);
		sale = new Sale("Henry Street", "Kensington", 2,2,2,"house");
	}

	@After
	public void tearDown() throws Exception 
	{
		System.out.println("After each method");
	}
	
	//Positive JUnit test case where employee assigned to property creates inspection
	@Test
	public void testCreateInspection1() throws Exception
	{
		sale.setSalesConsultant(salesConsultant);
		salesConsultant.createInspection(sale, "05/06/2020");
		assertEquals(salesConsultant.getInspection().get(0).getInspectionID(), "INS002");
	}
	
	//Negative JUnit test case where inspection is tried to be created on Property not assigned to employee
	@Test(expected = PropertyNotAssignedToEmployee.class)
	public void testCreateInspection2() throws Exception
	{
		salesConsultant.createInspection(sale, "05/06/2020");
	}
	
	//Positive Junit test case where employee assigned to property conducts inspection
	@Test
	public void testConductInspection1() throws Exception
	{
		sale.setSalesConsultant(salesConsultant);
		salesConsultant.createInspection(sale, "05/06/2020");
		salesConsultant.conductInspection("INS001");
		assertEquals(salesConsultant.getInspection().get(0).getStatus(), "Conducted");
	}
	
	//Negative JUnit test case where inspection is tried to be cancelled on property not assigned to employee
	@Test(expected = PropertyNotAssignedToEmployee.class)
	public void testCancelInspection1() throws Exception
	{
		salesConsultant.cancelInspection(sale);
	}
	
	//Positive Junit test case where employee assigned to property cancels inspection
	//after property is under contract
	@Test
	public void testCancelInspection2() throws Exception
	{
		sale.setSalesConsultant(salesConsultant);
		salesConsultant.createInspection(sale, "05/07/2020");
		sale.setStatus("under contract");
		salesConsultant.cancelInspection(sale);
		assertEquals(salesConsultant.getInspection().get(0).getStatus(), "Cancelled");
	}


}




