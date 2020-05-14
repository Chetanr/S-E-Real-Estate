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
		employees.add(new BranchAdministrator("BA001", "welcome123!!","Branch Administrator", "FT", 5000, 0));
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
	    	if(choice == 1)
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
	    			if(employees.get(index).getPassword().equals(password));
	    			{
	    				System.out.println("----Welcome "+employeeID+" -----");
	    				employeeMenu(employeeID);
	    				
	    			}
	    			if(!employees.get(index).getPassword().equals(password))
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
		if(employeeID.contains("PM"))
		{
			type = "Property Manager";
		}
		else if(employeeID.contains("BM"))
		{
			type = "Branch Manager";
		}
		else if(employeeID.contains("SC"))
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
			System.out.println("Welcome Property Manager");
			propertyManagerMenu();
			break;
		case "Branch Manager":
			System.out.println("Welcome Branch Manager");
			branchManagerMenu(employeeID);
			break;
		case "Sales Consultant":
			System.out.println("Welcome Sales Consultant");
			salesConsultantMenu();
			break;
		case "Branch Administrator":
			System.out.println("Welcome Branch Administrator");
			branchAdministratorMenu();
			break;
		default:
				System.out.println("Invalid type");
		}
		
	}
	
	public static void propertyManagerMenu()
	{
		System.out.println("1. Advertise Property");
		System.out.println("2. Create Inspection");
		System.out.println("3. Conduct Inspection");
		System.out.println("4. Cancel Inspection");
		System.out.println("5. Search Inspection");
		System.out.println("6. View Inspection");
		System.out.println("7. Review Application");
		System.out.println("8. Check Report");
		System.out.println("9. Organise Work");
		System.out.println("10. Pay Bill");
		System.out.println("11. Deduct Feee");
		System.out.println("12. View Property details");
		System.out.println("13. View Salary");
		System.out.println("14. Logout");
	}
	
	public static void branchManagerMenu(String empID)
	{
		boolean quit = false;
		do
		{
			quit = false;
			int ind = searchEmployee(empID);
			BranchManager branchManager = (BranchManager)employees.get(ind);
			System.out.println("1. Approve Hours");
			System.out.println("2. View Property details");
			System.out.println("3. Assign employee to property");
			System.out.println("4. View Property details");
			System.out.println("5. Logout");
			int choice = Global.scanner.nextInt();
			switch(choice)
			{
				case 2:
					for(int i = 0; i < properties.size(); i++)
					{
						System.out.println("-----The property details are-------");
						properties.get(i).printDetails();
						System.out.println();
					}
				break;
				
				case 3:
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
					else if(employeeIndex < 0)
					{
						System.out.println("Employee "+employeeID+" is not found");
					}
					else
					{
						System.out.println("Property "+propertyID+" is not found");
					}
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
	
	public static void salesConsultantMenu()
	{
		System.out.println("1. Advertise Property");
		System.out.println("2. Create Inspection");
		System.out.println("3. Conduct Inspection");
		System.out.println("4. Cancel Inspection");
		System.out.println("5. Search Inspection");
		System.out.println("6. View Inspection");
		System.out.println("7. View Commission");
		System.out.println("8. View Salary");
		System.out.println("9. Liase with Vendor");
		System.out.println("10. Organise Documents");
		System.out.println("11. View Property details");
		System.out.println("12. Logout");
		
	}
	
	public static void branchAdministratorMenu()
	{
		System.out.println("1. Receive Documents");
		System.out.println("2. Scan Documents");
		System.out.println("3. Run Payroll");
		System.out.println("4. Credit Rent to branch Account");
		System.out.println("5. Logout");
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

}
