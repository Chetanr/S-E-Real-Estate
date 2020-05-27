import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;




public class RealEstate {
	
	static Scanner sc = new Scanner(System.in);
	static int ch = 0;
	
	static int propCount = 1;
	
	static ArrayList<Property> property = new ArrayList<Property>() ;
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<Property> propertyList = new ArrayList<Property>();
	static ArrayList<Inspection> inspectionList = new ArrayList<Inspection>();

	public static void main(String[] args) throws Exception {
		
		System.out.println("Welcome.!");
		System.out.println("1. Customer Login");
		System.out.println("2. Employee Login");			
		System.out.println("3. Quit");
		
		while (ch != 3)
		{
			ch = sc.nextInt();
			switch (ch)
			{
				case 1: customerMenu();
						break;
				case 2: employeeMenu();
						break;
				case 3: System.exit(0);
				
				default:System.out.println("Invalid input. Please enter a valid input.");
						throw new Exception();
			}
		}
		
	
	}
		
	
	
	//menu for customer
	public static void customerMenu() throws FileNotFoundException, IOException
	{
		System.out.println("----------------------");
		System.out.println("1.Register");
		System.out.println("2.Login");
		
		try
		{
			ch = sc.nextInt();
			
			if (ch == 1)
			{
				register();
			}
			else if (ch == 2)
			{
				login();
			}
		} catch (InputMismatchException e)
		{
			System.out.println("Invalid input. Please enter a valid input");
		}
		
	}
	
	//menu for rentee
	private static  void fullRenteeMenu() {
	
	String pid;
	String propertyStr = "";
	
	int months;
	int years;
	System.out.println("1. apply to property");
	System.out.println("2. view update");
	System.out.println("3. Update payment status");
	ch = sc.nextInt();
	if (ch == 1)
	{
		System.out.println("Enter property id: ");
		pid = sc.next();
		System.out.println("Enter the proposed contract months: ");
		months = sc.nextInt();
		System.out.println("Enter the proposed contract months: ");
		years = sc.nextInt();
		
		if(searchproperty(pid))
		{
			for (Property i : property)
			{
				if(i.getProperty_id().equals(pid))
				{
					//enter customer details here
					
					((Rental) i).setApplicantDetails("R1", "Jack", "Reacher", 20000, "IT", "RMIT", months, years);
					
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
	}
	else if (ch == 2)
	{
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
	else if (ch == 3)
	{
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
					i.finaliseOffer();
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
		
	}
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
	public static void register() throws FileNotFoundException , IOException {
		
		
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

		System.out.println("Enter Emplower: ");
		String custEmployer = sc.next();

		String custId = getCustomerId(custType);
		
		String customerStr = "";
		
		if(custType.equals("1")) {
			Customer customerObj = new Vendor(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Vendor has been created with id "+custId);
			customerStr = customerObj.toString();
			
			customerStr = custType +","+ customerStr;
			
			customerList.add(customerObj);
		}
		else if(custType.equals("2")) {
			Customer customerObj = new Landlord(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Landlord has been created with id "+custId);
			
			customerStr = customerObj.toString();
			
			customerStr = custType +","+ customerStr;
			
			customerList.add(customerObj);
		}
		else if(custType.equals("3")) {
			Customer customerObj = new Rentee(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Rentee has been created with id "+custId);
			
			customerStr = customerObj.toString();
			
			customerStr = custType +","+ customerStr;
			
			customerList.add(customerObj);
		}
		else if(custType.equals("4")) {
			Customer customerObj = new Buyer(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Buyer has been created with id "+custId);
			
			customerStr = customerObj.toString();
			
			customerStr = custType +","+ customerStr;
			
			customerList.add(customerObj);
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
	}
	
	
	//menu for landlord
	private static void fullLandlordMenu() {
		String pid = "P";
		System.out.println("1. Add Property");
		System.out.println("2. View offers");
		ch = sc.nextInt();
		
		if (ch == 1)
		{
			addProperty();	
		}
		else if (ch == 2)
		{
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
		}
	}
	
	
	//adding the property for landlord
	private static void addProperty() {
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
		
	}



	//menu for employee
	public static void employeeMenu()
	{
//		System.out.println("----------------------");
//		System.out.println("1.Login");
//		
//		try
//		{
//			ch = sc.nextInt();
//			
//			if (ch == 1)
//			{
//					
//			}
//			else if (ch == 2)
//			{
//				
//			}
//		} catch (Exception e)
//		{				
//			System.out.println("Invalid input. Please enter a valid input");
//		}		
	}
	
	
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
	public static void login() throws IOException {

		//String abc = getCustomerId("1");
		System.out.println("Enter username: ");
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
	       String pass = read.next().replaceAll("\\r|\\n", "");
	       if(userName.equals(user)  && password.equals(pass)) {
	    	   
	    	   loginFlag = true;
	    	   break;
	       }
	    }
	    read.close();
	   
	    if(loginFlag == true) 
	    {
	    	Scanner reader = new Scanner(loginf);
		    reader.useDelimiter("\\n|,");
	    	while(reader.hasNext()){
	 	       String user = reader.next().replaceAll("\\r|\\n", "");
	 	       if(user.contains("REN")) 
	 	       {
	 	    	  fullRenteeMenu();
	 	       }
	 	       else if(user.contains("LAN"))
	 	       {
	 	    	  fullLandlordMenu();
	 	       }
	 	       else if(user.contains("BUY"))
	 	       {
	    		 //method for buyer menu
	 	       }
	 	       else if (user.contains("VEN"))
	 	       {
	    		 //method for vendor menu
	 	       }
	    	}
	    }
	    else  if(loginFlag == false) {
	    	System.out.println("Wrong username and password.");
	    }
	}

}
