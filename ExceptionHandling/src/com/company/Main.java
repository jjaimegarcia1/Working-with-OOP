package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void readFile(Scanner infile) {
        String s;
        int num;
        int sum = 0;
        try {
            while (infile.hasNext()) {
                s = infile.next();
                if (s.matches("[0-9]+")){
                    num = Integer.parseInt(s);
                    sum = sum + num;
                }
            }
        }
        catch(NumberFormatException exc) {
            System.out.println("Not an Integer");
        }
        catch (Exception exc) {
            System.out.println("Unable to process file");
        }
        finally {
            System.out.println("ALL DONE");
        }
        System.out.println(sum);
        System.out.println("Ending Function");
    }

    public static void main(String[] args) {
        try {
            Scanner infile = new Scanner(new File("File.txt"));
            readFile(infile);//This is included in your try because it is part of your scanner infile.
            System.out.println("ending Main");
        } catch (IOException exc) {
            System.out.println("File not Found");
        }
    }
}
