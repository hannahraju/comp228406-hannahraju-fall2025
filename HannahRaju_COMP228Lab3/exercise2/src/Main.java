/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 2 - Main.java
*/

import javax.swing.JOptionPane;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // display monthly salary
        GameTester employee1;
        double salary = 0;

        // prompt user for their name
        String name = JOptionPane.showInputDialog(null, "Please enter your name:");
        // prompt user for their employment type
        String input = JOptionPane.showInputDialog(null, "Select Game Tester type (full/part):");


        // CASE: full time
        if(input.equals("full")) {
            employee1 = new FullTimeGameTester(name);
            salary = employee1.determineSalary();

        }
        // CASE: part time
        else if(input.equals("part")){
            employee1 = new PartTimeGameTester(name);
            salary = employee1.determineSalary();


        }

        else{
            JOptionPane.showMessageDialog(null,"ERROR");
            return;
        }
        String output = String.format("Your monthly salary is: %.2f", salary);
        JOptionPane.showMessageDialog(null, output);


    }
}