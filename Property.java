
public class Property 
{
	private String propertyID;
	private String address;
	private String suburb;
	private int noOfRoom;
	private int noOfBath;
	private int noOfCarPark;
	private String type;
	private static int IDCounter = 0;
	
	
	public Property(String address, String suburb, int noOfRoom, int noOfBath, int noOfCarPark, String type)
	{
		this.propertyID = setPropertyID();
		this.address = address;
		this.suburb =  suburb;
		this.noOfRoom = noOfRoom;
		this.noOfBath = noOfBath;
		this.noOfCarPark = noOfCarPark;
		this.type = type;
	}
	
	public String setPropertyID()
	{
		IDCounter++;
		if(IDCounter > 9)
		{
			return "PRO" + "0" + IDCounter;
		}
		else if(IDCounter >= 100)
		{
			return "PRO" + "" + IDCounter;
		}
		else
		{
			return "PRO" + "00" + IDCounter;
		}
	}

	public String getPropertyID() 
	{
		return propertyID;
	}

	public void setPropertyID(String propertyID) 
	{
		this.propertyID = propertyID;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getSuburb() 
	{
		return suburb;
	}

	public void setSuburb(String suburb) 
	{
		this.suburb = suburb;
	}

	public int getNoOfRoom() 
	{
		return noOfRoom;
	}

	public void setNoOfRoom(int noOfRoom) 
	{
		this.noOfRoom = noOfRoom;
	}

	public int getNoOfBath() 
	{
		return noOfBath;
	}

	public void setNoOfBath(int noOfBath) 
	{
		this.noOfBath = noOfBath;
	}

	public int getNoOfCarPark() 
	{
		return noOfCarPark;
	}

	public void setNoOfCarPark(int noOfCarPark) 
	{
		this.noOfCarPark = noOfCarPark;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}


	public void printDetails()
	{ 
		  System.out.println("Property ID:"+propertyID+'\n'+"Address: "+address + '\n' + "Suburb: "+ suburb +'\n' + "Rooms: " + noOfRoom + '\n' +"Bathrooms: "+ noOfBath +'\n' + "Car Park: "+ noOfCarPark + '\n'+"Property type: " +type);
	} 

	
	
}
