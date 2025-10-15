
public abstract class Insurance {

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
