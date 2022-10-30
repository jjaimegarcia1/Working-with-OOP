package com.company;
import java.util.*;
class Door{
    private boolean _open;
    public Door(){
        _open = true;
        System.out.println("in Door default constructor");
    }
    public Door(boolean b){_open=true;}
    /* For an Abstract class
    abstract class Door{
    private boolean _open;
    public Door(){
        _open = true;
        System.out.println("in Door default constructor");
    }*/
    public void close(){
        _open = false;
        System.out.println("door closed");
    }
    /*abstract void open();*/
    public void open(){
        System.out.println("inDoor open");
        _open=true;
    }
    public void openDoor(){
        _open=true;
    }
    {
        System.out.println("in Door open");
        _open = true;
        System.out.println("door opened");
    }
    public boolean isOpen(){return _open;}
    public String toString(){
        return "Open: " + Boolean.toString(_open);
    }
    public boolean equals(Object obj){
        if(((Door) obj)._open == _open)
            return true;
        else
            return false;
    }
}
/**
 * Door can't be locked unless closed.
 */
class LockedDoor extends Door{
    private boolean _locked;
    public LockedDoor(){
        System.out.println("in Locked Door default constructor");
    }
    public LockedDoor(boolean op, boolean lock){
        System.out.println("In LockedDoor n-arg constructor");
        _locked = lock;
        if (op && lock){
            _locked = false;
        }
        else if (!op)
            super.close();
    }
    public void lock(){
        // 1.
        if (isOpen()){
            System.out.println("must close door first");
        }
        else{
            _locked = true;
            System.out.println("door is locked");
        }
        // 2.
        //close();
        //_locked = true;
    }
    public void unlock(){
        System.out.println("unlocking door");
        _locked = false;
    }
    public boolean isLocked(){return _locked;}
    public void open(){
        System.out.println("in locked door open");
        // 1.
        if (_locked)
            System.out.println("must unlock door first");
        else
            super.open();
        // 2.
        //_locked = false;
        //super.open();
    }
    public String toString(){
        return super.toString() + " Locked: " + Boolean.toString(_locked);
    }
    public boolean equals(Object obj){
        if(((LockedDoor) obj)._locked == _locked && super.equals(obj))
            return true;
        else
            return false;
    }
}

class PasswordDoor extends LockedDoor{
    private String _password;
    public PasswordDoor(){
        super(false, true);
        _password = "password";
        System.out.println("in Password Door default constructor");
    }
    public PasswordDoor(boolean op, boolean lock, String pw){
        super(op, lock);
        _password = pw;
        System.out.println("in Password Door n-arg constructor");
    }

    /**
     * This is NOT overriding but overloading.  Notice though that
     * this can cause problems because the user can call the inherited open
     * without passing in the password.
     * @param pw
     */


    public void open(String pw){
        System.out.println("in password open");
        if (pw.equals(_password)){
            super.unlock();
            super.open();
        }
    }
    public void chgPassword(){

    }
    public void open(){
        System.out.println("In dummy open");
        // does nothing but doesn't open the door
    }
    public String toString(){
        return super.toString() + " Password: " + _password;
    }
    public boolean equals(Object obj){
        if(((PasswordDoor) obj)._password == _password && super.equals(obj))
            return true;
        else
            return false;
    }
}
class Inventory{
    private ArrayList<Door> _doors;
    private ArrayList<String> _whouse;
    private ArrayList<Integer> _snumber;
    public Inventory(){
        _doors= new ArrayList<Door>();
        _whouse= new ArrayList<String>();
        _snumber= new ArrayList<Integer>();

    }
    public void add(int t,boolean op,boolean lk,String pw, String wh,int snum){
        if(t==1)
            _doors.add(new Door(op));
        else if(t==2)
            _doors.add(new LockedDoor(op,lk));
        else
            _doors.add(new PasswordDoor(op,lk,pw));
            _whouse.add(wh);
            _snumber.add(snum);
    }
    public void print(){
        for(int i=0; i<_doors.size();i++) {
            System.out.println(_doors.get(i).toString());
            System.out.println(_whouse.get(i));
            System.out.println(_snumber.get(i));
        }
    }
    public void chgPassword(String s,int slot){
        ((PasswordDoor)_doors.get(slot)).chgPassword();
    }
}
public class Main {

    public static void main(String[] args) {
       Inventory inv = new Inventory();
       inv.add(1,false,false,"","100",12);
       inv.add(2,false,false,"","120",15);
       inv.add(3,false,false,"password123","100",19);
       inv.print();
       inv.chgPassword("pNEWPASSWOR",2);
       inv.print();
        /*
        Part2 Class
        Door d= new Door();
        d.open();
        System.out.println(d.isOpen());

        LockedDoor ld = new LockedDoor();
        ld.open();
        System.out.println("");

        PasswordDoor pd = new PasswordDoor();
        System.out.println(pd.isOpen());
        pd.open("password");
        System.out.println(pd.isOpen());
        System.out.println(pd.toString());
        */

        /*
        Instantiating door
        Door d = new Door();
        Door d2 = new Door();
        if (d.equals(d2)){
            System.out.println("yes");
        }
        if (d == d2){
            System.out.println("yes");
        }
        */
    }

}

        /*
        System.out.println("Instantiating ldTT");
        LockedDoor ldTT = new LockedDoor(true, true);
        System.out.println("isOpen? " + ldTT.isOpen() );
        System.out.println("isLocked? " + ldTT.isLocked() );
        System.out.println("Instantiating ldTF");
        LockedDoor ldTF = new LockedDoor(true, false);
        System.out.println("isOpen? " + ldTF.isOpen() );
        System.out.println("isLocked? " + ldTF.isLocked() );
        System.out.println("Instantiating ldFT");
        LockedDoor ldFT = new LockedDoor(false, true);
        System.out.println("isOpen? " + ldFT.isOpen() );
        System.out.println("isLocked? " + ldFT.isLocked() );
        System.out.println("Instantiating ldFF");
        LockedDoor ldFF = new LockedDoor(false, false);
        System.out.println("isOpen? " + ldFF.isOpen() );
        System.out.println("isLocked? " + ldFF.isLocked() );

        /* White-box testing for ldoor
        System.out.println("Instantiating ldoor:");
        LockedDoor ldoor = new LockedDoor();
        System.out.println("Closing door:");
        ldoor.close();
        System.out.println("Locking door:");
        ldoor.lock();
        System.out.println("isLocked? " + ldoor.isLocked());
        System.out.println("Opening door:");
        ldoor.open();
        System.out.println("Unlocking door:");
        ldoor.unlock();
        System.out.println("isLocked? " + ldoor.isLocked());
        System.out.println("Opening door:");
        ldoor.open();
         */

        /*
        White-box testing for door:
        System.out.println("Instantiating door");
        Door door = new Door();
        System.out.println("isOpen? " + door.isOpen());
        System.out.println("Open door:");
        door.open();
        System.out.println("isOpen? " + door.isOpen());
        System.out.println("Close door:");
        door.close();
        System.out.println("isOpen? " + door.isOpen());
        System.out.println("Close door:");
        door.close();
        System.out.println("isOpen? " + door.isOpen());
         */

