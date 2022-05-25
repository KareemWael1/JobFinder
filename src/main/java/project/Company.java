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
    private int numberOfEmployees = (int)(Math.random()*1000);

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
        addEmployee();
    }

    public void addEmployee(){
        numberOfEmployees++;
    }

    public void addReview(String review){
        reviews.add(review);
    }

    public void addVacancy(JobVacancy jobVacancy) {
        jobVacancies.add(jobVacancy);
    }

    public ArrayList<JobVacancy> getJobVacancies(){
        return jobVacancies;
    }

    public ArrayList<String> getReviews(){
        return reviews;
    }

    public String getCompanyDescription(){
        return companyDescription;
    }

    public int getNumberOfEmployees(){
        return numberOfEmployees;
    }

    @Override
    public String toString() {
        return this.NAME + "\n" + this.companyDescription + "\n";
    }
}