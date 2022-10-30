package com.company;
import java.util.*;

interface Encryption{
    void encrypt();
    void decrypt();
}
class Secret implements Encryption{
    private String _msg;
    private boolean _isEncrypted;
    private Random _rand;
    private int _rval;
    public Secret(String s, boolean b){
        _msg = s;
        _isEncrypted = b;
    }
    public void encrypt(){
        String temp = "";
        for (int i=0; i<_msg.length(); i++){
            int x = ((int)_msg.charAt(i));
            x = x - 4; // should be _rval
            temp = temp + ((char)x);
        }
        _msg = temp;
    }
    public void print(){
        System.out.println(_msg);
    }
    public void decrypt(){}
}
public class Main {

    public static void main(String[] args) {
        Secret s = new Secret("aello", false);
        s.encrypt();
        s.print();
    }
}
