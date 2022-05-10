package project;
import java.util.ArrayList;

public class CompanyAdmin extends Person {
    final static private ArrayList<Company> companies = new ArrayList<>(); // final so companies do not point to other list
    final static private ArrayList<JobPoster> jobPosters = new ArrayList<>();

    CompanyAdmin(String name, String email, String gender, String password){
        super(name, email, gender, password);
    }

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public static ArrayList<JobPoster> getJobPosters() {
        return jobPosters;
    }

    public static void addCompany(Company name) {
        name.setID(companies.size());
        companies.add(name);
    }

    public static void addJobPoster(JobPoster name) {
        jobPosters.add(name);
    }

    public static void updateCompanyDescription(Company chosenCompany, String newDescription) {
        chosenCompany.setCompanyDescription(newDescription);
    }

    @Override
    public String toString() {
        return "Name: " + NAME + "\nEmail: " + EMAIL + "\nGender: " + GENDER + "\n";
    }
}