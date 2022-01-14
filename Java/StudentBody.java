import java.util.ArrayList;

public class StudentBody {

    private  ArrayList<Student>  studentList = new ArrayList<Student>();

    public Student addStudent(String name){
        Student newStudent =new Student(name);
        studentList.add(newStudent);
        return(newStudent);
    }
    public Student getStudentByName(String name){
        Student result=null;
        for(Student student :studentList){
            if(student.getName() == name){
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
                    System.out.print(coord.getLat()+"  "+coord.getLong() + " ");
            }
            System.out.println();
        }            

    }

    public void findContact(String name){
        Student patientZero = getStudentByName(name);
        if(patientZero != null){
            for(Student person : studentList){
                if(person != patientZero){
                   for(Location pzCoord: patientZero.getGpsList()){
                       if(person.compareGPS(pzCoord)== true){
                           System.out.println(name + " <--> "+ person.getName());
                           break;
                       }
                   } 
                }
            }            
        }else{
            System.out.println(name + "  is not a Student!");

        }
    }
}
