
public class Inspection {

	private int inspectionId;
	private String description;
	private String date;
	private String time;
	private String agentId;
	private int status; // 0- created, 1 - cancelled, 2 - completed
	
	public Inspection( int inspectionId, String description, String date, String time, String agentId) {
		this.inspectionId = inspectionId;
		this.description  = description;
		this.date         = date;
		this.time         = time;
		this.agentId      = agentId;
		this.status       = 0;
		notifyBuyerOrRentee();
	}
	
    public int getInspectionId() {
	    return inspectionId;
	}

	public void setInspectionId(int inspectionId) {
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
		
		
	}
	
}
