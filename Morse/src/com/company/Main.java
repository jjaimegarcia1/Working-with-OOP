
package com.company;
import java.util.*;
import java.io.*;

class Morse {
    private static String[] MorseCode = new String[26];
    private static char[] Alphabetic = new char[26];

    private Morse(){
    }

    public Morse(String m) { //n argument constructor
        Scanner inCode = new Scanner(new File( Morse.class.get("morse.txt").getFile()));


        }


    public char _getMorse() { //accessor
        return String(_MorseText);
    }

    public String getChar() { //accessor
        return char(_MorseText);
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

