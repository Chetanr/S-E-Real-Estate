
public class BranchAdministrator extends Employee
{
	private static int baCounter = 0;
	
	public BranchAdministrator(String name, String type, double salary, double hourlyRate)
	{
		super(name, type, salary, hourlyRate);
	}
	
	public String setID()
	{
		return " ";
	}
	
	public boolean receiveDoc()
	{
		return true;
	}
	public boolean scanDoc()
	{
		return true;
	}
	public void collectRent()
	{
		
	}
	public void creditAmt()
	{
		
	}
	public void payroll()
	{
		
	}
}
