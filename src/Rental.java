import java.util.Scanner;

public class Rental extends Property 
{
	private static final double MANAGEMENT_FEE = 0.08;
	private static final double DISCOUNT1 = 0.07;
	private static final double DISCOUNT2 = 0.06;
	private double fee;
	private double rentalAmount;
	private int contractMonths;
	private int contractYears;
	private int acceptableContractMonths;
	private int acceptableContractYears;
	private int proposedContractMonths;
	private int proposedContractYears;
	private static final int ACCEPT_DAYS = 3;
	private static final int BOND_PAY_DURATION = 1;	
	private String customer_id ;
	private String firstname;
	private String surename;
	private double income;
	private String occupation;
	private String presentEmployer;
	private String accept;
	
	static Scanner sc = new Scanner (System.in);
	
	

	

	public Rental(int contract_months, int contract_years, int proposed_contract_months, int proposed_contract_years, double rental_amount)
	{
		this.contractMonths = contract_months;
		this.contractYears = contract_years;
		this.proposedContractMonths = proposed_contract_months;
		this.proposedContractYears = proposed_contract_years;
		this.rentalAmount = rental_amount;
	}
	
	
	
	
	public Rental() {
		// TODO Auto-generated constructor stub
	}




	//calculate the management fee for a property
	public double calculateMgmtFee(int property, int rental) throws Exception
	{
		double temp;
		temp = rental * MANAGEMENT_FEE;
		if (property >= 2)
		{
			temp = temp - (temp * DISCOUNT1);
		}
		
		temp = negotiateManagementFee(property, temp);
		System.out.println("Management fees is : " + temp);
		setFee(temp);
		
		return temp;
	}
	

	//negotiate management fee
	public static double negotiateManagementFee(int property, double fees) throws Exception
	{
		char ch = 'Y';
		
		double offer;
		if (ch == 'Y')
		{
			while(ch == 'Y')
			{
				try
				{
					System.out.println("Do you want to negotiate the management fee?: (Y/N)");
					ch = sc.next().charAt(0);
					if (ch == 'Y')
					{
						try
						{
							System.out.println("Enter your offer: ");
							offer = sc.nextDouble();
							if (property == 1)
							{
								if (offer > DISCOUNT1)
								{
									System.out.println("Offer is not acceptable.!");
								} 
								else
								{
									fees = fees - (fees * offer);
									System.out.println("Offer Accepted.!");
									return fees;
								}
							}
							else if (property >= 2)
							{
								if (offer > DISCOUNT2)
								{
									System.out.println("Offer is not acceptable.!");
								} 
								else
								{
									fees = fees - (fees * offer);
									return fees;
								}
									
							}
						} catch (Exception e) {
							System.out.println("Invalid input. Please enter a valid offer");
						}
						
					}
					
				} catch (Exception e)
				{
					System.out.println("Please enter valid input.");
				}
			}
		} 
		
			
		
		
		return fees;
	}
	
	
	//get the applicant details for the property under rent
	public void makeApplication() 
	{
				
	}
	
	
	//view offers by the landlord
	public void viewOffer()
	{
		System.out.println("Rental Amount: " + getRentalAmount());
		System.out.println("Proposed Contract: " + getRentalAmount());
		System.out.println(getProposedContractYears() + " months and " + getProposedContractMonths() + " months");
		System.out.println("Do you want to accept offer?");
		setAccept(sc.next());	
	}


	//get the applicant details for the property under rent
	public void getApplicantDetails(Customer customer) 
	{
				setCustomer_id(customer.getCustomer_id());
				setFirstname(customer.getFirstname());
				setSurename(customer.getSurename());
				setIncome(customer.getIncome());
				setOccupation(customer.getOccupation());
				setPresentEmployer(customer.getPresent_employer());
	}
	
	
	@Override
	public void negotiateOffer() {
		
	}


	@Override
	public boolean acceptOffer() {
		return false;
	}
	

	//settle the payment
	public boolean payAdvance()
	{
		return true;
	}
	
	
	//finalise offer and transfer to tenant
	public void finaliseOffer()
	{
		if (payAdvance())
		{
			setTenant_name(getFirstname());
		}
	}
	
	
	private String getFirstname() {
		return this.firstname;
	}
	
	
	//getter to get the management fee
	public double getManagementFee() 
	{
		return this.fee;
	}
	
	
	//getter for No_of_Days
	public int getNo_of_Days() 
	{
		return this.No_of_Days;
	}
	
	
	//getter for fee
	public double getFee() {
		return this.fee;
	}


	//setter for fee
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	private void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	private void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	private void setSurename(String surename) {
		this.surename = surename;
	}	
	
	
	private double getRentalAmount() {
		return this.rentalAmount;
	}


	public void setRentalAmount(double rentalAmount) {
		this.rentalAmount = rentalAmount;
	}


	public int getProposedContractMonths() {
		return this.proposedContractMonths;
	}


	public void setProposedContractMonths(int proposedContractMonths) {
		this.proposedContractMonths = proposedContractMonths;
	}


	public int getProposedContractYears() {
		return this.proposedContractYears;
	}

	
	public void setProposedContractYears(int proposedContractYears) {
		this.proposedContractYears = proposedContractYears;
	}
	
	
	public String getAccept() {
		return this.accept;
	}


	public void setAccept(String accept) {
		this.accept = accept;
	}
	
	
	public void setIncome(double income) {
		this.income = income;
		
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
		
	}


	public void setPresentEmployer(String presentEmployer) {
		this.presentEmployer = presentEmployer;
		
	}
}
