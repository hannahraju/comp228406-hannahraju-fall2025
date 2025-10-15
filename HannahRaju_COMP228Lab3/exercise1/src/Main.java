import javax.swing.JOptionPane;

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