
public class Sale extends Property {
	
	private String auction_negotiation_ID;
	private String present_employer;
	private String inspection_id;
	private double sale_commissionrate;
	private boolean section32_bondstatus;
	private double property_sellingprice;
	private double minimum_sellingprice;
	private String auction_negotiation_date;
	private Double property_askingvalue;
	private boolean offer_status;
	private static final double downpayment = 0.10;
	private double deposit;
	private String auction_inspection_date;
	private String minimum_reserveprice;
	private static final double increasebid_reserveprice=1000;
	private static final double deduce_reserveprice=10000;
	private double maxbid;
	private boolean under_contract=false;
	
	
	public Sale(String present_employer,String auction_negotiation_ID,String inspection_id, double sale_commissionrate,double property_sellingprice,String auction_negotiation_date)
	{
		this.present_employer=present_employer;	
		this.auction_negotiation_ID=auction_negotiation_ID;
		this.inspection_id=inspection_id;
		this.sale_commissionrate=sale_commissionrate;
		this.property_sellingprice=property_sellingprice;
		this.auction_negotiation_date=auction_negotiation_date;
		
	}
	 
	public void Negotiation()
	{
	
		
		//Algo for negotiation
		
	}
	
	public void Auction()
	{
		//Algo for auction
		
	}
	
	
	
	public String getauction_negotiation_ID() {
		return auction_negotiation_ID;
	}



	public void setauction_negotiation_ID(String auction_negotiation_ID) {
		this.auction_negotiation_ID = auction_negotiation_ID;
	}



	public double getSale_commissionrate() {
		return sale_commissionrate;
	}



	public void setSale_commissionrate(double sale_commissionrate) {
		this.sale_commissionrate = sale_commissionrate;
	}


	public double getproperty_sellingprice() {
		return property_sellingprice;
	}
	
	public double getminimum_sellingprice() {
		return minimum_sellingprice;
	}
	
	public void setminimum_sellingprice(double minimum_sellingprice) {
		this.minimum_sellingprice = minimum_sellingprice;
	}



	public boolean setproperty_sellingprice(double property_sellingprice) {
		this.property_sellingprice = property_sellingprice;
		return true;
	}

	@Override
	public void negotiateOffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finaliseOffer() {
		// TODO Auto-generated method stub
		//to be used in auction to obtain the bidder who purchased
		
	}
	
	public void withdrawoffer()
	{
		// algo to withdraw offer 
		//can be used in negotiation
	}
	
	public boolean manageinspection()
	{
		return true;
		//algo to use inspections for both Negotiation and Auction
	}
	
	public void manage_failedauction()
	{
		//tobe used in auction if no valid bids left
		//also handle the situation in which no minimum reserve can be introduced if previously failed to sell without a reserve
	}
	
	public void managecontract()
	{ 
		
	}
	
	}



	
	
	



