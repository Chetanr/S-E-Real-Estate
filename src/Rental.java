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
	private int proposedContractMonths;
	private int proposedContractYears;
	private static final int ACCEPT_DAYS = 3;
	private static final int BOND_PAY_DURATION = 1;	
	private String customer_id ;
	private String firstname;
	private String surName;
	private double income;
	private String occupation;
	private String presentEmployer;
	private Rentee renteeId;
	private Landlord landlordId;
	private PropertyManager propertyManager;
	
	
	static Scanner sc = new Scanner (System.in);
	

	public Rental(String propertyId, int numBed, int numBath, int numCarSpace, String addr, String suburb, String houseType,  int contract_months, int contract_years, double rental_amount)
	{
		super (propertyId, addr, suburb, numBed, numBath, numCarSpace, houseType);
		this.contractMonths = contract_months;
		this.contractYears = contract_years;
		this.rentalAmount = rental_amount;
	}
	
	public PropertyManager getPropertyManager() 
	{
		return this.propertyManager;
	}

	public void setPropertyManager(PropertyManager propertyManager) 
	{
		this.propertyManager = propertyManager;
	}


	//calculate the management fee for a property
	public double calculateMgmtFee(int property, double rental) throws Exception
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
	
	
	//view offers by the landlord
	public void viewOffer()
	{
		String response;
		System.out.println("Applicant name: " + getFirstname());
		System.out.println("Occupation: " + getOccupation());
		System.out.println("Income: " + getIncome());
		System.out.println("Rental Amount: " + getRentalAmount());
		System.out.println("Proposed Contract: ");
		System.out.println(getProposedContractYears() + " years and " + getProposedContractMonths() + " months");
		System.out.println("Do you want to accept offer?");
		response = sc.next();
		setStatus(response);	
	}

	
	private String getOccupation() {
		return occupation;
	}


	public void setApplicantDetails(String cid, String firstName, String surName, 
			double income, String occupation, String presentEmp, int proposedMonths, int proposedYears)
	{
		setCustomerId(cid);
		setFirstname(firstName);
		setSurname(surName);
		setIncome(income);
		setOccupation(occupation);
		setPresentEmployer(presentEmp);
		setProposedContractMonths(proposedMonths);
		setProposedContractYears(proposedYears);
	}
	
	public void getApplicantDetails() 
	{
		System.out.println("Proposed Contract months: " + getProposedContractMonths());
		System.out.println("Proposed Contract years: " + getProposedContractYears());
		System.out.println("Income : " + getIncome());
	}


	private double getIncome() {
		return this.income;
	}


	public boolean acceptOffer() {
		setStatus("accept");
		return true;
	}
	

	//settle the payment
	public boolean payAdvance()
	{
		return true;
	}
	
	
	//finalise offer and transfer to tenant
	public void finaliseOffer()
	{
		if (payAdvance() && getStatus().equalsIgnoreCase("accept"))
		{
			setTenant_name(getFirstname());
			setStatus("let");
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
	
	
	//getter for fee
	public double getFee() {
		return this.fee;
	}


	//setter for fee
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public void setCustomerId(String customer_id) {
		this.customer_id = customer_id;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public void setSurname(String surename) {
		this.surName = surename;
	}	
	
	
	public double getRentalAmount() {
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
