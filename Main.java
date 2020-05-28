
import java.util.ArrayList;

import java.util.Scanner;
public class Main {
static ArrayList<Property> propertyList = new ArrayList<Property>();
	
	public static void main(String[] args) {
		DisplayMainMenu();
	}
	public static void DisplayMainMenu() {
		Scanner in = new Scanner(System.in);
		System.out.println("** UniLink System **");
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
	
	public static void login() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter username: ");
		String userName = in.nextLine();
		
		displayMenu(userName);
		in.close();
	}
	
	public static void logout() {
		System.exit(0);
	}
	
	public static void displayMenu(String S1) {
		Scanner in = new Scanner(System.in);
		boolean validateInput = true;
		while (validateInput == true) {
			try {
				System.out.println(" ****Welcome**** "+S1);
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
					DisplayMainMenu();
					validateInput = false;
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
	
	private static void DeleteProperty(String userName) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter id of the Post or q to quit:");
		String postId = in.nextLine();

		if(postId.equals("q")) displayMenu(userName);
		
		boolean NotFound = false;
		boolean notOwner = true;
		for(int i = 0; i < propertyList.size(); i++)
		{
		    if(propertyList.get(i).getPropertyID().equals(postId)) {
		    	NotFound = true;
		    	if(propertyList.get(i).getPropertyOwnerID().equals(userName) ) {
		    		notOwner = false;
		    		propertyList.remove(i);
		    	}
		    } 
		}
		
		if(NotFound == false) {
			System.out.println("Not Found. Please try again");
			displayMenu(userName);
		}

		else if(notOwner == true) {
			System.out.println("you are not owner. Please try again");
			displayMenu(userName);
		}
		else {
			System.out.println("Delete successfully");
			displayMenu(userName);
		}

	}
	
	private static void CloseProperty(String userName) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter id of the Post or q to quit:");
		String postId = in.nextLine();

		if(postId.equals("q")) displayMenu(userName);
		
		boolean NotFound = false;
		boolean notOwner = true;
		for(int i = 0; i < propertyList.size(); i++)
		{
		    if(propertyList.get(i).getPropertyID().equals(postId)) {
		    	NotFound = true;
		    	if(propertyList.get(i).getPropertyOwnerID().equals(userName)) {
		    		notOwner = false;
		    		propertyList.get(i).setStatus(1);
		    	}
		    } 
		}
		
		if(NotFound == false) {
			System.out.println("Not Found. Please try again");
			displayMenu(userName);
		}

		else if(notOwner == true) {
			System.out.println("you are not owner. Please try again");
			displayMenu(userName);
		}
		else {
			System.out.println("Closed successfully");
			displayMenu(userName);
		}
	
	}
	
	private static void DisplayAllProperties(String userName) {
		System.out.println("Display all Properties:");
		System.out.println(propertyList.size());
		
		for(int i = 0; i < propertyList.size(); i++)
		{
			System.out.println(propertyList.get(i).getPropertyDetails());
		}
		displayMenu(userName);
	}
	
	private static void DisplayMyAuctionProperty(String userName) {//showing nego property as well
		System.out.println("Display my Property:");
		System.out.println(propertyList.size());		
		for(int i = 0; i < propertyList.size(); i++)
		{
			if(propertyList.get(i).getPropertyOwnerID().equals(userName)) {
		      //System.out.println(propertyList.get(i).getPropertyDetails());////////figure out this part
			  System.out.println(((Sale) propertyList.get(i)).getAuctionPropertyDetails());
		      System.out.println(((Sale) propertyList.get(i)).getAuctionReplyDetails());///////this as well
		      System.out.println("----------------------------\n");
		      System.out.println("\n");
			}
		}
		
		displayMenu(userName);
	}
	
	private static void DisplayMyNegotiationProperty(String userName) {
		System.out.println("Display my Property:");
		System.out.println(propertyList.size());		
		for(int i = 0; i < propertyList.size(); i++)
		{
			if(propertyList.get(i).getPropertyOwnerID().equals(userName)) {
			  System.out.println(((Sale) propertyList.get(i)).getNegotiationPropertyDetails());
		      //System.out.println(propertyList.get(i).getPropertyDetails());////////figure out this part
		      System.out.println(((Sale) propertyList.get(i)).getNegotiationReplyDetails());///////this as well
		      System.out.println("----------------------------\n");
		      System.out.println("\n");
			}
		}
		
		displayMenu(userName);
	}
	
	private static void NewAuctionProperty(String userName) {
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
		for(int i = 0; i < propertyList.size(); i++)
		{
			if(propertyList.get(i).toString().matches(".*Sale.*")) {
				count++;
			}
		}

		String eventId = "AUC"+String.format("%03d", count);
		Property postObj = new Sale(eventId, Address, suburb, askingPrice, minimumRaise, userName);
		propertyList.add(postObj);
		System.out.println("Success! Auction property created with id "+eventId);

		displayMenu(userName);
	}
	
	private static void NewNegotiationProperty(String userName) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter details of the Job below:");
		System.out.println("Address:");
		String Address = in.nextLine();
		System.out.println("Suburb:");
		String Suburb = in.nextLine();
		System.out.println("Propose Price:");
		String proposePrice = in.nextLine();
		
		int count = 1;
		for(int i = 0; i < propertyList.size(); i++)
		{
			if(propertyList.get(i).toString().matches(".*Sale.*")) {
				count++;
			}
		}

		String eventId = "NEG"+String.format("%03d", count);
		Property postObj = new Sale(eventId, Address, Suburb, proposePrice, userName);
		propertyList.add(postObj);
		System.out.println("Success! Your job has been created with id "+eventId);
		displayMenu(userName);
	}
	
