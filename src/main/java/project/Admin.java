package project;

public class Admin extends Person {

    public Admin(String name, String email, String gender, String password){
        super(name, email, gender, password);
    }

    @Override
    public String toString() {
        return "Name: " + NAME + "\nEmail: " + EMAIL + "\nGender: " + GENDER + "\n";
    }
}