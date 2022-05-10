package project;

import java.util.ArrayList;

public class JobPoster extends Person{

    private final int COMPANY_ID;
    private final ArrayList<JobVacancy> jobVacancies;

    public JobPoster(String name, String email, String gender, String password, int id) {
        super(name, email, gender, password);
        this.COMPANY_ID = id;
        jobVacancies = CompanyAdmin.getCompanies().get(COMPANY_ID).getJobVacancy();
        CompanyAdmin.getCompanies().get(COMPANY_ID).addJobPoster(this);
    }

    public void addJobVacancy(String title, String info){
        ArrayList<Company> companies = CompanyAdmin.getCompanies();
        jobVacancies.add(new JobVacancy(COMPANY_ID, title, info));
    }

    public void deleteJob(int jobVacancyIdx){
        jobVacancies.remove(jobVacancyIdx);
    }

    public void setApplicationStatus(String status, int jobVacancyIdx, int jobApplicationIdx){
        this.jobVacancies.get(jobVacancyIdx).getJobApplications().get(jobApplicationIdx).setApplicationState(status);
    }

    public ArrayList<JobVacancy> getJobVacancies() {return jobVacancies;}

    public void viewJobVacancies() {
        int idx = 0;
        for (JobVacancy vacancy : jobVacancies){
            System.out.println("Job " + idx + ": " + vacancy.getJobTitle() + ": " + vacancy.getJobDescription());
            idx++;
        }
    }

    @Override
    public String toString() {
        return "Name: " + NAME + "\nEmail: " + EMAIL + "\nGender: " + GENDER +
                "\n Company: " + CompanyAdmin.getCompanies().get(COMPANY_ID) + "\n";
    }
}