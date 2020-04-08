
public abstract class Employee 
{
	private String ID;
	private String name;
	private double salary;
	private String type;
	
	public Employee(String name, String type, double salary)
	{
		this.ID = setID();
		this.name = name;
		this.type = type;
		if(type.equalsIgnoreCase("FT"))
		{
			this.salary = ftSalary(salary);
		}
		else
		{
			this.salary = ptSalary(salary);
		}
	}
	
	public abstract String setID();
	//Hours should be approved by branch manager
	//Salary calculation of part time employees
	public double ptSalary(double salary)
	{
		return this.salary;
	}
	//Salary calculation of full time employees
	public double ftSalary(double salary)
	{
		return this.salary;
	}
	
	public double getSalary()
	{
		return this.salary;
	}
}
