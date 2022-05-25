package project;

import java.util.ArrayList;

public class JobVacancy{
    private final int COMPANY_ID;
    private final String JOB_TITLE;
    private final String JOB_DESCRIPTION;
    private final ArrayList<JobApplication> applications = new ArrayList<>();

    public JobVacancy(int companyID, String title, String description){
        this.COMPANY_ID = companyID;
        this.JOB_TITLE = title;
        this.JOB_DESCRIPTION = description;
    }

    public void addApplication (JobApplication application){
        applications.add(application);
    }

    public ArrayList<JobApplication> getApplications() {
        return applications;
    }

    public int getCOMPANY_ID(){
        return COMPANY_ID;
    }

    public String getJobTitle(){
        return JOB_TITLE;
    }

    public void removeApplication(int idx){
        applications.remove(idx);
    }

    @Override
    public String toString(){
        return "Title: " + JOB_TITLE + "\nDescription: " + JOB_DESCRIPTION + "\nCompany name: " +
                FinderSystem.getCompanies().get(COMPANY_ID).getName();
    }
}