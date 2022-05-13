package project;

import java.util.ArrayList;

public class JobPoster extends Person{

    private final int COMPANY_ID;
    private final ArrayList<JobVacancy> jobVacancies;

    public JobPoster(String name, String email, String gender, String password, int id) {
        super(name, email, gender, password);
        this.COMPANY_ID = id;
        jobVacancies = FinderSystem.getCompanies().get(COMPANY_ID).getJobVacancy();
    }


    public void deleteJob(int jobVacancyIdx){
        jobVacancies.remove(jobVacancyIdx);
    }

    public int getCOMPANY_ID() {
        return COMPANY_ID;
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
                "\n Company: " + FinderSystem.getCompanies().get(COMPANY_ID) + "\n";
    }
}