
public class Customer {
	
	String customer_id ;
	private String firstname;
	private String surename;
	private String email_address;
	String password;
	private String income;
	private String occupation;
	private String present_employer;
	
	
	protected String getCustomer_id() {
		return customer_id;
	}
	protected void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	protected String getFirstname() {
		return firstname;
	}
	protected void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	protected String getSurename() {
		return surename;
	}
	protected void setSurename(String surename) {
		this.surename = surename;
	}
	protected String getIncome() {
		return income;
	}
	protected void setIncome(String income) {
		this.income = income;
	}
	protected String getOccupation() {
		return occupation;
	}
	protected void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	protected String getPresent_employer() {
		return present_employer;
	}
	protected void setPresent_employer(String present_employer) {
		this.present_employer = present_employer;
	}

}
