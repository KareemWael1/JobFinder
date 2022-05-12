package project;

import java.util.ArrayList;

public class FinderSystem {
    JobSeeker ahmed = new JobSeeker("Ahmed", "ahmed@gmail.com", "male", "8520", 20
            , "Masters", "MIT", 15);
    JobSeeker yara = new JobSeeker("Yara", "yara@gmail.com", "female", "yara123", 19
            , "PHD", "Cairo", 5);
    Company dell = new Company("Dell", "Tech company");
    Company edx = new Company("edx", "Educational company");
    JobPoster mai = new JobPoster("Mai", "mai@gmail.com", "female", "mai123", 0);
    JobPoster amr = new JobPoster("Amr", "amr@gmail.com", "male", "amr123", 1);
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
}
