package project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ali
 */

import java.util.ArrayList;

public class JobVacancy {
    
    
   int companyID;
    String jobTitle;
    String jobDescription;
    
    public ArrayList<JobApplication> applications = new ArrayList<JobApplication>();
    
   
    public ArrayList<JobApplication> getJobApplications()
    {
    return applications;
    }
    
    
    
    public void addApplication (JobApplication application){
        
        
    }
    
    public String getJobDescription(){
    
    return jobDescription;
    
    }
    
    
    public void updateapplication (String info){
        
        info.setinfo(info);
    
    
    }
    
    
   String getJobTitle(){
        
        return jobTitle;
    }
            
            
   private Object getAllApplications()
   
   {
       for (int i=0;i<applications.size();i++)
           
           return applications.get(i).getname();
           
   }
    
    void removeapplication(int jobapplicationidx)
    {
    applications.remove(jobapplicationidx);
    
    }
    
    
    
    
}
