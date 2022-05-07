package project;

import java.util.ArrayList;
import java.util.Scanner;

public class JobFinder {


    public static void main(String[] args){
        System.out.println("Welcome to Job Finder!");
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
        ArrayList<Company> companies = new ArrayList<>();
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
        amr.addJobVacancy("Slave","to work as student in AinShams");
        amr.addJobVacancy("TA","Mange slaves in AinShams");
        //*****************************************************//

        while(true){
            System.out.println("""
                    Press 's' to login as job seeker
                    press 'a' to login as admin
                    press 'p' to login as job poster""");
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            switch (s) {
                case "s":
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
                        System.out.println("you are logging in as job seeker");
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
                default:
                    System.out.println("wrong input try again");
                    break;
            }

        }
    }
}
