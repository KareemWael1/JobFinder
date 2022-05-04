import java.util.ArrayList;

public class CompanyAdmin {
    private ArrayList<Company> companies = new ArrayList<Company>();


    public ArrayList<Company> getCompanies() {
        return this.companies;
    }

    public void addCompany(Company name) {
        companies.add(name);
    }

    public void updateCompanyDescription(Company chosenCompany, String newDescription) {
        chosenCompany.setCompanyDescription(newDescription);
    }
}
