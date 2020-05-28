import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertyManagerTest 
{
	PropertyManager propertyManager;
	Rental rental;
	
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
		propertyManager = new PropertyManager("pm001", "welcome123","James Isaac", "PT", 0, 25);
		rental = new Rental("Henry Street", "Kensington", 2,2,2,"house");
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
		rental.setPropertyManager(propertyManager);
		propertyManager.createInspection(rental, "05/06/2020");
		assertEquals(propertyManager.getInspection().get(0).getInspectionID(), "INS002");
	}
		
	//Negative JUnit test case when trying to create inspection on property that is not assigned to an employee
	@Test(expected = PropertyNotAssignedToEmployee.class)
	public void testCreateInspection2() throws Exception
	{
		propertyManager.createInspection(rental, "05/06/2020");
	}
	
	//Positive Junit test case where employee assigned to property conducts inspection
	@Test
	public void testConductInspection1() throws Exception
	{
		rental.setPropertyManager(propertyManager);
		propertyManager.createInspection(rental, "05/06/2020");
		propertyManager.conductInspection("INS001");
		assertEquals(propertyManager.getInspection().get(0).getStatus(), "Conducted");
	}
	
	//Negative JUnit test case where inspection is tried to be cancelled on property that is not assigned to an employee
	@Test(expected = PropertyNotAssignedToEmployee.class)
	public void testCancelInspection1() throws Exception
	{
		propertyManager.cancelInspection(rental);
	}
		
	//Positive Junit test case where employee assigned to property cancels inspection
	//after property is let
	@Test
	public void testCancelInspection2() throws Exception
	{
		rental.setPropertyManager(propertyManager);
		propertyManager.createInspection(rental, "05/07/2020");
		rental.setStatus("let");
		propertyManager.cancelInspection(rental);
		assertEquals(propertyManager.getInspection().get(0).getStatus(), "Cancelled");
	}

}
