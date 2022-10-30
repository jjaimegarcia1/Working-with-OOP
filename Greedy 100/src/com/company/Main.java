//*********************************
// Jose Jaime
//Greedy100 Project
//Object Oriented Programming
//Dr. Caroline St. Clair
//*********************************

package com.company;
import java.util.*;


class Dice {
    private int _die1;
    private int _die2;

    public Dice(){
        _die1 = 6;
        _die2 = 6;
    }
    public int getDie1() {
        roll();
        return _die1;
    }
    public int getDie2() {
        roll();
        return _die2;
    }
    public void roll() {
        _die1 = (int) (Math.random() * 6)+1;
        _die2 = (int) (Math.random() * 6)+1;
    }
}

class Player {

    private String _name;
    private int _totalscore;

    public Player() {
        _name = "";
        _totalscore=0;
    }

    public Player(String n) {
        _name = n;
    }


    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }

    public void set_totalscore(int t) {
        _totalscore = t;
    }

    public int get_totalscore() {
        return _totalscore;
    }

    public void set_addscore(int addscore) {
        _totalscore += addscore;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("*Welcome to Greedy 100*");
        System.out.println("Please enter number of players");
        int ctr;
        int i;
        int j;

        ctr = scan.nextInt();
        Player[] player = new Player[ctr];
        for (i = 0; i < ctr; i++) {
            player[i] = new Player();
            System.out.println("Please enter Player " + (i + 1) + " name");
            player[i].set_name(scan.next());
            player[i].set_totalscore(0);
        }

        for (j = 0; j < player.length; j++) {
            String name = player[j].get_name();
            int score = player[j].get_totalscore();
            System.out.println(name + " Its your turn, your score is: " + score);
            System.out.println();

            System.out.println("Press r to roll, any other character to pass");
            String r = scan.next();
            while (r.equals("r")) {
                final int win = 100;
                Dice d = new Dice();
                for (int k = score; k <= win; k = (d.getDie1() + d.getDie2())) {
                    int die1 = d.getDie1();
                    int die2 = d.getDie2();
                    int addscore = die1 + die2;
                    if (die1 != 1 && die2 != 1) {
                        System.out.println("Die 1: " + die1);
                        System.out.println("Die 2: " + die2);
                        System.out.println("Value: " + addscore);
                        player[j].set_addscore(addscore);
                        System.out.println("Player " + player[j].get_name());
                        System.out.println("Your Score right now is " + player[j].get_totalscore());


                    }
                    else if (addscore == 2) {
                        System.out.println("Die 1: " + die1);
                        System.out.println("Die 2: " + die2);
                        System.out.println("Super BAD Luck you rolled two 1's");
                        System.out.println("Resetting your score to 0");
                        player[j].set_totalscore(0);

                    }
                    else {
                        System.out.println("Die 1: " + die1);
                        System.out.println("Die 2: " + die2);
                        System.out.println(player[j].get_name()+ " Too Bad you rolled a 1");
                        System.out.println("Next players turn");
                    }
                    if (player[j].get_totalscore() > 100) {
                        System.out.println(" ");
                        System.out.println("************************************");
                        System.out.println("Congrats Player " + player[j].get_name() + " you have won");
                        System.out.println("***********************************");
                        System.out.println(" ");

                    }
                    System.out.println("Press r to roll, any other character to pass ");
                    r = scan.next();
                }



            }

        }
    }
}