public class Location {
   private double latitude=0.0;
   private double longitude=0.0; 
   private long minutes=0; 
   private String stringTime=""; 
   Location(double x, double y,String z){
       latitude=x;
       longitude=y;
        stringTime=z;

       String[] splitLine=z.split(":");
       // convert time 10:32 into minutes from midnight  (10*60)+32 = 632
       minutes=(Long.parseLong(splitLine[0])*60)+Long.parseLong(splitLine[1]);
   }
   public double getLat(){
       return(latitude);
   } 
   public double getLong(){
       return(longitude);
   } 
   public long getMinutes(){
       return(minutes);
   } 
   public String getTime(){
       return(stringTime);
   } 
}
