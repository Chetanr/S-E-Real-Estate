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
	
	protected static boolean exception = false;
	
	

	

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
		Scanner sc = new Scanner (System.in);
		char ch = 'Y';
		
		double offer;
		if (ch == 'Y')
		{
			while(ch == 'Y')
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
				else
				{
					exception = true;
				}
		
			}
		} 
		
			
		
		
		return fees;
	}
	
	
	protected boolean isException() {
		return exception;
	}




	protected void setException(boolean exception) {
		this.exception = exception;
	}




	//get the applicant details for the property under rent
	public void getApplicantDetails(Customer customer) 
	{
		
		/* retrieve the data from the file
		foreach (Customer c :)
		{
			if (customer.customer_id.Equals(c)) 
			{*/
				setCustomer_id(customer.getCustomer_id());
				setFirstname(customer.getFirstname());
				setSurename(customer.getSurename());
				setIncome(customer.getIncome());
				setOccupation(customer.getOccupation());
				setPresent_employer(customer.getPresent_employer());
			//}
		//}
		
	}
	
	
	//settle the payment
	public boolean payAdvance()
	{
		return true;
	}
	


	


	@Override
	public void negotiateOffer() 
	{
		// TODO Auto-generated method stub
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
		return firstname;
	}


	//accepting the offer
	@Override
	public boolean acceptOffer() 
	{
		if(getNo_of_Days() > DAY_LIMIT)
		{
			return false;
		}
		return true;
	}

	
	
	//getter to get the management fee
	public double getManagementFee() 
	{
		return this.fee;
	}
	
	
	//getter for No_of_Days
	public int getNo_of_Days() 
	{
		return No_of_Days;
	}
	
	
	//getter for fee
	public double getFee() {
		return fee;
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


	private void setIncome(double string) {
		this.income = string;
	}


	private void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	private void setPresent_employer(String present_employer) {
		this.presentEmployer = present_employer;
	}
	

	


	
}
