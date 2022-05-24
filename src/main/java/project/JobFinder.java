package project;

import java.util.Scanner;

public class JobFinder {

    public static void main(String[] args) {
        System.out.println("*********** Welcome to Job Finder! *************");
        FinderSystem finderSystem = new FinderSystem();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("""
                to sign in press 'i'
                to sign up as a job seeker press 'u'
                press any button to end
                """);
            String choice = input.nextLine();
            if (choice.equals("i")) {
                String user = "";
                        //= finderSystem.login("admin@gmail.com", "admin123", "a");
                seeker:
                while (user.equals("Seeker")) {
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
                        String function = input.nextLine();
                        switch (function) {
                            case "sj":
                                System.out.println("enter the name of vacancy you want to search for");
                                String toSearch = input.nextLine();
                                finderSystem.browseJobs(toSearch);
                                break;
                            case "q":
                                break seeker;
                            case "bj":
                                System.out.println(finderSystem.browseJobs());
                                break;
                            case "v":
                                System.out.println(finderSystem.viewMyApplications());
                                break;
                            case "a": {
                                System.out.println("enter the company id: ");
                                int id = input.nextInt();
                                input.nextLine(); //must be called to avoid errors

                                System.out.println("enter the job title: ");
                                String title = input.nextLine();
                                //finderSystem.addApplication(id, title);
                                break;
                            }
                            case "d": {
                                System.out.println("enter the index you want to remove: ");
                                int idx = input.nextInt();
                                input.nextLine();
                                //finderSystem.deleteApplication(idx);
                                break;
                            }
                            case "ua": {
                                System.out.println("enter the idx of application to be updated");
                                int idx = input.nextInt();
                                input.nextLine(); // must be called to avoid errors

                                System.out.println("enter the updated info");
                                String info = input.nextLine();
                                //finderSystem.updateApplication(idx, info);
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
                                    finderSystem.updateInfo(what);
                                }
                                break;
                            case "bc":
                                finderSystem.browseCompanies();
                                break;
                            case "sc":
                                System.out.println("enter the company name to search for it");
                                String name = input.nextLine();
                                finderSystem.browseCompanies(name);
                                break;
                            case "ar": {
                                System.out.println("enter the company id you want to rate out of ");
                                int id = input.nextInt();
                                input.nextLine(); // must be called to avoid errors

                                System.out.println("enter the review you want to give");
                                String review = input.nextLine();
                                finderSystem.addReview(review, id);
                                break;
                            }
                            default:
                                System.out.println("\nerror try again\n");
                                break;
                        }

                    }
                }

                admin:
                while (user.equals("Admin")) {
                    while (true) {
                        System.out.println("""
                                press 'c' to add company
                                press 'p' to add poster
                                press 'u' to update company
                                press 'q' to end
                                """);

                        String function = input.nextLine();

                        switch (function) {
                            case "p":
                                System.out.print("Enter the new job poster name: ");
                                String jobPosterName = input.nextLine();
                                System.out.print("Enter the job poster email: ");
                                String jobPosterEmail = input.nextLine();
                                System.out.print("Enter the job poster password: ");
                                String jobPosterPassword = input.nextLine();
                                System.out.print("Enter the job poster gender: ");
                                String jobPosterGender = input.nextLine();
                                System.out.print("Enter the company Id: ");
                                int companyId = input.nextInt();
                                input.nextLine();
                                finderSystem.addJobPoster(new JobPoster(jobPosterName, jobPosterEmail, jobPosterGender, jobPosterPassword, companyId));
                                break;
                            case "c":
                                System.out.print("Enter the new company name: ");
                                String companyName = input.nextLine();
                                System.out.print("Enter the new company description: ");
                                String companyDescription = input.nextLine();
                                finderSystem.addCompany(new Company(companyName, companyDescription));
                                break;
                            case "u":
                                System.out.print("Enter the chosen company name: ");
                                String chosenCompanyName = input.nextLine();
                                System.out.print("Enter the chosen company updated description: ");
                                String updatedDescription = input.nextLine();
                                //finderSystem.updateCompanyDescription(chosenCompanyName, updatedDescription);

                                break;
                            case "q":
                                break admin;
                            default:
                                System.out.println("\nerror try again\n");
                                break;
                        }
                    }
                }

                poster:
                while (user.equals("Poster")) {
                    finderSystem.viewJobVacancies();
                    System.out.println("""
                            press 'a' to add job vacancy
                            press 'd' to delete job vacancy
                            press 'v' to view job vacancy's applications and update their status
                            press 'q' to end
                            """);

                    String function = input.nextLine();

                    switch (function) {
                        case "a":
                            System.out.print("Enter job title: ");
                            String jobTitle = input.nextLine();
                            System.out.print("Enter job description: ");
                            String jobDescription = input.nextLine();
                            finderSystem.addJobVacancy(jobTitle, jobDescription);
                            break;
                        case "d":
                            System.out.print("Enter job vacancy index: ");
                            int idx = input.nextInt();
                            input.nextLine();
                            //finderSystem.deleteJob(idx);
                            System.out.println("Deleted! \n");
                            break;
                        case "v":
                            boolean can = false;
                            for (int i = 0; i < finderSystem.getJobVacancies().size(); i++) {
                                System.out.println("index is " + i);
                                System.out.println("Job title is " + finderSystem.getJobVacancies().get(i).getJobTitle());
                                System.out.println("-------------");
                                can = true;

                            }
                            if (can) {
                                System.out.print("Enter job vacancy index: ");
                                int vacancyIdx = input.nextInt();
                                input.nextLine();

                                if (finderSystem.getJobVacancies().get(vacancyIdx).viewApplications()) {
                                    System.out.print("\nEnter application's index to update its status: ");
                                    int applicationIdx = input.nextInt();
                                    input.nextLine();
                                    System.out.print("\nEnter new status: ");
                                    String status = input.nextLine();
                                    //finderSystem.setApplicationStatus(status, vacancyIdx, applicationIdx);
                                    System.out.println("\nadded!\n");
                                } else {
                                    System.out.println("\nthere is no applications on this job\n");
                                }
                            }else{
                                System.out.println("\ncan not be performed\n");
                            }
                            break;
                        case "q":
                            break poster;
                        default:
                            System.out.println("\nerror try again\n");
                            break;
                        }
                    }
            }
            else if (choice.equals("u")) {
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
                String degree = input.nextLine();
                System.out.println("enter your university: ");
                String uni = input.nextLine();
                System.out.println("enter your years of experience:");
                int expYears = input.nextInt();
                input.nextLine();
                finderSystem.addJobSeeker(name,email,gender,pass,age,degree,uni,expYears);
            }
            else break;
        }
    }
}