import java.util.ArrayList;
import java.util.Scanner;


public class SEF {

	public static void main(String[] args) {
		DisplayMainMunu();
	}
	
	public static void DisplayMainMunu() {
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
				//DisplayMainMunu();
			}
		}
		
	}
	
	public static void login() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter username: ");
		String userName = in.nextLine();
		
		//displayMenu(userName);
		in.close();
	}
	
	public static void logout() {
		System.exit(0);
	}

}
