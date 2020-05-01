import java.util.Scanner;

public class Rental extends Property 
{
	private static final double MANAGEMENT_FEE = 0.08;
	private static final double DISCOUNT1 = 0.07;
	private static final double DISCOUNT2 = 0.06;
	private double fee;
	private static double rental_amount;
	private int contract_months;
	private int contract_years;
	private int acceptable_contract_months;
	private int acceptable_contract_years;
	private int proposed_contract_months;
	private int proposed_contract_years;
	private static final int ACCEPT_DAYS = 3;
	private static final int BOND_PAY_DURATION = 1;
	private static final int DAY_LIMIT = 3;
	private int No_of_Days;
	private String customer_id ;
	private String firstname;
	private String surename;
	private String income;
	private String occupation;
	private String present_employer;
	
	



	public Rental(int contract_months, int contract_years, int proposed_contract_months, int proposed_contract_years, double rental_amount)
	{
		this.contract_months = contract_months;
		this.contract_years = contract_years;
		this.proposed_contract_months = proposed_contract_months;
		this.proposed_contract_years = proposed_contract_years;
		this.rental_amount = rental_amount;;
	}
	
	
	//calculate the management fee for a property
	public static void calculateMgmtFee(int property, int rental)
	{
		double fees;
		fees = rental * MANAGEMENT_FEE;
		if (property >= 2)
		{
			fees = fees - (fees * DISCOUNT1);
		}
		
		fees = negotiateManagementFee(property, fees);
		System.out.println("Management fees is : " + fees);
	}
	

	//negotiate management fee
	public static double negotiateManagementFee(int property, double fees)
	{
		Scanner sc = new Scanner (System.in);
		String ch = "Y";
		double offer;
		//implementing this method
		while(ch.equals("Y"))
		{
			System.out.println("Do you want to negotiate the management fee?: (Y/N)");
			ch = sc.next();
			if (ch.equals("Y"))
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
					}
						
				}
			}
		}
		
		return fees;
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


	private void setIncome(String income) {
		this.income = income;
	}


	private void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	private void setPresent_employer(String present_employer) {
		this.present_employer = present_employer;
	}

	
}
