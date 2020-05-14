import java.util.ArrayList;

public class Vendor extends Customer 
{
	private ArrayList<Property> properties;
	public Vendor(String customerName, String emailID)
	{
		super(customerName, emailID);
	}
	
	public void addProperty(Property property)
	{
		properties.add(property);
	}
	
	//can also edit details
}
