/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 1 - Main.java
*/
import javax.swing.JOptionPane;

// This main function prompts the user for their insurance type and cost and creates a new insurance object of the corresponding type
public class Main {
    public static void main(String[] args) {

        Insurance insurance;

        String type = JOptionPane.showInputDialog(null, "Enter type of insurance (health/life):");
        String cost = JOptionPane.showInputDialog(null, "Enter monthly cost:");

        // case health
        if(type.equals("health")){
            insurance = new Health(Double.parseDouble(cost));
            insurance.displayInfo();

        }

        // case life
        else if (type.equals("life")){
            insurance = new Life(Double.parseDouble(cost));
            insurance.displayInfo();

        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR: enter \"health\" or \"life\"");
        }

    }



}