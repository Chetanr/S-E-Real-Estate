import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BranchAdministratorTest 
{
	BranchAdministrator branchAdministrator;
	Employee propertyManager;
	BranchManager branchManager;
	ArrayList<Employee> employees;
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
	
		branchAdministrator = new BranchAdministrator("ba001", "welcome123","James Isaac", "PT", 0.0, 25.0);
		propertyManager = new PropertyManager("PM001", "welcome12***3","Jason White", "FT", 5000, 0);
		branchManager = new BranchManager("BM001", "welcome123","Branch Manager", "FT", 5000, 0);
		employees = new ArrayList<>();
		employees.add(propertyManager);
		employees.add(branchAdministrator);
	}
	
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("After each method");
	}
	
	//Negative JUnit test case where an exception occurs when payroll is run at date that is not end of month
	@Test(expected = PayrollException.class)
	public void testPayroll1() throws Exception
	{
		branchAdministrator.currentDate();
		branchAdministrator.payroll(employees);
	}
	
	//Positive Junit test showing salary calculated for month for Full time employee
	//after running payroll
	@Test
	public void testPayroll2() throws Exception
	{
		branchAdministrator.advanceDate(3);
		branchAdministrator.payroll(employees);
		assertEquals(employees.get(0).getSalaryForMonth(), 5000);
	}
	
	//Positive Junit test showing salary calculated for month for part time employee after
	//running payroll
	@Test
	public void testPayroll3() throws Exception
	{
		employees.get(1).setHours(10);
		branchAdministrator.advanceDate(3);
		branchAdministrator.payroll(employees);
		assertEquals(employees.get(1).getSalaryForMonth(), 250);
	}
	


}
