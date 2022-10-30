package com.company;

import java.util.*;
import java.io.*;
import java.io.IOException;

class MorseCode {
    private static char[] alphabetic = new char[26];
    private static String[] morse = new String[26];


    private MorseCode() {
    }

    public static String translate(String toTranslate) {

        StringBuilder result = new StringBuilder();

        // loop over all chars in the string, skipping spaces etc...
        for (char c : toTranslate.toCharArray()) {
            if (Character.compare(c, ' ') == 0) {
                result.append('\n');
            }
            result.append(letterToMorse(c));
            result.append(' ');
        }

        return result.toString();
    }

    private static String letterToMorse(char c) {
        for (int i = 0; i < alphabetic.length; i++) {
            if (alphabetic[i] == Character.toUpperCase(c)) {
                return morse[i];
            }
        }

        return "";
    }

}


    // At first use, loads the translation table

    public static String getFileName(Scanner scan) throws IOException {
        boolean validFile = false;
        String fileName= null;
        while (!validFile) {
            System.out.println("Please enter data file name: ");
            fileName = scan.nextLine();
            new Scanner(new File(fileName));
        }
        return fileName;
    }

    public static void main(String[]arg) throws IOException {
        File file = new File(fileName);

        Scanner scan = new Scanner(file);

        //for loop that loads values in morsecode.txt to the code string array.
        for (int k = 0; scan.hasNextLine(); k++) {
            morse[k] = scan.nextLine();
        }

    }
}
