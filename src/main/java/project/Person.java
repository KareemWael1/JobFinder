package project;

public abstract class Person{
    protected final String NAME;
    protected final String EMAIL;
    protected final String GENDER;
    protected final String PASSWORD;

    // It is assumed that the user can't change their name, email, gender, and password once a new account is created.

    public Person(String name, String email, String gender, String password){
        this.NAME = name;
        this.EMAIL = email;
        this.GENDER = gender;
        this.PASSWORD = password;
    }

    public String getNAME(){
        return NAME;
    }

    public String getEMAIL(){
        return EMAIL;
    }

    public String getPassword(){
        return PASSWORD;
    }
}