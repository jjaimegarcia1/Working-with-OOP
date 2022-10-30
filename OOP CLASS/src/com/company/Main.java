package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        String s ="firehouse";
        int r1,r2;
        r1 = rand.nextInt(s.length());
        r2 = rand.nextInt(s.length());
        String j;
        if (r1 > r2){
            int t = r1;
            r1 = r2;
            r2 = t;

        }
        int len = s.length();
        j = s.substring(0,r1);
        j = j + s.charAt(r2);
        j = j + s.substring(r1+1,r2);
        j = j + s.charAt(r1);
        j = j +s.substring(r2+1,len);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(j);



    }
}
