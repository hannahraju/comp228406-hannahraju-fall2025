/*
    Name: Hannah Raju
    ID: 301543568
    Date: October 14, 2025
    Info: COMP 228 Lab 3 Exercise 3 - ProcessMortgage.java (MAIN)
*/
import javax.swing.JOptionPane;

public class ProcessMortgage implements MortgageConstants{

    public static void main(String[] args) {

        Mortgage[] mortgages = new Mortgage[3];

        String input = JOptionPane.showInputDialog(null, "What is the current interest rate?");
        double currentRate = Double.parseDouble(input);

        String name = JOptionPane.showInputDialog(null, "What is your name?");

        // loop to create mortgage objects
        for (int i = 0; i < mortgages.length; i++) {

            // prompt user for mortgage type
            String type = JOptionPane.showInputDialog(null, "MORTGAGE #"+Integer.toString(i+1)+"\n What is the mortgage type? (business/personal)");

            // instantiate mortgage based on type
            if (type.equals("business")) {
                mortgages[i] = new BusinessMortgage(currentRate/100);
            } else if (type.equals("personal")) {
                mortgages[i] = new PersonalMortgage(currentRate/100);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
                return;
            }

            // set customer name
            mortgages[i].setCustomerName(name);

            // prompt user and set their mortgage number
            input = JOptionPane.showInputDialog(null,"What is your mortgage number?");
            mortgages[i].setMortgageNumber(Integer.parseInt(input));

            // prompt user and set their mortgage amount
            input = JOptionPane.showInputDialog(null,"What is your mortgage amount?");
            mortgages[i].setAmount(Double.parseDouble(input));

            // prompt user for their term
            input = JOptionPane.showInputDialog(null, "What is your mortgage term in years?");
            int years = Integer.parseInt(input);

            // determine which term
            if(years == LONG_TERM){
                mortgages[i].setTerm(LONG_TERM);
            }
            else if(years==MEDIUM_TERM){
                mortgages[i].setTerm(MEDIUM_TERM);
            }
            else{
                mortgages[i].setTerm(SHORT_TERM);
            }
        }

        // loop to print all mortgage info

        for(int i=0; i<mortgages.length; i++){
            mortgages[i].getMortgageInfo();
        }

    }
}

