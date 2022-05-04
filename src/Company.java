public class Company {
    private String name;
    private int ID;
    private int numberOfEmployees = 1;
    private int numberOfReviews;
    private float reviewRate;
    private String companyDescription;
    //private JobPoster[] jobPosters;
    // private JobVacancy[] jobVacancies;


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

    public float calculateReviewRate() {
        return this.reviewRate; //wrongCalculation
        //incomplete
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
    
    public void addJobPoster() {
        //incomplete
    }

    public void addVacancy() {
        //incomplete
    }

    /*public JobVacancy[] getJobVacancies() {
        return this.jobVacancies;
    }*/

    /*public int getNumberOfVacancies() {
        return this.jobVacancies.length();
    }*/
}
