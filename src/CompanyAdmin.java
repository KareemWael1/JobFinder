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

    @Override
    public String toString() {
        for (int i = 0; i < companies.size(); i++) {
            return companies.get(i).getName();
        }
        return null;
    }
}
