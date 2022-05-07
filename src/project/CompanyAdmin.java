package project;
import java.util.ArrayList;

public class CompanyAdmin extends Person {
    final static private ArrayList<Company> companies = new ArrayList<>(); // final so companies do not point to other list

    CompanyAdmin(String name, String email, String gender, String password){
        super(name, email, gender, password);
    }

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company name) {
        name.setID(companies.size());
        companies.add(name);
    }

    public void updateCompanyDescription(Company chosenCompany, String newDescription) {
        chosenCompany.setCompanyDescription(newDescription);
    }

    @Override
    public String toString() {
        return "Name: " + NAME + "\nEmail: " + EMAIL + "\nGender: " + GENDER + "\n";
    }
}