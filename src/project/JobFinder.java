package project;

import java.util.ArrayList;
import java.util.Scanner;

public class JobFinder {


    public static void main(String[] args){
        System.out.println(" ******** Welcome to Job Finder! *************");
        //Admin
        CompanyAdmin admin = new CompanyAdmin("admin","admin@gmail.com","male","admin123");
        // two hard coded JobSeekers
        ArrayList<JobSeeker> jobSeekers = new ArrayList<>();
        JobSeeker ahmed = new JobSeeker("Ahmed","ahmed@gmail.com","male","8520",20
        ,"Masters","MIT",15);
        JobSeeker yara = new JobSeeker("Yara","yara@gmail.com","female","yara123",19
        ,"PHD","Cairo",5);
        jobSeekers.add(ahmed);
        jobSeekers.add(yara);
        //two companies
        Company dell = new Company("Dell","Tech company");
        Company edx = new Company("edx","Educational company");
        admin.addCompany(dell);
        admin.addCompany(edx);
        // Job posters
        ArrayList<JobPoster> allJobPosters = new ArrayList<>();
        JobPoster amr = new JobPoster("Amr","amr@gmail.com","male","amr123");
        edx.addJobPoster(amr);
        JobPoster mai = new JobPoster("Mai","mai@gmail.com","female","mai123");
        dell.addJobPoster(mai);
        allJobPosters.add(amr);
        allJobPosters.add(mai);
        //job vacancies
        mai.addJobVacancy("Slave","to work as student in AinShams");
        mai.addJobVacancy("Doctor","mange TAs in AinShams");
        amr.addJobVacancy("TA","Mange slaves in AinShams");
        //*****************************************************//
        lab:
        while(true){
            System.out.println("""
                    Press 's' to login as job seeker
                    press 'a' to login as admin
                    press 'p' to login as job poster
                    press 'q' to end""");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            switch (s) {
                case "s":
                    JobSeeker theOne = null;
                    while (true) {
                        System.out.println("you are logging in as job seeker");
                        System.out.println("enter your email: ");
                        String email = input.nextLine();
                        System.out.println("enter your password: ");
                        String pass = input.nextLine();
                        boolean logged = false;
                        for (JobSeeker i : jobSeekers) {
                            if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                                System.out.println("logged in !");
                                logged = true;
                                theOne = i;
                                break;
                            }
                        }
                        if (!logged) {
                            System.out.println("wrong mail or pass try again");
                        } else {
                            break;
                        }
                    }
                    // JobSeeker actions go here
                    while (true) {
                        System.out.println("""
                                Press 'bj' to browse jobs
                                press 'v' to view your applications
                                press 'a' to add application
                                press 'd' to delete application
                                press 'ua' to update application
                                press 'ui' to update info
                                press 'bc' to browse companies
                                press 'sc' to search for company
                                press 'ar' to add review
                                press 'q' to end
                                """);
                        String choice = input.nextLine();
                        if (choice.equals("q")){
                            break;
                        }else if (choice.equals("bj")){
                            System.out.println(theOne.browseJobs());
                        }else if (choice.equals("v")){
                            System.out.println(theOne.viewMyApplications());
                        }else if (choice.equals("a")){
                            System.out.println("enter the company id: ");
                            int id = input.nextInt();
                            input.nextLine(); //must be called to avoid errors
                            System.out.println("enter the job title: ");
                            String title = input.nextLine();
                            theOne.addApplication(id,title);
                        }else if (choice.equals("d")){
                            System.out.println("enter the index you want to remove: ");
                            int idx = input.nextInt();
                            input.nextLine(); // must be called to avoid errors
                            theOne.deleteApplication(idx);
                        }else if (choice.equals("ua")){
                            System.out.println("enter the idx of application to be updated");
                            int idx = input.nextInt();
                            input.nextLine(); // must be called to avoid errors
                            System.out.println("enter the updated info");
                            String info = input.nextLine();
                            theOne.updateApplication(idx,info);
                        }else if (choice.equals("ui")){
                            while (true){
                                System.out.println("""
                                    enter what to update: age, degree or years of experience
                                    when you finish press 'f'
                                  """);
                                String what = input.nextLine();
                                if (what.equals("f")) break;
                                System.out.println("enter the new value");
                                theOne.updateInfo(what);
                            }
                        }else if (choice.equals("bc")){
                            theOne.browseCompanies();
                        }else if (choice.equals("sc")){
                            System.out.println("enter the company name to search for it");
                            String name = input.nextLine();
                            theOne.browseCompanies(name);
                        }else if (choice.equals("ar")){
                            System.out.println("enter the company id you want to rate out of ");
                            int id = input.nextInt();
                            input.nextLine(); // must be called to avoid errors
                            System.out.println("enter the rate you want to give");
                            float review = input.nextFloat();
                            input.nextLine();
                            theOne.addReview(review,id);
                        }else{
                            System.out.println("error try again");
                        }

                    }


                    break;
                case "a":
                    while (true) {
                        System.out.println("you are logging in as Admin");
                        System.out.println("enter your email: ");
                        String email = input.nextLine();
                        System.out.println("enter your password: ");
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
                    // admin actions go here

                    break;
                case "p":
                    while (true) {
                        System.out.println("you are logging in as job Poster");
                        System.out.println("enter your email: ");
                        String email = input.nextLine();
                        System.out.println("enter your password: ");
                        String pass = input.nextLine();
                        boolean logged = false;
                        for (JobPoster i : allJobPosters) {
                            if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                                System.out.println("logged in !");
                                logged = true;
                                break;
                            }
                        }
                        if (!logged) {
                            System.out.println("wrong mail or pass try again");
                        } else {
                            break;
                        }
                    }
                    // poster actions go here


                    break;
                case   "q":
                    break lab;
                default:
                    System.out.println("wrong input try again");
                    break;
            }

        }
    }
}
