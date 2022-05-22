package project;

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
    static Company dell = new Company("Dell", "Tech company");
    static Company edx = new Company("edx", "Educational company");
    {
        dell.addVacancy(it);
        edx.addVacancy(instructor);
        dell.addJobPoster(mai);
        edx.addJobPoster(amr);
    }

    private Person user;

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
        }
    };


    final static private ArrayList<Company> companies = new ArrayList<>() {
        {
            add(dell);
            add(edx);
        }
    };

    public ArrayList<JobPoster> getAllJobPosters() {
        return allJobPosters;
    }

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
                for (JobPoster i : getAllJobPosters()) {
                    if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                        logged = true;
                        user = i;
                        break;
                    }
                }
                System.out.println(logged);
                return logged;
            }
        }
        return false;
    }


    public void addJobSeeker(String name, String email, String gender, String password, int age, String degree, String uni, int exp) {
        JobSeeker seeker = new JobSeeker(name, email, gender, password, age, degree, uni, exp);
        jobSeekers.add(seeker);
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public void addJobPoster(JobPoster jobPoster) {
        companies.get(jobPoster.getCOMPANY_ID()).addJobPoster(jobPoster);
        allJobPosters.add(jobPoster);
    }




    public void deleteApplication(int idx) {
        String jobTitle = ((JobSeeker) user).getJobApplications().get(idx).getJobTitle();

        int companyID = ((JobSeeker) user).getJobApplications().get(idx).getCOMPANY_ID();

        String mail = user.getEMAIL();

        for (JobVacancy i : companies.get(companyID).getJobVacancy()) {

            int index=0;
            for (JobApplication j : i.getApplications()) {
                if (j.getJobTitle().equalsIgnoreCase(jobTitle) && j.getApplicantMail().equals(mail)) {
                    i.removeApplication(index);
                    ((JobSeeker) user).deleteApplication(idx);
                    return;

                }
                index++;
            }
        }
    }

    public void browseCompanies(String name) {
        boolean found = false;
        for (Company company : companies) {
            if (name.equalsIgnoreCase(company.getName())) {
                found = true;
                System.out.println(company);
            }
        }
        if (!found) {
            System.out.println("\nNot found\n");
        }
    }

    public void browseCompanies() {
        for (Company company : companies) {
            System.out.println(company);
            System.out.println(company.getJobVacancy());
            System.out.println("\n--------------------------");
        }
    }

    public void updateInfo(String field) {
        Scanner input = new Scanner(System.in);
        switch (field.toLowerCase()) {
            case "age" -> {
                ((JobSeeker) user).setAge(input.nextInt());
                input.nextLine();
            }
            case "degree" -> ((JobSeeker) user).setDegree(input.nextLine()); //there is error when using nextLine after or before other next inputs
            case "university" -> ((JobSeeker) user).setUniversity(input.nextLine());
            case "years of experience" -> ((JobSeeker) user).setYearsOfExperience(input.nextInt());
            default -> {
            }
        }
    }

    public void addReview(String review, int COMPANY_ID) {
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
        } else {
            System.out.println("\nyou can not add a review to this company as you did not submit an application to it\n");
        }
    }

    public void updateApplication(int idx, String info) {

        ((JobSeeker) user).getJobApplications().get(idx).setApplicantInfo(info);
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

    public void addApplication(int COMPANY_ID, String jobTitle) {
        for (JobVacancy J : allJobVacancies) {
            if (J.getJobTitle().equalsIgnoreCase(jobTitle) && J.getCOMPANY_ID()==COMPANY_ID) {
                String info = "My name is " + user.getNAME() + ", And I have " + ((JobSeeker) user).getAge() + " years old " + "\n I got a " +
                        ((JobSeeker) user).getDegree() +
                        " degree " + "from " + ((JobSeeker) user).getUniversity() + " university " + "also I have " +
                        ((JobSeeker) user).getYearsOfExperience()
                        + " years of experience.";
                String email = user.getEMAIL();
                JobApplication application = new JobApplication(info, COMPANY_ID, jobTitle, email);
                ((JobSeeker) user).getJobApplications().add(application);
                J.addApplication(application);
                System.out.println("\nDone!\n");
                return;
            }
        }
        System.out.println("\nOops!! Not found!\n");
    }

    public void viewJobVacancies() {
        ((JobPoster) user).viewJobVacancies();
    }

    public void browseJobs(String name){
        for (JobVacancy j: allJobVacancies) {
            if(j.getJobTitle().equalsIgnoreCase(name)) {
                System.out.println(j);
                System.out.println("\n-------------------------");
            }
        }
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

    public void deleteJob(int jobVacancyIdx) {
        JobVacancy vacancy = ((JobPoster) user).getJobVacancies().get(jobVacancyIdx);
        allJobVacancies.remove(vacancy);
        ((JobPoster) user).deleteJob(jobVacancyIdx);
    }

    public ArrayList<JobVacancy> getJobVacancies() {
        return companies.get(((JobPoster) user).getCOMPANY_ID()).getJobVacancies();
    }

    public void setApplicationStatus(String status, int jobVacancyIdx, int jobApplicationIdx){
        getJobVacancies().get(jobVacancyIdx).getJobApplications().get(jobApplicationIdx).setApplicationState(status);
    }

    public void updateCompanyDescription(String chosenCompanyName, String updatedDescription) {
        for (Company company: companies) {
            if (company.getName().equals(chosenCompanyName)) {
                company.setCompanyDescription(updatedDescription);
                break;
            }
        }
    }
}