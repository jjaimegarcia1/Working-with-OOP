package com.company;

class Address{
    private String _street;
    private String _city;
    private String _state;
    private String _zip;

    public Address() {
    Address n = new Address();
    }

    public String get_street() {
        return _street;
    }

    public void set_street(String _street) {
        this._street = _street;
    }
    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }
    public String get_state() {
        return _state;
    }

    public void set_state(String _state) {
        this._state = _state;
    }
    public String get_zip() {
        return _zip;
    }

    public void set_zip(String _zip) {
        this._zip = _zip;
    }
    public String toString(){
        return _street+" "+_city+" "+ _state + " "+_zip;
    }

}

class Student{
    private String _name;
    private Address _home;
    private Address _otherAddr;

    public Student() {
        _name = "";
        _home = new Address();
        _otherAddr = new Address();
    }


    public String getHomeStreet(){
        return _home.get_street();
    }

    public String toString(){
        String s= " ";
        s = _name+" "+_home.toString()+" "+_otherAddr.toString();
        return s;
    }

}


public class Main {

    public static void main(String[] args) {
       Student s =new Student();
        s.setHomeStreet("100 Prairie St");
        System.out.println(s.getHomeStreet());
        System.out.println(s.toString());
    }
}
