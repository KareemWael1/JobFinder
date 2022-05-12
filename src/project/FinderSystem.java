package project;

import java.util.ArrayList;

public class FinderSystem {
    JobSeeker ahmed = new JobSeeker("Ahmed", "ahmed@gmail.com", "male", "8520", 20
            , "Masters", "MIT", 15);
    JobSeeker yara = new JobSeeker("Yara", "yara@gmail.com", "female", "yara123", 19
            , "PHD", "Cairo", 5);
    JobPoster mai = new JobPoster("Mai", "mai@gmail.com", "female", "mai123", 0);
    JobPoster amr = new JobPoster("Amr", "amr@gmail.com", "male", "amr123", 1);
    CompanyAdmin admin = new CompanyAdmin("admin", "admin@gmail.com", "male", "admin123");


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

    public void searchJobs(JobSeeker seeker, String toSearch){
        System.out.println(seeker.browseJobs(toSearch));
    }

    public void browseJobs(JobSeeker seeker){
        System.out.println(seeker.browseJobs());
    }

    public void addApplication(JobSeeker seeker, int id, String title){
        seeker.addApplication(id, title);
    }

    public void deleteApplication(JobSeeker seeker, int idx)
    {
        seeker.deleteApplication(idx);
    }

    public void updateApplication(JobSeeker seeker, int idx, String info){
        seeker.updateApplication(idx, info);
    }
}
