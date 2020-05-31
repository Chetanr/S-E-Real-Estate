import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MenuEmployee
{
	private static  ArrayList<Employee> employees;
	private static ArrayList<Property> properties;
	private static File employeeFile = new File("C:\\temp\\Employee.dat");
	private static File propertyFile = new File("C:\\temp\\Properties.dat");
	public static void main(String args[])
	{
	employees = new ArrayList<>();
	properties = new ArrayList<>();
	if(!employeeFile.exists())
	{
		employees.add(new BranchManager("BM001", "welcome123","Branch Manager", "FT", 5000, 0));
		employees.add(new PropertyManager("PM001", "welcome123!W","Property Manager 1", "PT", 0.0, 25.0));
		employees.add(new PropertyManager("PM002", "welcome123","Property Manager 2", "PT", 0.0, 25.0));
		employees.add(new PropertyManager("PM003", "welcome123W@","Property Manager 3", "PT", 0.0, 25.0));
		employees.add(new BranchAdministrator("BA001", "welcome123!!","Branch Administrator", "FT", 6000, 0.0));
		employees.add(new SalesConsultant("SC001", "welcome123Sc1","Sales Consultant 1", "PT", 0.0, 25.0));
		employees.add(new SalesConsultant("SC002", "welcome123Sc2","Sales Consultant 2", "PT", 0.0, 25.0));
		employees.add(new SalesConsultant("SC003", "welcome123Sc3","Sales Consultant 3", "PT", 0.0, 25.0));
		try 
		{ 	
			employeeFile.createNewFile();
			System.out.println("New Employee File created");
		}
		catch(IOException io)
		{
			System.out.println("Problem creating a new employee file");
		}
		catch(Exception e)
		{
			System.out.println("Program terminated due to unhandled exception while creating employee file");
		}
	}
	else
	{
		try 
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(employeeFile));              
			employees =  (ArrayList<Employee>) in.readObject(); 
			System.out.println("Employee File read");
			in.close();
		}
		catch(FileNotFoundException f)
		{
			System.out.println("Employee file cannot be found");
		}
    
		catch(IOException io)
		{
			System.out.println("Employee file cannot be read");
		}
		catch(ClassNotFoundException c)
		{
			System.out.println("Class to read the Employee file cannot be found");
		}
		catch(Exception e)
		{
			System.out.println("Program terminated due to unhandled exception while reading Employee file");
		}
	}
	if(!propertyFile.exists())
	{
		properties.add(new Rental ("Henry Street", "Kensington", 2,2,2,"apartment"));
		properties.add(new Rental ("Bangalore Street", "Spotswood", 2,2,2,"apartment"));
		properties.add(new Sale("Conder Street", "Burwood", 2,2,2,"house"));
		properties.add(new Sale("Henry Street", "Kensington", 2,2,2,"house"));
		properties.add(new Sale("Henry StreetTest", "Kensington", 2,2,2,"house"));
		try
		{
			propertyFile.createNewFile();
			System.out.println("New property file created");
		}
		catch(IOException io)
		{
			System.out.println("Problem creating a new property file");
		}
		catch(Exception e)
		{
			System.out.println("Program terminated due to unhandled exception while creating property file");
		}
	}
	else
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(propertyFile));              
			properties =  (ArrayList<Property>) in.readObject(); 
			System.out.println("Property File read");
			in.close(); 
		}
		catch(FileNotFoundException f)
		{
			System.out.println("Property file cannot be found");
		}
    
		catch(IOException io)
		{
			System.out.println("Property file cannot be read");
		}
		catch(ClassNotFoundException c)
		{
			System.out.println("Class to read the property file cannot be found");
		}
		catch(Exception e)
		{
			System.out.println("Program terminated due to unhandled exception while reading property file");
		}
}
	mainMenu();
	}
	
	public static void mainMenu()
	{
		boolean incorrectID = false;
		boolean incorrectPassword = false;
		boolean incorrectOption = false;
		do 
	    {
	    	incorrectID = false;
	    	incorrectPassword = false;
	    	incorrectOption = false;
	    	int choice = 0;
	    	System.out.println("------Welcome to Real Estate System-----");
	    	System.out.println("1.Login");
	    	System.out.println("2.Logout");
	    	System.out.println("Enter your choice");
	    	try
	    	{
	    		choice = Global.scanner.nextInt();
	    	}
	    	catch(InputMismatchException e)
	    	{
	    		
	    		System.out.println("Please enter a number between 1-2 for the choice");
	    		incorrectOption = true;
	    		Global.scanner.nextLine();
	    	}
		
	    	if(choice == 2)
	    	{
	    		System.out.println("Successfully Logged out");
	    		writeToFile();
	    		
	    	}
	    	else if(choice == 1)
	    	{
	    		System.out.println("Employee ID: ");
	    		String employeeID = Global.scanner.next();
	    		int index = searchEmployee(employeeID);
	    		if(index == -1)
	    		{
	    			incorrectID = true;
	    			System.out.println("Employee with "+employeeID+" not found");
	    		}
	    		else
	    		{
	    			System.out.println("Password: ");
	    			String password = Global.scanner.next();
	    			if(employees.get(index).getPassword().equals(password))
	    			{
	    				System.out.println("----Welcome "+employeeID+" -----");
	    				employeeMenu(employeeID);
	    				
	    			}
	    			else
	    			{
	    				System.out.println("Incorrect Password");
		    			incorrectPassword = true;
		    		}
	
	    		}
	    	}
	    	else if(!incorrectOption)
	    	{
	    		System.out.println("Incorrect Option");
	    		incorrectOption = true;
	    	}
	    }while(incorrectID || incorrectPassword || incorrectOption);

	}
	
	public static int searchEmployee(String employeeID)
	{
		int index = -1;
		for(int i =0 ; i < employees.size(); i++)
		{
			if(employeeID.equalsIgnoreCase(employees.get(i).getID()))
			{
				index = i;
			}
		}
		return index;
	}
	
	public static void employeeMenu(String employeeID)
	{
		String type = "";
		employeeID = employeeID.toUpperCase();
		if(employeeID.startsWith("PM"))
		{
			type = "Property Manager";
		}
		else if(employeeID.startsWith("BM"))
		{
			type = "Branch Manager";
		}
		else if(employeeID.startsWith("SC"))
		{
			type = "Sales Consultant";
		}
		else
		{
			type = "Branch Administrator";
		}
		System.out.println(type);
		switch(type)
		{
		case "Property Manager":
			propertyManagerMenu(employeeID);
			break;
		case "Branch Manager":
			branchManagerMenu(employeeID);
			break;
		case "Sales Consultant":
			salesConsultantMenu(employeeID);
			break;
		case "Branch Administrator":
			branchAdministratorMenu(employeeID);
			break;
		default:
				System.out.println("Invalid type");
		}
		
	}
	
	public static void propertyManagerMenu(String empID)
	{
		boolean quit = false;
		int choice = 0;
		do
		{
			choice = 0;
			quit = false;
			System.out.println("Welcome Property Manager");
			System.out.println("1. Create Inspection");
			System.out.println("2. Conduct Inspection");
			System.out.println("3. Cancel Inspection");
			System.out.println("4. Search Inspection");
			System.out.println("5. View Inspection");
			System.out.println("6. View Salary");
			System.out.println("7. View Property details");
			System.out.println("8. Enter Hours");
			System.out.println("9. Logout");
			System.out.println("Enter choice");
			try
			{
				choice = Global.scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				quit = false;
				Global.scanner.nextLine();
			}
			int ind = searchEmployee(empID);
			PropertyManager propertyManager = (PropertyManager)employees.get(ind);
			int bIndex = searchBranchManager();
			BranchManager branchManager = (BranchManager)employees.get(bIndex);
			switch(choice)
			{
			case 1:
				System.out.println("Enter property id");
				String propertyID = Global.scanner.next();
				System.out.println("Enter the date");
				String date = Global.scanner.next();
				int index = searchProperty(propertyID);
				if(index < 0)
				{
					System.out.println("Property with ID "+propertyID+" does not exist");
				}
				else
				{
					try
					{
						Rental rental = (Rental) properties.get(index);
						propertyManager.createInspection(rental, date);
					}
					catch (PropertyNotAssignedToEmployee e) 
					{
						System.out.println(e);
					}
					catch(Exception e)
					{
						System.out.println("Unable to create inspection.The property is not assigned to the employee");
					}
				}
			break;
			case 2:
				System.out.println("Enter inspection id");
				String inspectionID = Global.scanner.next();
				propertyManager.conductInspection(inspectionID);
				break;
			
			case 3:
				System.out.println("Enter property id");
				String propID = Global.scanner.next();
				int pos = searchProperty(propID);
				if(pos < 0)
				{
					System.out.println("Property with ID "+propID+" does not exist");
				}
				else
				{
					try
					{
						Rental rental = (Rental) properties.get(pos);
						propertyManager.cancelInspection(rental);
					}
					catch (PropertyNotAssignedToEmployee e) 
					{
				// TODO Auto-generated catch block
						System.out.println(e);
					}
					catch (Exception e) 
					{
					// TODO Auto-generated catch block
						System.out.println("Unable to cancel Inspection.The property is not assigned to employee");
					}
				}
				break;
			
			case 4:
				System.out.println("Enter inspection id");
				String ID = Global.scanner.next();
				int position = propertyManager.searchInspection(ID);
				if(position < 0)
				{
					System.out.println("Cannot find inspection with id "+ID);
				}
				else
				{
					System.out.println(propertyManager.getInspection().get(position));
				}
				break;
			case 5:
				if(propertyManager.getInspection().isEmpty())
				{
					System.out.println("No inspection to be displayed");
				}
				else
				{
					propertyManager.printInspection();
				}
				break;
			case 6:
				employees.get(ind).viewSalary();
				break;
			case 7:
				if(propertyManager.getProperty().isEmpty())
				{
					System.out.println("No properties to be displayed");
				}
				else
				{
					for(int i = 0; i < propertyManager.getProperty().size(); i++)
					{
						propertyManager.getProperty().get(i).printDetails();
					}
				}
			break;
			case 8:
				try
				{
					employees.get(ind).enterHours(branchManager);
				}
				catch(HourException e)
				{
					System.out.println(e);
				}
			break;
				
			case 9:
				System.out.println("You are successfully logged out");
				quit = true;
				mainMenu();
				break;
			default:
				System.out.println("Invalid choice.Please enter a number between 1-9");
				break;
			}
		
		}while(!quit);
	}
	
	public static void branchManagerMenu(String empID)
	{
		int choice = 0;
		int ind = searchEmployee(empID);
		BranchManager branchManager = (BranchManager)employees.get(ind);
		boolean quit = false;
		do
		{
			choice = 0;
			quit = false;
			System.out.println("Welcome Branch Manager");
			System.out.println("1. View Property details");
			System.out.println("2. Assign employee to property");
			System.out.println("3. View Employee Details");
			System.out.println("4. View Salary");
			System.out.println("5. Logout");
			System.out.println("Enter choice");
			try
			{
				choice = Global.scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				quit = false;
				Global.scanner.nextLine();
			}
			switch(choice)
			{
				case 1:
					for(int i = 0; i < properties.size(); i++)
					{
						properties.get(i).printDetails();
						System.out.println();
					}
				break;
				
				case 2:
					System.out.println("Enter employee ID");
					String employeeID = Global.scanner.next();
					int employeeIndex = searchEmployee(employeeID);
					System.out.println("Enter the property ID");
					String propertyID = Global.scanner.next();
					int propertyIndex = searchProperty(propertyID);
					if(employeeIndex >= 0 && propertyIndex >= 0)
					{
						try
						{
							branchManager.assignEmployee(employees.get(employeeIndex), properties.get(propertyIndex));
						}
						catch(PropertyAlreadyAssignedEmployee e1)
						{
							System.out.println(e1);
						}
						catch(IncorrectEmployeeAssigned e2)
						{
							System.out.println(e2);
						}
					}
					else if(employeeIndex < 0 && propertyIndex < 0)
					{
						System.out.println("Employee "+employeeID+" and Property "+propertyID+" is not found");
					}
					else if(propertyIndex < 0)
					{
						System.out.println("Property "+propertyID+" is not found");
					}
					else
					{
						System.out.println("Employee "+employeeID+" is not found");
					}
				break;
				
				case 3:
					for(int i = 0; i < employees.size(); i++)
					{
						System.out.println("----Employee Details-----");
						employees.get(i).printDetails();
						System.out.println();
					}
					break;
				case 4:
					employees.get(ind).viewSalary();
					break;
				case 5:
					System.out.println("You are successfully logged out");
					quit = true;
					mainMenu();
					break;
				
				default:
					System.out.println("Invalid choice.Please enter a number between 1-5");
					break;
			
		 }
	}while(!quit);
				
  }
	
	public static void salesConsultantMenu(String empID)
	{
		int choice = 0;
		boolean quit = false;
		do
		{
			choice = 0;
		quit = false;
		System.out.println("Welcome Sales Consultant");
		System.out.println("1. Create Inspection");
		System.out.println("2. Conduct Inspection");
		System.out.println("3. Cancel Inspection");
		System.out.println("4. Search Inspection");
		System.out.println("5. View Inspection");
		System.out.println("6. View Commission");
		System.out.println("7. View Salary");
		System.out.println("8. View Property details");
		System.out.println("9. Enter Hours");
		System.out.println("10. Logout");
		System.out.println("Enter choice");
		try
		{
			choice = Global.scanner.nextInt();
		}
		catch(InputMismatchException e)
		{
			quit = false;
			Global.scanner.nextLine();
		}
		int ind = searchEmployee(empID);
		SalesConsultant salesConsultant = (SalesConsultant)employees.get(ind);
		int bIndex = searchBranchManager();
		BranchManager branchManager = (BranchManager)employees.get(bIndex);
		switch(choice)
		{
		case 1:
			System.out.println("Enter property id");
			String propertyID = Global.scanner.next();
			System.out.println("Enter the date");
			String date = Global.scanner.next();
			int index = searchProperty(propertyID);
			if(index < 0)
			{
				System.out.println("Property with ID "+propertyID+" does not exist");
			}
			else
			{
				try
				{
					Sale sale = (Sale) properties.get(index);
					salesConsultant.createInspection(sale, date);
				}
				catch (PropertyNotAssignedToEmployee e) 
				{
				// TODO Auto-generated catch block
					System.out.println(e);
				}
				catch (Exception e) 
				{
				// TODO Auto-generated catch block
					System.out.println("Unable to craete Inspection.The property is not assigned to employee");
				}
			}
			break;
		case 2:
			System.out.println("Enter inspection id");
			String inspectionID = Global.scanner.next();
			salesConsultant.conductInspection(inspectionID);
			break;
			
		case 3:
			System.out.println("Enter property id");
			String propID = Global.scanner.next();
			int pos = searchProperty(propID);
			if(pos < 0)
			{
				System.out.println("Property with ID "+propID+" does not exist");
			}
			else
			{
				try
				{
					Sale sale = (Sale) properties.get(pos);
					salesConsultant.cancelInspection(sale);
				}
				catch (PropertyNotAssignedToEmployee e) 
				{
				// TODO Auto-generated catch block
					System.out.println(e);
				}
				catch (Exception e) 
				{
				// TODO Auto-generated catch block
					System.out.println("Unable to cancel Inspection.The property is not assigned to employee");
				}
			}
			break;
			
		case 4:
			System.out.println("Enter inspection id");
			String ID = Global.scanner.next();
			int position = salesConsultant.searchInspection(ID);
			if(position < 0)
			{
				System.out.println("Cannot find inspection with id "+ID);
			}
			else
			{
				System.out.println(salesConsultant.getInspection().get(position));
			}
			break;
		case 5:
			if(salesConsultant.getInspection().isEmpty())
			{
				System.out.println("No inspection to be displayed");
			}
			else
			{
				salesConsultant.printInspection();
			}
			break;
		case 6:
			System.out.println("The commission is "+ salesConsultant.getCommission());
			break;
		case 7:
			employees.get(ind).viewSalary();
			break;
			
		case 8:
			if(salesConsultant.getProperty().isEmpty())
			{
				System.out.println("No properties to be displayed");
			}
			else
			{
				for(int i = 0; i < salesConsultant.getProperty().size(); i++)
				{
					salesConsultant.getProperty().get(i).printDetails();
				}
			}
			break;
		case 9:
			try
			{
				employees.get(ind).enterHours(branchManager);
			}
			catch(HourException e)
			{
				System.out.println(e);
			}
			break;
		case 10:
			System.out.println("You are successfully logged out");
			quit = true;
			mainMenu();
			break;
		default:
			System.out.println("Invalid choice.Please enter a number between 1-10");
			break;
		}
		}while(!quit);
			
		
	}
	
	public static void branchAdministratorMenu(String empID)
	{
		int choice = 0;
		int ind = searchEmployee(empID);
		BranchAdministrator branchAdministrator = (BranchAdministrator)employees.get(ind);
		int bIndex = searchBranchManager();
		BranchManager branchManager = (BranchManager)employees.get(bIndex);
		boolean quit = false;
		do
		{
			choice = 0;
		quit = false;
		System.out.println("Welcome Branch Administrator");
		System.out.println("1. Run Payroll");
		System.out.println("2. View Salary");
		System.out.println("3. Enter Hours");
		System.out.println("4. Advance Date to test");
		System.out.println("5. Current date to test");
		System.out.println("6. Logout");
		System.out.println("Enter choice");
		try
		{
			choice = Global.scanner.nextInt();
		}
		catch(InputMismatchException e)
		{
			quit = false;
			Global.scanner.nextLine();
		}
		switch(choice)
		{
			case 1:
			try 
			{
				branchAdministrator.payroll(employees);
			} 
			catch (PayrollException e1) 
			{
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Set date to current date or advance days for testing");
			}
				break;
			case 2:
				employees.get(ind).viewSalary();
				break;
			case 3:
				try
				{
					employees.get(ind).enterHours(branchManager);
				}
				catch(HourException e)
				{
					System.out.println(e);
				}
				break;
			case 4:
				int days = 0;
				System.out.println("Enter the days you want to advance");
					try
					{
						days = Global.scanner.nextInt();
						branchAdministrator.advanceDate(days);
					}
					catch(InputMismatchException e)
					{
						System.out.println("Please enter a number for days");
					}
				break;
			case 5:
				branchAdministrator.currentDate();
				break;
			case 6:
				System.out.println("You are successfully logged out");
				quit = true;
				mainMenu();
				break;
			default:
				System.out.println("Invalid choice.Please enter a number between 1-6");
				break;
		}
	}while(!quit);
	}
	
	public static int searchProperty(String propertyID)
	{
		int propertyIndex = -1;
		for(int i = 0; i < properties.size(); i++)
		{
			if(propertyID.equalsIgnoreCase(properties.get(i).getPropertyID()))
			{
				propertyIndex = i;
			}
		}
		return propertyIndex;
	}
	
	public static int searchBranchManager()
	{
		int index = -1;
		for(int i =0 ; i < employees.size(); i++)
		{
			if(employees.get(i).getID().startsWith("BM"))
			{
				index = i;
			}
		}
		return index;
	}
	

public static void writeToFile()
{
	try

{
	   ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(employeeFile));       
		out.writeObject(employees);   
		System.out.println("Employee objects stored into file successfully");
		out.close();  
}
catch(FileNotFoundException fn)
{
		System.out.println("File not found, Please check the filename and path specified and try again...Exiting");
		System.out.println(fn);
		System.exit(1);
}
catch(IOException io)
{
		System.out.println("Problem reading from file, Please check and retry...Exiting");
		System.out.println(io);
		System.exit(1);
}
		
	try
	{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(propertyFile));       
		out.writeObject(properties);   
		System.out.println("Property objects stored into file successfully");
		out.close();  
	}
	catch(FileNotFoundException fnfe)
	{
		System.out.println("File not found, Please check the filename and path specified and try again...Exiting");
		System.out.println(fnfe);
		System.exit(1);
	}
	catch(IOException ioe)
	{
		System.out.println("Problem reading from file, Please check and retry...Exiting");
		System.out.println(ioe);
		System.exit(1);
	}
}
}



