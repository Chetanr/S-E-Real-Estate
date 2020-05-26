/////////SEF
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
public class Sale extends Property {
	private String askingPrice;
	private String max_offer;
	private String minimumRaise;
	private String proposePrice;
	private String highestoffer;
	private double finalizeSaleOffer;
	private double initialDownpayment;
	private double auctionDeposit;
	private double NegotiationSalePrice;
	private double negotiationDownpayment;
	private double negotiationDeposit;
	
	//constructor for Auction
	public Sale(String propertyID, String address, String suburb,String askingPrice, String minimumRaise,String propertyOwnerID ) {
		super(propertyID, address, suburb, propertyOwnerID);
		// TODO Auto-generated constructor stub
		this.askingPrice=askingPrice;
		this.max_offer="0";
		this.minimumRaise=minimumRaise;
	}
	//constructor for negotiation
	public Sale(String propertyID,String address, String suburb,String proposePrice, String propertyOwnerID) {
		super(propertyID, address, suburb, propertyOwnerID);
		this.proposePrice=proposePrice;
		this.max_offer="0";
		
	}
	
	public double returnFinalOffer(double finalizedOffer) {
		return finalizedOffer;
		
		
	}
	private ArrayList<Reply> replyList = new ArrayList<Reply>();
	
	public String getAskingPrice() {
		return askingPrice;
	}

	public void setAskingPrice(String askingPrice) {
		this.askingPrice = askingPrice;
	}

	public String getHighestOffer() {
		return max_offer;
	}

	public void setHighestOffer(String max_offer) {
		this.max_offer = max_offer;
	}

	public String getMinimumRaise() {
		return minimumRaise;
	}

	public void setMinimumRaise(String minimumRaise) {
		this.minimumRaise = minimumRaise;
	}
	
