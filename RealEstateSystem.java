import java.util.*;
public class RealEstateSystem 
{
	public static void main(String[] args) 
	{
			Property rentalProperty1 = new Rental ("Henry Street", "Kensington", 2,2,2,"apartment");
			Property rentalProperty2 = new Rental ("Bangalore Street", "Spotswood", 2,2,2,"apartment");
			Property saleProperty1 = new Sale("Conder Street", "Burwood", 2,2,2,"house");
			Property saleProperty2 = new Sale("Henry Street", "Kensington", 2,2,2,"house");
			BranchManager branchManager = new BranchManager("BM001", "welcome123","Branch Manager", "FT", 5000, 0);
			Employee propertyManager1 = new PropertyManager("PM001", "welcome123@","James Isaac", "PT", 0.0, 25.0);
			Employee propertyManager2 = new PropertyManager("PM002", "welcome123!","Mike Johnson", "PT", 0.0, 25.0);
			Employee saleConsultant1 = new SalesConsultant("SC001", "welcome12***3","Jason White", "PT", 0.0, 25.0);
			Employee saleConsultant2 = new SalesConsultant("SC001", "welcome1_#23","Mark Staurt", "PT", 0.0, 25.0);
			//Incorrect Employee assigned exception when trying to assign sales consultant to rental property
			try
			{
				branchManager.assignEmployee(saleConsultant1, rentalProperty1);
			}
			catch(PropertyAlreadyAssignedEmployee e1)
			{
				System.out.println(e1);
			}
			catch(IncorrectEmployeeAssigned e2) 
			{
				System.out.println(e2);
			}
			
			//Incorrect Employee assigned exception when trying to assign sales consultant to rental property
			try
			{
				branchManager.assignEmployee(propertyManager1, saleProperty1);
			}
			catch(PropertyAlreadyAssignedEmployee e1)
			{
				System.out.println(e1);
			}
			catch(IncorrectEmployeeAssigned e2) 
			{
				System.out.println(e2);
			}
			
			
			//Successfully assign rental property to property manager
			try
			{
				branchManager.assignEmployee(propertyManager1, rentalProperty1);
			}
			catch(PropertyAlreadyAssignedEmployee e1)
			{
				System.out.println(e1);
			}
			catch(IncorrectEmployeeAssigned e2) 
			{
				System.out.println(e2);
			}
			
		    //RentalProperty1 is already assigned to propertyManager1, throws PropertyAlreadyAssignedEmployee
			try
			{
				branchManager.assignEmployee(propertyManager2, rentalProperty1);
			}
			catch(PropertyAlreadyAssignedEmployee e1)
			{
				System.out.println(e1);
			}
			catch(IncorrectEmployeeAssigned e2) 
			{
				System.out.println(e2);
			}
			
				
			//Successfully assign sale property to sales consultant
			try
			{
				branchManager.assignEmployee(saleConsultant1, saleProperty1);
			}
			catch(PropertyAlreadyAssignedEmployee e1)
			{
				System.out.println(e1);
			}
			catch(IncorrectEmployeeAssigned e2) 
			{
				System.out.println(e2);
			}
			
			
			
			//Successfully assigns another property to propertyManager1
			try
			{
				branchManager.assignEmployee(propertyManager1, rentalProperty2);
			}
			catch(PropertyAlreadyAssignedEmployee e1)
			{
				System.out.println(e1);
			}
			catch(IncorrectEmployeeAssigned e2) 
			{
				System.out.println(e2);
			}
			//Print all properties assigned to propertyManager1
			PropertyManager propertyManager = (PropertyManager)propertyManager1;
			System.out.println("Displaying all properties assigned to propertyManager1");
			for(int i = 0; i < propertyManager.getProperty().size(); i++ )
			{
				propertyManager.getProperty().get(i).printDetails();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//assign sale property to property manager
			/*try
			{
				branchManager.assignEmployee(propertyManager1, saleProperty1);
			}
			catch(PropertyAlreadyAssignedEmployee e1)
			{
				System.out.println(e1);
			}
			catch(EmployeeAlreadyAssignedProperty e2) 
			{
				System.out.println(e2);
			}
			catch(IncorrectEmployeeAssigned e3) 
			{
				System.out.println(e3);
			}
			
			//assign rental property to salesConsultant
			try
			{
				branchManager.assignEmployee(saleConsultant1, rentalProperty1);
			}
			catch(PropertyAlreadyAssignedEmployee e1)
			{
				System.out.println(e1);
			}
			catch(EmployeeAlreadyAssignedProperty e2) 
			{
				System.out.println(e2);
			}
			catch(IncorrectEmployeeAssigned e3) 
			{
				System.out.println(e3);
			}*/
			
		   
					
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				/*pm1.createInspection(rent);
				for(int i = 0; i < pm1.getInspection().size(); i++)
				{
					System.out.println("-----Inspection------");
					System.out.println(pm1.getInspection().get(0).toString());
				}
				pm1.conductInspection("INS001");
				pm1.cancelInspection("INS001");
				for(int i = 0; i < pm1.getInspection().size(); i++)
				{
					System.out.println("-----Inspection------");
					System.out.println(pm1.getInspection().get(0).toString());
				}*/
				
				
				
				//bm.assignRentalEmployee(pm1, rent, "pm001");
				
				//To test scanning documents
				/*BranchAdministrator ba = new BranchAdministrator("ba001", "welcome123","Branch Administrator", "FT", 5000, 0);
				Customer customer = new Landlord ("soumya", "soan9s9");
				System.out.println(customer);
				customer.setBranchAdmin(ba);
				customer.submitDocument("passport");
				customer.submitDocument("dl");
				System.out.println(customer);*/
				
				/*// TODO Auto-generated method stub
				Employee[] emp = new Employee[2];
				emp[0] = new BranchAdministrator("ba001", "welcome123","James Isaac", "PT", 0.0, 25.0);//PT Employee
				emp[1] = new BranchManager("bm001", "welcome123","Branch Manager", "FT", 5000, 0);
				
				
				//Part time employee entering hours and getting approval from branch manager
				try
				{
					emp[0].checkType((BranchManager)emp[1]);
				}
				catch(HourException e)
				{
					System.out.println(e);
				}
				emp[0].calculateSalary();
				System.out.println("The salary of "+emp[0].getName()+" is "+emp[0].getSalary());*/
				
				
				

		
		
		
	}

}
