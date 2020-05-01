import java.util.*;
public class Employee 
{
	private String ID;
	private String password;
	private String name;
	private double salary;
	private double hours;
	private double hourlyRate;
	private String type;
	
	public Employee(String ID,String password , String name,String type, double salary, double hourlyRate)
	{
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.type = type;
		this.salary = salary;
		this.hourlyRate = hourlyRate;
		this.hours = 0.0;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return this.password;
	}
	
	public String getName()
	{
		return this.name;
	}
	
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
	
	public void checkType(BranchManager bm) throws HourException
	{
		if(type.equalsIgnoreCase("PT"))
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter the number of hours.(Part time employees can work upto 40 hours a month)");
			double hours = scan.nextDouble();
			if(bm.approveHours(this.hours + hours))
			{
				this.hours = this.hours + hours;
				setHours(this.hours);
				System.out.println("Branch Manager has approved the Hours");
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

	public String getID() 
	{
		return ID;
	}

	public void setID(String iD) 
	{
		ID = iD;
	}

	public double getHourlyRate() 
	{
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate)
	{
		this.hourlyRate = hourlyRate;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	
}
