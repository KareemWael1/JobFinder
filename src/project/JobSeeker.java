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
    public void addApplication(int COMPANY_ID){
          String info = "My name is "+ getNAME() + ", And I have " +getAge()+ " years old " + "\n I got a " + getDegree() +
                " degree " + "from " + getUniversity() + " university " + "also I have " + getYearsOfExperience()
                + " years of experience.";

        jobApplications.add(new JobApplication(info,COMPANY_ID));
    }
    // return the array itself
    public ArrayList<JobApplication> viewMyApplications(){
        return jobApplications;
    }
    // update the info in specific application
    public void updateApplication(int applicationIdx,String updatedInfo){
        jobApplications.get(applicationIdx).setApplicantInfo(updatedInfo);
    }
    // delete specific application based on index
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
            case "age" -> setAge(input.nextInt());
            case "degree" -> setDegree(input.nextLine()); //there is error when using nextLine after or before other next inputs
            case "university" -> setUniversity(input.nextLine());
            case "years of experience" -> setYearsOfExperience(input.nextInt());
        }
    }
    public void browseCompanies(){
        ArrayList<Company> companies =  CompanyAdmin.getCompanies();
        for (Company i : companies){
            System.out.println("Company name: "+i.getName());
            System.out.println("Company ID: "+i.getID());
            System.out.println("Company Description: "+i.getCompanyDescription());
            System.out.println("Company Rating: "+ i.getReviewRate());
            //System.out.println();  #comapny job vacancies
            System.out.println("*********************************************");
        }
    }

    public void browseCompanies(String name) {
        ArrayList<Company> companies = CompanyAdmin.getCompanies();
        for (Company i : companies) {
            if (name.equalsIgnoreCase(i.getName())) {
                System.out.println("Company name: " + i.getName());
                System.out.println("Company ID: " + i.getID());
                System.out.println("Company Description: " + i.getCompanyDescription());
                System.out.println("Company Rating: " + i.getReviewRate());
                //System.out.println();  #comapny job vacancies
                System.out.println("*********************************************");
            }
        }
    }

    public void addReview(float rate,int ID){
        boolean canAddReview = false;
        for (JobApplication i: jobApplications){
            if (i.getCOMPANY_ID()==ID){
                canAddReview = true;
                break;
            }
        }
        if(canAddReview){
            ArrayList<Company> companies = CompanyAdmin.getCompanies();
            for (Company j : companies){
                if (j.getID()==ID){
                    j.setSeekerReviews(rate);
                    break;
                }
            }
        }
        else {
            System.out.println("you can not add a review to this company as you did not submit an application to it");
        }

    }

    @Override
    public String toString(){
        return "Name: " + NAME + "\nEmail: " + EMAIL + "\nGender: " + GENDER + "\n Age: " + age + "\nDegree: " + degree +
                "\nUniversity: " + university + "\nYears of Experience: " + yearsOfExperience + "\n";
    }

}