package com.company;

import java.util.*;
import java.io.*;

public class Main {

        public static void main (String[]args) throws IOException {
            Scanner infile = new Scanner(new File("data.txt"));
            int num = 0;
            boolean found = false;
            while (infile.hasNext() && !found) { // found == false
                num = infile.nextInt();
                if (num == 32) //looking for number 32
                    found = true;
            }
            System.out.println("Value Found?" + found);
        }
    }

