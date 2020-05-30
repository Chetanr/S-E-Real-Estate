import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class RealEstate {
	
	static Scanner sc = new Scanner(System.in);
	static int ch = 0;
	
	static int propCount = 1;
	
	
	static ArrayList<Property> property = new ArrayList<Property>();
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<Inspection> inspectionList = new ArrayList<Inspection>();
	private static  ArrayList<Employee> employees = new ArrayList<>();
	

	public static void main(String[] args) throws Exception 
	{
		employees.add(new BranchManager("BM001", "welcome123","Branch Manager", "FT", 5000, 0));
		employees.add(new PropertyManager("PM001", "welcome123!W","Property Manager 1", "PT", 0.0, 25.0));
		employees.add(new PropertyManager("PM002", "welcome123","Property Manager 2", "PT", 0.0, 25.0));
		employees.add(new PropertyManager("PM003", "welcome123W@","Property Manager 3", "PT", 0.0, 25.0));
		employees.add(new BranchAdministrator("BA001", "welcome123!!","Branch Administrator", "FT", 6000, 0.0));
		employees.add(new SalesConsultant("SC001", "welcome123Sc1","Sales Consultant 1", "PT", 0.0, 25.0));
		employees.add(new SalesConsultant("SC002", "welcome123Sc2","Sales Consultant 2", "PT", 0.0, 25.0));
		employees.add(new SalesConsultant("SC003", "welcome123Sc3","Sales Consultant 3", "PT", 0.0, 25.0));
		mainMenu();
		
	}
	
	public static void mainMenu() throws Exception
	{
		System.out.println("Welcome.!");
		System.out.println("1. Customer Menu");
		System.out.println("2. Employee Menu");			
		System.out.println("3. Logout");
		

			ch = sc.nextInt();
			switch (ch)
			{
				case 1: customerMenu();
						break;
				case 2: employeeMenu();
						break;
				case 3: break;
				
				default:System.out.println("Invalid input. Please enter a valid input.");
						throw new Exception();
			}
	}
	
	//menu for customer
	public static void customerMenu() throws Exception
	{
//		while(ch < 3)
//		{
			System.out.println("----------------------");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Main Menu");
			
			try
			{
				ch = sc.nextInt();
				
				switch(ch)
				{
					case 1 :register();
							break;
					case 2 :login();
							break;
					case 3: mainMenu();
							break;
				}
			} catch (InputMismatchException e)
			{
				System.out.println("Invalid input. Please enter a valid input");
			}
//		}
		
		
	}
	
	//menu for rentee
	private static  void fullRenteeMenu(String userName) throws Exception {
	
	String pid;
	System.out.println("1. apply to property");
	System.out.println("2. view update");
	System.out.println("3. Update payment status");
	System.out.println("4. Logout");
	ch = sc.nextInt();
	
	switch(ch)
	{
		case 1: applyToProperty(userName);
				break;
		case 2: viewUpdate();
				break;
		case 3: updatePayment(userName);
				break;
		case 4: mainMenu();
				break;
	}
}
	
	private static void updatePayment(String userName) throws Exception {
		String pid;
		System.out.println("Enter property id: ");
		pid = sc.next();
		System.out.println("1. I have made the payment to the property.!");
		System.out.println("2. I am yet to make the payment.!");
		ch = sc.nextInt();
		if (ch == 1)
		{
			for (Property i : property)
			{
				if(i.getProperty_id().equals(pid))
				{
					((Rental) i).finaliseOffer();
					System.out.println("Yuu are now the tenant of the house. You are now responsible "
							+ "for the property. Please discuss the"
							+ "terms and conditions with the landlord."
							+ "Congratulation again.!");
				}	
			}	
		}
		else if (ch == 2)
		{
			System.out.println("Please make the payment and come back");
		}	
		fullRenteeMenu(userName);
	}



	private static void viewUpdate() {
		String pid;
		System.out.println("Enter property id you want to view update: ");
		pid = sc.next();
		if(searchproperty(pid))
		{
			for (Property i :property)
			{
				if(i.getProperty_id().equals(pid))
				{
					if(((Rental) i).getStatus().equals(null))
					{
						System.out.println("No update available");
					}
					else if (((Rental) i).getStatus().equalsIgnoreCase("accept"))
					{
						System.out.println("Congrats.! Your application has been accepted.!");
						System.out.println("Please pay the advance to the landlord");
					}
				}
			}
			
		}	
	}



	private static void applyToProperty(String userName) throws Exception {
		String pid;
		int months;
		int years;
		System.out.println("Enter property id: ");
		pid = sc.next();
		System.out.println("Enter the proposed contract months: ");
		months = sc.nextInt();
		System.out.println("Enter the proposed contract years: ");
		years = sc.nextInt();
		
		if(searchproperty(pid))
		{
			for (Property i : property)
			{
				if(i.getProperty_id().equals(pid))
				{
					for(Customer j : customerList)
					{
						if(j.getCustomer_id().equals(userName))
						{
							((Rental) i).setApplicantDetails(j.getCustomer_id(), j.getFirstname(), j.getSurename(), j.getIncome(), j.getOccupation(), j.getPresent_employer(), months, years);
						}
						else
							continue;
					}	
				}
				else
				{
					System.out.println("Property id not found. Please try again");
				}
				
			}
			System.out.println("Successfully applied to property " + pid);
		}
		else
		{
			System.out.println("property not found. Please try again");
		}
		fullRenteeMenu(userName);
	}



	private static  boolean searchproperty(String pid) {
		for (Property i : property)
		{
			if(i.getProperty_id().equals(pid))
			{
				return true;
			}
		}
		return false;	
	}
	
	
	//register a customer
	public static void register() throws Exception {
		
		System.out.println("Enter Name: ");
		String custName = sc.next();

		System.out.println("Enter surname: ");
		String surName = sc.next();

		System.out.println("Enter Email: ");
		String custEmail = sc.next();

		System.out.println("Enter Password: ");
		String custPass = sc.next();
		
		System.out.println("Enter Customer type(1-> Vendor, 2->Landlord, 3->Rentee, 4->Buyer,): ");
		String custType = sc.next();
		
		System.out.println("Enter Income: ");
		String custIncome = sc.next();
		
		System.out.println("Enter Occupation: ");
		String custOccu = sc.next();

		System.out.println("Enter Employer: ");
		String custEmployer = sc.next();

		String custId = getCustomerId(custType);
		
		String customerStr = "";
		
		if(custType.equals("1")) {
			Customer customerObj = new Vendor(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Vendor has been created with id "+custId);
			customerStr = customerObj.toString();
			
			customerStr = custType +","+ customerStr;
		}
		else if(custType.equals("2")) {
			Customer customerObj = new Landlord(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Landlord has been created with id "+custId);
			
			customerStr = customerObj.toString();
			
			customerStr = custType +","+ customerStr;
		}
		else if(custType.equals("3")) {
			Customer customerObj = new Rentee(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Rentee has been created with id "+custId);
			
			customerStr = customerObj.toString();
			
			customerStr = custType +","+ customerStr;
		}
		else if(custType.equals("4")) {
			Customer customerObj = new Buyer(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Buyer has been created with id "+custId);
			
			customerStr = customerObj.toString();
			
			customerStr = custType +","+ customerStr;
		}
		
		try
		{
		    String filename= "Customer.txt";
		    FileWriter fw = new FileWriter(filename,true);
		    fw.write(customerStr + "\n");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
		mainMenu();
			
	}
	
	
	//menu for landlord
	private static void fullLandlordMenu(String userName) throws Exception {
		String pid = "P";
		System.out.println("1. Add Property");
		System.out.println("2. View offers");
		System.out.println("3. Negotiaite Management Feee");
		System.out.println("4. Logout");
		ch = sc.nextInt();
		
		switch(ch)
		{
			case 1: addProperty(userName);
					break;
			case 2: offer(userName);
					break;
			case 3: negotiateFee();
					break;
			default: mainMenu();
					break;
					
		}
		
	}
	
	
	private static void negotiateFee() throws Exception {
		String pid;
		System.out.println("Enter the property id: ");
		pid = sc.next();
		for (Property i : property)
		{
			if(i.getProperty_id().equals(pid))
			{
				((Rental) i).calculateMgmtFee(1, ((Rental) i).getRentalAmount());
				break;
			}	
			else
			{
				System.out.println("Property id not found.");
			}
		}
		
		
	}



	private static void offer(String userName) throws Exception {
		String pid;
		System.out.println("Enter property id: ");
		pid = sc.next();
		
		for (Property i : property)
		{
			if(i.getProperty_id().equals(pid))
			{
				((Rental) i).viewOffer();
				break;
			}	
			else
			{
				System.out.println("Property id not found.");
			}
		}
		fullLandlordMenu(userName);
		
	}



	//adding the property for landlord
	private static void addProperty(String userName) throws Exception {
		String pid = "P";
		int numBed;
		int numBath;
		int numCarSpace;
		int contractMonth;
		int contractYear;
		int rentalAmount;
		
		String propertyStr = "";
		
		String addr;
		String suburb;
		String houseType;
		System.out.println("Enter number of bedrooms: ");
		numBath = sc.nextInt();
		System.out.println("Enter number of bathrooms: ");
		numBed = sc.nextInt();
		System.out.println("Enter number of carspaces: ");
		numCarSpace = sc.nextInt();
		System.out.println("Enter address of the property: ");
		addr = sc.next();
		System.out.println("Enter suburb ");
		suburb = sc.next();
		System.out.println("Enter house type ");
		houseType = sc.next();
		System.out.println("Enter contract months: ");
		contractMonth = sc.nextInt();
		System.out.println("Enter contract years: ");
		contractYear = sc.nextInt();
		System.out.println("Enter rental amount: ");
		rentalAmount = sc.nextInt();
		
		pid = pid + propCount;
		
		Rental rental = new Rental(pid, numBed, numBath, numCarSpace, addr, suburb, houseType, contractMonth,
				contractYear, rentalAmount);
		property.add(rental);
		
		propertyStr = rental.toString() + ",";
		
		try
		{
		    String filename= "Property.txt";
		    FileWriter fw = new FileWriter(filename,true);
		    fw.write(propertyStr + "\n");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
		fullLandlordMenu(userName);
	}



	//menu for employee
	public static void employeeMenu() throws Exception
	{
			
		employeeMainMenu();
	}
			
			
			public static void employeeMainMenu() throws Exception
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
			    	System.out.println("------ Welcome to Real Estate System's Employee Menu -----");
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
			    		mainMenu();
			    		
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
			
			public static void employeeMenu(String employeeID) throws Exception
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
			
			public static void propertyManagerMenu(String empID) throws Exception
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
								Rental rental = (Rental) property.get(index);
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
								Rental rental = (Rental) property.get(pos);
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
								System.out.println(propertyManager.getProperty().get(i).getPropertyDetails());
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
						employeeMainMenu();
						break;
					default:
						System.out.println("Invalid choice.Please enter a number between 1-9");
						break;
					}
				
				}while(!quit);
			}
			
			public static void branchManagerMenu(String empID) throws Exception
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
							for(int i = 0; i < property.size(); i++)
							{
								System.out.println(property.get(i).getPropertyDetails());
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
									branchManager.assignEmployee(employees.get(employeeIndex), property.get(propertyIndex));
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
							employeeMainMenu();
							break;
						
						default:
							System.out.println("Invalid choice.Please enter a number between 1-5");
							break;
					
				 }
			}while(!quit);
						
		  }
			
			public static void salesConsultantMenu(String empID) throws Exception
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
							Sale sale = (Sale) property.get(index);
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
							Sale sale = (Sale) property.get(pos);
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
							System.out.println(salesConsultant.getProperty().get(i).getPropertyDetails());
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
					employeeMainMenu();
					break;
				default:
					System.out.println("Invalid choice.Please enter a number between 1-10");
					break;
				}
				}while(!quit);
					
				
			}
			
			public static void branchAdministratorMenu(String empID) throws Exception
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
						employeeMainMenu();
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
				for(int i = 0; i < property.size(); i++)
				{
					if(propertyID.equalsIgnoreCase(property.get(i).getProperty_id()))
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
	
	//end of employee menu

	
	
	//generate customer id
	private static String getCustomerId(String type) {
		int count = 1;
		String classType  = "";
		String customerId = ""; 
		if(type.equals("1")) {
			classType = "Vendor";
			for(int i = 0; i < customerList.size(); i++)
			{
				if(customerList.get(i).toString().matches(".*Vendor.*")) {
					count++;
				}
			}
			customerId = "VEN"+String.format("%03d", count);
		} else if(type.equals("2")) {
			classType = "Landlord";
			for(int i = 0; i < customerList.size(); i++)
			{
				if(customerList.get(i).toString().matches(".*Landlord.*")) {
					count++;
				}
			}
			customerId = "LAN"+String.format("%03d", count);
		} else if(type.equals("3")) {
			classType = "Rentee";
			for(int i = 0; i < customerList.size(); i++)
			{
				if(customerList.get(i).toString().matches(".*Rentee.*")) {
					count++;
				}
			}
			customerId = "REN"+String.format("%03d", count);
		} else if(type.equals("4")) {
			classType = "Buyer";
			for(int i = 0; i < customerList.size(); i++)
			{
				if(customerList.get(i).toString().matches(".*Buyer.*")) {
					count++;
				}
			}
			customerId = "BUY"+String.format("%03d", count);
		}
		return customerId;
	}
	
	
	//login menu
	public static void login() throws Exception {

		//String abc = getCustomerId("1");
		System.out.println("Enter user: ");
		String userName = sc.next();
		userName= userName.replaceAll("\\r|\\n", "");
		
		System.out.println("Enter password: ");
		String password = sc.next();
		password= password.replaceAll("\\r|\\n", "");
		
		File loginf = new File("customer.txt");
		
	    Scanner read = new Scanner(loginf);
	    read.useDelimiter("\\n|,");
	    boolean loginFlag = false;
	    while(read.hasNext()){
	       String user = read.next().replaceAll("\\r|\\n", "");
	       if(userName.equals(user))
	       {
	    	   while(read.hasNext())
	    	   {
	    		   String pass = read.next().replaceAll("\\r|\\n", "");
	    		   if(password.equals(pass))
	    		   {
	    			   loginFlag = true;
	    			   break;
	    		   }
	    	   }
	    	  break; 
	       }
	    }
	    read.close();
	   
	    if(loginFlag == true) 
	    {
//	    	Scanner reader = new Scanner(loginf);
//		    reader.useDelimiter("\\n|,");
//	    	while(reader.hasNext()){
//	 	        String u1 = reader.next().replaceAll("\\r|\\n", "");
	 	       if(userName.contains("REN")) 
	 	       {
	 	    	  fullRenteeMenu(userName);
	 	       }
	 	       else if(userName.contains("LAN"))
	 	       {
	 	    	  fullLandlordMenu(userName);
	 	       }
	 	       else if(userName.contains("BUY"))
	 	       {
	    		 displayMenu(userName);
	 	       }
	 	       else if (userName.contains("VEN"))
	 	       {
	 	    	  displayMenu(userName);
	 	       }
//	    	}
	    }
	    else  if(loginFlag == false) {
	    	System.out.println("Wrong user and password.");
	    }
	}
	
	public static void displayMenu(String S1) {
		Scanner in = new Scanner(System.in);
		boolean validateInput = true;
		while (validateInput == true) {
			try {
				System.out.println("Welcome "+S1);
				System.out.println("****Real Estate Menu****");
				System.out.println("1. New Auction Property");
				System.out.println("2. New Negotiation Property");
				System.out.println("3. Display my Auction Property");
				System.out.println("4. Display My Negotiation Property");
				System.out.println("5. Display All Properties");
				System.out.println("6. Reply To Auction Property");		
				System.out.println("7. Reply To Negotiation Property");		
				System.out.println("8. Close Property");
				System.out.println("9. Delete Property");
				System.out.println("10. Log Out");
				System.out.println("Enter your choice:"); 
				String a = in.nextLine();
				
				if(a.equals("1")) {
					NewAuctionProperty(S1);
					validateInput = false;
				}
				else if(a.equals("2")) {
					NewNegotiationProperty(S1);
					validateInput = false;
				}
				else if(a.equals("3")) {
					DisplayMyAuctionProperty(S1);
					validateInput = false;
				}
				else if(a.equals("4")) {
					DisplayMyNegotiationProperty(S1);
					validateInput = false;
				}
				else if(a.equals("5")) {
					DisplayAllProperties(S1);
					validateInput = false;
				}
				else if(a.equals("6")) {
					ReplyAuctionProperty(S1);
					validateInput = false;
				}
				else if(a.equals("7")) {
					ReplyNegotiationProperty(S1);
					validateInput = false;
				}
				else if(a.equals("8")) {
					CloseProperty(S1);
					validateInput = false;
				}
				else if(a.equals("9")) {
					DeleteProperty(S1);
					validateInput = false;
				}
				else if(a.equals("10")) {
					customerMenu();
					break;
				}
				else {
					System.out.println("Invalid Choice, please choose between [1-9]");			
				}
			} catch(Exception ex) {
				ex.printStackTrace(); 
				System.out.println("Invalid Choice, please choose between [1-9]");
				
			}
		}
	}
	
	private static void DeleteProperty(String user) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter id of the Post or q to quit:");
		String postId = in.nextLine();

		if(postId.equals("q")) displayMenu(user);
		
		boolean NotFound = false;
		boolean notOwner = true;
		for(Property i : property)
		{
		    if(((Sale) i).getProperty_id().equals(postId)) {
		    	NotFound = true;
		    	if(((Sale)i).getPropertyOwnerID().equals(user) ) {
		    		notOwner = false;
		    		property.remove(i);
		    	}
		    } 
		}
		
		if(NotFound == false) {
			System.out.println("Not Found. Please try again");
			displayMenu(user);
		}

		else if(notOwner == true) {
			System.out.println("you are not owner. Please try again");
			displayMenu(user);
		}
		else {
			System.out.println("Delete successfully");
			displayMenu(user);
		}

	}
	
	private static void CloseProperty(String user) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter id of the Post or q to quit:");
		String postId = in.nextLine();

		if(postId.equals("q")) displayMenu(user);
		
		boolean NotFound = false;
		boolean notOwner = true;
		for(Property i : property)
		{
			if(i.getPropertyOwnerID().equals(user))
			{
				 if(i.getProperty_id().equals(postId)) {
				    	NotFound = true;
				    	if(i.getPropertyOwnerID().equals(user)) {
				    		notOwner = false;
				    		i.setStatus("closed");
				    	}
				  } 
			}
		   
		}
		System.out.println("This action can be performed by property owner only");
		
		if(notOwner == true) {
			System.out.println("you are not owner. Please try again");
			displayMenu(user);
		}
		else if(NotFound == false) {
			System.out.println("Not Found. Please try again");
			displayMenu(user);
		}
		else {
			System.out.println("Closed successfully");
			displayMenu(user);
		}
	
	}
	
	private static void DisplayAllProperties(String user) {
		System.out.println("Display all Properties:");
		System.out.println(property.size());
		
		for(Property i : property)
		{
			if (i instanceof Sale)
			{
				System.out.println(((Sale) i).getPropertyDetails());
			}
			
		}
		displayMenu(user);
	}
	
	private static void DisplayMyAuctionProperty(String user) {//showing nego property as well
		System.out.println("Display my Property:");
		System.out.println(property.size());		
		for(Property i : property)
		{
			if(i.getPropertyOwnerID().equals(user)) {
				if(i.getProperty_id().contains("AUC"))
				{
					System.out.println(((Sale) i).getAuctionPropertyDetails());
					System.out.println(((Sale) i).getAuctionReplyDetails());///////this as well
					System.out.println("----------------------------\n");
					System.out.println("\n");
				}
			}
		}
		displayMenu(user);
	}
	
	private static void DisplayMyNegotiationProperty(String user) {
		System.out.println("Display my Property:");
		System.out.println(property.size());		
		for(Property i : property)
		{
			if(i.getPropertyOwnerID().equals(user)) {
				if(i.getProperty_id().contains("NEG"))
				{
					System.out.println(((Sale) i).getNegotiationPropertyDetails());
				    System.out.println(((Sale) i).getNegotiationReplyDetails());///////this as well
				    System.out.println("----------------------------\n");
				    System.out.println("\n");
				}
			  
			}
		}
		
		displayMenu(user);
	}
	
	private static void NewAuctionProperty(String user) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter details of the Auction property below:");
		System.out.println("Address");
		String Address = in.nextLine();
		System.out.println("Suburb:");
		String suburb = in.nextLine();
		System.out.println("Asking Price:");
		String askingPrice = in.nextLine();
		System.out.println("Minimum raise:");
		String minimumRaise = in.nextLine();
		
		int count = 1;
		for(Property i : property)
		{
			if(i.toString().matches(".*Sale.*")) {
				count++;
			}
		}

		String eventId = "AUC"+String.format("%03d", count);
		Sale postObj = new Sale(eventId, Address, suburb, askingPrice, minimumRaise, user);
		property.add(postObj);
		System.out.println("Success! Auction property created with id "+eventId);

		displayMenu(user);
	}
	
	private static void NewNegotiationProperty(String user) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter details of the Job below:");
		System.out.println("Address:");
		String Address = in.nextLine();
		System.out.println("Suburb:");
		String Suburb = in.nextLine();
		System.out.println("Propose Price:");
		String proposePrice = in.nextLine();
		
		int count = 1;
		for(Property i : property)
		{
			if(i.toString().matches(".*Sale.*")) {
				count++;
			}
		}

		String eventId = "NEG"+String.format("%03d", count);
		Sale postObj = new Sale(eventId, Address, Suburb, proposePrice, user);
		property.add(postObj);
		System.out.println("Success! Your job has been created with id "+eventId);
		displayMenu(user);
	}
	
	private static void ReplyNegotiationProperty(String user) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter id of the Post or q to quit:");
		String postId = in.nextLine();
		if(postId.equals("q")) displayMenu(user);
		else {
		 
		
		boolean NotFound = false;
		boolean closed   = false;
		boolean ownPost  = false;
		for(Property i : property)
		{
			System.out.println("Hello");
		    if(i.getProperty_id().equals(postId) ) {
		    	if (i.getProperty_id().contains("NEG"))
		    	{
		    		NotFound = true;
		    		if(i.getStatus().equals("closed")){
		    		closed = true;
                    break;
		    		}
		    		
		    	}
		    	
		    	if(i.getPropertyOwnerID().equals(user)) {
		    		ownPost = true;
		    		break;
		    	}
		    	//For Negotiation    	
       if(i.toString().matches(".*Sale.*")) {
		    		System.out.println(((Sale)i).getNegotiationPropertyDetails());//*****//yaha p propose price show kar******
    	
		    		
		    		boolean validateInput = true;
		    		while (validateInput == true)
		            {
		    			System.out.println("Enter your offer or q to quit: ");
			    		String replyValueJ = in.nextLine();
			    		boolean isDouble = true;
			    		
			    		if(replyValueJ.equals("q")) {
			    			System.out.println("Quit from negotiation");
			    			validateInput = false;
			    			displayMenu(user);
			    		}
			    		else if(isDouble == true) {
			    		
				    		boolean cheackAlreadyExists = ((Sale) i).checkAlreadyJoin(user);
					    		if(cheackAlreadyExists == true) {
					    		Reply replyObj = new Reply(postId, replyValueJ, user);
			    				boolean flag = ((Sale) i).negotiationReply(replyObj);
			    				if(flag == true) validateInput = false;
			    				
				    		}
					    	
		    				System.out.println("FROM Negotiation LOOP");
		    				displayMenu(user);
			    		}
			    		else {
			    			System.out.println("Invalid offer !");
			    		}
		            }
		    	} 	
		    	
		    }
		}
		
		if(NotFound == false) {
			System.out.println("Not Found. Please try again");
			ReplyNegotiationProperty(user);
		}

		else if(closed == true) {
			System.out.println("you can not reply to closed post. Please try again");
			displayMenu(user);
		}
		else if(ownPost == true) {
			System.out.println("Replying to your own post is invalid.");
			displayMenu(user);
		}
		}
		
	
	}
	
	private static void ReplyAuctionProperty(String user) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter id of the Post or q to quit:");
	String postId = in.nextLine();
	if(postId.equals("q")) displayMenu(user);
	else {
	 
	
	boolean NotFound = false;
	boolean closed   = false;
	boolean ownPost  = false;
	for(Property i : property)
	{
		System.out.println("**Auction Property Details***");
	    if(i.getProperty_id().equals(postId) ) {
	    	if (i.getProperty_id().contains("AUC"))
	    	{
	    		NotFound = true;
		    	
		    	if(i.getStatus().equalsIgnoreCase("closed")) {
		    		closed = true;
	                break;
		    	}
	    	
	    	}
	    	if(i.getPropertyOwnerID().equals(user)) {
	    		ownPost = true;
	    		break;
	    	}
	    	
	    	if(i.toString().matches(".*Sale.*")) {
	    		//System.out.println(i.getPropertyDetails());
	    		System.out.println(((Sale)i).getAuctionPropertyDetails());

	    		boolean validateOffer = true;
	    		while (validateOffer == true)
	            {
	    			System.out.println("Enter your offer or q to quit: ");
		    		String replyValueJ = in.nextLine();
		    		System.out.println("You entered: " +replyValueJ );
		    		boolean isDouble = true;
		    		
		    		if(replyValueJ.equals("q")) {
		    			System.out.println("FROM Sale QUIT");
		    			validateOffer = false;
		    			displayMenu(user);
		    		}
		    		else if(isDouble == true) {
		    			
			    		boolean cheackAlreadyExists = ((Sale) i).checkAlreadyJoin(user);
				    		if(cheackAlreadyExists == true) {
				    		Reply replyObj = new Reply(postId, replyValueJ, user);
				    		boolean flag = ((Sale) i).auctionReply(replyObj);
				    		//boolean flag = (((Sale)i).auctionReply(replyObj)));
		    				if(flag == true) validateOffer = false;
			    		}
	    				
				    	//validateInput = false;
				    		System.out.println("Exit auction");
				    		displayMenu(user);
	                }
		    		else {
		    			System.out.println("Invalid offer !");
		    		}
	            }
	    		
	    	}
	    
	 }
	}//for
	if(NotFound == false) {
		System.out.println("Not Found. Please try again");
		ReplyAuctionProperty(user);
	}

	else if(closed == true) {
		System.out.println("you can not reply to closed post. Please try again");
		displayMenu(user);
	}
	else if(ownPost == true) {
		System.out.println("Replying to your own post is invalid.");
		displayMenu(user);
	}
	}
	}

}
