import java.util.ArrayList;

public class Inspection {

	private String inspectionId;
	private String description;
	private String date;
	private String time;
	private String agentId;
	private int status; // 0- created, 1 - cancelled, 2 - completed
	private ArrayList<Property> propertyList = new ArrayList<Property>();
	
	public Inspection( String inspectionId, String description, String date, 
			String time, String agentId, Property propertyObj) {
		this.inspectionId = inspectionId;
		this.description  = description;
		this.date         = date;
		this.time         = time;
		this.agentId      = agentId;
		this.status       = 0;
		
		this.propertyList.add(propertyObj);
		notifyBuyerOrRentee();
	}
	
    public String getInspectionId() {
	    return inspectionId;
	}

	public void setInspectionId(String inspectionId) {
	    this.inspectionId = inspectionId;
	}
	
    public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}
	
    public String getDate() {
	    return date;
	}

	public void setDate(String date) {
	    this.date = date;
	}
	
    public String getTime() {
	    return time;
	}

	public void setTime(String time) {
	    this.time = time;
	}
	
    public String getAgentId() {
	    return agentId;
	}

	public void setAgentId(String agentId) {
	    this.agentId = agentId;
	}

    public int getStatus() {
	    return status;
	}

	public void setStatus(int status) {
	    this.status = status;
	    notifyBuyerOrRentee();
	}
	
	public void notifyBuyerOrRentee() {
		System.out.println("Notify Buyer and Rentee");
		
	}
	
}