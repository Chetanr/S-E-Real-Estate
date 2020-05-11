abstract class Property 
{
	private String propertyID;
	private String address;
	private String suburb;
	private int numBed;
	private int numBath;
	private int numCarSpace;
	private String houseType;
	private String tenantName;
	private String propertyOwnerID;
	//private Customer cus;
	

	//abstract class to negotiate the offer between buyer and seller
	public abstract void negotiateOffer();

	@Override
	public String toString() {
		return "Property [propertyID=" + propertyID + ", address=" + address + ", numBed=" + numBed + ", numBath="
				+ numBath + ", numCarSpace=" + numCarSpace + ", houseType=" + houseType + ", tenantName="
				+ tenantName + ", propertyOwnerID=" + propertyOwnerID + "]";
	}

	public Property(String propertyID, String address, int numBed, int numBath, int numCarSpace, String houseType,
			String tenantName, String propertyOwnerID) {
		super();
		this.propertyID = propertyID;
		this.address = address;
		this.numBed = numBed;
		this.numBath = numBath;
		this.numCarSpace = numCarSpace;
		this.houseType = houseType;
		this.tenantName = tenantName;
		this.propertyOwnerID = propertyOwnerID;
	}



	public String getpropertyID() {
		return propertyID;
	}

	public void setpropertyID(String propertyID) {
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

	public int getnumBed() {
		return numBed;
	}

	public void setnumBed(int numBed) {
		this.numBed = numBed;
	}

	public int getnumBath() {
		return numBath;
	}

	public void setnumBath(int numBath) {
		this.numBath = numBath;
	}

	public int getnumCarSpace() {
		return numCarSpace;
	}

	public void setnumCarSpace(int numCarSpace) {
		this.numCarSpace = numCarSpace;
	}

	public String gethouseType() {
		return houseType;
	}

	public void sethouseType(String houseType) {
		this.houseType = houseType;
	}

	public String gettenantName() {
		return tenantName;
	}

	public void settenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getPropertyOwnerID() {
		return propertyOwnerID;
	}

	public void setPropertyOwnerID(String propertyOwnerID) {
		this.propertyOwnerID = propertyOwnerID;
	}


	
	
	
}
