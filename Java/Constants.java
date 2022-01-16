public class Constants {
    /* Because of floating point percision, 0.0001 = 0.00011 */
    /* This catches any persision issues Example: 1.2 = 1.19999999999*/
    public static final double LOCATION_RESOLUTION = 0.00011;
    public static final long TIME_RESOLUTION = 5; // time in minutes
    private Constants(){}
}
