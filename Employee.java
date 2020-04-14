import java.util.*;
public abstract class Employee 
{
	private String ID;
	private String name;
	private double salary;
	private double hours;
	private double hourlyRate;
	private String type;
	//private BranchManager bm;
	
	public Employee(String name, String type, double salary, double hourlyRate)
	{
		this.ID = setID();
		this.name = name;
		this.type = type;
		this.salary = salary;
		this.hourlyRate = hourlyRate;
		this.hours = 0.0;
	}
	
	public abstract String setID();
	//Hours should be approved by branch manager
	//Salary calculation of part time employees
	public double calculateSalary()
	{
		if(type.equalsIgnoreCase("FT"))
		{
			return this.salary;
		}
		else
		{
			this.salary = hourlyRate * hours;
			return this.salary;
		}
		
	}
	
	public void enterHours(BranchManager bm) throws HourException
	{
		if(type.equalsIgnoreCase("PT"))
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the number of hours");
			double hours = scan.nextDouble();
			if(bm.approveHours(hours))
			{
				setHours(hours);
				System.out.println("Hours Approved");
			}
			else
			{
				System.out.println("Branch manager approval for hours entered has been refused");
			}
		}
		else
		{
			System.out.println("Only part time employees are allowed to enter hours");
		}
	}
	
	public double getSalary()
	{
		return this.salary;
	}
	
	public void setHours(double hours)
	{
		this.hours = hours;
	}
	
	public double getHours()
	{
		return this.hours;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
}
