import javax.swing.JOptionPane;

public class Life extends Insurance{

    public Life(double cost){
        this.type = "life";
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

