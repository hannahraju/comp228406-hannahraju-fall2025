/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 3 - Mortgage.java
*/
import javax.swing.JOptionPane;

public abstract class Mortgage implements MortgageConstants {

    int mortgageNumber;
    String customerName;
    double amount;
    double interestRate;
    int term;

    public Mortgage(){
        this.mortgageNumber = 0;
        this.customerName = "name unknown";
        this.amount = 0;
        this.interestRate = PRIME_RATE;
        this.term = SHORT_TERM;
    }

    // getters and setters
    // mortgage numbers
    public int getMortgageNumber(){return mortgageNumber;}
    public void setMortgageNumber(int mortgageNumber){this.mortgageNumber = mortgageNumber;}

    //customer name
    public String getCustomerName(){return customerName;}
    public void setCustomerName(String customerName){this.customerName=customerName;}

    //mortgage amount
    public double getAmount(){return amount;}
    public void setAmount(double amount){
        if(amount>MAX_MORTGAGE){this.amount = MAX_MORTGAGE;}
        else{this.amount = amount;}
    }

    // interest rate
    public double getInterestRate(){return interestRate;}
    public void setInterestRate(double interestRate){this.interestRate=interestRate;}

    // term
    public int getTerm(){return term;}
    public void setTerm(int term){this.term = term;}

    public void getMortgageInfo(){
        String output = String.format("Mortgage Number: %d\nCustomer Name: "+customerName+"\nMortgage amount: %.2f\nInterest Rate: %f\nTerm: %d", mortgageNumber, amount, interestRate, term);
        JOptionPane.showMessageDialog(null, output);
    }


}
