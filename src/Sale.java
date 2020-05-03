import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Sale extends Property {
	
	private double sale_commissionrate;
	private static double property_sellingprice;
	private static double minimum_sellingprice=5000;
	private String auction_negotiation_date;
	private String auction_negotiation_inspection_date;
	private double property_askingvalue;
	private int auction_status;
	private static final double downpaymentpercentage = 0.10;
	private static double deposit;
	private String auction_inspection_date;
	private String minimum_reserveprice;
	private int increasebid_reserveprice=1000;
	private static final double deduce_reserveprice=10000;
	private String maxbid;
	private static int No_ofDays=1;
	private boolean under_contract=false;
	private static final int daylimit=3;
	private static double formaloffer;
	private static boolean test1=false;
	private static double downpayment;
	private String creator;
	
	
	

	private ArrayList<reply> responseList=new ArrayList<reply>();
	private ArrayList<Sale> propertyList=new ArrayList<Sale>();
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {	
		this.creator = creator;
	}
	
	public int getAuction_status() {
		return auction_status;
	}

	public void setAuction_status(int auction_status) {
		this.auction_status = auction_status;
	}

	
	public String getMaxbid() {
		return maxbid;
	}

	public void setMaxbid(String maxbid) {
		this.maxbid = maxbid;
	}
	
	public String getAuction_negotiation_inspection_date() {
		return auction_negotiation_inspection_date;
	}

	public String setAuction_negotiation_inspection_date(String auction_negotiation_inspection_date) {
		return this.auction_negotiation_inspection_date = auction_negotiation_inspection_date;
	}

	public String getAuction_negotiation_date() {
		return auction_negotiation_date;
	}

	public  String setAuction_negotiation_date(String auction_negotiation_date) {
		return this.auction_negotiation_date = auction_negotiation_date;
	}
	public String getMinimum_reserveprice() {
		return minimum_reserveprice;
	}

	public void setMinimum_reserveprice(String Minimum_reserveprice)//auction
	{
		try {
			int minimum_reserveprice=Integer.parseInt(this.getMinimum_reserveprice());
		if(minimum_reserveprice>=0) 
		this.minimum_reserveprice = Minimum_reserveprice;
		}catch(Exception e)
		{
			System.out.println("You have entered a negative value,Try again");
		}
	}
	
	Scanner sc=new Scanner(System.in);
	
	
	public Sale(String present_employer,String auction_negotiation_ID,String inspection_id, double sale_commissionrate,double property_sellingprice,String auction_negotiation_date)
	{
		this.sale_commissionrate=sale_commissionrate;
		this.property_sellingprice=property_sellingprice;
		this.auction_negotiation_date=auction_negotiation_date;
		
	}
	 
	
	public void checkcommisionrate()//negotiation
	//commission rate between vendor and sales consultant is decided 
	{
		Scanner bo=new Scanner(System.in);
	  System.out.println("Enter the commision rate that is negotiated between the Sale Consultant and the vendor ");
	  double SaleCommisionrate= bo.nextDouble();
	  try {
		  if(SaleCommisionrate>=2 && SaleCommisionrate<=5)
		  {
			  setSale_commissionrate(SaleCommisionrate);// this is given to sale consultant for the final selling price
		  }
		  
	  }catch(Exception e)
	  {
		  System.out.println("Kindly enter between 2 and 5");
	  }
	  
		
	}
	
	public boolean isUnder_contract() {
		return under_contract;
	}

	public static void setUnder_contract(boolean under_contract) {
		under_contract = under_contract;
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
	this.minimum_sellingprice=minimum_sellingprice;		
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
	public static double getFormaloffer() {
		return formaloffer;
	}
	public static void setFormaloffer(double formaloffer) {
		Sale.formaloffer = formaloffer;
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
	public void managecontract() {
		//method to manage the contract
	}

	
	public void manageAuctionInspection(Property property_id) throws ParseException //auction
	{
		Scanner ur=new Scanner(System.in);
		
		// a vendor enters the inspection date for his property before the auction date comparing the inspection date and auction date
	    
		System.out.println("Enter the auction date that you want for the " + property_id + "in the format (yyyy-mm-dd)");
	    String D=ur.next();  
	    if(compareDates(D,getAuction_negotiation_date())== true)
	    {
	    	//setting of inspection date is done
	    	setAuction_negotiation_inspection_date(D);
	    }
	    else
	    {
	    	System.out.println("The auction Date can't be before the initial auction Date");
	    }
	}
	
	public static boolean compareDates(String psDate1, String psDate2) throws ParseException {
       //method to compare dates
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        Date date1 = dateFormat.parse(psDate1);
        Date date2 = dateFormat.parse(psDate2);
        if(date2.after(date1)) {
            return true;
        } else {
            return false;
        }
    }
	public static boolean acceptoffer() //negotiation
	{ 	
		
		Scanner no=new Scanner(System.in);
		System.out.println("Enter an offer: ");
		double formaloffer = no.nextDouble();	
		setFormaloffer(formaloffer);
		if(minimum_sellingprice>formaloffer)
			System.out.println("Offer cannot be made as threshold not met");
		else
		{
			System.out.println("Enter the no days vendor took to respond");
			int No_ofDays=no.nextInt();
				if(No_ofDays<daylimit)
				{
					System.out.println("type yes if you want to accept the offer");
					String answer=no.next();
					if(answer.equalsIgnoreCase("yes"))
					{
						System.out.println("Offer is ACCepted");				
					}
					return true;
				}
				else {
					System.out.println("Offer not accepted! No of days exceed the day limit");
				}
		}	
		return false;	
	}
	public static boolean section32() //negotiation
	{
		Scanner io= new Scanner(System.in);		
		System.out.println("Enter response to section 32");
		String rep=io.next();
		if(rep== ("yes"))
		{
			System.out.println("section32_bondstatus is present ");	
			return true;
		
		}
		else
		{
			return false;
		}
	}
	public static boolean checkdownpayment() //negotiation
	{
		Scanner uo=new Scanner(System.in);
		property_sellingprice=formaloffer;
		downpayment=property_sellingprice*downpaymentpercentage;
		

				if(No_ofDays <= 1)
				{
					test1=true;
					System.out.println("Accept downpayment from the buyer?");
					String accept=uo.next();
					if(accept.equalsIgnoreCase("yes"))
					{
						System.out.println("Downpayment is received");
					}
					else
					{
						System.out.println("You have rejected the Downpayment and offer");
					}		
				}
				else {
					System.out.println("you have exceeded the 24 hour limit");
				}
		return test1;	
	}	
	public static void checkdeposit() //negotiation
	{
		Scanner dep=new Scanner(System.in);
		deposit=property_sellingprice-downpayment;		
				//legal formalities
				System.out.println("Customer is making a deposit do u want to accept which is $" +deposit);
				String reply=dep.next();
				if(reply.equalsIgnoreCase("YES"))
				{
					System.out.println("Deposit made");
					setUnder_contract(true);
					System.out.println("The property is under undercontract");
					//assignSaleEmployee();
				}
				else
				{
				System.out.println("Deposit not made");	
				}			
			}
	
	public boolean confirmJoin(String replyID) //checks if already a buyer and bidded
	{
		for(int i=0;i<this.responseList.size();i++)
		{
			if(this.responseList.get(i).getreplyID().equals(replyID))
			{
				System.out.println("you have already made a bid");
				return false;
			}
		}
		return true;
	}
	
	
	public boolean auctionreply(reply Reply) { //auction
	 int minimum_reserveprice=Integer.parseInt(this.getMinimum_reserveprice());
	int replyValue = Integer.parseInt(Reply.getreplyValue());
	int maxbid=0;
	if(this.getMaxbid()!="")
	maxbid=Integer.parseInt(this.getMaxbid());
	
	
	
	if(replyValue<0)
	{
		System.out.println("The Bid can never be negative");
	}
	else if(replyValue<increasebid_reserveprice)
	{
		System.out.println("Offer is below minimum raise");
	}
	else if(replyValue<increasebid_reserveprice+maxbid)
	{
		System.out.println("Bid is not accepted");
		return false;
	}
	else if(replyValue>increasebid_reserveprice+maxbid)
	{
		this.responseList.add(Reply);
		System.out.println("Bid acknowledged, Auction continues");
	}
	
	else
	{
		if(this.getMaxbid()=="")
			this.setMaxbid(Reply.getreplyValue());
		else if(Integer.parseInt(this.getMaxbid())>Integer.parseInt(Reply.getreplyValue()))
		this.setMaxbid(Reply.getreplyValue());	
	}
	this.responseList.add(Reply);
	System.out.println("Highest bid is obtained");
				return false;
		
	}
	
	public void propertyreply(String customer)//auction
	{
		Scanner rw=new Scanner(System.in);
		System.out.println("Enter Property ID or quit");
		String auctionID=rw.nextLine();
		if(auctionID.equals("q"))
		{
			//implement displaymenu
			System.out.println("Go to main menu");
		}
		boolean propertyNotPresent=false;
		boolean auctionClosed=false;
		boolean selfProperty=false;
		boolean validatebid=true;
		for(int i=0;i<propertyList.size();i++)
		{
			if(propertyList.get(i).getProperty_id().equals(auctionID))
			{
				propertyNotPresent=true;
			}
			if(propertyList.get(i).getAuction_status()==1)
			{
				auctionClosed=true;
				break;
			}
			if(propertyList.get(i).getCreator().equals(customer))
			{
				selfProperty=true;
				break;
			}
			while(validatebid==true)
			{
				System.out.println("Enter your offer or q to quit");
				String bid =rw.nextLine();
				System.out.println("Your Bid is " + bid);
				boolean checkDouble =true;
				try
				{
					Double bidoffer=Double.parseDouble(bid);
					
				}catch(NumberFormatException e)
				{
					checkDouble=false;
				}
				if(bid.equals("q"))
				{
					System.out.println("Quit from sale");
					validatebid=false;
				}
				else if(checkDouble==true)
				{
					boolean checkExisting=propertyList.get(i).confirmJoin(customer);
					if(checkExisting==true)
					{
						reply replyObject=new reply(auctionID,bid,customer);
						boolean test=propertyList.get(i).auctionreply(replyObject);
						if(test1==true)
							validatebid=false;
					}
				}
					else {
						System.out.println("Invalid Bid!");
					}
				}
			}
		     if(propertyNotPresent==false)
		     {
		    	 System.out.println("Property not found. Kindly Try again");
		    	 propertyreply(customer);	    	 
		     }
		     else if(auctionClosed==true) {
		    	 System.out.println("You cannot reply to a closed post");
		    	 //main menu
		     }
		     else if(selfProperty==true)
		     {
		    	 System.out.println("You can't do a bid for your own property");
		     }
		     else
		     {      
		    	 System.out.println("We should be in main menu");
		     }	
		}
	
	

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println(" Welcome! Type yes if u a vendor ");
		String ans=sc.next();
		if(ans.equalsIgnoreCase("yes"))
		{
			acceptoffer();
			System.out.println("Check with the customer if He/She has legal Documentation(section32)");
			section32();
			checkdownpayment();
			
			System.out.println("Downpayment you have received is "+downpayment);
			checkdeposit();		
		}
		else
		{
			System.out.println("Functionality not implemented");
		}	
	}

	
	}
