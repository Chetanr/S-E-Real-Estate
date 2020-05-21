abstract class Property
{
	private String property_id;
	private String address;
	private String suburb;
	private int numBed;
	private int numBath;
	private int numCarSpace;
	private String houseType;
	private String tenantName;
	private Inspection inspectionId;
	protected static final int DAY_LIMIT = 3;


	public Property(String propertyId, String addr, String suburb, int numBed, int numBath, int numCarSpace,
			String houseType) {
		this.property_id = propertyId;
		this.address = addr;
		this.suburb = suburb;
		this.numBed = numBed;
		this.numBath = numBath;
		this.numCarSpace = numCarSpace;
		this.houseType = houseType;
		this.tenantName = null;
		
		
	}
	
	
	//transfer the property contract to tenant
	public abstract void finaliseOffer();
	
	
	public abstract boolean acceptOffer();


	public void setTenant_name(String tenant_name) {
		this.tenantName = tenant_name;
	}	
	
	public String getProperty_id() {
		return property_id;
	}
}
