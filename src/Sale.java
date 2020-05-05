import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Sale extends Property {
	
	private String property_id;
	public String getProperty_id() {
		return property_id;
	}

	public String setProperty_id(String property_id) {
		return this.property_id = property_id;
	}




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
	
	private static int increasebid_reserveprice=1000;
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
	private static ArrayList<Sale> propertyList=new ArrayList<Sale>();
	
	
		
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
	

	
	
	Scanner sc=new Scanner(System.in);
	
	
	public Sale(String property_id,String address)
	{
		this.property_id=property_id;
		this.address=address;
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
		//property_sellingprice=formaloffer;
		//property_sellingprice=highestoffer;
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
	

	
	/*public boolean confirmJoin(String replyID)//auction
	//checks if already a buyer and bidded
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
	*/
	
	
	
	
	public void manageAuctionInspection(Property property_id) throws ParseException //auction
	{
		Scanner ur=new Scanner(System.in);
		
		// a vendor enters the inspection date for his property before the auction date comparing the inspection date and auction date
	    
		System.out.println("Enter the auction date that you want for the " + property_id + "in the format (yyyy-mm-dd)");
	    String D=ur.next();  
	    if(compareDates(D,getAuction_negotiation_date())== true)
	    {
	    	//setting of inspection date is done for buyers to come
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
	
	private static void NewProperty(String customer)//to add a property
	{
		Scanner np=new Scanner(System.in);
		System.out.println("Enter the specs of the property");
		System.out.println("Address");
		String propertyAddress=np.nextLine();
		int count=1;
		String auctionID="AUC"+String.format("%03d", count);
		Property propertyobject=new Sale(auctionID,address);
		propertyList.add((Sale) propertyobject);
		System.out.println("Success!! Property has been added with id " + auctionID );
		
	}
	
	public static void propertyreply(String customer)//auction
	//customer will come when u login 
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
			
				propertyNotPresent=true;
			
			  if(propertyList.get(i).getAuction_status()==1)
			    {
				auctionClosed=true;
				break;
			    }
			/*if(propertyList.get(i).getCreator().equals(customer))
			{
				selfProperty=true;
				break;
			}*/
			while(validatebid==true)
			{
				System.out.println("Enter your offer or q to quit");
				double bid =rw.nextDouble();
				
				
				System.out.println("Your Bid is " + bid);
				double highestoffer=100000;
			    double asking_price=20000;
				
				if(bid <0)
				{
					System.out.println("Kindly try a valid positive bid above asking price");
				}
				else if(bid<increasebid_reserveprice)//increasebid_reserve=1000
			    {
						System.out.println("Offer is below minimum raise");
			    }
				else if(bid < asking_price) {
					System.out.println("Your Bid is below the asking price ");	
				}
				else if(bid>(increasebid_reserveprice + highestoffer) && bid<asking_price)//if highestoffer=1300 asking price=2000
				{
					System.out.println("Offer is below asking price");
				}
				else if(bid>increasebid_reserveprice + highestoffer)//bid=
				{
					
					System.out.println("Highest bid is recorded");
					highestoffer=bid;
					Scanner po=new Scanner(System.in);
					System.out.println("check if no one else is biding for the next 30 seconds");
					String check=po.nextLine();
					if(check.equalsIgnoreCase("No"))
					{
						System.out.println("Property Sold to you,Selling Price for the Propert is "+highestoffer);
						property_sellingprice=highestoffer;
						double initiadownpayment=property_sellingprice*0.10;
						System.out.println("Your initial downpayment is " +initiadownpayment);
						System.out.println("Do u wish to pay the downpayment $"+initiadownpayment+ "within 1 day");
						String check1=po.nextLine();
						if(check1.equalsIgnoreCase("yes"))
						{
							if(No_ofDays <= 1)
							
								{
									System.out.println("Downpayment is received");
									
									deposit=(property_sellingprice-initiadownpayment);
									
									System.out.println(" Do you want to submit the deposit which is $" +deposit);
									String check2=po.next();
									if(check2.equalsIgnoreCase("YES"))
									{
										System.out.println("Deposit made");
										setUnder_contract(true);
										System.out.println("The property is under undercontract");
										//assignSaleEmployee();
										break;
									}
									else
									{
									System.out.println("Deposit not made");	
									System.out.println("You refued to pay the deposit Property again goes to auction");
									double newAskingPrice=asking_price-10000;
									System.out.println("New asking Price foe the property is"+ newAskingPrice );
									
									}			
								}
							else {
								System.out.println("you have exceeded the 24 hour limit");
							}
						}
						else {
							System.out.println("You refued to pay the downpayment Property again goes to auction");
							double newAskingPrice=asking_price-10000;
							System.out.println("New asking Price foe the property is"+ newAskingPrice );
						}
						}	
					}
				else if(bid<highestoffer && bid>asking_price)
				{
					System.out.println("offer accepted and recorded however not heightest ");
					double secondHighestBid=bid;
					
				}
				else {
					System.out.println("invalid Bid");
				}
				
				
			
				
				
				//reply responseobject=new reply(auctionID, bid, customer);
				//boolean test=propertyList.get(i).auctionreply(responseobject);
			}
		}
				
			/*	//boolean checkDouble =true;
				/*try
				{
					//Double bidoffer=double.parseDouble(bid);
					double bidd=Double.parseDouble(bid);
					
					
				}catch(NumberFormatException e)
				{
					checkDouble=false;
				}
				if(bid.equals("q"))
				{
					System.out.println("Quit from sale");
					validatebid=false;
				}*/
				//if(checkDouble==true)
				//{
					//{	
						//boolean test=propertyList.get(i).auctionreply(replyObject);
						//if(test==true)
							//validatebid=false;
					//}
				//}
				//	else {
						//System.out.println("Invalid Bid!");
				//	}
				//}
			}
		    /* if(propertyNotPresent==false)
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
		}*/
	/*public boolean auctionreply() { //auction
		System.out.println("Enter the Minimum asking price ");
		 int asking_price=5000;
		
		 
		 
		
		int maxbid=0;
		if(this.getMaxbid()!="")
		{
		maxbid=Integer.parseInt(this.getMaxbid());
		}
		
		
		
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
			
		}*/
	
	public String getReplyDetails() {
		String Offer_History = "Offer History: ";
		String Asking_price = "Asking price: " + this.getAskingPrice()+"\n";
		
		ArrayList<reply> replyLists = this.responseList;
		Collections.sort(replyLists, reply.ReplyComparatorDesc);
		
		for(int i = 0; i < replyLists.size(); i++)
		{
			Offer_History += replyLists.get(i).getreplyID()+ " : " + replyLists.get(i).getreplyValue()+"\n";
		}
		return Asking_price + Offer_History+"\n";
	}
	
	

	private String getAskingPrice() {
				// TODO Auto-generated method stub
				return null;
			}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
	/*	System.out.println(" Welcome! Type yes if u a vendor ");
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
	
	*/
		System.out.println("Enter the customer name");
		String customername= sc.nextLine();
		NewProperty(customername);
		propertyreply(customername);
		
	}
	
	}
