abstract class Property
{
	private String propertyId;
	private String address;
	private String suburb;
	private int numBed;
	private int numBath;
	private int numCarSpace;
	private String houseType;
	private String tenantName;
	private Inspection inspectionId;
	private String propertyOwnerId;
	private String status;


	public Property(String propertyId, String addr, String suburb, int numBed, int numBath, int numCarSpace,
			String houseType) {
		this.propertyId = propertyId;
		this.address = addr;
		this.suburb = suburb;
		this.numBed = numBed;
		this.numBath = numBath;
		this.numCarSpace = numCarSpace;
		this.houseType = houseType;
		this.tenantName = null;				
	}
	
	
	public Property(String propertyID, String address, String suburb, String propertyOwnerID, String status) {
		super();
		this.propertyId = propertyID;
		this.address = address;
		this.suburb = suburb;
		this.propertyOwnerId = propertyOwnerID;
		this.status = status;
	}



	public void setTenant_name(String tenant_name) {
		this.tenantName = tenant_name;
	}	
	
	public String getProperty_id() {
		return propertyId;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getSuburb()
	{
		return suburb;
	}
	
	public void setPropertyOwnerID(String id)
	{
		this.propertyOwnerId = id;
	}
	
	public String getPropertyOwnerID()
	{
		return propertyOwnerId;
	}
	
	public String getStatus() {
		return this.status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPropertyDetails() {
    	String propertyDetails = "";
    	propertyDetails += "propertyID: " + this.getProperty_id() + "\n";
    	propertyDetails += "address: "+ this.getAddress() + "\n";
    	propertyDetails += "suburb: "+ this.getSuburb() + "\n";
    	propertyDetails += "propertyOwnerID : "+ this.getPropertyOwnerID() + "\n";
    	propertyDetails += "Status: "+ this.getStatus() +"\n";
    	
    	return propertyDetails;
    }	
}
