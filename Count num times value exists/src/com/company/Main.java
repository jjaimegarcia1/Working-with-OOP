package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main (String[]args) throws IOException {
        Scanner infile = new Scanner(new File("data.txt"));
        int num;
        int ctr = 0;
        while (infile.hasNext()){
            num = infile.nextInt();
            if (num == 32) //looking for number 32
                ctr++;
        }
        System.out.println("# times found: " + ctr);
    }
}
