
public class Customer {
	protected String customer_id ;
	protected String firstname;
	protected String surename;
	protected String email_address;
	protected String password;
	protected double income;
	protected String occupation;
	protected String present_employer;
	
	public Customer(String customer_id, String firstname, String surename, String email_address, String password,
			double income, String occupation, String present_employer) {

		this.customer_id      = customer_id;
		this.firstname        = firstname;
		this.surename         = surename;
		this.email_address    = email_address;
		this.password         = password;
		this.income           = income;
		this.occupation       = occupation;
		this.present_employer = present_employer;
	}
	
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPresent_employer() {
		return present_employer;
	}
	public void setPresent_employer(String present_employer) {
		this.present_employer = present_employer;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstname=" + firstname + ", surename=" + surename
				+ ", email_address=" + email_address + ", income=" + income + ", occupation="
				+ occupation + ", present_employer=" + present_employer + "]";
	}
	
	
	public String searchProperty() {
		
	    return "";
	}

	public String createProfile() {
		
	    return "";
	}
	
	public boolean register() {
		
	    return true;
	}
	
	public void application() {
		
	}
}
