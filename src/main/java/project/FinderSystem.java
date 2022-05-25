package project;

import team2.sourcecode.AgeHandling;
import team2.sourcecode.YearsOfExperienceException;

import java.util.*;

public class FinderSystem {
    JobSeeker ahmed = new JobSeeker("Ahmed", "ahmed@gmail.com", "male", "8520", 20
            , "Masters", "MIT", 15);
    JobSeeker yara = new JobSeeker("Yara", "yara@gmail.com", "female", "yara123", 19
            , "PHD", "Cairo", 5);
    JobPoster mai = new JobPoster("Mai", "mai@gmail.com", "female", "mai123", 0);
    JobPoster amr = new JobPoster("Amr", "amr@gmail.com", "male", "amr123", 1);
    Admin admin = new Admin("admin", "admin@gmail.com", "male", "admin123");
    JobVacancy instructor = new JobVacancy(1, "Instructor", "Gives lectures");
    JobVacancy it = new JobVacancy(0, "IT", "Technical support");
    JobVacancy hardwareEngineer = new JobVacancy(0, "Hardware Engineer", "Design devices");
    static Company dell = new Company("Dell", "Tech company");
    static Company edx = new Company("edx", "Educational company");
    {
        dell.addVacancy(it);
        dell.addVacancy(hardwareEngineer);
        edx.addVacancy(instructor);
        dell.addJobPoster(mai);
        edx.addJobPoster(amr);
    }

    private Person user;
    public String getName(){
        return user.getNAME();
    }

    private final ArrayList<JobPoster> allJobPosters = new ArrayList<>() {
        {
            add(mai);
            add(amr);
        }
    };

    private final ArrayList<JobSeeker> jobSeekers = new ArrayList<>() {
        {
            add(ahmed);
            add(yara);
        }
    };
    private final ArrayList<JobVacancy> allJobVacancies = new ArrayList<>(){
        {
            add(instructor);
            add(it);
            add(hardwareEngineer);
        }
    };


