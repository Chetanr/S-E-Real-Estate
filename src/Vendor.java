
public class Vendor extends Customer {
	private String vendor_ID;

	public Vendor(String firstname, String surename, String email_address, String vendor_ID) {
		super(firstname, surename, email_address);
		this.vendor_ID = vendor_ID;
	} 
	 String addsuburb() {return"";}
	 String interestPropertyList() {return"";}
     double makeoffer() {return 0.0;}
     void pricing (double minprice) {}
     
}
