//Jose Jaime
//Range Guessing Game
//Object Oriented Programming
//Dr. Caroline St. Clair

package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to The Number Guessing Game");
        System.out.println("Do you want to play, type y if yes");
        String play = scan.next();
        while (play.equals("y")) {
            System.out.println("Please enter 2 numbers as your limits");
            int lowlimit = scan.nextInt();
            int highlimit = scan.nextInt();
            int guess = valInput(scan,lowlimit,highlimit);

            Random rand = new Random();
            int numbertoguess = rand.nextInt(lowlimit,highlimit);
            int i=1;
            boolean answered=false;
            while(i!=6 && !answered) {
                if (guess == numbertoguess){
                    System.out.println("Congratulations!");
                    System.out.println("The number was "+numbertoguess);
                    answered=true;
                }
                if (guess > numbertoguess) {
                    System.out.println("Too high, try again");
                    System.out.println("This is guess # " + i);
                    numbertoguess = rand.nextInt(guess)+lowlimit;
                    highlimit=(guess-1);
                    guess = valInput(scan,lowlimit,highlimit);
                    i++;
                }
                if (guess < numbertoguess) {
                    System.out.println("Too low, try again");
                    System.out.println("This is guess # " + i);
                    numbertoguess = rand.nextInt(highlimit)+guess;
                    lowlimit=(guess+1);
                    guess = valInput(scan,lowlimit,highlimit);
                    i++;
                }
                if (i == 5){
                    System.out.println("Your 5 guesses are up too bad!");
                    System.out.println("The number was "+numbertoguess);
                    i=6;
                }

            }
            System.out.println("Do you want to play, type y for yes");
            play = scan.next();
        }
        System.out.println("Okay! Goodbye!");
    }

public static int valInput(Scanner scan, int lowlimit,int highlimit) {
        System.out.println("Guess a number between " +  lowlimit+ " and " + highlimit);
        int guess = scan.nextInt();
        while (guess < lowlimit || guess > highlimit) {
            System.out.println("Your number was not within the range please try again");
            guess = scan.nextInt();
        }
        return guess;
    }
}
