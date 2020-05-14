import java.util.ArrayList;
import java.util.Random;

public abstract class Customer 
{
	private String customerName;
	private String emailID;
	private String customerID;
	private String password;
	private static int customerCounter = 0;
	
	public Customer(String customerName, String emailID)
	{
		this.customerID = setCustomerID();
		this.customerName = customerName;
		this.emailID = emailID;
		this.password = Password();
	}
	
	public String setCustomerID()
	{
		customerCounter++;
		if(customerCounter > 9)
		{
			return "CUS" + "0" + customerCounter;
		}
		else if(customerCounter >= 100)
		{
			return "CUS" + "" + customerCounter;
		}
		else
		{
			return "CUS" + "00" + customerCounter;
		}
	}
	
	

	public String Password()
	{
		String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder initialPassword = new StringBuilder();
        Random rnd = new Random();
        while (initialPassword.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * alphaNumeric.length());
            initialPassword.append(alphaNumeric.charAt(index));
        }
        this.password = initialPassword.toString();
        return this.password;
	}

	public String getCustomerName() 
	{
		return customerName;
	}

	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}

	public String getEmailID() 
	{
		return emailID;
	}

	public void setEmailID(String emailID) 
	{
		this.emailID = emailID;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getCustomerID()
	{
		return this.customerID;
	}
	
}
