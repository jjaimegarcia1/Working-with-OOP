package com.company;
class Student {
    // _sid is a unique identifier for a student
    private String _sid;
    private String _sname;

    Student() {
        System.out.println("inStudent()");
    }

    Student(String id, String n) {
        System.out.println("In Student N-ARG");
        _sid = id;
        _sname = n;

    }

    void setID(String id) {
        _sid = id;
    }

    String getID() {
        return _sid;
    }

    void setName(String n) {
        _sname = n;
    }

    String getName() {
        return _sname;
    }
}
class Ugrad extends Student{
    private String _major;
    public Ugrad(){
        System.out.println("in UGRAD()");
    }
    public Ugrad(String a, String b, String c){
        super (a,b);
        System.out.println("In UGRAD- N-ARG");
        //setID(a);
        //setName(b);
        _major= c;
    }
    public void setMajor(String s){_major=s;}
    String getMajor(){return _major;}
    //print out everything from your Parent Class and Child since it is an is-a
    public void print(){
        System.out.println(getID());
        System.out.println(getName());
        System.out.println(_major);
    }
}
class Atlarge extends Student{
    public Atlarge(){
        System.out.println("in at Atlarge");
    }
    public Atlarge(String a, String b){
        super(a,b);
        System.out.println("in Atlarge(n-arg)");
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Instantating Student");
        Student s = new Student();
        System.out.println("Instantating UGRAD Student");
        Ugrad s2 = new Ugrad("100","mary","csc");
        //s2.print();
        System.out.println(s2.getID());
        System.out.println(s2.getName());
        System.out.println(s2.getMajor());
        System.out.println("Instantating At Large Student");
        Atlarge at= new Atlarge("200","Tom");
        System.out.println(at.getID());
        System.out.println(at.getName());

    }
}
