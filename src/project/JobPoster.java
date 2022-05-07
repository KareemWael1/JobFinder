package project;

import java.util.ArrayList;

public class JobPoster extends Person{

    private final int COMPANY_ID;
    private final ArrayList<JobVacancy> jobVacancies = new ArrayList<>();

    public JobPoster(String name, String email, String gender, String password, int companyId) {
        super(name, email, gender, password);
        this.COMPANY_ID = companyId;
    }

    public void addJobVacancy(String title, String info){
        jobVacancies.add(new JobVacancy(COMPANY_ID, title, info));
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