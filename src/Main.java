import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int ch = 0;
	static String ch2 = null;
	static int propCount = 1;
	
	static ArrayList<Property> property = new ArrayList<Property>();
	
	
	public static void main(String[] args) {
		
		Rental rent1 = new Rental ("P1", 2, 2, 1, "33 Rose Lane", "Melbourne",  "flat" , 
				6, 1, 1000);
		Rental rent2 = new Rental ("P2", 2, 2, 1, "44 Cleve Lane", "Melbourne",  "flat" , 
				6, 0, 1000);
		
		property.add(rent1);
		property.add(rent2);
		while(ch != 3)
		{
			System.out.println("1. Rentee Login");
			System.out.println("2. Landlord Login");
			System.out.println("3. Quit");
			ch = sc.nextInt();
			if (ch == 1)
			{
				fullRenteeMenu();
			}
			else if (ch == 2)
			{
				fullLandlordMenu();
			}	
		}
	}
	
	
	private static void fullLandlordMenu() {
		String pid = "P";
		System.out.println("1. Add Property");
		System.out.println("2. View offers");
		System.out.println("3. ");
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
	private static void addProperty() {
		String pid = "P";
		int numBed;
		int numBath;
		int numCarSpace;
		int contractMonth;
		int contractYear;
		int rentalAmount;
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
		
	}


	private static  void fullRenteeMenu() {
		String pid;
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

}
