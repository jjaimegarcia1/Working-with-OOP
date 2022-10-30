package com.company;
import java.io.*;
import java.util.*;

class Teacher {
    private String _name;
    private String _rank;
    public Teacher() {
        _name = "Jose";
        _rank = "Professor";
    }

    public Teacher(String n, String r) {
        _name = n;
        _rank = r;
    }

    public void setName(String n) {
        _name = n;
    }

    public void setRank(String r) {
        _rank = r;
    }

    public String getName() {
        return _name;
    }

    public String getRank() {
        return _rank;
    }

}
public class Main {

    public static void main(String[] args) {
        Teacher[] t = new Teacher[10];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Teacher();
        }
        t[0].setName("St. Clair");
        t[0].setRank("Professor");
        for(int i=0;i<t.length;i++){
            System.out.println(t[i].getRank());
            System.out.println(t[i].getName());
            System.out.println("************");

        }
    }
}
