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


public class JobPoster extends Person {
        int companyID;
        private ArrayList<JobVacancy> jobVacancies = new ArrayList <JobVacancy>();
          
  
  JobPoster(String name, String email, String gender, String password) {
        super(name, email, gender, password);
        //TODO Auto-generated constructor stub
}
                   
          addjobvacancy(string title)
   
   final static private ArrayList<JobVacancy> jobvacancies = new ArrayList<JobVacancy>();
   
   
   public ArrayList<JobVacancy> getJobVacancies() {
   
   return this.jobvacancies;
   }   
   
   public void addjobvacancy(String info,String title){
           
           jobVacancies.void add(String title, String info);
                   }


void setApplicationstatus(boolean status){

        this.status= status;
}


public void deletejob(int jobvacancyidx){

jobvacancies.remove (jobvacancyidx);
}


@Override
public String toString() {
        // TODO Auto-generated method stub
        return null;
}


}
