import java.util.ArrayList;
import java.util.*;

public class register {
    private String id;
    private String name;
    private String email;
    private String address;
    private String user_type;
    private int status;

	
	public register(String id, String name, String email, String address, String user_type) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.user_type = user_type;
		this.email = email;
		this.status = 1; // 1 means active, 0 means inactive
	}
	
    public String getId() {
	    return id;
	}
	
    public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}
	
    public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}
	
    public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}
	
    public String getUserType() {
	    return user_type;
	}
    
	public void setUserType(String user_type) {
	    this.user_type = user_type;
	}	
	
}
