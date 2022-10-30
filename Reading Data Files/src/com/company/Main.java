package com.company;


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner infile = new Scanner(new File("data.txt"));
        int sum = 0;
        while(infile.hasNext()){
            sum = sum + infile.nextInt();
        }
        System.out.println(sum);
    }
}
