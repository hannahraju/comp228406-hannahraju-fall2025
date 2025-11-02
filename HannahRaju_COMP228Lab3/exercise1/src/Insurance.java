/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 1 - Insurance.java
*/

// This class implements the abstract class Insurance
public abstract class Insurance {

    // declare instance variables type and monthly cost
    public String type;
    public double monthlyCost;

    // no-arg constructor
    public Insurance(){

    }

    public Insurance(String type, double monthlyCost) {
        this.type = type;
        this.monthlyCost = monthlyCost;
    }
    // getter for type
    public String getType(){
        return type;
    }

    // getter for monthly cost
    public double getMonthlyCost(){
        return monthlyCost;
    }

    public abstract void setInsuranceCost(double cost);

    public abstract void displayInfo();
}
