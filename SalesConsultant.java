import java.util.ArrayList;
import java.util.*;
public class SalesConsultant extends Employee
{
	private static final double RATE = 0.4;
	private ArrayList<Sale> properties;
	private ArrayList<Inspection> inspection;
	private boolean createInspection;
	private double commission;
	public SalesConsultant(String ID,String password , String name, String type, double salary, double hourlyRate)
	{
		super(ID, password, name, type, salary, hourlyRate);
		inspection = new ArrayList<Inspection>();
		properties = new ArrayList<Sale>();
		createInspection = false;
	}

	
	public void createInspection(Sale sale, String date) throws PropertyNotAssignedToEmployee
	{
		if(sale.getSalesConsultant() == null)
		{
			throw new PropertyNotAssignedToEmployee("Inspection cannot be created as property not assigned to an employee");
		}
		else if(this.getID().equalsIgnoreCase(sale.getSalesConsultant().getID()) && sale.getStatus().equalsIgnoreCase("Open"))
		{
			inspection.add(new Inspection (sale, date, this.getID()));
			System.out.println("Inspection created successfully");
			createInspection = true;
		}
		else if(!(this.getID().equalsIgnoreCase(sale.getSalesConsultant().getID())))
		{
			System.out.println("Only employee assigned to property can create inspection");
		}
		else
		{
			System.out.println("Inspection cannot be created as property is under contract");
		}
	}
	
	public void conductInspection(String inspectionID)
	{
		int index = searchInspection(inspectionID);
		if(createInspection && index >=0 && inspection.get(index).getStatus().equalsIgnoreCase("Created"))
		{
		    inspection.get(index).setStatus("Conducted");
			System.out.println("Inspection conducted successfully");
		}
		else if(index < 0)
		{
			System.out.println("Inspection "+inspectionID+" cannot be conducted as it is not assigned to you");
		}
		else
		{
			System.out.println("Inspection cannot be conducted as it cancelled/already conducted");
		}
		
		
	}
	
	public void cancelInspection(Sale sale) throws PropertyNotAssignedToEmployee
	{
		if(sale.getSalesConsultant() == null)
		{
			throw new PropertyNotAssignedToEmployee("Inspection cannot be cancelled as property not assigned to an employee");
		}
		else if(!(this.getID().equalsIgnoreCase(sale.getSalesConsultant().getID())))
		{
			System.out.println("Only employee assigned to property can cancel inspection");
		}
		else if(sale.getStatus().equalsIgnoreCase("Open"))
		{
			System.out.println("The property should be 'under contract' for inspections to be cancelled");
		}
		else if(this.getID().equalsIgnoreCase(sale.getSalesConsultant().getID()) && sale.getStatus().equalsIgnoreCase("under contract"))
		{
			for(int i = 0; i < inspection.size(); i++)
			{
				if(sale.getPropertyID().equalsIgnoreCase(inspection.get(i).getPropID()))
				{
					System.out.println("Inspection cancelled successfully");
					inspection.get(i).setStatus("Cancelled");
				}
			}
		}
		
	}
	
	public int searchInspection(String inspectionID)
	{
		int index = -1;
		for(int i = 0; i < inspection.size(); i++)
		{
			if(inspectionID.equalsIgnoreCase(inspection.get(i).getInspectionID()))
			{
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void printInspection() 
	{
		
			for (int i = 0; i < inspection.size(); i++) 
			{
				System.out.println(inspection.get(i).toString());
			}
		
	}

	public double getRate()
	{
		return RATE;
	}
	
	public ArrayList<Sale> getProperty() 
	{
		return this.properties;
	}
	public ArrayList<Inspection> getInspection() 
	{
		return this.inspection;
	}
	
	public void setInspection(Inspection ins) 
	{
		inspection.add(ins);
	}


	public void setProperty(Sale property) 
	{
		properties.add(property);
		
	}
	
	public double totalCommission()
	{
		commission = 0;
		for(int i = 0; i < properties.size(); i++)
		{
			commission += properties.get(i).getSalesConsultantCommission();
		}
		return commission;
	}
	public double getCommission()
	{
		return this.commission;
	}
	@Override
	public void calculateMonthlySalary()
	{
		double saleConsultantCommission = totalCommission();
		if(getType().equalsIgnoreCase("PT"))
		{
			setSalaryForMonth((getHourlyRate() * getHours()) + saleConsultantCommission);
		}
		else
		{
			setSalaryForMonth((getSalary() * getHours()) + saleConsultantCommission);
		}
	}
	
	@Override
	public void printDetails()
	{
		super.printDetails();
		if(getProperty().isEmpty())
			System.out.println("No Property assigned to employee");
		else
		{
			System.out.print("Property Assigned:");
			for(int i = 0; i < getProperty().size(); i++)
			{
				System.out.print(getProperty().get(i).getPropertyID()+" ");
			}
			System.out.println();
		}
	}
	
	
}
