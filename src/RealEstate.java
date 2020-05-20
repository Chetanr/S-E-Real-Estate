import java.util.*;


public class RealEstate {
	
	static Scanner sc = new Scanner(System.in);
	static int ch = 0;

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
	public static void customerMenu()
	{
		System.out.println("----------------------");
		System.out.println("1.Register");
		System.out.println("2.Login");
		
		try
		{
			ch = sc.nextInt();
			
			if (ch == 1)
			{
				
			}
			else if (ch == 2)
			{
				
			}
		} catch (Exception e)
		{
			System.out.println("Invalid input. Please enter a valid input");
		}
		
	}
	
	
	//menu for employee
	public static void employeeMenu()
	{
		System.out.println("----------------------");
		System.out.println("1.Login");
		
		try
		{
			ch = sc.nextInt();
			
			if (ch == 1)
			{
					
			}
			else if (ch == 2)
			{
				
			}
		} catch (Exception e)
		{				
			System.out.println("Invalid input. Please enter a valid input");
		}		
	}

}
