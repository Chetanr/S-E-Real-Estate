public class Rental extends Property 
{
	private static final double MANAGEMENT_FEE = 0.08;
	private static final double DISCOUNT1 = 0.07;
	private static final double DISCOUNT2 = 0.06;
	private int contract_months;
	private int contract_years;
	private int acceptable_contract_months;
	private int acceptable_contract_years;
	private int proposed_contract_months;
	private int proposed_contract_years;
	private double income;
	private String occupation;
	private String present_employer;
	private static final int ACCEPT_DAYS=3;
	private static final int BOND_PAY_DURATION=1;
	private String Section32_bondStatus;
	
	
	//calculate the management fee for a property
	public void calculateMgmtFee()
	{
		
	}
	
	
	//get the applicant details for the property under rent
	public void getApplicantDetails() 
	{
		
	}
	
	
	//settle the payment
	public void payAdvance()
	{
		
	}


	@Override
	public void negotiateOffer() {
		// TODO Auto-generated method stub
		
	}
}
