import java.util.ArrayList;

public class Buyer extends Customer
{
	private ArrayList<String> suburbs;
	
	public Buyer(String customerName, String emailID)
	{
		super(customerName, emailID);
	}
	
	public void addSuburbs(String suburb)
	{
		suburbs.add(suburb);
	}
	
	public ArrayList<String> getSuburb()
	{
		return suburbs;
	}
	
	public void getNewProperty()
	{
		
	}
	
	public void bookInspection()
	{
		
	}
	
	public void getInspectionStatus()
	{
		
	}
}
