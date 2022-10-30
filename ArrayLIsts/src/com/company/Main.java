package com.company;
import java.sql.SQLOutput;
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

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> n =new ArrayList<Student>();
        n.add(new Student());//default constructor
        n.add(new Student("ID","address num","State","City","Zip"));//n argument constructor
        System.out.println(n);
        for (int i=0; i<n.size(); i++){
            System.out.println(n.get(i).getID());
        }
        for(Student a:n){
            System.out.println(a.getID());
        }

    }
}
//ArrayList<Integer> n = new //ArrayList<Integer>();
// n.add(12);
// n.add(5);
//n.add(17);
//System.out.println(n);
//System.out.println(n.size());
//System.out.println(n.get(0));
//n.remove(n.indexOf(5)); // index
//System.out.println(n);
//System.out.println(n.size());
// Integer five = 5;
// n.remove(five);
//System.out.println(n);
//System.out.println(n.size());
// write your code here
