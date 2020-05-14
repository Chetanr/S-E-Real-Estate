
public class Rental extends Property
{
	private PropertyManager propertyManager;
	public Rental(String address, String suburb, int noOfRoom, int noOfBath, int noOfCarPark, String type)
	{
		super(address,suburb, noOfRoom, noOfBath, noOfCarPark, type);
		propertyManager = null;
	}
	
	public PropertyManager getPropertyManager() 
	{
		return this.propertyManager;
	}

	public void setPropertyManager(PropertyManager propertyManager) 
	{
		this.propertyManager = propertyManager;
	}
	@Override
	public void printDetails()
	{
		System.out.println("----Rental property Details----");
		super.printDetails();
		if(propertyManager != null)
			System.out.println("Property Manager:"+propertyManager.getID());
		else
			System.out.println("No property manager has been assigned to the property");
		
	}
	
}
