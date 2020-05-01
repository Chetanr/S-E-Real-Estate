import java.util.ArrayList;

public class PropertyManager extends Employee
{
	private String property;
	private ArrayList<Inspection> inspection;
	private boolean createInspection;
	public PropertyManager(String ID,String password , String name, String type, double salary, double hourlyRate)
	{
		super(ID, password, name, type, salary, hourlyRate);
		property = null;
		createInspection = false;
		inspection = new ArrayList<Inspection>();
	}
	
	
	public void advertiseProperty(Rental prop)
	{
		if(this.getID().equalsIgnoreCase(prop.getPropertyManager()))
		{
			System.out.println("The property details are: \n"+prop);
		}
		else
		{
			System.out.println("You cannot advertise the property as you are not assigned to it");
		}
	}
	public void createInspection(Rental rental)
	{
		if(this.getID().equalsIgnoreCase(rental.getPropertyManager()))
		{
			System.out.println(this.getID());
			System.out.println(rental.getPropertyManager());
			
			inspection.add(new Inspection (rental, "22/08/1994", this.getID()));
			System.out.println("Inspection created successfully");
			createInspection = true;
		}
		else
		{
			System.out.println("Inspection cannot be created for property "+rental.getPropertyID());
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
			System.out.println(index);
			System.out.println(createInspection);
			System.out.println("Inspection is not cancelled");
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

	public String getProperty() 
	{
		return property;
	}


	public void setProperty(String property) 
	{
		this.property = property;
	}


	public boolean reviewApplication()
	{
		return true;
	}
	public boolean checkReport()
	{
		return true;
	}
	public boolean organiseWork()
	{
		return true;
	}
	public void payBill()
	{
		
	}
	public void deductFee()
	{
		
	}
}
