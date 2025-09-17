public class Singer {

    private int id;
    private String name;
    private String address;
    private String dob; // yyyy-mm-dd
    private int albums;

    // Constructor 1: 5 arguments
    public Singer(int id, String name, String address, String dob, int albums){
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.albums = albums;
    }

    // Constructor 2: 0 arguments (default values)
    public Singer() {
        this.id = 0;
        this.name = "default";
        this.address = "default";
        this.dob = "default";
        this.albums = 0;
    }

    // Setter for id
    public void set_id(int id){
        this.id = id;
    }

    // Getter for id
    public int get_id(){
        return this.id;
    }

    // Setter for name
    public void set_name(String name){
        this.name = name;
    }

    // Getter for name
    public String get_name(){
        return this.name;
    }

    // Setter for address
    public void set_address(String address){
        this.address = address;
    }

    // Getter for address
    public String get_address(){
        return this.address;
    }

    // Setter for date of birth
    public void set_dob(String dob){
        this.dob = dob;
    }

    // Getter for date of birth
    public String get_dob(){
        return this.dob;
    }

    // Setter for albums
    public void set_albums(int albums){
        this.albums = albums;
    }

    // Getter for albums
    public int get_albums(){
        return this.albums;
    }

}