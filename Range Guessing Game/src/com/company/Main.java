package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to The Number Guessing Game");
        System.out.println("Do you want to play, type y/n)");
        String play = scan.next();
        if (play.equals("n")) {
            System.out.println("Goodbye!");
        }
        else if (play.equals("y")) {
            System.out.println("Please enter your limit");
            int l = scan.nextInt();

            Random rand = new Random();
            int ng = rand.nextInt(l);

            int i;

            for (i = 0; i < 5; i++) ;{
                System.out.println("Guess a number between 0 and" + l);
                int g = scan.nextInt();

                // if guess is greater than actual
                if (g > ng) {
                    System.out.println("Too high, try again");
                }

                // if guess is less than actual
                else if (g < ng) {
                    System.out.println("Too low, try again");
                }

                // guess is equal to actual value
                else {
                    System.out.println("Yes, you guessed the number.");
                }
            }
        }
    }
}
