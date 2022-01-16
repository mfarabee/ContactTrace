import java.util.ArrayList;

public class Student {

    private String fName = "";
    private String lName = "";
    private int grade = 0;
    private  ArrayList<Location>  locationList = new ArrayList<Location>();
    Student(String f, String l, int g) {
       fName=f; 
       lName=l; 
       grade=g;
    }
    private boolean near(double x, double y){
        boolean result=false;
        if(Math.abs(x-y) <= Constants.LOCATION_RESOLUTION){
            result=true;
        }
        return(result);
    }
    private boolean nearTime(long x, long y){
        boolean result=false;
        if(Math.abs(x-y) <= Constants.TIME_RESOLUTION){
            result=true;
        }
        return(result);
    }
    public void addGPS(double lat,double lon, String stringTime){
        locationList.add(new Location(lat,lon,stringTime));
    }
    public String getFirstName(){
        return(fName);
    }
    public String getLastName(){
        return(lName);
    }
    public String getName(){
        return(fName +" "+ lName);
    }
    public int getGrade(){
        return(grade);
    }
    public ArrayList<Location> getGpsList(){
        return(locationList);
    }
    public boolean compareGPS(Location coord){
        boolean result=false;
        for(Location  point : locationList ){
            if(near(point.getLat(),coord.getLat()) && 
               near(point.getLong(),coord.getLong()) &&
               nearTime(point.getMinutes(), coord.getMinutes())  ){
                //System.out.print(point.getLat() +" "+coord.getLat()+" - "+point.getLong() +" "+coord.getLong()+" ");
                result=true;
            }
        }
        return(result);
    }
}   

