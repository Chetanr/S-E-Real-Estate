import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Sale extends Property {
	
	public Sale(String propertyID, String address, int numBed, int numBath, int numCarSpace, String houseType,
			String tenantName, String propertyOwnerID) {
		super(propertyID, address, numBed, numBath, numCarSpace, houseType, tenantName, propertyOwnerID);
		// TODO Auto-generated constructor stub
	}
	private double saleCommissionRate;
	private double propertySellingPrice;
	private double minimumSellingPrice=5000;
	private String auctionNegotiationDate;
	private String auctionNegotiationInspectionDate;
	private double propertyAskingValue;
	private int auctionStatus;
	private final double DOWN_PAYMENT_PERCENTAGE = 0.10;
	private double deposit;
	private int increaseBidReserveprice=1000;
	private String maxBid;
	private int noOfDays=1;
	private boolean underContract=false;
	private final int daylimit=3;
	private  double formalOffer;
	private boolean test1=false;
	private double downPayment;
	private String creator;
	private double propertyNegoPrice;
	private double negoDownPayment;
	private final double DEDUCE_RESERVEPRICE=10000;
	private double initialDownpayment;
	
	
	private ArrayList<reply> responseList=new ArrayList<reply>();
	private static ArrayList<Sale> propertyList=new ArrayList<Sale>();
	
	
		
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {	
		this.creator = creator;
	}
	
	public int getauctionStatus() {
		return auctionStatus;
	}

	public void setauctionStatus(int auctionStatus) {
		this.auctionStatus = auctionStatus;
	}

	
	public String getmaxBid() {
		return maxBid;
	}

	public void setmaxBid(String maxBid) {
		this.maxBid = maxBid;
	}
	
	public String getauctionNegotiationInspectionDate() {
		return auctionNegotiationInspectionDate;
	}

	public String setauctionNegotiationInspectionDate(String auctionNegotiationInspectionDate) {
		return this.auctionNegotiationInspectionDate = auctionNegotiationInspectionDate;
	}

	public String getauctionNegotiationDate() {
		return auctionNegotiationDate;
	}

	public  String setauctionNegotiationDate(String auctionNegotiationDate) {
		return this.auctionNegotiationDate = auctionNegotiationDate;
	}
	Scanner sc=new Scanner(System.in);
	
	public boolean isunderContract() {
		return underContract;
	}

	public void setunderContract(boolean underContract) {
		this.underContract = underContract;
	}
	
	public double getsaleCommissionRate() {
		return saleCommissionRate;
	}
	public void setsaleCommissionRate(double saleCommissionRate) {
		this.saleCommissionRate = saleCommissionRate;
	}
	public double getpropertySellingPrice() {
		return propertySellingPrice;
	}	
	public double getminimumSellingPrice() {
		return minimumSellingPrice;
	}	
	public void setminimumSellingPrice(double minimumSellingPrice) {
	this.minimumSellingPrice=minimumSellingPrice;		
	}
	public boolean setpropertySellingPrice(double propertySellingPrice) {
		this.propertySellingPrice = propertySellingPrice;
		return true;
	}
	@Override
	public void negotiateOffer() {
		// TODO Auto-generated method stub
		
	}
	
	public void withdrawoffer()
	{
		// algo to withdraw offer 
		//can be used in negotiation
	}	
	public double getformalOffer() {
		return formalOffer;
	}
	public void setformalOffer(double formalOffer) {
		this.formalOffer = formalOffer;
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
	public void acceptOffer(Customer cnego,Property prnego,Vendor vnego, double formaloffer) //negotiation
	{ 	
		
		//Scanner no=new Scanner(System.in);
		//System.out.println("Enter an offer: ");
		//double formaloffer = no.nextDouble();	
		//setformalOffer(formaloffer);
		System.out.println("Welcome "+cnego.getcustomerID() + "for the negotition of " + prnego.getpropertyID());
		System.out.println("Currently asking Price for the property is $5000");
		System.out.println("You entered th property price to be  "+ formalOffer);
		boolean validFormalOffer=false;
		while(validFormalOffer=true)
		{
		 if(minimumSellingPrice>formaloffer)
			System.out.println("Offer cannot be made as threshold not met");
		 else
		{
			 propertyNegoPrice= formaloffer;
			System.out.println("Enter the no days vendor took to respond");
			//int noOfDays=no.nextInt();
				if(noOfDays<daylimit)
				{
					System.out.println("type yes if you want to accept the offer");
					//String answer=no.next();
					String answer="yes";
					if(answer.equalsIgnoreCase("yes"))
					{
						System.out.println("Offer is accepted by the vendor " + vnego.getcustomerID());	
					}
				
				}
				else {
					System.out.println("Offer not accepted! No of days exceed the day limit");
					System.out.println("Consider the Formal offer of another user");
				}
		}	
		}
	}
	public boolean section32(Customer cnego,Property prnego) //negotiation
	{
		Scanner io= new Scanner(System.in);		
		System.out.println("Verify if the customer "+ cnego.getcustomerID()+" has section 32");
		String rep="yes";
		//String rep=io.next();
		if(rep== ("yes"))
		{
			System.out.println("section32_bondstatus is present for  "+ prnego.getpropertyID());	
			return true;
		
		}
		else
		{
			System.out.println("Kindly get your section 32 form ready");
			return false;
		}
	}
	public void checkDownPayment(Customer cnego,Property prnego,Vendor vnego, double formaloffer) //negotiation
	{
		Scanner uo=new Scanner(System.in);
		//property_sellingprice=formaloffer;
		//property_sellingprice=highestoffer;
		 negoDownPayment=propertyNegoPrice*DOWN_PAYMENT_PERCENTAGE;
		

				if(noOfDays <= 1)
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
	}	
	public void checkDeposit(Customer cnego,Property prnego,Vendor vnego, double formaloffer) //negotiation
	{
		//Scanner dep=new Scanner(System.in);
		deposit=propertyNegoPrice-negoDownPayment;		
				//legal formalities
				System.out.println("Customer is making a deposit do u want to accept which is $" +deposit);
				//String reply=dep.next();
				String reply="Yes";
				if(reply.equalsIgnoreCase("YES"))
				{
					System.out.println("Deposit made");
					setunderContract(true);
					System.out.println("The property is under undercontract");
					prnego.setPropertyOwnerID(cnego.getcustomerID());
					System.out.println(prnego.toString());
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
	
	
	
	
	public void manageAuctionInspection(Property propertyID) throws ParseException //auction
	{
		Scanner ur=new Scanner(System.in);
		
		// a vendor enters the inspection date for his property before the auction date comparing the inspection date and auction date
	    
		System.out.println("Enter the auction date that you want for the " + propertyID + "in the format (yyyy-mm-dd)");
	    String D=ur.next();  
	    if(compareDates(D,getauctionNegotiationDate())== true)
	    {
	    	//setting of inspection date is done for buyers to come
	    	setauctionNegotiationInspectionDate(D);
	    }
	    else
	    {
	    	System.out.println("The auction Date can't be before the initial auction Date");
	    }
	}
	
	public boolean compareDates(String psDate1, String psDate2) throws ParseException {
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
	
	private void newProperty(String customer)//to add a property
	{
		Scanner np=new Scanner(System.in);
		System.out.println("Enter the specs of the property");
		System.out.println("Address");
		String propertyAddress=np.nextLine();
		int count=1;
		String auctionID="AUC"+String.format("%03d", count);
		//Property propertyobject=new Sale(auctionID,address);
		//propertyList.add((Sale) propertyobject);
		System.out.println("Success!! Property has been added with id " + auctionID );
		
	}
	
	public void propertyReply(Customer cus, Property pr,double bid)//auction
	//customer will come when u login 
	{	
		Scanner rw=new Scanner(System.in);
		/*System.out.println("Enter Property ID or quit");
		String auctionID=rw.nextLine();
		if(auctionID.equals("q"))
		{
			//implement displaymenu
			System.out.println("Go to main menu");
		}
		for(int i=0;i<propertyList.size();i++)
		{
			if(propertyList.get(i).getProperty_id().equals(auctionID))
			
				propertyNotPresent=true;
			
			  if(propertyList.get(i).getAuction_status()==1)
			    {
				auctionClosed=true;
				break;
			    }
			if(propertyList.get(i).getCreator().equals(customer))
			{
				selfProperty=true;
				break;
			}*/
		System.out.println("Welcome " + cus.getcustomerID() + " for the auction of " + pr.getpropertyID());
		double highestoffer=250000;
	    double asking_price=200000;
	    System.out.println("Current asking price :" + asking_price);
	    System.out.println("Minimum raise needed for the offer is " + increaseBidReserveprice);
	    
		boolean propertyNotPresent=false;
		boolean auctionClosed=false;
		boolean selfProperty=false;
		boolean validatebid=true;
			while(validatebid==true)
			{
				System.out.println("Enter your offer or q to quit");
				//double bid =rw.nextDouble();
				//System.out.println("Your Bid is " + bid);
				
				if(bid <0)
				{
					System.out.println("Kindly try a valid positive bid above asking price");
					break;
					
					
				}
				else if(bid<increaseBidReserveprice)//increasebid_reserve=1000
			    {
						System.out.println("Offer is below minimum raise");
						break;
			    }
				else if(bid < asking_price) {
					System.out.println("Your Bid is below the asking price ");	
					break;
				}
				else if(bid>(increaseBidReserveprice + highestoffer) && bid<asking_price)//if highestoffer=1300 asking price=2000
				{
					System.out.println("Offer is below asking price");
					break;
				}
				else if(bid>increaseBidReserveprice + highestoffer)//bid=
				{
					
					System.out.println("Highest bid is recorded");
					highestoffer=bid;
					Scanner po=new Scanner(System.in);
					
					//System.out.println("check if no one else is biding for the next 30 seconds");
					String check="No";
					if(check.equalsIgnoreCase("No"))
					{
						System.out.println("Property Sold to you,Selling Price for the Propert is "+highestoffer);
						propertySellingPrice=highestoffer;
						 initialDownpayment=propertySellingPrice*0.10;
						System.out.println("Your initial downpayment is " +initialDownpayment);
						System.out.println("Do u wish to pay the downpayment $"+initialDownpayment+ " within 1 day");
						String check1="Yes";
						if(check1.equalsIgnoreCase("yes"))
						{
							if(noOfDays <= 1)
							
								{
									System.out.println("Downpayment is received");
									
									deposit=propertySellingPrice-initialDownpayment;
									
									
									//System.out.println(" Do you want to submit the deposit which is $" +deposit);
									String check2="Yes";
									if(check2.equalsIgnoreCase("YES"))
									{
										System.out.println("Deposit made of $" + deposit);
										setunderContract(true);
										System.out.println("The property is under undercontract");
										//assignSaleEmployee();
										pr.setPropertyOwnerID(cus.getcustomerID());
										System.out.println("*****Updated property details*****");
										System.out.println("Property Owner Changed to " + pr.getPropertyOwnerID());
										System.out.println(pr.toString());
										break;
									}
									else
									{
									System.out.println("Deposit not made/n");	
									System.out.println("Property "+pr.getpropertyID()+" will be assigned to the second highest bidder/n");
									double secondHighestBid=bid;
									 if(secondHighestBid>=asking_price)
									 {
									   System.out.println("Property Sold to second highest bid,Selling Price for the Property is "+secondHighestBid);
									   System.out.println("Your initial downpayment is " +secondHighestBid*0.10);
									   System.out.println("your Deposit is "+(secondHighestBid-(secondHighestBid*0.10)));
									   setunderContract(true);
									   pr.setPropertyOwnerID(cus.getcustomerID());
									   
									   System.out.println("*****Updated property details*****");
									   System.out.println("Property Owner Changed to " + pr.getPropertyOwnerID());
									   System.out.println(pr.toString());
									   break;
									 }
									   else
									   {
										   System.out.println("So again available for auction with asking price $" + (asking_price-10000));
									   }
									
									}			
								}
							else {
								System.out.println("you have exceeded the 24 hour limit");
								System.out.println("Property "+pr.getpropertyID()+"not assigned to anyone/n");
								System.out.println("So again available for auction with asking price $" + (asking_price-10000));
							}
						}
						else {
							System.out.println("You refued to pay the downpayment Property again goes to auction");
							System.out.println("Property "+pr.getpropertyID()+"not assigned to anyone/n");
							System.out.println("So again available for auction with asking price $" + (asking_price-10000));
						}
						}	
					}
				else if(bid<highestoffer && bid>asking_price)
				{
					System.out.println("offer accepted and recorded however not heightest ");
					System.out.println("Current asking price was : $" + asking_price+" reduced to "+(asking_price-DEDUCE_RESERVEPRICE) );	
					double secondHighestBid=bid;
					System.out.println("Property Sold to you,Selling Price for the Property is "+secondHighestBid);
					System.out.println("Your initial downpayment is " +secondHighestBid*0.10);
					System.out.println("your Deposit is "+(secondHighestBid-(secondHighestBid*0.10)));
					setunderContract(true);
					pr.setPropertyOwnerID(cus.getcustomerID());
					System.out.println("*****Updated property details*****");
					System.out.println("Property Owner Changed to " + pr.getPropertyOwnerID());
					System.out.println(pr.toString());
					break;	
				}
				else {
					System.out.println("invalid Bid");
					break;
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
			return false
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
	public void checkCommisionrate()//negotiation
	//commission rate between vendor and sales consultant is decided 
	{
		Scanner bo=new Scanner(System.in);
	  System.out.println("Enter the commision rate that is negotiated between the Sale Consultant and the vendor ");
	  double saleCommision= bo.nextDouble();
	  try {
		  if(saleCommision>=2 && saleCommision<=5)
		  {
			  setsaleCommissionRate(saleCommision);
			  System.out.println("the Sales consultant will get "+saleCommision+" of"+ propertySellingPrice+ "thats is $"+propertySellingPrice*saleCommision);
			  
			  // this is given to sale consultant for the final selling price
		  }
		  
	  }catch(Exception e)
	  {
		  System.out.println("Kindly enter between 2 and 5");
	  }
	  
		
	}

	public static void main(String[] args) {
		//Scanner sc =new Scanner(System.in);
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


		Customer cus = new Customer("BUY001", "Pavan", "KA", "pavan.7185@gmail.com", "password",1000000, "occupation", "present_employer");
		Customer cus1 = new Customer("BUY002", "Sanjay", "K", "sanjay.7185@gmail.com", "password",1100000, "occupation", "present_employer");
		Customer cnego = new Customer("CUS010", "Virat", "K", "virat@gmail.com", "password",1200000, "occupation", "present_employer");
		Property pr = new Sale("PRID001", "address", 2, 2, 2, "house_type", "tenant_name", "EVEN007");
		Property prnego = new Sale("PRID002", "205 Henry Street", 2, 2, 2, "apartment", "tenant_name", "CUST020");
		Employee Sc=new SalesConsultant("SALC001","Auction",10000,25);
		Sale s=new Sale("PRID002", "address", 2, 2, 2, "house_type", "tenant_name", "CUST008");
		Customer v=new Vendor("VEN001", "Rahul", "S", "rahul@gmail.com", "password",1000000, "occupation", "present_employer");
		//SalesConsultant sac=new ("SALC001","Auction",10000,25);
		Vendor vnego=new Vendor("VEN002", "Simon", "S", "simon@gmail.com", "password",1500000, "occupation", "present_employer");
		
		s.propertyReply(cus, pr,260000);
		
	
	}
	
	
}
