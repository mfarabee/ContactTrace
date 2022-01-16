
public class contractTrace {
    public static void test(StudentBody mySchool){
        Student tmp;
        tmp=mySchool.addStudent("Tom","Ato",10);
        tmp.addGPS(0,0,"0:0");
        tmp.addGPS(1,0,"0:0");
        tmp.addGPS(1,1,"0:0");
        tmp=mySchool.addStudent("Dick","Tracy",12);
        tmp.addGPS(1,0,"0:0");
        tmp.addGPS(2,0,"0:0");
        tmp.addGPS(2,1,"0:0");
        tmp=mySchool.addStudent("Harry","Mole",12);
        tmp.addGPS(3,0,"0:0");
        tmp.addGPS(3,1,"0:0");
        tmp.addGPS(3,2,"0:0");

    }

    
	public static void main(String[] args) {
		System.out.println("Hello Tracers!");
        StudentBody mySchool= new StudentBody();
        // test(mySchool);
        mySchool.readData("students.txt");
        mySchool.findContact("Mike Farabee");
        mySchool.findContact("Square Bob");
        //mySchool.printAll();

	}
}