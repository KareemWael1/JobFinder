package project;
import java.util.ArrayList;

public class Company{
    private final String NAME;
    private final int ID;
    static int companiesCount=0;
    private String companyDescription;
    private final ArrayList<JobPoster> jobPosters = new ArrayList<>();
    private final ArrayList<JobVacancy> jobVacancies = new ArrayList<>();
    private final ArrayList<String> reviews = new ArrayList<>();
    private int numberOfEmployees;



    public Company(String name, String description) {
        this.NAME = name;
        this.companyDescription = description;
        this.ID = companiesCount;
        companiesCount++;
    }

    public String getName() {
        return this.NAME;
    }

    public int getId() {
        return this.ID;
    }

    public void setCompanyDescription(String description) {
        this.companyDescription = description;
    }
    
    public void addJobPoster(JobPoster poster) {
        jobPosters.add(poster);
        numberOfEmployees = jobPosters.size();
    }

    public void addReview(String review){
        reviews.add(review);
    }

    public void addVacancy(JobVacancy jobVacancy) {
        jobVacancies.add(jobVacancy);
    }

    public ArrayList<JobVacancy> getJobVacancy() {
        return this.jobVacancies;
    }

    public ArrayList<JobVacancy> getJobVacancies(){
        return jobVacancies;
    }

    @Override
    public String toString() {
        return "Company Name: " + this.NAME + "\n"
             + "Company ID: " + this.ID + "\n"
             + "Company Description: " + this.companyDescription + "\n"
             + "Number of Employees: " + this.numberOfEmployees + "\n"
             + "Reviews:\n" + reviews + "\n";
    }
}