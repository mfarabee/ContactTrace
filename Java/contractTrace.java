
public class contractTrace {
    public static void test(StudentBody mySchool){
        Student tmp;
        tmp=mySchool.addStudent("Tom");
        tmp.addGPS(0,0);
        tmp.addGPS(1,0);
        tmp.addGPS(1,1);
        tmp=mySchool.addStudent("Dick");
        tmp.addGPS(1,0);
        tmp.addGPS(2,0);
        tmp.addGPS(2,1);
        tmp=mySchool.addStudent("Harry");
        tmp.addGPS(3,0);
        tmp.addGPS(3,1);
        tmp.addGPS(3,2);

    }

	public static void main(String[] args) {
		System.out.println("Hello World!");
        StudentBody mySchool= new StudentBody();
        test(mySchool);
        mySchool.findContact("Harry");

	}
}