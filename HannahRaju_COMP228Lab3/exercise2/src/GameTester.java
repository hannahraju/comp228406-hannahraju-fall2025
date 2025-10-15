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
