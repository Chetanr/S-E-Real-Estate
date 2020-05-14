import java.util.ArrayList;

public class BranchManager extends Employee 
{   
	private ArrayList<Property> properties;

	public BranchManager(String ID,String password , String name, String type, double salary, double hourlyRate)
	{
		super(ID, password, name, type, salary, hourlyRate);
	}
	
	
	public void assignEmployee(Employee employee, Property property) throws PropertyAlreadyAssignedEmployee, IncorrectEmployeeAssigned
	{
		if((employee instanceof SalesConsultant) && (property instanceof Sale))
		{
			SalesConsultant salesConsultant = (SalesConsultant)employee;
			Sale saleProperty = (Sale)property;
			if (saleProperty.getSalesConsultant() != null)
			{
				throw new PropertyAlreadyAssignedEmployee("A property can be assigned to only one employee. The property "+property.getPropertyID()+" is assigned to sales consultant "+saleProperty.getSalesConsultant().getID());
			}
			else
			{
				saleProperty.setSalesConsultant(salesConsultant);
				salesConsultant.setProperty(saleProperty);
				System.out.println("Successfully assigned property with id "+property.getPropertyID()+" to "+salesConsultant.getID());
			}
		}
		else if((employee instanceof PropertyManager) && (property instanceof Rental))
		{
			PropertyManager propertyManager = (PropertyManager)employee;
			Rental rentalProperty = (Rental)property;
			if(rentalProperty.getPropertyManager() != null)
			{
				throw new PropertyAlreadyAssignedEmployee("A property can be assigned to only one employee.The property "+property.getPropertyID()+" is assigned to property manager "+rentalProperty.getPropertyManager().getID());
			}
			else
			{
				rentalProperty.setPropertyManager(propertyManager);
				propertyManager.setProperty(rentalProperty);
				System.out.println("Successfully assigned property with id "+property.getPropertyID()+" to "+propertyManager.getID());
			}
		}
		else 
		{
			throw new IncorrectEmployeeAssigned("Sales Consultant should be assigned Sale Property. Property Manager should be assigned to a Rental property");
		}
		
	}
	
	
	public boolean approveHours(double hours) throws HourException
	{
		if(hours < 0)
		{
			throw new HourException("Please enter a positive value for hours");
		}
		else if(hours <= 40)
		{
			return true;
		}
		else
		{
			return false;
		}
	}



	
	
}
