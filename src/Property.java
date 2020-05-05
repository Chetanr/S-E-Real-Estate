
abstract class Property 
{
	private static String property_id;
	private static String address;
	private static String suburb;
	private int num_bed;
	private int num_bath;
	private int num_car_space;
	private String house_type;
	private String tenant_name;
	protected int No_of_Days;
	protected static final int DAY_LIMIT = 3;
	
	
	//abstract class to negotiate the offer between buyer and seller
	public abstract void negotiateOffer();
	
	
	//transfer the property contract to tenant
	public abstract void finaliseOffer();
	
	
	public abstract boolean acceptOffer();


	public String getTenant_name() {
		return tenant_name;
	}


	public void setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
	}
	
	
}
