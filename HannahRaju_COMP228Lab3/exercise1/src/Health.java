/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 1 - Health.java
*/

import javax.swing.JOptionPane;

// This class implements the Health which inherits the superclass Insurance
public class Health extends Insurance{

    public Health(double cost){
        this.type = "health";
        this.monthlyCost = cost;
    }
    public void setInsuranceCost(double cost){
        this.monthlyCost = cost;
    }
    public void displayInfo(){
        String output = String.format("Insurance type: %s\nMonthly cost: $%.2f", type, monthlyCost);
        JOptionPane.showMessageDialog(null, output);
    }
}
