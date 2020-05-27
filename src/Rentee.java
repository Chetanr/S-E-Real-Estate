public class Rentee extends Customer{

	private String renteeId;
	
	public Rentee(String customer_id, String firstname, String surename, String email_address, String password,
			String custIncome, String occupation, String present_employer) {
		super(customer_id, firstname, surename, email_address, password, custIncome, occupation, present_employer);
		
		this.renteeId = customer_id;
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