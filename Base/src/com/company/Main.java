package com.company;

import java.lang.reflect.Array;

class Base {
    private int _x;
    private static int _w = 7;

    public void setX(int a) {
        _x = a;

    }

    public Base() {
        _x = 5;
    }

    public void print() {
        System.out.println("x is" + _x);
    }

    //static void, non virtual method for w must include static variable.
    public static void print2() {
        System.out.println("w is" + _w);
    }
}

//New Class includes inheritance "extends"
class Derived extends Base {
    private int _y;

    public Derived() {
        _y = 3;
    }

    public void setY(int a) {
        _y = a;
    }

    public void print() {
        super.print();
        System.out.println("y is" + _y);
    }

    public static void print2() {
        System.out.println("hello");
    }
}


public class Main {

    public static void main(String[] args) {
        Base[] b = new Base[4];
        b[0] = new Base();
        b[1] = new Derived();
        b[2] = new Base();
        b[3] = new Derived();
        for (int i = 0; i < b.length; i++) {
            //call method in Base Class that is not overridden
            b[i].setX(5);
            //this is trying to only get the derived methods to output, call method in child class that is not overridden
            //check if child object AND typecast
            if (b[i].getClass().equals(Derived.class))
                ((Derived) b[i]).setY(9);//changes your y's to 9
            b[i].print(); //dynamically bound method, overrriding
        }


        /*Base b = new Derived();
        Derived d = new Derived();
        System.out.println("Print b");
        b.print();
        b.print2();
        //Typecast because b.setY(); Creates syntax error
        ((Derived) b).setY(8);
        System.out.println("Print d");
        d.print();
        b = new Base();
        System.out.println("Print b");
        b.print();
        b.print2();
        //static method
        Derived.print2();*/
    }
}
