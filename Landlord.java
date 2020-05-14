import java.util.ArrayList;

public class Landlord extends Customer
{
	private ArrayList<Property> properties;
	public Landlord(String customerName, String emailID)
	{
		super(customerName, emailID);
	}
	
	public void addProperty(Property property)
	{
		properties.add(property);
	}
	
	//can also edit details
}
