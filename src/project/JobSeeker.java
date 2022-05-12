package project;

import java.util.*;
public class JobSeeker extends Person

{
    private int age;
    private String degree;
    private String university;
    private int yearsOfExperience;
    // its assumed that the info in any application is this if the seeker want to change it he can use update info

    private final ArrayList<JobApplication>  jobApplications = new ArrayList<>();

    JobSeeker(String name, String email, String gender, String password,int age,String degree,
              String university,int yearsOfExperience) {
        super(name, email, gender, password);
        this.age = age;
        this.degree = degree;
        this.university = university;
        this.yearsOfExperience = yearsOfExperience;
    }

    public void addApplication(int COMPANY_ID,String jobTitle){
          String info = "My name is "+ getNAME() + ", And I have " +getAge()+ " years old " + "\n I got a " + getDegree() +
                " degree " + "from " + getUniversity() + " university " + "also I have " + getYearsOfExperience()
                + " years of experience.";
          JobApplication application = new JobApplication(info,COMPANY_ID,jobTitle);
          jobApplications.add(application);
          ArrayList<Company> companies = CompanyAdmin.getCompanies();
          ArrayList<JobVacancy> jobVacancies;
          for (Company i : companies){
            jobVacancies =i.getJobVacancy();
            for (JobVacancy j : jobVacancies){
                if (j.getJobTitle().equals(jobTitle)){
                    j.addApplication(application);
                }
            }
        }


    }

    public ArrayList<JobApplication> viewMyApplications(){
        return jobApplications;
    }

    public void updateApplication(int applicationIdx,String updatedInfo){
        jobApplications.get(applicationIdx).setApplicantInfo(updatedInfo);
    }

    public void deleteApplication(int applicationIdx){
        jobApplications.remove(applicationIdx);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void updateInfo(String field){
        Scanner input = new Scanner(System.in);
        switch (field.toLowerCase()) {
            case "age" -> {
                setAge(input.nextInt());
                input.nextLine();
            }
            case "degree" -> setDegree(input.nextLine()); //there is error when using nextLine after or before other next inputs
            case "university" -> setUniversity(input.nextLine());
            case "years of experience" -> setYearsOfExperience(input.nextInt());
            default -> {
            }
        }
    }

    public void browseCompanies(){
        ArrayList<Company> companies =  CompanyAdmin.getCompanies();
        for (Company i : companies){
            System.out.println("Company name: "+i.getName());
            System.out.println("Company ID: "+i.getId());
            System.out.println("Company Description: "+i.getCompanyDescription());
            System.out.println("Company Rating: "+ i.getReviewRate());
            System.out.println("available vacancies"+i.getJobVacancy());  //company job vacancies
            System.out.println("*********************************************");
        }
    }

    public void browseCompanies(String name) {
        ArrayList<Company> companies = CompanyAdmin.getCompanies();
        boolean found = false;
        for (Company i : companies) {
            if (name.equalsIgnoreCase(i.getName())) {
                found = true;
                System.out.println("Company name: " + i.getName());
                System.out.println("Company ID: " + i.getId());
                System.out.println("Company Description: " + i.getCompanyDescription());
                System.out.println("Company Rating: " + i.getReviewRate());
                System.out.println("available vacancies"+i.getJobVacancy());  //company job vacancies
                System.out.println("*********************************************");
            }
        }
        if (! found){
            System.out.println("Not found");
        }
    }

    public void addReview(float rate,int COMPANY_ID){
        boolean canAddReview = false;
        for (JobApplication i: jobApplications){
            if (i.getCOMPANY_ID()==COMPANY_ID){
                canAddReview = true;
                break;
            }
        }
        if(canAddReview){
            ArrayList<Company> companies = CompanyAdmin.getCompanies();
            for (Company j : companies){
                if (j.getId()==COMPANY_ID){
                    j.setSeekerReviews(rate);
                    break;
                }
            }
        }
        else {
            System.out.println("you can not add a review to this company as you did not submit an application to it");
        }

    }

    public ArrayList<JobVacancy> browseJobs(){
        ArrayList<JobVacancy> allJobVacancies = new ArrayList<>();
        ArrayList<Company> companies = CompanyAdmin.getCompanies();
        for (Company i : companies ){
            allJobVacancies.addAll(i.getJobVacancy());
        }
        return allJobVacancies;
    }

    public ArrayList<JobVacancy> browseJobs(String name){
        ArrayList<JobVacancy> allJobVacancies = new ArrayList<>();
        ArrayList<Company> companies = CompanyAdmin.getCompanies();
        for (Company i : companies ){
            for (JobVacancy j: i.getJobVacancy()) {
                if(j.getJobTitle().equalsIgnoreCase(name))
                allJobVacancies.add(j);
            }
        }
        return allJobVacancies;
    }




    @Override
    public String toString(){
        return "Name: " + NAME + "\nEmail: " + EMAIL + "\nGender: " + GENDER + "\n Age: " + age + "\nDegree: " + degree +
                "\nUniversity: " + university + "\nYears of Experience: " + yearsOfExperience + "\n";
    }

}