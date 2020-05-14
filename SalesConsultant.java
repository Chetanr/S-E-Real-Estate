import java.util.ArrayList;

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

	
	public void advertiseProperty(Sale sale)
	{
		if(this.getID().equalsIgnoreCase(sale.getSalesConsultant().getID()))
		{
			System.out.println("The property details are: \n"+sale);
		}
		else
		{
			System.out.println("You cannot advertise the property as you are not assigned to it");
		}
	}
	public void liaseVendor()
	{
		
	}
	public void createInspection(Sale sale)
	{
		String salesConsultantID = sale.getSalesConsultant().getID();
		if(this.getID().equalsIgnoreCase(salesConsultantID))
		{
			
			inspection.add(new Inspection (sale, "22/08/1994", this.getID()));
			System.out.println("Inspection created successfully");
			createInspection = true;
		}
		else
		{
			System.out.println("Inspection cannot be created for property "+sale.getPropertyID());
		}
	}
	
	public void conductInspection(String inspectionID)
	{
		int index = searchInspection(inspectionID);
		if(index >=0 && createInspection && inspection.get(index).getStatus().equalsIgnoreCase("Created"))
		{
			System.out.println("Inspection conducted successfully");
		}
		else
		{
			System.out.println("Inspection not conducted successfully");
		}
	}
	
	public void cancelInspection(String inspectionID)
	{
		int index = searchInspection(inspectionID);
		if(index >= 0 && createInspection)
		{
			inspection.get(index).setStatus("Cancel");
			System.out.println("Inspection is cancelled");
		}
		else
		{
			System.out.println("Inspection cannot be cancelled");
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
	
	public ArrayList<Inspection> getInspection() 
	{
		return inspection;
	}

	public void negotiate()
	{
		
	}
	public double getRate()
	{
		return RATE;
	}
	
	public ArrayList<Sale> getProperty() 
	{
		return this.properties;
	}


	public void setProperty(Sale property) 
	{
		properties.add(property);
		
	}
	
	public void calculateCommission()
	{
		for(int i = 0; i < properties.size(); i++)
		{
			commission += properties.get(i).getSalesConsultantCommission();
		}
	}
	@Override
	public void calculateMonthlySalary()
	{
		if(getType().equalsIgnoreCase("PT"))
		{
			setSalaryForMonth((getHourlyRate() * getHours()) + commission);
		}
		else
		{
			setSalaryForMonth((getSalary() * getHours()) + commission);
		}
	}
	
	
}
