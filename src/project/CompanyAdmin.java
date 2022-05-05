package project;
import java.util.ArrayList;

public class CompanyAdmin extends Person {
    static private ArrayList<Company> companies = new ArrayList<Company>();


    CompanyAdmin(String name, String email, String gender, String password) {
        super(name, email, gender, password);
    }

    public ArrayList<Company> getCompanies() {
        return CompanyAdmin.companies;
    }

    public void addCompany(Company name) {
        companies.add(name);
    }

    public void updateCompanyDescription(Company chosenCompany, String newDescription) {
        chosenCompany.setCompanyDescription(newDescription);
    }

    @Override
    public int compareTo(Person p) {
        return this.NAME.compareTo(p.NAME);
    }

    @Override
    public boolean equals(Object p) {
        if (p instanceof CompanyAdmin){
            return this.NAME.equals(((CompanyAdmin)p).NAME);
        }
        return  false;
    }

    @Override
    public String toString() {
        return "Company Admin name: " + this.NAME + "\n"
             + "Company Admin email: " + this.EMAIL + "\n"
             + "Company Admin gender: " + this.GENDER;
    }
}
