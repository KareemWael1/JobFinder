package project;
import java.util.ArrayList;

public class Company implements Comparable<Company> {
    private String name;
    private int Id;
    private int numberOfEmployees = 1;
    private float seekerReviews = 0;
    private int numberOfReviews = 0;
    private float reviewRate;
    private String companyDescription;
    private final ArrayList<JobPoster> jobPosters = new ArrayList<>();
    private final ArrayList<JobVacancy> jobVacancies = new ArrayList<>();


    public Company(String name, String description) {
        this.name = name;
        this.companyDescription = description;
    }

    public void setID(int ID){
        this.Id = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.Id;
    }

    public int getNumberOfEmployees() {
        return this.numberOfEmployees;
    }

    public void setSeekerReviews(float seekerReviews) {
        this.seekerReviews += seekerReviews;
        this.numberOfReviews++;
        calculateReviewRate();
    }

    public float getSeekerReviews() {
        return seekerReviews;
    }

    public int getNumberOfReviews() {
        return this.numberOfReviews;
    }

    public void calculateReviewRate() {
        this.reviewRate = seekerReviews/numberOfReviews;
    }

    public float getReviewRate() {
        return this.reviewRate;
    }

    public void setCompanyDescription(String description) {
        this.companyDescription = description;
    }

    public String getCompanyDescription() {
        return this.companyDescription;
    }
    
    public void addJobPoster(JobPoster poster) {
        jobPosters.add(poster);
        numberOfEmployees++;
    }

    public void addVacancy(JobVacancy jobVacancy) {
        jobVacancies.add(jobVacancy);
    }

    public ArrayList<JobPoster> getJobPoster() {
        return this.jobPosters;
    }

    public ArrayList<JobVacancy> getJobVacancy() {
        return this.jobVacancies;
    }

    public int getNumberOfVacancies() {
        return this.jobVacancies.size();
    }

    @Override
    public int compareTo(Company C) {
        return this.name.compareTo(C.name);
    }

    @Override
    public boolean equals(Object c) {
        if (c instanceof Company) {
            return this.name.equals(((Company)c).name);
        }
        else return  false;
    }

    @Override
    public String toString() {
        return "Company Name: " + this.name + "\n"
             + "Company ID: " + this.Id + "\n"
             + "Company Review Rate: " + this.reviewRate + "\n"
             + "Company Description: " + this.companyDescription + "\n"
             + "Number of Employees: " + this.numberOfEmployees;
    }
}