/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 2 - FullTimeGameTester.java
*/

public class FullTimeGameTester extends GameTester {

    public FullTimeGameTester(String name){
        super(name, true);
    }
    @Override
    public double determineSalary() {
        return 3000;
    }
}