    final static private ArrayList<Company> companies = new ArrayList<>() {
        {
            add(dell);
            add(edx);
        }
    };

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public boolean login(String email, String pass, String userType) {
        boolean logged = false;
        switch (userType) {
            case "s" -> {
                for (JobSeeker i : jobSeekers) {
                    if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                        logged = true;
                        user = i;
                        break;
                    }
                }
                return logged;
            }

            case "a" -> {
                return admin.getEMAIL().equals(email) && admin.getPassword().equals(pass);
            }

            case "p" -> {
                for (JobPoster i : allJobPosters) {
                    if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                        logged = true;
                        user = i;
                        break;
                    }
                }
                return logged;
            }
        }
        return false;
    }


    public void addJobSeeker(String name, String email, String gender, String password, int age, String degree, String uni, int exp) throws AgeHandling, YearsOfExperienceException {
        if (age >= 14 && age <= 70 && exp < age && exp >= 0) {
            JobSeeker seeker = new JobSeeker(name, email, gender, password, age, degree, uni, exp);
            jobSeekers.add(seeker);
        } else if (age < 14 || age > 70) {
            throw new AgeHandling("Invalid age, you should age between 14 and 70\nto apply for Jobs.");
        } else {
            throw new YearsOfExperienceException("Years of experience should be a positive number smaller than the age!");
        }
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public void addJobPoster(JobPoster jobPoster) {
        companies.get(jobPoster.getCOMPANY_ID()).addJobPoster(jobPoster);
        allJobPosters.add(jobPoster);
    }

    public void deleteApplication(JobApplication application) {
        String jobTitle = application.getJobTitle();
        int companyID = application.getCOMPANY_ID();
        String mail = user.getEMAIL();

        int index=0;
        for (JobApplication j : (((JobSeeker) user).getJobApplications())){
            if (j == application) {
                ((JobSeeker)user).deleteApplication(index);
                return;
            }
            index++;
        }

        for (JobVacancy i : companies.get(companyID).getJobVacancies()) {

            index=0;
            for (JobApplication j : i.getApplications()) {
                if (j.getJobTitle().equalsIgnoreCase(jobTitle) && j.getApplicantMail().equals(mail)) {
                    i.removeApplication(index);
                    return;
                }
                index++;
            }
        }
    }

    public ArrayList<Company> browseCompanies(String name) {
        ArrayList<Company> companiesList = new ArrayList<>();
        for (Company company : companies) {
            if (name.equalsIgnoreCase(company.getName())) {
                companiesList.add(company);
            }
        }
        return companiesList;
    }

    public ArrayList<Company> browseCompanies() {
        return companies;
    }

    public void updateInfo(int age, String degree, String university, int yearsOfExperience) throws YearsOfExperienceException, AgeHandling {
        if (age >= 14 && age <= 70) {
            ((JobSeeker) user).setAge(age);
        }else{
            throw new AgeHandling("Invalid age, you should age between 14 and 70\nto apply for Jobs.");
        }

        ((JobSeeker) user).setDegree(degree);
        ((JobSeeker) user).setUniversity(university);

        if (yearsOfExperience >= 0 && yearsOfExperience < age) {
            ((JobSeeker) user).setYearsOfExperience(yearsOfExperience);
        } else {
            throw new YearsOfExperienceException("Years of experience should be a positive number smaller than the age!");
        }
    }

    public boolean addReview(String review, int COMPANY_ID) {
        boolean canAddReview = false;
        for (JobApplication i : ((JobSeeker) user).getJobApplications()) {
            if (i.getCOMPANY_ID() == COMPANY_ID) {
                canAddReview = true;
                break;
            }
        }
        if (canAddReview) {
            for (Company j : companies) {
                if (j.getId() == COMPANY_ID) {
                    j.addReview(review);
                    break;
                }
            }
        }
        return canAddReview;
    }

    public ArrayList<String> getReviews(Company company){
        return company.getReviews();
    }

    public void updateApplication(JobApplication application, String info) {
        application.setApplicantInfo(info);
    }

    public ArrayList<JobVacancy> browseJobs() {
        return allJobVacancies;
    }

    public ArrayList<JobApplication> viewMyApplications() {
        ArrayList<JobApplication> applications = ((JobSeeker) user).viewMyApplications();
        int idx = 0;
        for(JobApplication application: applications){
            boolean deleted = true;
            for(JobVacancy vacancy: allJobVacancies){
                if(application.getJobTitle().equals(vacancy.getJobTitle())
                        && (application.getCOMPANY_ID() == vacancy.getCOMPANY_ID())){
                    deleted = false;
                    break;
                }
            }
            if(deleted){
                applications.remove(idx);
            }
            idx++;
        }
        ((JobSeeker)user).setJobApplications(applications);
        return applications;
    }

    public void addApplication(JobVacancy jobVacancy) {
        String info = "My name is " + user.getNAME() + ", And I have " + ((JobSeeker) user).getAge() + " years old " + "\n I got a " +
                ((JobSeeker) user).getDegree() +
                " degree " + "from " + ((JobSeeker) user).getUniversity() + " university " + "also I have " +
                ((JobSeeker) user).getYearsOfExperience()
                + " years of experience.";
        String email = user.getEMAIL();
        JobApplication application = new JobApplication(info, jobVacancy.getCOMPANY_ID(), jobVacancy.getJobTitle(), email);
        ((JobSeeker) user).getJobApplications().add(application);
        jobVacancy.addApplication(application);
    }

    public ArrayList<JobVacancy> browseJobs(String name){
        ArrayList<JobVacancy> vacancies = new ArrayList<>();
        for (JobVacancy j: allJobVacancies) {
            if(j.getJobTitle().equalsIgnoreCase(name)) {
                vacancies.add(j);
            }
        }
        return vacancies;
    }

    public void addJobVacancy(String title, String info) {
        JobVacancy vacancy = new JobVacancy(((JobPoster) user).getCOMPANY_ID(), title, info);
        for (Company i : companies) {
            if (i.getId() == ((JobPoster) user).getCOMPANY_ID()) {
                i.addVacancy(vacancy);
                break;
            }
        }
        allJobVacancies.add(vacancy);
    }

    public void deleteJob(JobVacancy vacancy) {
        allJobVacancies.remove(vacancy);
        for (int jobVacancyIdx=0; jobVacancyIdx<((JobPoster) user).getJobVacancies().size(); jobVacancyIdx++){
            if(((JobPoster) user).getJobVacancies().get(jobVacancyIdx)==vacancy){
                ((JobPoster) user).deleteJob(jobVacancyIdx);
            }
        }
    }

    public ArrayList<JobVacancy> getJobVacancies() {
        return companies.get(((JobPoster) user).getCOMPANY_ID()).getJobVacancies();
    }

    public void setApplicationStatus(String status, JobApplication application){
        application.setApplicationState(status);
    }

    public void updateCompanyDescription(Company company, String updatedDescription) {
        company.setCompanyDescription(updatedDescription);
    }

    public int getAge(){
        return ((JobSeeker)user).getAge();
    }

    public String getDegree(){
        return ((JobSeeker)user).getDegree();
    }

    public String getUniversity(){
        return ((JobSeeker)user).getUniversity();
    }

    public int getYearsOfExperience(){
        return ((JobSeeker)user).getYearsOfExperience();
    }
}