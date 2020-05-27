import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;


public class SEF {
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<Property> propertyList = new ArrayList<Property>();
	static ArrayList<Inspection> inspectionList = new ArrayList<Inspection>();
	
	public static void main(String[] args) {
		initializeData();
		DisplayMainMunu();
	}
	
	private static void initializeData() {
		try {
			File custFile = new File("Customer.txt");
		    Scanner read = new Scanner(custFile);
		    read.useDelimiter("\\n|,");
		    while(read.hasNext()){
		       String custType  = read.next().replaceAll("\\r|\\n", "");
		       String custId    = read.next().replaceAll("\\r|\\n", "");
		       String custName  = read.next().replaceAll("\\r|\\n", "");
		       String surName   = read.next().replaceAll("\\r|\\n", "");
		       String custEmail = read.next().replaceAll("\\r|\\n", "");
		       String custPass  = read.next().replaceAll("\\r|\\n", "");
		       
		       String custIncome = read.next().replaceAll("\\r|\\n", "");
		       String custOccu = read.next().replaceAll("\\r|\\n", "");
		       String custEmployer = read.next().replaceAll("\\r|\\n", "");
		       
				if(custType.equals("1")) {
					Customer customerObj = new Vendor(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
					customerList.add(customerObj);
				}
				else if(custType.equals("2")) {
					Customer customerObj = new Landlord(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
					customerList.add(customerObj);
				}
				else if(custType.equals("3")) {
					Customer customerObj = new Rentee(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
					customerList.add(customerObj);
				}
				else if(custType.equals("4")) {
					Customer customerObj = new Buyer(custId, custName, surName, custEmail, custPass, custIncome, custOccu, custEmployer );
					customerList.add(customerObj);
				}
		    }
		    
		    //property
			File propFile = new File("Property.txt");
		    Scanner propRead = new Scanner(propFile);
		    propRead.useDelimiter("\\n|,");
		    while(propRead.hasNext()){
		        String propertyId      = propRead.next().replaceAll("\\r|\\n", "");
		        String propAddress     = propRead.next().replaceAll("\\r|\\n", "");
		        int propBed            = Integer.parseInt(propRead.next().replaceAll("\\r|\\n", ""));
		        int propBath           = Integer.parseInt(propRead.next().replaceAll("\\r|\\n", ""));
		        int propSpace          = Integer.parseInt(propRead.next().replaceAll("\\r|\\n", ""));
		        String houseType       = propRead.next().replaceAll("\\r|\\n", "");
		        String propTenantName  = propRead.next().replaceAll("\\r|\\n", "");
		        String propOwner       = propRead.next().replaceAll("\\r|\\n", "");
		       
				Property propertyObj = new Property(propertyId, propAddress, propBed, propBath, propSpace, houseType, propTenantName, propOwner );
				propertyList.add(propertyObj);
		    }

		    //inspection
			File insFile = new File("Inspection.txt");
		    Scanner insRead = new Scanner(insFile);
		    insRead.useDelimiter("\\n|,");
		    while(insRead.hasNext()){
		        String inspectionId     = insRead.next().replaceAll("\\r|\\n", "");
		        String insDescription   = insRead.next().replaceAll("\\r|\\n", "");
		        String insDate          = insRead.next().replaceAll("\\r|\\n", "");
		        String insTime          = insRead.next().replaceAll("\\r|\\n", "");
		        String insAgentId       = insRead.next().replaceAll("\\r|\\n", "");
		        String insPropId        = insRead.next().replaceAll("\\r|\\n", "");
	       
		        Property propertyObj = new Property();
				for(int i = 0; i < propertyList.size(); i++)
				{
					if(propertyList.get(i).getProperty_id().equals(insPropId) ) {
						propertyObj = propertyList.get(i); 
					}
				}
		        
				Inspection inspectionObj = new Inspection(inspectionId, insDescription, insDate, insTime, insAgentId, propertyObj );
				inspectionList.add(inspectionObj);
				System.out.println("AFTER READ FILE: " + inspectionList.size());
		    }

		}catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
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
	
	public static void login() throws IOException {

		//String abc = getCustomerId("1");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter username: ");
		String userName = in.nextLine();
		userName= userName.replaceAll("\\r|\\n", "");
		
		System.out.println("Enter password: ");
		String password = in.nextLine();
		password= password.replaceAll("\\r|\\n", "");
		
		File loginf = new File("login.txt");
		
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
	    
	    if(loginFlag == false) {
	    	System.out.println("Wrong username and password.");
	    	DisplayMainMunu();
	    }
	    
	    if(loginFlag == true) {
	    	displayMenu(userName);
	    }
		
	    in.close();
	}
	
	public static void logout() {
		System.exit(0);
	}
	
	public static void displayMenu(String userName) throws FileNotFoundException, IOException {
		Scanner in = new Scanner(System.in);
		
		System.out.println("1. Add Customer");
		System.out.println("2. Add Property");
		System.out.println("3. Add Inspection");
		System.out.println("4. Display Customer");
		System.out.println("5. Display Property");
		System.out.println("6. Display Inspection");
		
		System.out.println("Enter your choice: ");
		
		String userChioce = in.nextLine();
		
		if(userChioce.equals("1") ) {
			addCustomer(userName);
		} else if(userChioce.equals("2")) {
			addProperty(userName);
		} else if(userChioce.equals("3")) {
			addInspection(userName);
		} else if(userChioce.equals("4")) {
			displayCustomer(userName);
		} else if(userChioce.equals("5")) {
			displayProperty(userName);
		} else if(userChioce.equals("6")) {
			displayInspection(userName);
		}
		
		in.close();
	}
	
	/* 
	 * Name : addCustomer
	 * Purpose: Customer info to save
	 * Param: logged In user Name
	 * return: none
	 */
	public static void addCustomer(String userName) throws FileNotFoundException , IOException {
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
		
		displayMenu(userName);
		in.close();
		
	}
	
	
	/* 
	 * Name : addProperty
	 * Purpose: get property info to save
	 * Param: logged In user Name
	 * return: none
	 */
	public static void addProperty(String userName) throws FileNotFoundException, IOException {
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
		System.out.println("Success! Property has been created with id "+propertyId);

		try
		{
		    String filename= "Property.txt";
		    FileWriter fw = new FileWriter(filename,true);
		    fw.write(propertyObj.toString() + "\n");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
		displayMenu(userName);
		in.close();
	}
	
	/* 
	 * Name : addInspection
	 * Purpose: save inspection
	 * Param: logged In user Name
	 * return: none
	 */
	public static void addInspection(String userName) throws FileNotFoundException, IOException {
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
		
		try
		{
		    String filename= "Inspection.txt";
		    FileWriter fw = new FileWriter(filename,true);
		    fw.write(inspectionObj.toString() + "\n");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
		displayMenu(userName);
		in.close();
	}
	
	/* 
	 * Name : displayInspection
	 * Purpose: Display Inspection List
	 * Param: logged In user Name
	 * return: none
	 */
	private static void displayInspection(String userName) throws FileNotFoundException, IOException {
		System.out.println("FROM DISPLAY INSPECTION............");
		for(int i = 0; i < inspectionList.size(); i++)
		{
			System.out.println("ID: "+inspectionList.get(i).getInspectionId() +" "+ 
				"Description: "+inspectionList.get(i).getDescription() +" "+
				"Date: "+inspectionList.get(i).getDate() +" "+
				"Time: "+ inspectionList.get(i).getTime()
			);
		
		}		
		
		displayMenu(userName);
	}

	/* 
	 * Name : displayProperty
	 * Purpose: Display Property List
	 * Param: logged In user Name
	 * return: none
	 */
	private static void displayProperty(String userName) throws FileNotFoundException, IOException {
		for(int i = 0; i < propertyList.size(); i++)
		{
			System.out.println("Property ID: "+propertyList.get(i).getProperty_id() +" "+ 
				"Address: "+propertyList.get(i).getAddress() +" "+
				"Bed: "+propertyList.get(i).getNum_bed() +" "+
				"Bath: "+propertyList.get(i).getNum_bath() +" "+
				"Space: "+propertyList.get(i).getNum_car_space() +" "+
				"Type: "+propertyList.get(i).getHouse_type() +" "+
				"Tanent Name: "+propertyList.get(i).getTenant_name() +" "+
				"Owner ID: "+propertyList.get(i).getPropertyOwnerID()
			);
		
		}
		
		displayMenu(userName);
	}
	
	/* 
	 * Name : displayCustomer
	 * Purpose: Display Customer List
	 * Param: logged In user Name
	 * return: none
	 */
	private static void displayCustomer(String userName) throws FileNotFoundException, IOException {
	
		String custType = "";
		for(int i = 0; i < customerList.size(); i++)
		{
			if(customerList.get(i).toString().matches(".*Vendor.*")) {
				custType = "Vendor";
			} else if(customerList.get(i).toString().matches(".*Landlord.*")) {
				custType = "Landlord";
			} else if(customerList.get(i).toString().matches(".*Rentee.*")) {
				custType = "Rentee";
			} else if(customerList.get(i).toString().matches(".*Buyer.*")) {
				custType = "Buyer";
			}
			
			System.out.println("ID:"+customerList.get(i).getCustomer_id() +" "+ 
				"FirstName:"+customerList.get(i).getFirstname() +" "+ 
				"SurName:"+customerList.get(i).getSurename() +" "+
				"Email:"+customerList.get(i).getEmail() +" "+
				"Type:"+custType
			);
		
		}
		
		displayMenu(userName);
	}
	
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
//        System.out.println(customerId);
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
