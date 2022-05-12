package project;

import java.util.*;

public class FinderSystem {
    JobSeeker ahmed = new JobSeeker("Ahmed", "ahmed@gmail.com", "male", "8520", 20
            , "Masters", "MIT", 15);
    JobSeeker yara = new JobSeeker("Yara", "yara@gmail.com", "female", "yara123", 19
            , "PHD", "Cairo", 5);
    JobPoster mai = new JobPoster("Mai", "mai@gmail.com", "female", "mai123", 0);
    JobPoster amr = new JobPoster("Amr", "amr@gmail.com", "male", "amr123", 1);
    CompanyAdmin admin = new CompanyAdmin("admin", "admin@gmail.com", "male", "admin123");
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



    public ArrayList<JobSeeker> getJobSeekers() {
        return jobSeekers;
    }

    public ArrayList<JobPoster> getAllJobPosters() {
        return allJobPosters;
    }

    public static ArrayList<Company> getCompanies() {
        return companies;
    }

    public String login() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Press 's' to login as job seeker
                press 'a' to login as admin
                press 'p' to login as job poster
                press 'q' to end""");
        String s = input.nextLine();
        switch (s) {
            case "s":
                while (true) {
                    System.out.println("you are logging in as job seeker");
                    System.out.print("enter your email: ");
                    String email = input.nextLine();
                    System.out.print("enter your password: ");
                    String pass = input.nextLine();
                    boolean logged = false;
                    for (JobSeeker i : jobSeekers) {
                        if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                            System.out.println("\nlogged in !\n");
                            logged = true;
                            user = i;
                            break;
                        }
                    }
                    if (!logged) {
                        System.out.println("\nwrong mail or pass try again\n");
                    } else {
                        break;
                    }
                }
                return "Seeker";

            case "a":
                while (true) {
                    System.out.println("you are logging in as Admin");
                    System.out.print("enter your email: ");
                    String email = input.nextLine();
                    System.out.print("enter your password: ");
                    String pass = input.nextLine();
                    boolean logged = false;
                    if (admin.getEMAIL().equals(email) && admin.getPassword().equals(pass)) {
                        System.out.println("logged in !");
                        logged = true;
                        break;
                    }

                    if (logged) {
                        break;
                    } else {
                        System.out.println("try again");
                    }
                }
                return "Admin";

            case "p":
                while (true) {
                    System.out.println("you are logging in as job Poster");
                    System.out.print("enter your email: ");
                    String email = input.nextLine();
                    System.out.print("enter your password: ");
                    String pass = input.nextLine();
                    boolean logged = false;
                    for (JobPoster i : getAllJobPosters()) {
                        if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                            System.out.println("logged in !");
                            logged = true;
                            user = i;
                            break;
                        }
                    }
                    if (!logged) {
                        System.out.println("wrong mail or pass try again");
                    } else {
                        break;
                    }
                }
                return "Poster";
        }
        return "";
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
        ArrayList<JobVacancy> vacancies = companies.get(companyID).getJobVacancy();
        for (JobVacancy i : vacancies) {
            for (JobApplication j : i.getApplications()) {
                if (j.getJobTitle().equalsIgnoreCase(jobTitle) && j.getApplicantMail().equals(mail)) {
                    i.removeApplication(j);
                    return;

                }
            }
        }

        ((JobSeeker) user).deleteApplication(idx);
    }

    public void browseCompanies(String name) {
        boolean found = false;
        for (Company i : companies) {
            if (name.equalsIgnoreCase(i.getName())) {
                found = true;
                System.out.println("Company name: " + i.getName());
                System.out.println("Company ID: " + i.getId());
                System.out.println("Company Description: " + i.getCompanyDescription());
                System.out.println("Company Rating: " + i.getReviewRate());
                System.out.println("available vacancies" + i.getJobVacancy());  //company job vacancies
                System.out.println("*********************************************");
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }

    public void browseCompanies() {
        for (Company company : companies) {
            System.out.println(company);
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

    public void addReview(float rate, int COMPANY_ID) {
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
                    j.setSeekerReviews(rate);
                    break;
                }
            }
        } else {
            System.out.println("you can not add a review to this company as you did not submit an application to it");
        }
    }

    public void updateApplication(int idx, String info) {

        ((JobSeeker) user).getJobApplications().get(idx).setApplicantInfo(info);
    }

    public ArrayList<JobVacancy> browseJobs() {
        return allJobVacancies;
    }

    public ArrayList<JobApplication> viewMyApplications() {
        return ((JobSeeker) user).viewMyApplications();
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
                System.out.println("Done :) hehe !");
                return;
            }
        }
        System.out.println("Oops!! Not found! :(");
    }

    public void viewJobVacancies() {
        ((JobPoster) user).viewJobVacancies();
    }

    public void browseJobs(String name){
        for (JobVacancy j: allJobVacancies) {
            if(j.getJobTitle().equalsIgnoreCase(name))
                System.out.println(j);
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
        return ((JobPoster) user).getJobVacancies();
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