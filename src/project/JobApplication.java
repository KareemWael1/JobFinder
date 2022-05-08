package project;

public class JobApplication implements Comparable<JobApplication>{
    private int COMPANY_ID;
    private String applicationState = "Pending";
    private String applicantInfo;
    private String jobTitle;
    public JobApplication(String applicantInfo,int COMPANY_ID,String jobTitle){
        this.applicantInfo = applicantInfo;
        this.COMPANY_ID = COMPANY_ID;
        this.jobTitle = jobTitle;
    }


    public void setCOMPANY_ID(int COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    public int getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setApplicationState(String applicationState) {
        this.applicationState = applicationState;
    }

    public String getApplicationState() {
        return applicationState;
    }

    public void setApplicantInfo(String applicantInfo) {
        this.applicantInfo = applicantInfo;
    }

    public String getApplicantInfo() {
        return applicantInfo;
    }

    @Override
    public int compareTo(JobApplication a){
        return this.applicantInfo.compareTo(a.applicantInfo);
    }

    @Override
    public boolean equals(Object a){
        if (a instanceof JobVacancy){
            return this.applicantInfo.equals(((JobApplication)a).applicantInfo);
        }
        return false;
    }
    @Override
    public String toString(){
        return "Job Title"+ jobTitle+ "Applicant info: " + applicantInfo + "\nApplication State: " + applicationState +
                "\n" + CompanyAdmin.getCompanies().get(COMPANY_ID) + "\n";
    }
}