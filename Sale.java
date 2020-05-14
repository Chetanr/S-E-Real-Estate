
public class Sale extends Property
{
	private SalesConsultant salesConsultant;
	private double propertySellingPrice;
	private double saleCommissionRate;
	private double SECommission;
	private double salesConsultantCommission;
	

	public Sale(String address, String suburb, int noOfRoom, int noOfBath, int noOfCarPark, String type)
	{
		super(address,suburb, noOfRoom, noOfBath, noOfCarPark, type);
		salesConsultant = null;
	}
	
	public SalesConsultant getSalesConsultant() 
	{
		return this.salesConsultant;
	}

	public void setSalesConsultant(SalesConsultant salesConsultant) 
	{
		this.salesConsultant = salesConsultant;
	}
	
	public double getSalesConsultantCommission() 
	{
		return salesConsultantCommission;
	}

	public void setSalesConsultantCommission(double salesConsultantCommission) 
	{
		this.salesConsultantCommission = salesConsultantCommission;
	}

	public void calculateCommission()
	{
		SECommission = propertySellingPrice * saleCommissionRate;
		salesConsultantCommission = salesConsultant.getRate() * SECommission;
	}
	@Override
	public void printDetails()
	{
		System.out.println("----Sale propert details----");
		super.printDetails();
		if(salesConsultant != null)
			System.out.println("Sale Consultant "+salesConsultant.getID());
		else
			System.out.println("No sales consultant has been assigned to the property");
	}
	
}
