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
	
	
	//abstract class to negotiate the offer between buyer and seller
	public abstract void negotiateOffer();
	
	
	//transfer the property contract to tenant
	public abstract void finaliseOffer();
	
	
	public abstract boolean acceptOffer();


	public void setTenant_name(String tenant_name) {
		this.tenantName = tenant_name;
	}	
}
