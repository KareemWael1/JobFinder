package project;

public abstract class Person implements Comparable<Person> {
    protected final String NAME;
    protected final String EMAIL;
    protected final String GENDER;
    protected String password;

    // It is assumed that the user can't change their name, email, and gender once a new account is created.
    // but they can change their password.

    public Person(String name, String email, String gender, String password){
        this.NAME = name;
        this.EMAIL = email;
        this.GENDER = gender;
        this.password = password;
    }

    public String getNAME(){
        return NAME;
    }

    public String getEMAIL(){
        return EMAIL;
    }

    public String getGENDER(){
        return GENDER;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Boolean checkLogInInfo(String email, String password){
        return this.EMAIL.equals(email) && this.password.equals(password);
    }

    @Override
    public int compareTo(Person p){
        return this.NAME.compareTo(p.NAME);
    }

    @Override
    public boolean equals(Object p){
        if (p instanceof Person){
            return this.NAME.equals(((Person)p).NAME);
        }
        return false;
    }

    @Override
    public abstract String toString();
}