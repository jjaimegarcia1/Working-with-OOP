//**************************************
//Jose Jaime
//HW#4 ArrayLists & Whitebox Testing
//Dr. St.Clair
//*************************************
package com.company;
import java.io.*;
import java.util.*;

class Address {
    private String _street;
    private String _city;
    private String _state;
    private String _zip;

    Address() {
    }
    Address(String s, String c, String st, String z) {
        _street = s;
        _city = c;
        _state = st;
        _zip = z;
    }
    void setStreet(String s){_street = s;}
    void setCity(String c){_city = c;}
    void setState(String st){_state = st;}
    void setZip(String z){_zip = z;}
    String getStreet(){return _street;}
    String getCity(){return _city;}
    String getState(){return _state;}
    String getZip(){return _zip;}
}
class Course{
    // _cnum is a unique identifier for a course
    private String _cnum;
    private String _cname;
    private int _credits;
    Course(){}
    Course(String num, String name, int cred){
        _cnum = num;
        _cname = name;
        _credits = cred;
    }
    void setNumber(String num){_cnum = num;}
    void setName(String name){_cname = name;}
    void setCredits(int cred){_credits = cred;}
    String getNumber(){return _cnum;}
    String getName(){return _cname;}
    int getCredits(){return _credits;}
}
class Student{
    // _sid is a unique identifier for a student
    private String _sid;
    private Address _addr;
    private ArrayList<String>_courses;
    Student(){
        _courses = new ArrayList();
    }
    Student(String d, String s, String c, String st, String z){
        _sid = d;
        _addr = new Address(s, c, st, z);
        _courses = new ArrayList();
    }
    void setID(String id){_sid = id;}
    String getID(){return _sid;}
    void setStreet(String s){_addr.setStreet(s);}
    String getStreet(){return _addr.getStreet();}
    void setCity(String s){_addr.setCity(s);}
    String getCity(){return _addr.getCity();}
    void setState(String s){_addr.setState(s);}
    String getState(){return _addr.getState();}
    void setZip(String s){_addr.setZip(s);}
    String getZip(){return _addr.getZip();}
    /**
     * Add course to student schedule
     * @param cnum valid course number in the schedule that's not full
     * @return true if course added, false if no room to add course
     */
    boolean addCourse(String cnum){
        if(_courses.contains(cnum)){
            return false;
        }
        else{
            _courses.add(cnum);
            return true;
        }
    }
    /**
     * Drop from course to student schedule
     * @param cnum valid course number in the schedule that's not full
     * @return true if course dropped, false if no room to add course
     */
    boolean dropCourse(String cnum){
        if(_courses.contains(cnum)){
            _courses.remove(cnum);
            return true;
        }
        return false;
    }
}
class AllStudents extends Student {
    private static ArrayList<Student> _students;
    /**
     * Finds the student by id in the array of _students
     * @param id valid student id
     * @return index of where student found or -1 if not found
     */
    private int findStudent(String id) {
        int i = 0;
        int found = -1;
        while (i < _students.size() && found == -1) {
            if (_students.get(i).getID().equals(id)) {
                found = i;
            }
            i++;
        }
        return found;
    }
    public AllStudents() {

        _students = new ArrayList<Student>();
    }
    public static void loadStudent(Scanner infile){
        while (infile.hasNext()) {
            String dataline = infile.nextLine();
            String[] data = dataline.split(", ");
            String d = data[0];
            String s = data[1];
            String c = data[2];
            String st = data[3];
            String z = data[4];
            _students.add(new Student(d, s, c, st, z));
        }
    }
    /**
     * Add Student to Object
     * @param Student Student object in array of AllStudents
     * @return true if deleted, false if not
     */
    boolean addStudent(AllStudents Student) {
        if (_students.contains(Student)) {
            _students.add(Student);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Drops Student from object
     * @param Student Student object in Array of Allstudents
     * @return returns true if deleted, false if not
     */
    boolean dropStudent(AllStudents Student) {
        if (Student != null) {
            _students.remove(Student);
            return true;
        }
        return false;
    }
    /**
     * Adds course to student schedlue
     * @param id   student id number
     * @param cnum course number to add
     * @return true if added, false otherwise
     */
    public boolean addCourseToStudent(String id, String cnum) {
        int slot = findStudent(id);
        if (slot == -1)
            return false;
        else {
            if (_students.get(slot).addCourse(cnum))
                return true;
            else {
                return false;
            }
        }
    }
    /**
     * Drops Course from Student
     * @param id student id number
     * @param cnum course number
     * @return true if added, false if not
     */
    public boolean dropCourseFromStudent(String id, String cnum) {
        int slot = findStudent(id);
        if (slot != -1)
            return false;
        else {
            if (_students.get(slot).dropCourse(cnum))
                return true;
            else {
                return false;
            }
        }
    }
}
class Schedule {
    private ArrayList<Course> _courses;
    private ArrayList<Integer> _enrollment;
    private int _nextCourse;
    /**
     * Finds the course in the array
     * @param cnum course number
     * @return index where course is found returns -1 if not found
     */
    private int findCourse(String cnum) {
        int found = -1;
        int slot = 0;
        while (found == -1 && slot < _nextCourse) {
            if (_courses.get(slot).getNumber().equals(cnum)) {
                found = slot;
            }
            slot++;
        }
        return found;
    }
    public Schedule() {
        _courses = new ArrayList<>();
        _enrollment = new ArrayList<>();
        _nextCourse = 0;
    }
    public void loadSchedule(Scanner infile) {
        while (infile.hasNext() && _nextCourse < _courses.size()) {
            String dataline = infile.nextLine();
            String[] data = dataline.split(", ");
            String cnum = data[0];
            String cname = data[1];
            int cr = Integer.parseInt(data[2]);
            _courses.set(_nextCourse, new Course(cnum, cname, cr));
            _enrollment.set(_nextCourse, 0);
            _nextCourse++;
        }
    }
    /**
     * Adds course to schedule
     * @param cnum    course number
     * @param cname   course name
     * @param credits credits
     * @return return true if added, false if no room
     */
    public boolean addCourse(String cnum, String cname, int credits) {
        if (_nextCourse >= 0 && _nextCourse < _courses.size()) {
            _courses.set(_nextCourse, new Course(cnum, cname, credits));
            _enrollment.set(_nextCourse, 0);
            _nextCourse++;
            return true;
        }
        return false;
    }

    /**
     * drops Course from schedule
     * @param cnum course number
     * @return true if dropped course false if not
     */
    public boolean dropCourse(String cnum) {
        if (_nextCourse >= 0 && _courses != null) {
            _courses.remove(findCourse(cnum));
            return true;
        }
        return false;
    }
    /**
     * course number
     * @param i index of course to return - starts at 0
     * @return course number found at index i or "" if not found
     */
    public String getCourseNumber(int i) {
        if (i >= 0 && i < _nextCourse) {
            return _courses.get(i).getNumber();
        }
        return "";
    }
    /**
     * Adds 1 to course count
     * @param cnum course number
     */
    public void increaseEnrollment(String cnum) {
        int index = findCourse(cnum);
        if (index != -1)
            index++;
        _enrollment.get(index);
    }
    /**
     * Subtracts to course count
     * @param cnum course number
     */
    public void decreaseEnrollment(String cnum) {
        int index = findCourse(cnum);
        if (index != -1) {
            _enrollment.set(index, 0);
        }
    }
    public void printSchedule() {
        for (int i = 0; i < _nextCourse; i++) {
            System.out.println("Course Number: " + _courses.get(i).getNumber());
            System.out.println("Course Name: " + _courses.get(i).getName());
            System.out.println("Course Credits: " + _courses.get(i).getCredits());
            System.out.println("Number Enrolled: " + _enrollment.get(i));
        }
    }
    public int getNumCourses() {
        return _nextCourse;
    }
}
public class Main {
    public static Scanner openFile() throws IOException {
        File dataFile = new File("courses.txt");
        if (!dataFile.exists()) {
            System.out.println("data file does not exist - exiting program");
            System.exit(-1);
        }
        Scanner s = new Scanner(dataFile);
        return s;
    }
    public static Scanner openFile2() throws IOException {
        File dataFile = new File("students.txt");
        if (!dataFile.exists()) {
            System.out.println("data file does not exist - exiting program");
            System.exit(-1);
        }
        Scanner s = new Scanner(dataFile);
        return s;
    }
    public static int showMenu(Scanner scan) {
        System.out.println("1. Add Course");
        System.out.println("2. Drop Course");
        System.out.println("3. Exit");
        int choice;
        System.out.print("Make a Selection: ");
        choice = scan.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Invalid Selection - Try Again");
            choice = scan.nextInt();
        }
        return choice;
    }
    public static String getCourseChoice(Schedule sched, Scanner scan) {
        for (int i = 1; i <= sched.getNumCourses(); i++) {
            System.out.println("" + i + ": " + sched.getCourseNumber(i - 1));
        }
        System.out.print("Please make a choice: ");
        int choice = scan.nextInt();// should do input validation
        return sched.getCourseNumber(choice - 1);
    }
    public static void addCourse(Schedule sched, students, Scanner scan) {
        String cnum = getCourseChoice(sched, scan);
        System.out.println("Enter your id");
        String id = scan.next();
        boolean added;
        added = students.addCourseToStudent(id,cnum);
        if (added)
            sched.increaseEnrollment(cnum);
    }
    public static void dropCourse(Schedule sched, ArrayList<AllStudents> students, Scanner scan) {
        String cnum = getCourseChoice(sched, scan);
        System.out.println("Enter your id");
        String id = scan.next();
        System.out.println("in dropCourse");
        boolean dropped;
        dropped = students.dropCourseFromStudent(id,cnum);
        if (dropped)
            sched.decreaseEnrollment(cnum);
    }

    public static void main(String[] args)throws IOException {
        Scanner scan = new Scanner(System.in);
        Schedule schedule = new Schedule();
        schedule.loadSchedule(openFile());
        schedule.printSchedule();
        ArrayList<AllStudents> students =new ArrayList<>();
        AllStudents.loadStudent(openFile2());
        int choice = showMenu(scan);
        while (choice != 3) {
            if (choice == 1)
                addCourse(schedule,students, scan);
            else
                dropCourse(schedule,students, scan);
            choice = showMenu(scan);
        }
        schedule.printSchedule();
    }
}
//******************MAIN2**********
//public static void main(String[] args)throws IOException
/* White-box testing for Address
        System.out.println("Instantiating Address:");
        Address address = new Address();
        System.out.println("Setting Address Labels");
        address.setStreet("STREET");
        address.setCity("CITY");
        address.setState("STATE");
        address.setZip("ZIP");
        System.out.println("Getting address info");
        System.out.println(address.getStreet());
        System.out.println(address.getCity());
        System.out.println(address.getState());
        System.out.println(address.getZip());
        System.out.println(address);
*/
/*
        White-box testing for Course:
        System.out.println("Instantiating Course");
        Course course = new Course();
        System.out.println("Setting Course Labels");
        course.setNumber("");
        course.setName("");
        course.setCredits("");
        System.out.println("Getting Course info");
        System.out.println(course.getNumber());
        System.out.println(course.getName());
        System.out.println(course.getCredits());
*/
/*
        White-box testing for Student:
        System.out.println("Instantiating Student");
        Student student = new Student();
        System.out.println("Setting Student Labels");
        course.setID("ID");
        System.out.println("Address class should populate with student");
        System.out.println("Getting Student Info");
        System.out.println(student.getID());
        System.out.println(student.getStreet());
        System.out.println(student.getCity());
        System.out.println(student.getState();
        System.out.println(student.getZip());
        System.out.println(student);
*/
/*
        White-box testing for AllStudents:
        System.out.println("Instantiating Student");
        ArrayList<AllStudents> students= new ArrayList();
        System.out.println("Adding a new student to ArrayList");
        n.add(newStudent());
        n.add(newStudent("ID","Address","State","City","Zip");
        System.out.println("Printing Array");
        System.out.println(students);
*/
/*
        White-box testing for Schedule:
        System.out.println("Instantiating Schedule Array");
        ArrayList<Schedule> schedule= new ArrayList<>();
        System.out.println("Schedule includes courses no need to set info")
        System.out.println(schedule);
*/