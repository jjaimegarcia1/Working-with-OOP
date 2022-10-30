package com.company;
import java.io.*;
import java.util.*;
class Address{
    private String _street;
    private String _city;
    private String _state;
    private String _zip;
    Address(){}
    Address(String s, String c, String st, String z){
        _street = s;  _city = c; _state = st; _zip = z;
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
        _cnum = num;  _cname = name; _credits = cred;
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
    private String[] _courses;
    private int _nextCourse;
    Student(){
        _courses = new String[10];
        _nextCourse = 0;
    }
    Student(String d, String s, String c, String st, String z){
        _sid = d;
        _addr = new Address(s, c, st, z);
        _courses = new String[10];
        _nextCourse = 0;
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
        if(_nextCourse >= 0 && _nextCourse<_courses.length) {
            _courses[_nextCourse] = cnum;
            _nextCourse++;
            return true;
        }
        return false;
    }
    boolean dropCourse(String cnum){
        return false;
    }
}
class AllStudents{
    private Student[] _students;
    private int _nextStudent;

    /**
     * Finds the student by id in the array of _students
     * @param id valid student id
     * @return index of where student found or -1 if not found
     */
    private int findStudent(String id){
        int i=0;
        int found = -1;
        while(i<_nextStudent && found==-1){
            if(_students[i].getID().equals(id)){
                found = i;
            }
            i++;
        }
        return found;
    }

    public AllStudents(){
        _students = new Student[100];
        _nextStudent = 0;
    }

    /**
     * Adds student to object
     * @param id student id number
     * @param s street
     * @param c city
     * @param st state
     * @param z zip
     * @return true if students false if no room
     */
    public boolean addStudent(String id, String s, String c, String st, String z){
        if(_nextStudent >= 0 && _nextStudent<_students.length) {
            Student b = new Student(id, s, c, st, z);
            _students[_nextStudent] = b;
            //_students[_nextStudent] = new Student(id,s,c,st,z); instead of typing two lines of code
            _nextStudent++;
            return true;
        }
            return false;
    }
    public void dropStudent(String id){}
    /**
     * Adds course to student schedlue
     * @param id student id number
     * @param cnum course number to add
     * @return true if added, false otherwise
     */
    public boolean addCourseToStudent(String id, String cnum){
        int slot = findStudent(id);
        if (slot ==-1)
            return false;
        else{
            if (_students[slot].addCourse(cnum))
               return true;
           else
               return false;

        }
    }
    public void dropCourseFromStudent(String id, String cnum){}

    public void print(){
        for (int i=0; i<_nextStudent; i++){
            System.out.println(_students[i].getID());
        }
    }
}
class Schedule{
    // container of all courses offered for semester
    private Course[] _courses;
    // parallel container to _courses, number of students enrolled
    private int[] _enrollment;
    private int _nextCourse;

    /**
     * Finds the course in the array
     * @param cnum course number
     * @return index where course is found returns -1 if not found
     */
    private int findCourse(String cnum){
        int found =-1;
        int slot = 0;
        while (found == -1 && slot < _nextCourse) {
            if (_courses[slot].getNumber().equals(cnum)){
                found = slot;
            }
            slot ++;
        }
        return found;
    }
    public Schedule(){
        _courses = new Course[100];
        _enrollment = new int[100];
        _nextCourse = 0;
    }
    public void loadSchedule(Scanner infile){
        while (infile.hasNext() && _nextCourse<_courses.length) {
            String dataline = infile.nextLine();
            String[] data = dataline.split(", ");
            String cnum = data[0];
            String cname = data[1];
            int cr = Integer.parseInt(data[2]);
            _courses[_nextCourse] = new Course(cnum, cname, cr);
            _enrollment[_nextCourse] = 0;
            _nextCourse++;
        }
    }

    /**
     * Adds course to schedule
     * @param cnum course number
     * @param cname course name
     * @param credits credits
     * return true if added, false if no room
     */
    public boolean addCourse(String cnum, String cname, int credits){
       if(_nextCourse >= 0 && _nextCourse < _courses.length) {
           _courses[_nextCourse] = new Course(cnum, cname, credits);
           _enrollment[_nextCourse] = 0;
           _nextCourse++;
           return true;
       }
       return false;

       }
    public void dropCourse(String cnum){}

    /**
     * course number
     * @param i index of course to return - starts at 0
     * @return course number found at index i or "" if not found
     */
    public String getCourseNumber(int i){
        if(i>=0 && i <_nextCourse) {
            return _courses[i].getNumber();
        }
            return "";
        }

    /**
     * Adds 1 to course count
     * @param cnum course number
     */
    public void increaseEnrollment(String cnum){
        int index = findCourse(cnum);
        if(index != -1)
        _enrollment[index] ++;
    }
    public void printSchedule(){
        for(int i=0; i<_nextCourse; i++){
            System.out.println("Course Number: " + _courses[i].getNumber());
            System.out.println("\tCourse Name: " + _courses[i].getName());
            System.out.println("\tCourse Credits: " + _courses[i].getCredits());
            System.out.println("\tNumber Enrolled: " + _enrollment[i]);
        }
    }
    public int getNumCourses(){

        return _nextCourse;}
}

public class Main {
    public static Scanner openFile() throws IOException{
        File dataFile = new File("courses.txt");
        if (!dataFile.exists()){
            System.out.println("data file does not exist - exiting program");
            System.exit(-1);
        }
        Scanner s = new Scanner(dataFile);
        return s;
    }
    public static int showMenu(Scanner scan){
        System.out.println("1. Add Course");
        System.out.println("2. Drop Course");
        System.out.println("3. Exit");
        int choice;
        System.out.print("Make a Selection: ");
        choice = scan.nextInt();
        while (choice < 1 || choice > 3){
            System.out.println("Invalid Selection - Try Again");
            choice = scan.nextInt();
        }
        return choice;
    }
    public static String getCourseChoice(Schedule sched, Scanner scan){
        for (int i=1; i<=sched.getNumCourses(); i++){
            System.out.println("" + i + ": " + sched.getCourseNumber(i-1));
        }
        System.out.print("Please make a choice: ");
        int choice = scan.nextInt();// should do input validation
        return sched.getCourseNumber(choice-1);
    }
    public static void addCourse(Schedule sched, AllStudents students, Scanner scan){
        String cnum = getCourseChoice(sched,scan);
        System.out.println("Enter your id");
        String id = scan.next();
        boolean added = students.addCourseToStudent(id,cnum);
        if (added)
            sched.increaseEnrollment(cnum);
    }
    public static void dropCourse(Schedule sched, AllStudents students, Scanner scan){
        System.out.println("in dropCourse");
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Schedule schedule = new Schedule();
        schedule.loadSchedule(openFile());
        schedule.printSchedule();
        AllStudents students = new AllStudents();
        students.addStudent("100", "10 Elm", "Anywhere", "IL", "60506");
        students.addStudent("200", "20 Maple", "Somewhere", "IL", "60150");
        int choice = showMenu(scan);
        while (choice != 3){
            if (choice == 1)
                addCourse(schedule, students, scan);
            else
                dropCourse(schedule, students, scan);
            choice = showMenu(scan);
        }
        schedule.printSchedule();
    }
}