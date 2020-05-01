
public class BranchAdministrator extends Employee
{
	public BranchAdministrator(String ID,String password , String name, String type, double salary, double hourlyRate)
	{
		super(ID, password, name , type, salary, hourlyRate);
	}

	public boolean receiveDoc()
	{
		return true;
	}
	public void scanDoc(Customer customer, String document)
	{
		customer.setDocuments(document);
		
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
