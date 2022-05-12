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

    private Person user;

    private final ArrayList<JobPoster> allJobPosters = new ArrayList<>(){
        {
            add(mai);
            add(amr);
        }
    };

    private final ArrayList<JobSeeker> jobSeekers = new ArrayList<>(){
        {
            add(ahmed);
            add(yara);
        }
    };

    public ArrayList<JobSeeker> getJobSeekers() {
        return jobSeekers;
    }

    public ArrayList<JobPoster> getAllJobPosters() {
        return allJobPosters;
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

        }
    }

    public void addJobSeeker(String name,String email,String gender,String password,int age,String degree,String uni,int exp){
        JobSeeker seeker = new JobSeeker(name,email,gender,password,age,degree,uni,exp);
        jobSeekers.add(seeker);
    }
    public void addCompany(Company company){
        CompanyAdmin.addCompany(company);
    }

    public void addJobPoster(JobPoster jobPoster){
        CompanyAdmin.addJobPoster(jobPoster);
        allJobPosters.add(jobPoster);
    }

    public void searchJobs(String toSearch){
        System.out.println(((JobSeeker)user).browseJobs(toSearch));
    }

    public void browseJobs(){
        System.out.println(((JobSeeker)user).browseJobs());
    }

    public void addApplication(int id, String title){
        ((JobSeeker)user).addApplication(id, title);
    }

    public void deleteApplication(int idx)
    {
        ((JobSeeker)user).deleteApplication(idx);
    }

    public void updateApplication(int idx, String info){
        ((JobSeeker)user).updateApplication(idx, info);
    }
}
