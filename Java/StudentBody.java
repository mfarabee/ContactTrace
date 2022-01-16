import java.util.ArrayList;
import java.io.*;
public class StudentBody {

    private  ArrayList<Student>  studentList = new ArrayList<Student>();

    public Student addStudent(String first, String last, int grade){
        Student newStudent =new Student(first,last,grade);
        studentList.add(newStudent);
        return(newStudent);
    }
    public Student getStudentByName(String name){
        Student result=null;
        for(Student student :studentList){
            if(student.getName().equals(name)){
                result=student;
                break;
            }
        }
        return(result);
    }
    public void printAll(){
        ArrayList<Location> coordList;
        for(Student person : studentList){
            System.out.print(person.getName()+" ");
            coordList=person.getGpsList();
            for(Location coord: coordList){
                    System.out.print("("+coord.getLat()+" "+coord.getLong() + ")  ");
            }
            System.out.println();
        }            

    }

    public void findContact(String name){
        Student patientZero = getStudentByName(name);
        if(patientZero != null){
            for(Student person : studentList){
                if(person != patientZero){
                   for(Location pzCoord: patientZero.getGpsList()){ // Loop through patient zero coords
                       if(person.compareGPS(pzCoord)== true){ // compare to other student coords
                           System.out.println(name + " <--> "+ person.getName());
                           break;
                       }
                   } 
                }
            }            
        }else{
            System.out.println(name + " is not a Student!");

        }
    }

    public void readData(String fileName){
        Student person=null;
        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = lineReader.readLine()) != null) {
                line=line.trim().replace("\n","");

                if(line.charAt(0) != '+'){
                    String[] splitLine=line.split(" +");
                    person=addStudent(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]));
                }else{
                    if(line.charAt(0)=='+' && person != null){
                        String[] splitLine=line.split(" +");
                        person.addGPS(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]),splitLine[3]);
                    }
                }
            }
            lineReader.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
