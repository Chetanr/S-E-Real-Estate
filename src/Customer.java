
public class Customer {
	private String customerID ;
	private String firstName;
	private String surename;
	private String emailAddress;
	private String password;
	private double income;
	private String occupation;
	private String presentEmployer;
	
	public String getcustomerID() {
		return customerID;
	}
	public void setcustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
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
	public String getpresentEmployer() {
		return presentEmployer;
	}
	public void setpresentEmployer(String presentEmployer) {
		this.presentEmployer = presentEmployer;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", surename=" + surename
				+ ", emailAddress=" + emailAddress + ", income=" + income + ", occupation="
				+ occupation + ", presentEmployer=" + presentEmployer + "]";
	}
	public Customer(String customerID, String firstName, String surename, String emailAddress, String password,
			double income, String occupation, String present_employer) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.surename = surename;
		this.emailAddress = emailAddress;
		this.password = password;
		this.income = income;
		this.occupation = occupation;
		this.presentEmployer = presentEmployer;
	}
}
