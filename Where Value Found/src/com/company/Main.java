package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main (String[]args) throws IOException {
        File dataFile = new File("data1.txt"); //this checks for a data 1 txt file
        if (!dataFile.exists()){ //looking for if the file exists
            System.out.println("Data File does not exist- exiting program");
            System.exit(-1); //will exit program and put exit code to status of -1
        }
        Scanner infile = new Scanner(dataFile);
        int num;
        int ctr = 0;
        boolean found = false;
        while (infile.hasNext() && !found){
            ctr++;
            num = infile.nextInt();
            if (num == 32) //looking for number 32
                System.out.println("value found on line" + ctr);
        found = true;
        }
    }
}
