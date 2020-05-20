import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class SEF {
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<Property> propertyList = new ArrayList<Property>();
	static ArrayList<Inspection> inspectionList = new ArrayList<Inspection>();
	
	public static void main(String[] args) {
		DisplayMainMunu();
	}
	
	public static void DisplayMainMunu() {
		Scanner in = new Scanner(System.in);
		System.out.println("** Real State System **");
		boolean validateInput = true;
		while (validateInput == true) {
			try {
				System.out.println("1. Log in");
				System.out.println("2. Quit");
				System.out.println("Enter your choice: ");
				String a = in.nextLine();
				
				if(a.equals("1") ) {
					login();
					validateInput = false;
				}
				else if(a.equals("2") ) {
					logout();
					validateInput = false;
				}
				else {
					System.out.println("Invalid Choice from menu"); 
				}
			} catch(Exception ex) {
				System.out.println("Invalid Choice");
			}
		}
		
	}
	
	public static void login() throws FileNotFoundException {

	    
		Scanner in = new Scanner(System.in);
		System.out.println("Enter username: ");
		String userName = in.nextLine();
		
		System.out.println("Enter password: ");
		String password = in.nextLine();
		
		File loginf = new File("login.txt");
		
	    Scanner read = new Scanner(loginf);
	    read.useDelimiter("\\n|,");
	    boolean login = false;
	    while(read.hasNext()){
	       String user = read.next();
	       String pass = read.next();
	       //System.out.println(user + " " + pass);
	       
	       if(user == userName && pass == password) {
	    	   displayMenu(userName);
	       }
	    }
	    
		//displayMenu(userName);
		in.close();
	}
	
	public static void logout() {
		System.exit(0);
	}
	
	public static void displayMenu(String userName) {
		Scanner in = new Scanner(System.in);
		System.out.println("1. Add Customer");
		System.out.println("2. Add Property");
		System.out.println("3. Add Inspection");
		System.out.println("4. Display Customer");
		System.out.println("5. Display Property");
		System.out.println("6. Display Inspection");
		
		String userChioce = in.nextLine();
		
		if(userChioce == "1") {
			addCustomer(userName);
		} else if(userChioce == "2") {
			addProperty(userName);
		} else if(userChioce == "3") {
			addInspection(userName);
		} else if(userChioce == "4") {
			displayCustomer(userName);
		} else if(userChioce == "5") {
			displayProperty(userName);
		} else if(userChioce == "6") {
			displayInspection(userName);
		}
		
		in.close();
	}
	
	public static void addCustomer(String userName) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		String custName = in.nextLine();

		System.out.println("Enter surname: ");
		String surName = in.nextLine();

		System.out.println("Enter Email: ");
		String custEmail = in.nextLine();

		System.out.println("Enter Password: ");
		String custPass = in.nextLine();
		
		System.out.println("Enter Customer type(1-> Vendor, 2->Landlord, 3->Rentee, 4->Buyer,): ");
		String custType = in.nextLine();
		
		System.out.println("Enter Income: ");
		String custIncome = in.nextLine();
		
		System.out.println("Enter Occupation: ");
		String custOccu = in.nextLine();

		System.out.println("Enter Emplower: ");
		String custEmployer = in.nextLine();

		String custId = getCustomerId(custType);
		
		if(custType == "1") {
			Customer customerObj = new Vendor(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Vendor has been created with id "+custId);
		}
		else if(custType == "2") {
			Customer customerObj = new Landlord(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Landlord has been created with id "+custId);
		}
		else if(custType == "3") {
			Customer customerObj = new Rentee(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Rentee has been created with id "+custId);
		}
		else if(custType == "4") {
			Customer customerObj = new Buyer(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
			customerList.add(customerObj);
			System.out.println("Success! Buyer has been created with id "+custId);
		}
		
		in.close();
		displayMenu(userName);
	}
	
	public static void addProperty(String userName) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter address: ");
		String propAddress = in.nextLine();
		
		System.out.println("Enter No of Bed: ");
		int propBed = in.nextInt();
		
		System.out.println("Enter No of Bath: ");
		int propBath = in.nextInt();
		
		System.out.println("Enter No of Car Space: ");
		int propSpace = in.nextInt();
		
		System.out.println("Enter House Type: ");
		String houseType = in.nextLine();
		
		System.out.println("Enter tenant name: ");
		String propTenantName = in.nextLine();
		
		System.out.println("Owner ID: ");
		String propOwner = in.nextLine();
		
		String propertyId = getPropertyId();
		
		Property propertyObj = new Property(propertyId, propAddress, propBed, propBath, propSpace, houseType, propTenantName, propOwner );
		propertyList.add(propertyObj);
		System.out.println("Success! Vendor has been created with id "+propertyId);

		
		in.close();
		
		displayMenu(userName);
	}
	
	public static void addInspection(String userName) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Property Id: ");
		String insPropId = in.nextLine();
		
		System.out.println("Enter Description: ");
		String insDescription = in.nextLine();
		
		System.out.println("Enter Date: ");
		String insDate = in.nextLine();
		
		System.out.println("Enter Time: ");
		String insTime = in.nextLine();
		
		System.out.println("Enter AgentId: ");
		String insAgentId = in.nextLine();
		
		Property propertyObj = new Property();
		for(int i = 0; i < propertyList.size(); i++)
		{
			if(propertyList.get(i).getProperty_id().equals(insPropId) ) {
				propertyObj = propertyList.get(i); 
			}
		}
		String inspectionId = getInspectionId();
		Inspection inspectionObj = new Inspection(inspectionId, insDescription, insDate, insTime, insAgentId, propertyObj );
		inspectionList.add(inspectionObj);
		System.out.println("Success! inspection has been created with id "+inspectionId);		
		
		in.close();
		
		displayMenu(userName);
	}
	
	private static void displayInspection(String userName) {
		for(int i = 0; i < inspectionList.size(); i++)
		{
			//Display the inspection
		
		}		
		
		displayMenu(userName);
	}

	private static void displayProperty(String userName) {
		for(int i = 0; i < propertyList.size(); i++)
		{
		    //Display the property	
		
		}
		
		displayMenu(userName);
	}

	private static void displayCustomer(String userName) {
	
		for(int i = 0; i < customerList.size(); i++)
		{
			//Display the Customer
		
		}
		
		displayMenu(userName);
	}
	
	private static String getCustomerId(String type) {
		int count = 1;
		String classType  = "";
		String customerId = ""; 
		if(type == "1") {
			classType = "Vendor";
			for(int i = 0; i < customerList.size(); i++)
			{
				if(customerList.get(i).toString().matches(".*Vendor.*")) {
					count++;
				}
			}
			customerId = "VEN"+String.format("%03d", count);
		} else if(type == "2") {
			classType = "Landlord";
			for(int i = 0; i < customerList.size(); i++)
			{
				if(customerList.get(i).toString().matches(".*Landlord.*")) {
					count++;
				}
			}
			customerId = "LAN"+String.format("%03d", count);
		} else if(type == "3") {
			classType = "Rentee";
			for(int i = 0; i < customerList.size(); i++)
			{
				if(customerList.get(i).toString().matches(".*Rentee.*")) {
					count++;
				}
			}
			customerId = "REN"+String.format("%03d", count);
		} else if(type == "4") {
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
	
	public static String getPropertyId() {
		String propertyId = "";
		int count = 1;
		for(int i = 0; i < propertyList.size(); i++)
		{
			if(propertyList.get(i).toString().matches(".*Property.*")) {
				count++;
			}
		}
		propertyId = "PRO"+String.format("%03d", count);
		
		return propertyId;
	}

	public static String getInspectionId() {
		String inspectionId = "";
		int count = 1;
		for(int i = 0; i < inspectionList.size(); i++)
		{
			if(inspectionList.get(i).toString().matches(".*Inspection.*")) {
				count++;
			}
		}
		inspectionId = "INS"+String.format("%03d", count);
		
		return inspectionId;
	}

}
