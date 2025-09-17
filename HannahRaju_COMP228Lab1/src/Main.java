//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // create new Singer object and display default instance variables
        Singer singer1 = new Singer();
        System.out.println("singer1 id: " + singer1.get_id());
        System.out.println("singer1 name: " +singer1.get_name());
        System.out.println("singer1 address: " +singer1.get_address());
        System.out.println("singer1 date of birth: " +singer1.get_dob());
        System.out.println("singer1 albums: " +singer1.get_albums());
        System.out.println();


        // Set values of each instance variable and display the values
        singer1.set_id(1234);
        singer1.set_name("Taylor Swift");
        singer1.set_address("123 Main St");
        singer1.set_dob("1989-12-13");
        singer1.set_albums(12);

        System.out.println("singer1 id: " + singer1.get_id());
        System.out.println("singer1 name: " +singer1.get_name());
        System.out.println("singer1 address: " +singer1.get_address());
        System.out.println("singer1 date of birth: " +singer1.get_dob());
        System.out.println("singer1 albums: " +singer1.get_albums());
        System.out.println();


        // Change value of each instance variable and display the new values
        singer1.set_id(4321);
        singer1.set_name("Frank Zappa");
        singer1.set_address("999 Downtown Rd");
        singer1.set_dob("1940-12-21");
        singer1.set_albums(62);

        System.out.println("singer1 id: " + singer1.get_id());
        System.out.println("singer1 name: " +singer1.get_name());
        System.out.println("singer1 address: " +singer1.get_address());
        System.out.println("singer1 date of birth: " +singer1.get_dob());
        System.out.println("singer1 albums: " +singer1.get_albums());
    }
}