import java.util.ArrayList;

public class Student {

    private String name = "";
    private  ArrayList<Location>  locationList = new ArrayList<Location>();
    Student(String sName) {
       name=sName; 
    }
    private boolean near(double x, double y){
        boolean result=false;
        if(Math.abs(x-y) <= Constants.LOCATION_RESOLUTION){
            result=true;
        }
        return(result);
    }
    public void addGPS(double lat,double lon){
        locationList.add(new Location(lat,lon));
    }
    public String getName(){
        return(name);
    }
    public ArrayList<Location> getGpsList(){
        return(locationList);
    }
    public boolean compareGPS(Location coord){
        boolean result=false;
        for(Location  point : locationList ){
            if(near(point.getLat(),coord.getLat()) && near(point.getLong(),coord.getLong())){
                result=true;
            }
        }
        return(result);
    }
}   

