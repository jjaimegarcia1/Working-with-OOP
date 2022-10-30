package com.company;

import java.util.*;
import java.io.*;

class Book {
    private static int page;
    private static int chapter;

    public Book(){

    }
    public Book(int p, int c){
        page = 0;
        chapter = 0;
    }

    public static int getPage(){
        return getPage();
    }

    public static int getChapter(){
        return getChapter();
    }


private static int _Ctr=0 ;

    public int getCtr() {
        return _Ctr;
    }



    public static void main(String[] args) {
        Book b=new Book();
        System.out.println("Please enter chapter");
        System.out.println("Please enter page");


        Book b2 =new Book();
        System.out.println(b.getPage());
        System.out.println(b.getChapter());
    }
}
