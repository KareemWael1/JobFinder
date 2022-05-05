package project;

public class JobApplication {
    private int COMPANY_ID;
    private String applicationState = "Pending";
    private String applicantInfo;
    JobApplication(String applicantInfo,int COMPANY_ID){
        this.applicantInfo = applicantInfo;
        this.COMPANY_ID = COMPANY_ID;
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
}
