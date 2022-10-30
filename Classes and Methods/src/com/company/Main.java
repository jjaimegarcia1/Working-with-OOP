package com.company;

import java.util.*;
import java.io.*;

class Dog{
    private String_breed;
    private String_name;
    private int_age;
    private char_gender;
    public void setBreed(String b) {
        _breed = b;
    }
    public void setName(String n) {
        _name = n;
    }
    public void setAge(int a) {

        _age = a;
    }
    public void setGender(char g) {
        if (g=='f'|| g=='m')
        _gender = g;
    }



public class Main {
    public static Scanner openFile() throws IOException{...}
    public static void main(String[] args) {
        Dog d = new Dog("fido","german sheperd","10",'m');
        d.setAge(11);
        System.out.println(d.getName()+d.getBreed());
        Dog d2 = new Dog();
        System.out.println(d2.getName());




        }
    }













