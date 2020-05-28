import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BranchManagerTest 
{
	BranchManager branchManager;
	Property rentalProperty1;
	Property rentalProperty2;
	Property saleProperty1;
	Property saleProperty2;
	Employee propertyManager1;
	Employee propertyManager2;
	Employee saleConsultant1;
	
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
		propertyManager1 = new PropertyManager("PM001", "welcome123@","James Isaac", "PT", 0.0, 25.0);
		propertyManager2 = new PropertyManager("PM002", "welcome123@!","Jack Miller", "PT", 0.0, 25.0);
		rentalProperty1 = new Rental ("Henry Street", "Kensington", 2,2,2,"apartment");
		branchManager = new BranchManager("BM001", "welcome123","Branch Manager", "FT", 5000, 0);
		saleConsultant1 = new SalesConsultant("SC001", "welcome12***3","Jason White", "PT", 0.0, 25.0);
		saleProperty1 = new Sale("Conder Street", "Burwood", 2,2,2,"house");
		rentalProperty2 = new Rental ("Bangalore Street", "Spotswood", 2,2,2,"apartment");
		saleProperty2 = new Sale("Finder Street", "Foostcray", 2,2,2,"house");
		
	}
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("After each method");
	}
	
	//Positive JUnit Test case
	//Assigning a Rental property to a Property manager
	@Test
	public void testAssignEmployee1() throws Exception
	{
		System.out.println("-------testAssignEmployee1-----");
		branchManager.assignEmployee(propertyManager1, rentalProperty1);
		Rental rentalProperty = (Rental)rentalProperty1;
		assertEquals(rentalProperty.getPropertyManager(), propertyManager1);
	}
	
	//Positive JUnit Test case
	//Assigning a Sale property to Sales Consultant
	@Test
	public void testAssignEmployee2() throws Exception
	{
		System.out.println("-------testAssignEmployee2-----");
		branchManager.assignEmployee(saleConsultant1, saleProperty1);
		Sale saleProperty = (Sale)saleProperty1;
		assertEquals(saleProperty.getSalesConsultant(), saleConsultant1);
	}
		
	//Negative JUnit Test case
	//Trying to assign rental property to sales Consultant
	@Test (expected = IncorrectEmployeeAssigned.class)
	public void testAssignEmployee3() throws Exception
	{
		System.out.println("-------testAssignEmployee3-----");
		branchManager.assignEmployee(saleConsultant1, rentalProperty1);
	}	
	
	//Negative JUnit Test case
	//Trying to assign another Property Manager to a rental property
	@Test (expected = PropertyAlreadyAssignedEmployee.class)
	public void testAssignEmployee4() throws Exception
	{
		System.out.println("-------testAssignEmployee4-----");
		branchManager.assignEmployee(propertyManager1, rentalProperty1);
		branchManager.assignEmployee(propertyManager2, rentalProperty1);
	}
	
	//Positive test case showing that salesconsultant can be assigned more than one property
	@Test
	public void testAssignEmployee5() throws Exception
	{
		System.out.println("-------testAssignEmployee5-----");
		branchManager.assignEmployee(saleConsultant1, saleProperty1);
		branchManager.assignEmployee(saleConsultant1, saleProperty2);
		SalesConsultant salesConsultant = (SalesConsultant) saleConsultant1;
		assertEquals(salesConsultant.getProperty().get(0), saleProperty1);
		assertEquals(salesConsultant.getProperty().get(1), saleProperty2);
	}
		
	//Positive JUnit test case for approve hours	
	@Test
	public void testApproveHours() throws HourException
	{
		assertTrue(branchManager.approveHours(10));
	}
	
	//Negative JUnit test case when invalid hours is entered by employee and sent for branch Manager approval
	@Test (expected = HourException.class)
	public void testApproveHours1() throws HourException
	{
		branchManager.approveHours(-10);
	}

}
