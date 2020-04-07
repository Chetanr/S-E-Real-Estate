
abstract class Property 
{
	private static int property_id;
	private static String address;
	private static String suburb;
	private static int num_bed;
	private static int num_bath;
	private static int num_car_space;
	private static String house_type;
	
	
	//abstract class to negotiate the offer between buyer and seller
	public abstract void negotiateOffer();
	
	
	//transfer the property contract to tenant
	public void finaliseOffer()
	{
		
	}
}
