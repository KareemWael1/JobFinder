package project;
import java.util.ArrayList;

public class CompanyAdmin {
    // made it final so companies do not point to other list
    final static private ArrayList<Company> companies = new ArrayList<>();


    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company name) {
        companies.add(name);
    }

    public void updateCompanyDescription(Company chosenCompany, String newDescription) {
        chosenCompany.setCompanyDescription(newDescription);
    }

    @Override
    public String toString() {
        for (int i = 0; i < companies.size();) {
            return companies.get(i).getName();
        }
        return null;
    }
}
