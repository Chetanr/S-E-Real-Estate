
public class login {
	private String Id;
	private String password;
	
	
	public login(String Id, String password) {
		this.Id = Id;
		this.password = password;
	}
	
    public String getId() {
	    return Id;
	}

	public void setId(String Id) {
	    this.Id = Id;
	}
	
    public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}	
	
	public boolean verify(String givenId, String givenPassword) {
		if(this.Id == givenId && this.password == givenPassword)
		     return true;
		else return false;
	}

}
