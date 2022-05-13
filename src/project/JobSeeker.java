package project;

import java.util.*;
public class JobSeeker extends Person

{
    private int age;
    private String degree;
    private String university;
    private int yearsOfExperience;
    // its assumed that the info in any application is this if the seeker want to change it he can use update info

    private ArrayList<JobApplication>  jobApplications = new ArrayList<>();

    JobSeeker(String name, String email, String gender, String password,int age,String degree,
              String university,int yearsOfExperience) {
        super(name, email, gender, password);
        this.age = age;
        this.degree = degree;
        this.university = university;
        this.yearsOfExperience = yearsOfExperience;
    }


    public ArrayList<JobApplication> viewMyApplications(){
        return jobApplications;
    }

    public ArrayList<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(ArrayList<JobApplication> applications){
        jobApplications = applications;
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













    @Override
    public String toString(){
        return "Name: " + NAME + "\nEmail: " + EMAIL + "\nGender: " + GENDER + "\n Age: " + age + "\nDegree: " + degree +
                "\nUniversity: " + university + "\nYears of Experience: " + yearsOfExperience + "\n";
    }

}