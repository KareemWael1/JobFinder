package project;

public class JobApplication{
    private final int COMPANY_ID;
    private String applicationState = "Pending";
    private String applicantInfo;
    private final String JOB_TITLE;
    private final String APPLICANT_EMAIL;
    public JobApplication(String applicantInfo,int COMPANY_ID,String jobTitle,String mail){
        this.applicantInfo = applicantInfo;
        this.COMPANY_ID = COMPANY_ID;
        this.JOB_TITLE = jobTitle;
        this.APPLICANT_EMAIL = mail;
    }

    public String getApplicantMail() {
        return APPLICANT_EMAIL;
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

    public String getJobTitle() {
        return JOB_TITLE;
    }

    @Override
    public String toString(){
        return "Job Title: "+ JOB_TITLE+ "\nApplicant info: " + applicantInfo + "\nApplication State: " + applicationState +
                "\n" + FinderSystem.getCompanies().get(COMPANY_ID) + "\n";
    }
}