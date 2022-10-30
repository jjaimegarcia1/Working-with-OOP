//*********
// Jose Jaime
// Morse Code Program
// Dr. St Clair
// HW #2
//***********

package com.company;

import java.util.*;
import java.io.*;

class MorseCode {
    private static String[] morse = new String[26];
    private static char[] alphabetic = new char[26];

    public MorseCode() {
        Scanner scan = new Scanner(System.in);
        for (int k = 0; scan.hasNextLine(); k++) {
            morse[k] = scan.nextLine();
        }
        for (int j = 0; scan.hasNextLine(); j++) {
            alphabetic[j] = scan.nextLine().charAt(0);
        }
    }

    public String getMorse(char getMorse) {
        boolean found = false;
        int ctr = 0;
        while (ctr < morse.length && !found) {
            if (morse[ctr].getChar().equals(getMorse)) {
                found = true;
            }
            ctr++;
        }
        return getMorse(getMorse);
    }

    public static char getChar(String getChar) {
        boolean found = false;
        int ctr = 0;
        while (ctr < alphabetic.length && !found) {
            if (alphabetic[ctr].getMorse.equals(getChar)) {
                found = true;
            }
            ctr++;
        }
        return getChar(getChar);
    }

    public static String getFileName(Scanner scan) throws IOException {
        boolean validFile = false;
        String fileName = null;
        while (!validFile) {
            System.out.println("Please enter data file name: ");
            fileName = scan.nextLine();
            new Scanner(new File(fileName));
        }
        return fileName;
    }

    public static void main(String[] args) throws IOException {
        MorseCode code = new MorseCode();
        Scanner scan = new Scanner(System.in);
        System.out.println("Morse Code Translator Program");
        getFileName(scan);

        System.out.println("Do you wish to translate? Press (y) for yes");
        String translate = scan.next();
        while (translate.equals("y")) {
            System.out.println("Press 1 for English to Morse");
            System.out.println("Press 2 Morse to English");
            System.out.println("Press 0 to exit");
            int choice = scan.nextInt();

            if (choice == 1) //English to Morse
            {
                System.out.println("Enter what you want to translate in English");
                scan.nextLine();
                String phrase = scan.nextLine();
                phrase = phrase.toUpperCase();
                char[] sentenceChars = phrase.toCharArray();
                for (int i = 0; i < sentenceChars.length; i++) {
                    if (sentenceChars[i] == ' ') {
                        System.out.println("/ ");
                    }
                    else {
                        for (int j = 0; j < code.getMorse.length; j++) {
                            if (sentenceChars[i] == code.getMorse[j]) {
                                System.out.println(alphabetic[j] + " ");
                            }
                        }
                    }
                }
            }
            else if (choice == 2) {     //Morse to English
                System.out.println("Enter your morse code: ");
                scan.nextLine();
                String morseSentence = scan.nextLine();
                String[] morseSentenceArr = morseSentence.split(" ");
                for (int i = 0; i < morseSentenceArr.length; i++) {
                    if (morseSentenceArr[i].equals("/")) {
                        System.out.print("");
                    }
                    else {
                        for (int j = 0; j < code.getChar.length; j++) {
                            if (morseSentenceArr[i].equals(code.getChar[j])) {
                                System.out.println(morse[j]);
                            }
                        }
                    }
                }
            }
            System.out.println("Do you wish to translate? Press (y) for yes");
            translate = scan.next();
        }
    }
}