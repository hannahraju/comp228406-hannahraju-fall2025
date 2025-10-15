/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 2 - PartTimeGameTester.java
*/
import javax.swing.JOptionPane;

public class PartTimeGameTester extends GameTester {

    public PartTimeGameTester(String name){
        super(name, false);
    }
    @Override
    public double determineSalary() {
        String hours = JOptionPane.showInputDialog(null, "Enter your weekly hours:");

        return 4*20*Double.parseDouble(hours);
    }
}
