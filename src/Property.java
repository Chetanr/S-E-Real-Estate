public class Property 
{
	private String property_id;
	private String address;
	private static String suburb;
	private int num_bed;
	private int num_bath;
	private int num_car_space;
	private String house_type;
	private String tenant_name;
	private String propertyOwnerID;


	//abstract class to negotiate the offer between buyer and seller
	//public abstract void negotiateOffer();

	@Override
	public String toString() {
		return "Property [property_id=" + property_id + ", address=" + address + ", num_bed=" + num_bed + ", num_bath="
				+ num_bath + ", num_car_space=" + num_car_space + ", house_type=" + house_type + ", tenant_name="
				+ tenant_name + ", propertyOwnerID=" + propertyOwnerID + "]";
	}

	public Property(String property_id, String address, int num_bed, int num_bath, int num_car_space, String house_type,
			String tenant_name, String propertyOwnerID) {
		this.property_id = property_id;
		this.address = address;
		this.num_bed = num_bed;
		this.num_bath = num_bath;
		this.num_car_space = num_car_space;
		this.house_type = house_type;
		this.tenant_name = tenant_name;
		this.propertyOwnerID = propertyOwnerID;
	}
	
	public Property() {
		
	}

	public String getProperty_id() {
		return property_id;
	}

	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static String getSuburb() {
		return suburb;
	}

	public static void setSuburb(String suburb) {
		Property.suburb = suburb;
	}

	public int getNum_bed() {
		return num_bed;
	}

	public void setNum_bed(int num_bed) {
		this.num_bed = num_bed;
	}

	public int getNum_bath() {
		return num_bath;
	}

	public void setNum_bath(int num_bath) {
		this.num_bath = num_bath;
	}

	public int getNum_car_space() {
		return num_car_space;
	}

	public void setNum_car_space(int num_car_space) {
		this.num_car_space = num_car_space;
	}

	public String getHouse_type() {
		return house_type;
	}

	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}

	public String getTenant_name() {
		return tenant_name;
	}

	public void setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
	}

	public String getPropertyOwnerID() {
		return propertyOwnerID;
	}

	public void setPropertyOwnerID(String propertyOwnerID) {
		this.propertyOwnerID = propertyOwnerID;
	}


}