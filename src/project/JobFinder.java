package project;

import java.util.ArrayList;
import java.util.Scanner;

public class JobFinder {

    public static void main(String[] args) {
        System.out.println(" ******** Welcome to Job Finder! *************");
        FinderSystem finderSystem = new FinderSystem();
        CompanyAdmin admin = new CompanyAdmin("admin", "admin@gmail.com", "male", "admin123");
        finderSystem.addJobPoster(finderSystem.getAllJobPosters().get(0)); // mai
        finderSystem.addJobPoster(finderSystem.getAllJobPosters().get(1)); // amr
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("""
                to sign in press 'i'
                to sign up press 'u' (only Job Seeker)
                press any button to end
                """);
            String chose = input.nextLine();
            if (chose.equals("i")) {

                //*****************************************************
                lab:
                while (true) {
                    System.out.println("""
                            Press 's' to login as job seeker
                            press 'a' to login as admin
                            press 'p' to login as job poster
                            press 'q' to end""");
                    String s = input.nextLine();
                    switch (s) {
                        case "s":
                            JobSeeker theOne = null;
                            while (true) {
                                System.out.println("you are logging in as job seeker");
                                System.out.print("enter your email: ");
                                String email = input.nextLine();
                                System.out.print("enter your password: ");
                                String pass = input.nextLine();
                                boolean logged = false;
                                for (JobSeeker i : finderSystem.getJobSeekers()) {
                                    if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                                        System.out.println("\nlogged in !\n");
                                        logged = true;
                                        theOne = i;
                                        break;
                                    }
                                }
                                if (!logged) {
                                    System.out.println("\nwrong mail or pass try again\n");
                                } else {
                                    break;
                                }
                            }
                            // JobSeeker actions go here
                            //noinspection TextLabelInSwitchStatement
                            label1:
                            while (true) {
                                System.out.println("""
                                        Press 'bj' to browse jobs
                                        Press 'sj' to search jobs
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
                                switch (choice) {
                                    case "sj":
                                        System.out.println("enter the name of vacancy you want to search for");
                                        String toSearch = input.nextLine();
                                        System.out.println(theOne.browseJobs(toSearch));
                                        break;
                                    case "q":
                                        break label1;
                                    case "bj":
                                        System.out.println(theOne.browseJobs());
                                        break;
                                    case "v":
                                        System.out.println(theOne.viewMyApplications());
                                        break;
                                    case "a": {
                                        System.out.println("enter the company id: ");
                                        int id = input.nextInt();
                                        input.nextLine(); //must be called to avoid errors

                                        System.out.println("enter the job title: ");
                                        String title = input.nextLine();
                                        theOne.addApplication(id, title);
                                        break;
                                    }
                                    case "d": {
                                        System.out.println("enter the index you want to remove: ");
                                        int idx = input.nextInt();
                                        input.nextLine(); // must be called to avoid errors

                                        theOne.deleteApplication(idx);
                                        break;
                                    }
                                    case "ua": {
                                        System.out.println("enter the idx of application to be updated");
                                        int idx = input.nextInt();
                                        input.nextLine(); // must be called to avoid errors

                                        System.out.println("enter the updated info");
                                        String info = input.nextLine();
                                        theOne.updateApplication(idx, info);
                                        break;
                                    }
                                    case "ui":
                                        while (true) {
                                            System.out.println("""
                                                      enter what to update: age, degree or years of experience
                                                      when you finish press 'f'
                                                    """);
                                            String what = input.nextLine();
                                            if (what.equals("f")) break;
                                            System.out.println("enter the new value");
                                            theOne.updateInfo(what);
                                        }
                                        break;
                                    case "bc":
                                        theOne.browseCompanies();
                                        break;
                                    case "sc":
                                        System.out.println("enter the company name to search for it");
                                        String name = input.nextLine();
                                        theOne.browseCompanies(name);
                                        break;
                                    case "ar": {
                                        System.out.println("enter the company id you want to rate out of ");
                                        int id = input.nextInt();
                                        input.nextLine(); // must be called to avoid errors

                                        System.out.println("enter the rate you want to give");
                                        float review = input.nextFloat();
                                        input.nextLine();
                                        theOne.addReview(review, id);
                                        break;
                                    }
                                    default:
                                        System.out.println("error try again");
                                        break;
                                }

                            }


                            break;
                        case "a":
                            while (true) {
                                System.out.println("you are logging in as Admin");
                                System.out.print("enter your email: ");
                                String email = input.nextLine();
                                System.out.print("enter your password: ");
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

                            //noinspection TextLabelInSwitchStatement
                            label2:
                            while (true) {
                                System.out.println("""
                                        press 'c' to add company
                                        press 'p' to add poster
                                        press 'u' to update company
                                        press 'q' to end
                                        """);

                                String choice = input.nextLine();

                                switch (choice) {
                                    case "p":
                                        System.out.print("Enter the new job poster name: ");
                                        String jobPosterName = input.nextLine();
                                        System.out.print("Enter the job poster email: ");
                                        String jobPosterEmail = input.nextLine();
                                        System.out.print("Enter the job poster password: ");
                                        String jobPosterPassword = input.nextLine();
                                        System.out.print("Enter the job poster gender: ");
                                        String jobPosterGender = input.nextLine();
                                        System.out.print("Enter the job poster ID: ");
                                        int jobPosterID = input.nextInt();
                                        input.nextLine();
                                        JobPoster jobPoster = new JobPoster(jobPosterName, jobPosterEmail, jobPosterGender, jobPosterPassword, jobPosterID);
                                        finderSystem.addJobPoster(jobPoster); //boom
                                        break;
                                    case "c":
                                        System.out.print("Enter the new company name: ");
                                        String companyName = input.nextLine();
                                        System.out.print("Enter the new company description: ");
                                        String companyDescription = input.nextLine();
                                        Company company = new Company(companyName, companyDescription);
                                        admin.addCompany(company);
                                        break;
                                    case "u":
                                        System.out.print("Enter the chosen company name: ");
                                        String chosenCompanyName = input.nextLine();
                                        System.out.print("Enter the chosen company updated description: ");
                                        String updatedDescription = input.nextLine();

                                        for (int i = 0; i < CompanyAdmin.getCompanies().size(); i++) {
                                            if (CompanyAdmin.getCompanies().get(i).getName().equals(chosenCompanyName)) {
                                                CompanyAdmin.updateCompanyDescription(CompanyAdmin.getCompanies().get(i), updatedDescription);
                                                break;
                                            }
                                        }
                                        break;
                                    case "q":
                                        break label2;
                                    default:
                                        System.out.println("error try again");
                                        break;
                                }
                            }

                            break;

                        case "p":
                            JobPoster poster = null;
                            while (true) {
                                System.out.println("you are logging in as job Poster");
                                System.out.print("enter your email: ");
                                String email = input.nextLine();
                                System.out.print("enter your password: ");
                                String pass = input.nextLine();
                                boolean logged = false;
                                for (JobPoster i : finderSystem.getAllJobPosters()) {
                                    if (i.getEMAIL().equals(email) && i.getPassword().equals(pass)) {
                                        System.out.println("logged in !");
                                        logged = true;
                                        poster = i;
                                        break;
                                    }
                                }
                                if (!logged) {
                                    System.out.println("wrong mail or pass try again");
                                } else {
                                    break;
                                }
                            }

                            //noinspection TextLabelInSwitchStatement
                            label3:
                            while (true) {
                                poster.viewJobVacancies();
                                System.out.println("""
                                        press 'a' to add job vacancy
                                        press 'd' to delete job vacancy
                                        press 'v' to view job vacancy's applications and update their status
                                        press 'q' to end
                                        """);

                                String choice = input.nextLine();

                                switch (choice) {
                                    case "a":
                                        System.out.print("Enter job title: ");
                                        String jobTitle = input.nextLine();
                                        System.out.print("Enter job description: ");
                                        String jobDescription = input.nextLine();
                                        poster.addJobVacancy(jobTitle, jobDescription);
                                        break;
                                    case "d":
                                        System.out.print("Enter job vacancy index: ");
                                        int idx = input.nextInt();
                                        input.nextLine();
                                        poster.deleteJob(idx);
                                        System.out.println("Deleted! \n");
                                        break;
                                    case "v":
                                        System.out.print("Enter job vacancy index: ");
                                        int vacancyIdx = input.nextInt();
                                        input.nextLine();
                                        poster.getJobVacancies().get(vacancyIdx).viewApplications();
                                        System.out.print("\nEnter application's index to update its status: ");
                                        int applicationIdx = input.nextInt();
                                        input.nextLine();
                                        System.out.print("\nEnter new status: ");
                                        String status = input.nextLine();
                                        poster.setApplicationStatus(status, vacancyIdx, applicationIdx);
                                        break;
                                    case "q":
                                        break label3;
                                    default:
                                        System.out.println("error try again");
                                        break;
                                }
                            }

                            break;
                        case "q":
                            break lab;
                        default:
                            System.out.println("wrong input try again");
                            break;
                    }
                }
            } else if (chose.equals("u")) {
                System.out.println("enter your name: ");
                String name = input.nextLine();
                System.out.println("enter your email: ");
                String email = input.nextLine();
                System.out.println("enter your gender: ");
                String gender = input.nextLine();
                System.out.println("enter your age: ");
                int age = input.nextInt();
                input.nextLine();
                System.out.println("enter your password: ");
                String pass = input.nextLine();
                System.out.println("enter your degree: ");
                String degeree = input.nextLine();
                System.out.println("enter your university: ");
                String uni = input.nextLine();
                System.out.println("enter your years of experince:");
                int expyears = input.nextInt();
                input.nextLine();
                finderSystem.addJobSeeker(name,email,gender,pass,age,degeree,uni,expyears);
            }else{
                break;
            }
        }
    }

}

