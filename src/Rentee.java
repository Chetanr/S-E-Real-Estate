
public class Rentee extends Customer{

	private String renteeId;
	
	public Rentee(String customer_id, String firstname, String surename, String email_address, String password,
			double income, String occupation, String present_employer, String renteeId) {
		super(customer_id, firstname, surename, email_address, password, income, occupation, present_employer);
		
		this.renteeId = renteeId;
	}
	
	public String getRenteeId() {
		return renteeId;
	}
	public void setRenteeId(String renteeId) {
		this.renteeId = renteeId;
	}
	
	public String searchProperty() {
		
	    return "";
	}
	
	public String createProfile() {
		
	    return "";
	}
	public Double proposeOffer() {
		
	    return 0.0;
	}
	

}
