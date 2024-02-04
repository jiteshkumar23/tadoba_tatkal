package booking;

public class TatkalBooking_DataProfile1 extends BaseClassMethods {

	// Set ecoTouristPlace here
	public static String ecoTouristPlace = "Tadoba Andhari Tiger Reserve (Core)";

	// Set Zone here , valid values are "Moharli Zone (Core)" ,"Kolara Zone (Core)" , "Pangadi and Zari Zone (Core)"
	public static String zoneFromData = "Moharli Zone (Core)";

	// Set Gate here
	// For Moharli --> "Moharli"
	// For Kolara --> "Kolara"
	// For Pangadi and Zari --> "Pangadi" OR "Zari"
	public static String gateFromData = "Moharli";

	// Set shift here , valid values are "Morning" or "Afternoon"
	public static String shiftFromData = "Morning";

	// Set the number of members as "1" ,"2", "5" , "6"
	public static String numberOfMembers = "6";

	// payment mode
	public static String paymentMode = "UPI"; // valid values "UPI" , "Credit Card"

	// regular booking or tatkal booking
	public static String typeOfBooking = "Tatkal";// valid values "Regular" , "Tatkal"

}
