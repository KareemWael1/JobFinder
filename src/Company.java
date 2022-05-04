public class Company {
    private String name;
    private int ID;
    private int numberOfEmployees = 1;
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

    public int getNumberOfReviews() {
        return this.numberOfReviews;
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
}
