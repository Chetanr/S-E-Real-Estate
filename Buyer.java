public class Buyer extends Customer{

	private String buyerId;
	
	public Buyer(String customer_id, String firstname, String surename, String email_address, String password,
			String income, String occupation, String present_employer) {
		super(customer_id, firstname, surename, email_address, password, income, occupation, present_employer);
		
		this.buyerId = customer_id;
	}
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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

	public boolean withdrawOffer() {
		
	    return true;
	}

}