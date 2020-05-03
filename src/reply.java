
public class reply {
	private String auction_ID;
	private String replyValue;
	private String replyID;
	public reply(String auction_ID, String replyValue, String replyID) {
		this.auction_ID = auction_ID;
		this.replyValue = replyValue;
		this.replyID = replyID;
	}
	public String getAuction_ID() {
		return auction_ID;
	}
	public void setAuction_ID(String auction_ID) {
		this.auction_ID = auction_ID;
	}
	public String getreplyValue() {
		return replyValue;
	}
	public void setreplyValue(String replyValue) {
		this.replyValue = replyValue;
	}
	public String getreplyID() {
		return replyID;
	}
	public void setreplyID(String replyID) {
		this.replyID = replyID;
	}
	
	
	

}
