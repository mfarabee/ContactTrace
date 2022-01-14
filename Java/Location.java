public class Location {
   public double latitude=0.0;
   public double longitude=0.0; 
   Location(double x, double y){
       latitude=x;
       longitude=y;
   }
   public double getLat(){
       return(latitude);
   } 
   public double getLong(){
       return(longitude);
   } 
}
