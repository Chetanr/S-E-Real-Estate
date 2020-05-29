import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;




public class RealEstate {
	
	static Scanner sc = new Scanner(System.in);
	static int ch = 0;
	
	static int propCount = 1;
	
	static String user;
    static String pass;
	
	static ArrayList<Property> property = new ArrayList<Property>();
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<Inspection> inspectionList = new ArrayList<Inspection>();

	public static void main(String[] args) throws Exception {
		
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
					case 3: break;
				}
			} catch (InputMismatchException e)
			{
				System.out.println("Invalid input. Please enter a valid input");
			}
//		}
		
		
	}
	
	//menu for rentee
	private static  void fullRenteeMenu() {
	
	String pid;
	System.out.println("1. apply to property");
	System.out.println("2. view update");
	System.out.println("3. Update payment status");
	System.out.println("4. Logout");
	ch = sc.nextInt();
	
	switch(ch)
	{
		case 1: applyToProperty();
				break;
		case 2: viewUpdate();
				break;
		case 3: updatePayment();
				break;
		case 4: break;
	}
}
	
	private static void updatePayment() {
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



	private static void applyToProperty() {
		String pid;
		int months;
		int years;
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
					for(Customer j : customerList)
					{
						if(j.getCustomer_id().equals(user))
						{
							((Rental) i).setApplicantDetails(j.getCustomer_id(), j.getFirstname(), j.getSurename(), j.getIncome(), j.getOccupation(), j.getPresent_employer(), months, years);
						}
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
			
	}
	
	
	//menu for landlord
	private static void fullLandlordMenu() throws Exception {
		String pid = "P";
		System.out.println("1. Add Property");
		System.out.println("2. View offers");
		System.out.println("3. Negotiaite Management Feee");
		System.out.println("4. Logout");
		ch = sc.nextInt();
		
		switch(ch)
		{
			case 1: addProperty();
					break;
			case 2: offer();
					break;
			case 3: negotiateFee();
					break;
			default: break;
					
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



	private static void offer() {
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
	       user = read.next().replaceAll("\\r|\\n", "");
	       if(userName.equals(user))
	       {
	    	   while(read.hasNext())
	    	   {
	    		   pass = read.next().replaceAll("\\r|\\n", "");
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
	 	    	  fullRenteeMenu();
	 	       }
	 	       else if(userName.contains("LAN"))
	 	       {
	 	    	  fullLandlordMenu();
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
