import java.util.ArrayList;

public class MenuEmployee
{
	private static ArrayList<Employee> employees;
	private static ArrayList<Property> properties;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		employees = new ArrayList<>();
		properties = new ArrayList<>();
		employees.add(new BranchManager("BM001", "welcome123","Branch Manager", "FT", 5000, 0));
		employees.add(new PropertyManager("PM001", "welcome123!W","Property Manager 1", "PT", 0.0, 25.0));
		employees.add(new PropertyManager("PM002", "welcome123","Property Manager 2", "PT", 0.0, 25.0));
		employees.add(new PropertyManager("PM003", "welcome123W@","Property Manager 3", "PT", 0.0, 25.0));
		employees.add(new BranchAdministrator("BA001", "welcome123!!","Branch Administrator", "PT", 0.0, 25.0));
		employees.add(new SalesConsultant("SC001", "welcome123Sc1","Sales Consultant 1", "PT", 0.0, 25.0));
		employees.add(new SalesConsultant("SC002", "welcome123Sc2","Sales Consultant 2", "PT", 0.0, 25.0));
		employees.add(new SalesConsultant("SC003", "welcome123Sc3","Sales Consultant 3", "PT", 0.0, 25.0));
		properties.add(new Rental ("Henry Street", "Kensington", 2,2,2,"apartment"));
		properties.add(new Rental ("Bangalore Street", "Spotswood", 2,2,2,"apartment"));
		properties.add(new Sale("Conder Street", "Burwood", 2,2,2,"house"));
		properties.add(new Sale("Henry Street", "Kensington", 2,2,2,"house"));
		boolean incorrectID = false;
		boolean incorrectPassword = false;
		boolean incorrectOption = false;
	    do 
	    {
	    	incorrectID = false;
	    	incorrectPassword = false;
	    	incorrectOption = false;
	    	System.out.println("------Welcome to Real Estate System-----");
	    	System.out.println("1.Login");
	    	System.out.println("2.Logout");
	    	System.out.println("Enter your choice");
	    	int choice = Global.scanner.nextInt();
		
	    	if(choice == 2)
	    	{
	    		System.out.println("Successfully Logged out");
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
	    	else
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
			propertyManagerMenu();
			break;
		case "Branch Manager":
			branchManagerMenu(employeeID);
			break;
		case "Sales Consultant":
			salesConsultantMenu();
			break;
		case "Branch Administrator":
			branchAdministratorMenu(employeeID);
			break;
		default:
				System.out.println("Invalid type");
		}
		
	}
	
	public static void propertyManagerMenu()
	{
		System.out.println("Welcome Property Manager");
		System.out.println("1. Create Inspection");
		System.out.println("2. Conduct Inspection");
		System.out.println("3. Cancel Inspection");
		System.out.println("4. Search Inspection");
		System.out.println("5. View Inspection");
		System.out.println("6. View Property details");
		System.out.println("7. View Salary");
		System.out.println("8. Logout");
		int option = Global.scanner.nextInt();
	}
	
	public static void branchManagerMenu(String empID)
	{
		int ind = searchEmployee(empID);
		BranchManager branchManager = (BranchManager)employees.get(ind);
		boolean quit = false;
		do
		{
			quit = false;
			System.out.println("Welcome Branch Manager");
			System.out.println("1. View Property details");
			System.out.println("2. Assign employee to property");
			System.out.println("3. View Employee Details");
			System.out.println("4. Logout");
			int choice = Global.scanner.nextInt();
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
					System.out.println("You are successfully logged out");
					quit = true;
					break;
				
				default:
					System.out.println("Invalid choice");
					break;
			
		 }
	}while(!quit);
				
  }
	
	public static void salesConsultantMenu()
	{
		System.out.println("Welcome Sales Consultant");
		System.out.println("1. Create Inspection");
		System.out.println("2. Conduct Inspection");
		System.out.println("3. Cancel Inspection");
		System.out.println("4. Search Inspection");
		System.out.println("5. View Inspection");
		System.out.println("6. View Commission");
		System.out.println("7. View Salary");
		System.out.println("8. View Property details");
		System.out.println("9. Logout");
		
	}
	
	public static void branchAdministratorMenu(String empID)
	{
		int ind = searchEmployee(empID);
		BranchAdministrator branchAdministrator = (BranchAdministrator)employees.get(ind);
		int bIndex = searchBranchManager();
		BranchManager branchManager = (BranchManager)employees.get(bIndex);
		boolean quit = false;
		do
		{
		quit = false;
		System.out.println("Welcome Branch Administrator");
		System.out.println("1. Run Payroll");
		System.out.println("2. View Salary");
		System.out.println("3. Enter Hours");
		System.out.println("4. Advance Date");
		System.out.println("5. Logout");
		int choice = Global.scanner.nextInt();
		switch(choice)
		{
			case 1:
				branchAdministrator.payroll(employees);
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
				branchAdministrator.advanceDate(0);
				break;
			case 5:
				System.out.println("You are successfully logged out");
				quit = true;
				break;
			default:
				System.out.println("Invalid choice");
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
	

}
