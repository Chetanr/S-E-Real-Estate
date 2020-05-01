import java.util.ArrayList;

public class SalesConsultant extends Employee
{
	private static final double RATE = 0.4;
	private String property;
	private ArrayList<Inspection> inspection;
	private boolean createInspection = false;
	public SalesConsultant(String ID,String password , String name, String type, double salary, double hourlyRate)
	{
		super(ID, password, name, type, salary, hourlyRate);
		property = null;
		inspection = new ArrayList<Inspection>();
	}

	
	public void commission()
	{
		
	}
	
	public void advertiseProperty(Sale sale)
	{
		if(this.getID().equalsIgnoreCase(sale.getSalesConsultant()))
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
	public boolean organiseDocs()
	{
		return true;
	}
	public void createInspection(Sale sale)
	{
		if(this.getID().equalsIgnoreCase(sale.getSalesConsultant()))
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
	
	public String getProperty() 
	{
		return property;
	}


	public void setProperty(String property) 
	{
		this.property = property;
	}
	
}