	private static void ReplyNegotiationProperty(String userName) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter id of the Post or q to quit:");
		String postId = in.nextLine();
		if(postId.equals("q")) displayMenu(userName);
		else {
		 
		
		boolean NotFound = false;
		boolean closed   = false;
		boolean ownPost  = false;
		for(int i = 0; i < propertyList.size(); i++)
		{
			System.out.println("Hello");
		    if(propertyList.get(i).getPropertyID().equals(postId) ) {
		    	NotFound = true;
		    	if(propertyList.get(i).getStatus() == 1) {
		    		closed = true;
                    break;
		    	}
		    	if(propertyList.get(i).getPropertyOwnerID().equals(userName)) {
		    		ownPost = true;
		    		break;
		    	}
		    	//For Negotiation    	
       if(propertyList.get(i).toString().matches(".*Sale.*")) {
		    		System.out.println(((Sale)propertyList.get(i)).getNegotiationPropertyDetails());//*****//yaha p propose price show kar******
    	
		    		
		    		boolean validateInput = true;
		    		while (validateInput == true)
		            {
		    			System.out.println("Enter your offer or q to quit: ");
			    		String replyValueJ = in.nextLine();
			    		boolean isDouble = true;
			    		
			    		if(replyValueJ.equals("q")) {
			    			System.out.println("Quit from negotiation");
			    			validateInput = false;
			    			displayMenu(userName);
			    		}
			    		else if(isDouble == true) {
			    		
				    		boolean cheackAlreadyExists = ((Sale) propertyList.get(i)).checkAlreadyJoin(userName);
					    		if(cheackAlreadyExists == true) {
					    		Reply replyObj = new Reply(postId, replyValueJ, userName);
			    				boolean flag = ((Sale) propertyList.get(i)).negotiationReply(replyObj);
			    				if(flag == true) validateInput = false;
			    				
				    		}
					    	
		    				System.out.println("FROM Negotiation LOOP");
		    				displayMenu(userName);
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
			ReplyNegotiationProperty(userName);
		}

		else if(closed == true) {
			System.out.println("you can not reply to closed post. Please try again");
			displayMenu(userName);
		}
		else if(ownPost == true) {
			System.out.println("Replying to your own post is invalid.");
			displayMenu(userName);
		}
		}
		
	
	}
	
	private static void ReplyAuctionProperty(String userName) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter id of the Post or q to quit:");
	String postId = in.nextLine();
	if(postId.equals("q")) displayMenu(userName);
	else {
	 
	
	boolean NotFound = false;
	boolean closed   = false;
	boolean ownPost  = false;
	for(int i = 0; i < propertyList.size(); i++)
	{
		System.out.println("**Auction Property Details***");
	    if(propertyList.get(i).getPropertyID().equals(postId) ) {
	    	NotFound = true;
	    	
	    	if(propertyList.get(i).getStatus() == 1) {
	    		closed = true;
                break;
	    	}
	    	if(propertyList.get(i).getPropertyOwnerID().equals(userName)) {
	    		ownPost = true;
	    		break;
	    	}
	    	
	    	if(propertyList.get(i).toString().matches(".*Sale.*")) {
	    		//System.out.println(propertyList.get(i).getPropertyDetails());
	    		System.out.println(((Sale)propertyList.get(i)).getAuctionPropertyDetails());

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
		    			displayMenu(userName);
		    		}
		    		else if(isDouble == true) {
		    			
			    		boolean cheackAlreadyExists = ((Sale) propertyList.get(i)).checkAlreadyJoin(userName);
				    		if(cheackAlreadyExists == true) {
				    		Reply replyObj = new Reply(postId, replyValueJ, userName);
				    		boolean flag = ((Sale) propertyList.get(i)).auctionReply(replyObj);
				    		//boolean flag = (((Sale)propertyList.get(i)).auctionReply(replyObj)));
		    				if(flag == true) validateOffer = false;
			    		}
	    				
				    	//validateInput = false;
				    		System.out.println("Exit auction");
				    		displayMenu(userName);
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
		ReplyAuctionProperty(userName);
	}

	else if(closed == true) {
		System.out.println("you can not reply to closed post. Please try again");
		displayMenu(userName);
	}
	else if(ownPost == true) {
		System.out.println("Replying to your own post is invalid.");
		displayMenu(userName);
	}
	}
	}
	


}
