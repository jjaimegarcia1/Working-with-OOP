package com.company;

public class Main {
public static int fact(int num){
    System.out.println(num);
    if(num==0 || num==1) return 1;
    if(num <0) return 0;
    return num *fact(num-1);
}
    public static int gcd(int x, int y){
        System.out.println(" X " + x + " Y " + y);
        if (x%y==0) return y;
        return gcd(y, x%y);
    }
public static int fib(int num){
    System.out.println("FIB: " +num);
    if(num<=1) return 0;
    if(num==2) return 1;
    System.out.println(num);
    return fib(num-1)+fib(num-2);
}

    public static void main(String[] args) {
   /* System.out.println("Factorial " + fact(5));
    System.out.println("GCD 28 and 12 "+ gcd(28,12));
    System.out.println("GCD 12 and 28 "+ gcd(12,28));*/
    System.out.println("Fibonnaci "+ fib(4));
    }
}
