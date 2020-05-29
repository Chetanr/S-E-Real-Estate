
public abstract class Property 
{
	private String propertyID;
	private String address;
	private String suburb;
	private int numBed;
	private int numBath;
	private int numCarSpace;
	private String houseType;
	private String propertyOwnerID;
	private int status;
	
	public Property(String propertyID, String address, String suburb, String propertyOwnerID) {
		super();
		this.propertyID = propertyID;
		this.address = address;
		this.suburb = suburb;
		this.propertyOwnerID = propertyOwnerID;
	}
	
	public String getPropertyDetails() {
    	String propertyDetails = "";
    	propertyDetails += "propertyID: " + this.getPropertyID() + "\n";
    	propertyDetails += "address: "+ this.getAddress() + "\n";
    	propertyDetails += "suburb: "+ this.getSuburb() + "\n";
    	propertyDetails += "propertyOwnerID : "+ this.getPropertyOwnerID() + "\n";
    	propertyDetails += "Status: "+ this.getStatus() +"\n";
    	
    	return propertyDetails;
    }	
	
	public String getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public int getNumBed() {
		return numBed;
	}
	public void setNumBed(int numBed) {
		this.numBed = numBed;
	}
	public int getNumBath() {
		return numBath;
	}
	public void setNumBath(int numBath) {
		this.numBath = numBath;
	}
	public int getNumCarSpace() {
		return numCarSpace;
	}
	public void setNumCarSpace(int numCarSpace) {
		this.numCarSpace = numCarSpace;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getPropertyOwnerID() {
		return propertyOwnerID;
	}
	public void setPropertyOwnerID(String propertyOwnerID) {
		this.propertyOwnerID = propertyOwnerID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
	
