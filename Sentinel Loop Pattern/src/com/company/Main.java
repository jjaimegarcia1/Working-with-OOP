package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number, to exit enter 0");
        int num =scan.nextInt();
        while (num != 0){
            System.out.println("You entered your name");
            scan.nextLine();// this acts as a buffer to allow both uses of scan next int, scan next line
            String name = scan.nextLine();
            System.out.println("Your name is "+name);
            System.out.println("You entered "+ num);
            System.out.println("Please enter a number, to exit enter 0");
            num =scan.nextInt();
        }
    }
}
