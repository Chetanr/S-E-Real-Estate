///////////SEF
import java.util.Comparator;
import java.util.*;

public class Reply {
	private String saleId;
	private String replyValue;
	private String responderId;
	
    Reply(String saleId, String replyValue, String responderId){
    	this.saleId = saleId;
    	this.replyValue =	replyValue;
    	this.responderId = responderId;
	}
    
    
    public String getSaleIdId() {
    	return this.saleId;
    }
    
    public void setSaleId(String saleId) {
	    this.saleId = saleId;
	}
    
    public String getReplyValue() {
    	return this.replyValue;
    }
    
    public void setReplyValue(String replyValue) {
	    this.replyValue = replyValue;
	}
    
    public String getResponderId() {
    	return this.responderId;
    }
    
    public void setResponderId(String responderId) {
	    this.responderId = responderId;
	}
    
    public static Comparator<Reply> ReplyComparator = new Comparator<Reply>() {

	public int compare(Reply s1, Reply s2) {
	   Double Reply1 =  Double.parseDouble(s1.getReplyValue());
	   Double Reply2 =  Double.parseDouble(s2.getReplyValue());

	   //ascending order
	   return (int) (Reply1 - Reply2);
    }
	};
	
    public static Comparator<Reply> ReplyComparatorDesc = new Comparator<Reply>() {

	public int compare(Reply s1, Reply s2) {
	   Double Reply1 =  Double.parseDouble(s1.getReplyValue());
	   Double Reply2 =  Double.parseDouble(s2.getReplyValue());

	   //ascending order
	   return (int) (Reply2 - Reply1);
    }
	};
}
