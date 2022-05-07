package project;

import java.util.ArrayList;

public class JobPoster extends Person{

    private int COMPANY_ID;
    private final ArrayList<JobVacancy> jobVacancies = new ArrayList<>();

    public JobPoster(String name, String email, String gender, String password) {
        super(name, email, gender, password);
    }
    public void setCOMPANY_ID(int COMPANY_ID){
        this.COMPANY_ID = COMPANY_ID;
    }
    public void addJobVacancy(String title, String info){
        ArrayList<Company> companies = CompanyAdmin.getCompanies();
        jobVacancies.add(new JobVacancy(COMPANY_ID, title, info));
        companies.get(COMPANY_ID).addVacancy(jobVacancies.get(jobVacancies.size()-1));
    }

    public void deleteJob(int jobVacancyIdx){
        jobVacancies.remove(jobVacancyIdx);
    }

    public void setApplicationStatus(boolean status, int jobVacancyIdx, int jobApplicationIdx){
        if (status)
        {
            this.jobVacancies.get(jobVacancyIdx).getJobApplications().get(jobApplicationIdx).setApplicationState("Accepted");
        }
        else
        {
            this.jobVacancies.get(jobVacancyIdx).getJobApplications().get(jobApplicationIdx).setApplicationState("Rejected");
        }
    }

    public ArrayList<JobVacancy> getJobVacancies() {
        return this.jobVacancies;
    }

    @Override
    public String toString() {
        return "Name: " + NAME + "\nEmail: " + EMAIL + "\nGender: " + GENDER +
                "\n Company: " + CompanyAdmin.getCompanies().get(COMPANY_ID) + "\n";
    }
}