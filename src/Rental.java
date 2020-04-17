import java.util.Scanner;

public class Rental extends Property 
{
	private static final double MANAGEMENT_FEE = 0.08;
	private static final double DISCOUNT1 = 0.07;
	private static final double DISCOUNT2 = 0.06;
	private double fee;
	private double rental_amount;
	private int contract_months;
	private int contract_years;
	private int acceptable_contract_months;
	private int acceptable_contract_years;
	private int proposed_contract_months;
	private int proposed_contract_years;
	private double income;
	private String occupation;
	private String present_employer;
	private static final int ACCEPT_DAYS = 3;
	private static final int BOND_PAY_DURATION = 1;
	private static final int DAY_LIMIT = 3;
	private int No_of_Days;
	



	public Rental(int contract_months, int contract_years, int proposed_contract_months, int proposed_contract_years, double income, String occupation, String present_employer, double rental_amount)
	{
		this.contract_months = contract_months;
		this.contract_years = contract_years;
		this.proposed_contract_months = proposed_contract_months;
		this.proposed_contract_years = proposed_contract_years;
		this.income = income;
		this.occupation = occupation;
		this.present_employer = present_employer;
		this.rental_amount = rental_amount;;
	}
	
	
	//calculate the management fee for a property
	public double calculateMgmtFee(int property)
	{
		double fees;
		fees = rental_amount * MANAGEMENT_FEE;
		if (property >= 2)
		{
			fees = fees - (fees * DISCOUNT1);
		}
		
		fees = negotiateManagementFee(property, fees);
		setFee(fee);
		return fee;
	}
	

	//negotiate management fee
	public double negotiateManagementFee(int property, double fees)
	{
		Scanner sc = new Scanner (System.in);
		String ch;
		int offer;
		//implementing this method
		System.out.println("Do you want to negotiate the management fee?: (Y/N)");
		ch = sc.next();
		if (ch.equals("Y"))
		{
			System.out.println("Enter your offer in %: ");
			offer = sc.nextInt();
			if (property >= 2)
			{
				if (offer > DISCOUNT1)
				{
					System.out.println("Offer is no acceptable.!");
				} 
				else
				{
					fees = fees - (fees * offer);
				}
			}
		}
		return fees;
	}
	
	
	//get the applicant details for the property under rent
	public void getApplicantDetails() 
	{
		//yet to implement the method
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
		//working on this method
		if (payAdvance())
		{
			setTenant_name("abc");
		}
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


	public double getIncome() 
	{
		return this.income;
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

	
	
}
