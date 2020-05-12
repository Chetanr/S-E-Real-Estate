
public class Landlord extends Customer{

	private String landlordId;
	private String landlordProperty;
	
	public Landlord(String customer_id, String firstname, String surename, String email_address, String password,
			double income, String occupation, String present_employer, String landlordId, String landlordProperty) {
		super(customer_id, firstname, surename, email_address, password, income, occupation, present_employer);
		
		this.landlordId       = landlordId;
		this.landlordProperty = landlordProperty;
	}
	
	public String getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(String landlordId) {
		this.landlordId = landlordId;
	}
	
	public String getLandlordProperty() {
		return landlordProperty;
	}
	public void setLandlordProperty(String LandlordProperty) {
		this.landlordProperty = landlordProperty;
	}
	
	public String createProfile() {
		
	    return "";
	}

}
