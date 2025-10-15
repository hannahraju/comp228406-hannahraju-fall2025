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
