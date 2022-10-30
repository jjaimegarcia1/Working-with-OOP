package com.company;
import java.io.*;


class Teacher {
    private String _name;
    private String _rank;

    Teacher() {
        _name = "Jose";
        _rank = "Professor";
    }

    Teacher(String n, String r) {
        _name = n;
        _rank = r;
    }

    void setName(String n) {
        _name = n;
    }

    void setRank(String r) {
        _rank = r;
    }

    String getName() {
        return _name;
    }

    String getRank() {
        return _rank;
    }

}
public class Main{
public static void Main(String[] args) throws IOException{
    Teacher[] t = new Teacher[10];
    for (int i = 0; i < t.length; i++) {
        t[i] = new Teacher();

    }
    t[0].setName("St. Clair");
    t[0].setRank("Professor");
    for(int i=0;i<t.length;i++){
        System.out.print(t[i].getName());
        System.out.print(t[i].getRank());

    }


}
}
