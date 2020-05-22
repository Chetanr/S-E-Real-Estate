import java.util.ArrayList;

public class PropertyManager extends Employee
{
	private ArrayList<Rental> properties;
	private ArrayList<Inspection> inspection;
	private boolean createInspection;
	public PropertyManager(String ID,String password , String name, String type, double salary, double hourlyRate)
	{
		super(ID, password, name, type, salary, hourlyRate);
		createInspection = false;
		inspection = new ArrayList<Inspection>();
		properties = new ArrayList<Rental>();
	}
	
	
	public void createInspection(Rental rental,String date) throws PropertyNotAssignedToEmployee
	{
		if(rental.getPropertyManager() == null)
		{
			throw new PropertyNotAssignedToEmployee("Inspection cannot be created as property not assigned to an employee");
		}
		else if(this.getID().equalsIgnoreCase(rental.getPropertyManager().getID()) && rental.getStatus().equalsIgnoreCase("Open"))
		{
			inspection.add(new Inspection (rental, date, this.getID()));
			System.out.println("Inspection created successfully");
			createInspection = true;
		}
		else if(!(this.getID().equalsIgnoreCase(rental.getPropertyManager().getID())))
		{
			System.out.println("Only employee assigned to property can create inspection");
		}
		else
		{
			System.out.println("Inspection cannot be created as property is let");
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
			System.out.println("Inspection id cannot be found");
		}
		else
		{
			System.out.println("Inspection cannot be conducted as it cancelled/already conducted");
		}
	}
	
	public void cancelInspection(Rental rental) throws PropertyNotAssignedToEmployee
	{
		if(rental.getPropertyManager() == null)
		{
			throw new PropertyNotAssignedToEmployee("Inspection cannot be cancelled as property not assigned to an employee");
		}
		else if(!(this.getID().equalsIgnoreCase(rental.getPropertyManager().getID())))
		{
			System.out.println("Only employee assigned to property can create inspection");
		}
		else if(rental.getStatus().equalsIgnoreCase("Open"))
		{
			System.out.println("The property should be 'let' for inspections to be cancelled");
		}
		else if(this.getID().equalsIgnoreCase(rental.getPropertyManager().getID()) && rental.getStatus().equalsIgnoreCase("let"))
		{
			for(int i = 0; i < inspection.size(); i++)
			{
				if(rental.getPropertyID().equalsIgnoreCase(inspection.get(i).getPropID()))
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
	
	public ArrayList<Inspection> getInspection() 
	{
		return inspection;
	}

	public ArrayList<Rental> getProperty() 
	{
		return this.properties;
	}
	
	public void printInspection() 
	{
		for (int i = 0; i < inspection.size(); i++) 
		{
			System.out.println(inspection.get(i).toString());
		}
		
	}


	public void setProperty(Rental property) 
	{
		properties.add(property);
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
				System.out.print(getProperty().get(i).getPropertyID());
			}
			System.out.println();
		}
	}


}
