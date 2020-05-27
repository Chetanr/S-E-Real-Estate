public class Vendor extends Customer{
    private String vendorId;
    private String vendorProperty;
    
	public Vendor(String customer_id, String firstname, String surename, String email_address, String password,
			String custIncome, String occupation, String present_employer) {
		super(customer_id, firstname, surename, email_address, password, custIncome, occupation, present_employer);
		
		this.vendorId = customer_id;
		//this.vendorProperty = vendorProperty;
	}

	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
	public String getVendorProperty() {
		return vendorProperty;
	}
	public void setVendorProperty(String vendorProperty) {
		this.vendorProperty = vendorProperty;
	}
	
	public String createProfile() {
		
	    return "";
	}
	
	
	public double getMinPrice() {
		
		return 0.0;
	}
	
    public void setMinPrice(double minPrice) {
		
	}
    
    public boolean offerAccept() {
    	
    	return true;
    }
	
    public boolean offerWithdraw() {
    	
    	return true;
    }
	

}