import java.util.ArrayList;

public class Landlord extends Customer{

	private String landlordId;
	//private String landlordProperty;
	private ArrayList<Property> landlordProperty = new ArrayList<Property>();
	
	public Landlord(String customer_id, String firstname, String surename, String email_address, String password,
			String income, String occupation, String present_employer) {
		super(customer_id, firstname, surename, email_address, password, income, occupation, present_employer);
		
		this.landlordId       = customer_id;
		//this.landlordProperty = landlordProperty;
	}
	
	public String getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(String landlordId) {
		this.landlordId = landlordId;
	}
	
	/*
	public String getLandlordProperty() {
		return landlordProperty;
	}
	
	public void setLandlordProperty(String LandlordProperty) {
		this.landlordProperty = landlordProperty;
	}
	*/
	
	public String createProfile() {
		
	    return "";
	}

}