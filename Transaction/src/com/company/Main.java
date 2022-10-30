//****************************************************//
//**Jose Jaime
//**Dr. St.Clair
//**Hw #5
//**Polymorphism
//****************************************************//
package com.company;

import java.util.*;

//****First portion**********************//
//Product Class to produce an array of products
class Product {
    private String _pname;
    public String _price;

    public Product() {
    }

    public Product(String pname, String price) {
        _pname = pname;
        _price = price;
    }

    void setPname(String pname) {
        _pname = pname;
    }

    String getPname() {
        return _pname;
    }

    void setPrice(String price) {
        _price = price;
    }

    String getPrice() {
        return _price;
    }
}

//**************Transaction Class******************/
//Parent class example of Composition//
class Transaction {
    private String _cusname;
    private ArrayList<Product> _products;
    public String _price;

    Transaction() {
    }

    Transaction(String cusname, ArrayList<Product> products) {
        _cusname = cusname;
        _products = new ArrayList<>(products);
    }

    void setCusname(String cusname) {
        _cusname = cusname;
    }

    String getCusname() {
        return _cusname;
    }

    public ArrayList<Product> get_products() {
        return _products;
    }

    public void set_products(ArrayList<Product> products) {
        _products = products;
    }

    /**
     * Product price of transaction
     *
     * @param price price of the product
     * @return returns price
     */
    String getProductPrice(String price) {
        return _price;
    }
}

//********CASH TRANSACTION**********************//
//**Cash Trans and Credit Trans Inherit from Transaction class**//
class CashTrans extends Transaction {
    private String amount;
    private boolean _paid;

    public CashTrans() {
    }

    public CashTrans(String cusname, ArrayList<Product> products, boolean c) {
        super(cusname, products);
        c = _paid;
    }

    public void set_paid(boolean t) {
        _paid = t;
    }

    Boolean get_paid() {
        return _paid;
    }

    //Overrides getProductPrice from Transaction Class
    /**
     * getProductPrice overrides getProduct Price from Transaction Class
     *
     * @return price of your product to pay
     */
    String getProductPrice() {
        return _price;
    }

    //Overloading Example here Payment has different parameters but same method
    /**
     * Overloading Payment Example will be taking CASH in for the payment
     * Checks to see if payment is same amount
     *
     * @param c verifies if item has already been paid for
     * @return true if payment has been completed, false if not.
     */
    public boolean Payment(String amount, boolean c) {
        if (getProductPrice().equals(amount) && !c) {
            c = true;
            return true;
        }
        System.out.println("Payment Failed please try again");
        return false;
    }
}

//*************CREDIT CARD TRANSACTION**********************//
//**Cash Trans and Credit Trans Inherit from Transaction class**//
class CreditTrans extends Transaction {
    private String amount;
    private boolean _paid;
    public String _cardinfo;

    public CreditTrans() {
    }

    public CreditTrans(String cusname, ArrayList<Product> products, boolean c, String cardinfo) {
        super(cusname, products);
        _paid = c;
        _cardinfo = cardinfo;
    }

    public void set_paid(boolean s) {
        _paid = s;
    }

    Boolean get_paid() {
        return _paid;
    }
    //** Overrides getProduct price from Transaction

    /**
     * getProductPrice overrides getProduct Price from Transaction Class
     *
     * @return price of your product to pay
     */
    String getProductPrice() {
        return _price;
    }

    //Overloading Example Here Payment is same method but different parameters

    /**
     * Overloading Payment Example will be taking CREDIT CARD in for the payment
     * Checks to see if Card number is 18 digits to make sure it's a Valid card
     *
     * @param amount   the charging amount that is on the card
     * @param cardinfo 18 digit card number
     * @param c        boolean that verifies if item has not yet been paid for
     * @return True if Payment goes true, False if it fails
     */
    public boolean Payment(String amount, String cardinfo, boolean c) {
        if (cardinfo.length() != 18) {
            System.out.println("Invalid card, please try again");
            c = false;
        } else if (getProductPrice().equals(amount)) {
            c = true;
            return true;
        }
        System.out.println("Payment Failed please try again");
        return false;
    }

}

//*****************************************************************************//
//****INTERFACE Portion******//
interface Priority {
    public int setPriority(int priorities);

    public int getPriority();
}

class Task implements Priority {
    public int _priorities;
    public String _taskname;


    Task(int priorities, String taskname) {
        _taskname = taskname;
        _priorities = priorities;
    }

    public int setPriority(int priorities) {
        _priorities = priorities;
        return _priorities;
    }

    public int getPriority() {

        return _priorities;
    }

    public String toString() {
        return " Priority = " + _priorities + " Task: " + _taskname;
    }

}

public class Main {

    public static void main(String[] args) {
        Priority[] priorities = new Priority[5];
        Priority p = new Task(1, "First Task");
        Priority p1 = new Task(5, "Fourth Task");
        Priority p2 = new Task(3, "Third Task");
        Priority p3 = new Task(2, "Second Task");
        Priority p4 = new Task(10, "Fifth Task");

        priorities[0] = p;
        priorities[1] = p1;
        priorities[2] = p2;
        priorities[3] = p3;
        priorities[4] = p4;

        System.out.println("Before");
        System.out.println(Arrays.toString(priorities));

        System.out.println("After");


        for (int i = 0; i < priorities.length; i++) {
            for (int j = i + 1; j < priorities.length; j++) {
                if (priorities[i].getPriority() > priorities[j].getPriority()) {
                    Priority sort = priorities[i];
                    priorities[i] = priorities[j];
                    priorities[j] = sort;
                }

            }

        }
        for (Priority i : priorities) {
            System.out.println(i);
        }
    }
}




