package project;

import java.util.ArrayList;

public class JobVacancy implements Comparable<JobVacancy>{
    private final int COMPANY_ID;
    private String jobTitle;
    private String jobDescription;
    private final ArrayList<JobApplication> applications = new ArrayList<>();

    JobVacancy(int companyID, String title, String description){
        this.COMPANY_ID = companyID;
        this.jobTitle = title;
        this.jobDescription = description;
    }

    public void addApplication (JobApplication application){
        applications.add(application);
    }

    public ArrayList<JobApplication> getApplications() {
        return applications;
    }

    public boolean viewApplications() {
        int idx = 0;
        for (JobApplication application : applications){
            System.out.println("Application " + idx + ": " + application.getApplicantInfo()
                    + " - Status: " + application.getApplicationState() );
            idx++;
        }
        return idx>0;
    }

    public int getCOMPANY_ID(){
        return COMPANY_ID;
    }

    public String getJobDescription(){
        return jobDescription;
    }

    public void setJobDescription(String description){
        this.jobDescription = description;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public void setJobTitle(String title){
        this.jobTitle = title;
    }

    public void removeApplication(JobApplication jobApplication){
        applications.remove(jobApplication);
    }

    public ArrayList<JobApplication> getJobApplications()
    {
    return applications;
    }

    @Override
    public int compareTo(JobVacancy v){
        return this.jobTitle.compareTo(v.jobTitle);
    }

    @Override
    public boolean equals(Object v){
        if (v instanceof JobVacancy){
            return this.jobTitle.equals(((JobVacancy)v).jobTitle);
        }
        return false;
    }
    @Override
    public String toString(){
        return "Title: " + jobTitle + "\nDescription: " + jobDescription +
                "\n"+ "Comapany ID: " + FinderSystem.getCompanies().get(COMPANY_ID).getId() + "\n Company name: "+
                FinderSystem.getCompanies().get(COMPANY_ID).getName() + "\n***********************\n";
    }
}