	public String getProposePrice() {
		return proposePrice;
	}
	public void setProposePrice(String proposePrice) {
		this.proposePrice = proposePrice;
	}
	public String getHighestoffer() {
		if(this.highestoffer == null && this.highestoffer.isEmpty()) return "No OFFER";
	     return this.highestoffer;
	}
	public void setHighestoffer(String highestoffer) {
		this.highestoffer = highestoffer;
	}

	
	public boolean auctionReply(Reply reply) {
		// TODO Auto-generated method stub
		Scanner ball=new Scanner(System.in);
		int askingPrice = Integer.parseInt(this.getAskingPrice());
		int replyValue = Integer.parseInt(reply.getReplyValue());
		int minimumRaise = Integer.parseInt(this.getMinimumRaise());
		
		int highestOffer = 0;
	
		
		if(replyValue < 0){
			System.out.println("Negative value is not accepted");
			return false;
		}
		
		else if(replyValue < minimumRaise) {
			System.out.println("Offer is below Minimum Raise");
			return false;
		}
		
		else if(replyValue < (askingPrice+minimumRaise) ) {
			System.out.println("Offer not accepted as higher than " + (askingPrice+minimumRaise));
			return false;
		}
		
		else if(replyValue > (minimumRaise + highestOffer) && replyValue < askingPrice ) {
			System.out.println("Offer loaded! However, Offer is below asking Price");
		}
		
		else if(replyValue < minimumRaise + highestOffer ) {
			System.out.println("Offer not accepted");
			return false;
		}
		else {
			
			this.replyList.add(reply);
		    System.out.println("Valid Bid Recorded");
		    this.finalizeSaleOffer=Double.parseDouble(reply.getReplyValue());
		    System.out.println("the Selling Price of the property is $" + finalizeSaleOffer);
		    initialDownpayment=finalizeSaleOffer*0.10;
		    System.out.println("Downpayment to be payed by the buyer is within 1 day is $ "+ initialDownpayment);
		    System.out.println("Do you want " +reply.getResponderId()+ " to pay the downpayment with in 1 day");
		    System.out.println("Yes to PAY" + "\n");
		    String check= ball.nextLine();
		       if(check.equalsIgnoreCase("yes"))
		        {
		    	   System.out.println("Property is underContract Under" + reply.getResponderId() +"\n");
		    	   this.setStatus(1); 	   
		    	   auctionDeposit=(finalizeSaleOffer-initialDownpayment);
		    	   System.out.println("Do you want to pay the deposit $" +auctionDeposit );
		    	   System.out.println("Yes to PAY" + "\n");
		    	   String check1= ball.nextLine();
		    	   if(check1.equalsIgnoreCase("yes"))
		    	   {
		    		System.out.println("Now the property Belongs to " + reply.getResponderId());   
		    		this.setPropertyOwnerID(reply.getResponderId());
		    	   }
		    	   else {
		    		   System.out.println("property goes to Auction again");
		    		   this.setStatus(0);
		    	   }
		        	
		         }
		        else  {
		        	System.out.println("Property goes to auction again"); 
		        	this.setStatus(0);
		        }    
		}
		return true;
	}

	
	public boolean negotiationReply(Reply reply) {
		// TODO Auto-generated method stub
		Scanner bat=new Scanner(System.in);
		int proposePrice = Integer.parseInt(this.getProposePrice());
		int replyValue = Integer.parseInt(reply.getReplyValue());
		
		
		
		if(replyValue < 0){
			System.out.println("Negative value is not accepted");
			return false;
		}
		
		else if(replyValue < proposePrice) {
			System.out.println("Offer not accepted");
			return false;
		}
		
		
		
		this.replyList.add(reply);
		System.out.println("Offer accepted by the vendor");
		NegotiationSalePrice=Double.parseDouble(reply.getReplyValue());
		System.out.println("the Selling Price of the property is $" + NegotiationSalePrice);
		negotiationDownpayment=NegotiationSalePrice*0.10;
		System.out.println("Downpayment to be payed by the buyer is within 1 day is $ "+ negotiationDownpayment);
	    System.out.println("Do you want " +reply.getResponderId()+ " to pay the downpayment with in 1 day");
	    System.out.println("Yes to PAY" + "\n");
	    String check2= bat.nextLine();
	       if(check2.equalsIgnoreCase("yes"))
	       {
	    	   System.out.println("Property is underContract Under" + reply.getResponderId() +"\n");
    	       this.setStatus(1); 	   
    	       negotiationDeposit=(NegotiationSalePrice-negotiationDownpayment);
    	   System.out.println("Do you want to pay the deposit $" +negotiationDeposit );
    	   System.out.println("Yes to PAY" + "\n");
    	   String check3= bat.nextLine();
    	      if(check3.equalsIgnoreCase("yes"))
    	      {
    		   System.out.println("Now the property Belongs to " + reply.getResponderId());   
    		   this.setPropertyOwnerID(reply.getResponderId());
    	      }
    	      else {
    		   System.out.println("property goes to Negotiation again");
    		   this.setStatus(0);
    	      }
	       }
          else  {
        	System.out.println("Property goes to auction again"); 
        	this.setStatus(0);
                 }   
		return true;
}

	
	public boolean checkAlreadyJoin(String responderId) {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.replyList.size(); i++)
		{
			if(this.replyList.get(i).getResponderId().equals(responderId)) {
				System.out.println("You already reply.");
				return false;
			}
		}
		return true;
	}

	
	public String getAuctionReplyDetails() {
		String Offer_History = "Offer History: ";
		String Asking_price = "Asking price: " + this.getAskingPrice()+"\n";
		
		ArrayList<Reply> replyLists = this.replyList;
		Collections.sort(replyLists, Reply.ReplyComparatorDesc);
		
		for(int i = 0; i < replyLists.size(); i++)
		{
			Offer_History += replyLists.get(i).getResponderId()+ " : " + replyLists.get(i).getReplyValue()+"\n";
		}
		return Asking_price + Offer_History+"\n";
		
	}

	
	public String getNegotiationReplyDetails() {
		// TODO Auto-generated method stub
		System.out.println("\nOffer History:\n");
		ArrayList<Reply> replyLists = this.replyList;
		Collections.sort(replyLists, Reply.ReplyComparatorDesc);
		String Offer_History = " ";
		for(int i = 0; i < replyLists.size(); i++)
		{
			Offer_History += replyLists.get(i).getResponderId()+ " : " + replyLists.get(i).getReplyValue()+"\n";
		}
		
		return Offer_History+"\n";
	}
	
	public String getAuctionPropertyDetails() {
		String propertyDetails = "";
		propertyDetails += "ID: " + this.getPropertyID() + "\n";
		propertyDetails += "Address "+ this.getAddress() + "\n";
		propertyDetails += "Suburb: "+ this.getSuburb() + "\n";
		propertyDetails += "PropertyOwnerID "+ this.getPropertyOwnerID() + "\n";
    	
    	if(this.getStatus() == 0) propertyDetails += "Status: Open\n";
    	if(this.getStatus() == 1) propertyDetails += "Status: Close\n";
    	//postDetails += "Highest Offer: "+ this.getHighestOffer() + "\n";
    	propertyDetails += "Minimum Raise: "+ this.getMinimumRaise() + "\n";
    	propertyDetails += "Asking Price: "+ this.getAskingPrice()+ "\n";
    	//propertyDetails += "finalizeSaleOffer : "+ this.finalizeSaleOffer+"\n"; 
    	
    	return propertyDetails;
		
	}
	
	public String getNegotiationPropertyDetails( ) {
		String propertyDetails = "";
		propertyDetails += "ID: " + this.getPropertyID() + "\n";
		propertyDetails += "Address: "+ this.getAddress() + "\n";
		propertyDetails += "Suburb: "+ this.getSuburb() + "\n";
    	
    	if(this.getStatus() == 0) propertyDetails += "Status: Open\n";
    	if(this.getStatus() == 1) propertyDetails += "Status: Close\n";
    	
    	propertyDetails += "PropertyOwnerID: "+ this.getPropertyOwnerID() + "\n";
    	propertyDetails += "Propose Price: "+ this.getProposePrice() + "\n";
    	//propertyDetails += "finalizeSaleOffer"+ this.finalizeSaleOffer+"\n"; 
    	
    	//postDetails += "HIGHEST Price: "+ this.getHighestoffer() + "\n";
    	
    	return propertyDetails;
	}
	}

	

