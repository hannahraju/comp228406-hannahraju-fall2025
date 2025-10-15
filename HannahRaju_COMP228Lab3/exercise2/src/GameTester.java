/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 2 - GameTester.java
*/

public abstract class GameTester {

    String name;
    boolean fullTime;

    public GameTester(){}

    public GameTester(String name, boolean fullTime){
        this.name = name;
        this.fullTime = fullTime;
    }

    // abstract class determineSalary
    public abstract double determineSalary();

}
