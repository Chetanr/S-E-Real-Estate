import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class BranchAdministrator extends Employee implements Serializable
{
	private LocalDate currentDate;
	public BranchAdministrator(String ID,String password , String name, String type, double salary, double hourlyRate)
	{
		super(ID, password, name , type, salary, hourlyRate);
	}
	
	
	//Runs Payroll at the end of month
	public void payroll(ArrayList<Employee> employees) throws PayrollException
	{
	    int currentDay = currentDate.getDayOfMonth();
	    Calendar calendar = Calendar.getInstance();
        int payRollDay = calendar.getActualMaximum(Calendar.DATE);
	    if(currentDay == payRollDay)
	    {
	    	for(int i = 0; i < employees.size(); i++)
	    	{
	    		employees.get(i).calculateMonthlySalary();
	    		employees.get(i).setHours(0);
	    		if((employees.get(i) instanceof SalesConsultant))
	    		{
	    			SalesConsultant salesConsultant = (SalesConsultant)employees.get(i);
	    			for(int j = 0; j < salesConsultant.getProperty().size(); j++)
	    			{
	    				salesConsultant.getProperty().get(j).setSalesConsultantCommission(0);
	    			}
	    		}
	    	}
	    	System.out.println("The payroll for "+currentDate+" has been run successfully");
	    }
	    else
	    {
	    	//System.out.println("Unsuccessfull.Payroll runs on the end of every month");
	    	throw new PayrollException("Unsuccessfull.Payroll runs on the end of every month");
	    }
	}
	//Advance the date to specified number of days for testing payroll functionality
	public void advanceDate(long days)
	{
		currentDate = LocalDate.now().plusDays(days);
	}
	//Set date to current date for testing payroll functionality
	public void currentDate()
	{
		currentDate = LocalDate.now();
	}
	
}
