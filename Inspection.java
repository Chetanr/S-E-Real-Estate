import java.text.SimpleDateFormat;

public class Inspection 
{
	private String inspectionID;
	private String dateTime;
	private String propID;
	private String empID;
	private String status;
	private Property property;
	private SalesConsultant sc;
	private PropertyManager pm;
	private static int inspectionCounter = 0;
	
	
	public Inspection(Property property ,String dateTime, String empID)
	{
		inspectionID = setInspectionID();
		this.propID = property.getPropertyID();
		this.empID = empID; 
		this.dateTime = dateTime;
		this.status = "Created";
	}
	
	public String setInspectionID()
	{
		inspectionCounter++;
		if(inspectionCounter > 9)
		{
			return "INS" + "0" + inspectionCounter;
		}
		else if(inspectionCounter >= 100)
		{
			return "INS" + "" + inspectionCounter;
		}
		else
		{
			return "INS" + "00" + inspectionCounter;
		}
	}
	
	public String getInspectionID()
	{
		return this.inspectionID;
	}

	public String getPropID() 
	{
		return propID;
	}

	public void setPropID(String propID) 
	{
		this.propID = propID;
	}


	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	public String getDateTime()
	{
		return dateTime;
	}
	
	public String toString()
	{
		return "Property ID :"+propID+'\n'+"Inspection ID :"+inspectionID+"Status :"+status+
				'\n'+"DateTime :"
				+dateTime+'\n'+"Employee id :"+empID;
	}
	
	
	
	
}
