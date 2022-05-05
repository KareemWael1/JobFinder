package project;
//import java.util.ArrayList;

public class Company implements Comparable<Company> {
    private String name;
    private int ID;
    private int numberOfEmployees = 1;
    private float seekerReviews;
    private int numberOfReviews;
    private float reviewRate;
    private String companyDescription;
    //private ArrayList<JobPoster> jobPosters = new ArrayList<JobPoster>();
    //private ArrayList<JobVacancy> jobVacancies = new ArrayList<JobVacancy>();


    public Company(String name, String description) {
        this.name = name;
        this.companyDescription = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public int getNumberOfEmployees() {
        return this.numberOfEmployees;
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
    
    public void addJobPoster(/*JobPoster name*/) {
        //jobPosters.add(name);
    }

    public void addVacancy(/*JobVacancy name*/) {
        //jobVacancies.add(name);
    }

    /*public ArrayList<jobVacancies> getJobVacancies() {
        return this.jobVacancies;
    }*/

    /*public int getNumberOfVacancies() {
        return this.jobVacancies.size();
    }*/

    @Override
    public int compareTo(Company C) {
        return this.name.compareTo(C.name);
    }

    @Override
    public boolean equals(Object C) {
        if (C instanceof Company) {
            return this.name.equals(((Company)C).name);
        }
        else return  false;
    }

    @Override
    public String toString() {
        return "Company Name: " + this.name + "\n"
             + "Company ID: " + this.ID + "\n"
             + "Company Review Rate: " + this.reviewRate + "\n"
             + "Company Description: " + this.companyDescription + "\n"
             + "Number of Employees: " + this.numberOfEmployees;
    }
}
