/*
Class Name: JobifyRunner.java
Author: Justin Shi
Date: 06/10/2020
Purpose: This class contains the main method, user interface and run the entire program
*/
import java.util.*;
public class JobifyRunner{
   static Scanner sc = new Scanner (System.in);
   //create a new database object
   static JobifyDatabase jbfy = new JobifyDatabase("database");
   //declear a new employer object
   static Employer employer;
   //declear a new employee object
   static Employee employee;
   static String flush;
   
   public static void main(String[] args){
      startscreen(); 
   }
   //the initial screen when running the code asks user whether they are employee or employer, then functions accordingly
   //PPT slide #2
   public static void startscreen (){
      try{  //all the methods that prompt user for input is contained in a try and catch to avoid run-time error. If so, the method will call itself and start over again
         int choice;
         System.out.println("Are you 1. employer or 2. employee");
         System.out.println("Enter your choice: ");
         choice = sc.nextInt();
         while (!(choice == 1 || choice == 2)){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
         }
         if (choice == 1){ //goes to PPT slide #3
            employerStartScreen();
         } 
         if (choice == 2){ //goes to PPT slide #15
            employeeStartScreen();
         }
      }catch(Exception e){
         flush=sc.nextLine();
         System.out.println("invalid input(error occured in startScreen), please try again!");
         startscreen();
      } 
   }
   
   //PPT slide #3
   public static void employerStartScreen(){
      try{
         int choice;
         System.out.println("Do you want to 1.sign up, 2.sign in or 3.Go back to previous option?");
         choice=sc.nextInt();
         while(choice != 1 && choice != 2 && choice != 3){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();
         }
         if(choice == 1){ //goes to PPT slide #4
            signUp();
         }
         if(choice == 2){ //goes to PPT slide #5
            signIn();
         }
         if(choice ==3){ //back to PPT slide #2
            startscreen();
         }
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in employyerStartScreen), please try again!");
         employerStartScreen();
      }	
   }
   
   //PPT slide #4    
   public static void signUp(){
      String flush;
      try{
         int choice;
         System.out.println("Do you want to 1.Enter your information or 2.Go back to previous option?");
         choice=sc.nextInt();
         while(choice != 1 && choice != 2){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();
         }
         if(choice == 1){ //goes to slide #5 after execution in JobifyDatabase
            jbfy.addAccount();
            signIn();
         }
         if(choice == 2){ //back to slide #3
            employerStartScreen();
         }
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in employer sign up process), please try again!");
         signUp();
      }
   }
   
   //PPT slide #5    
   public static void signIn(){
      try{
         int choice;
         System.out.println("Do you want to 1.Enter your account or 2.Go back to previous option?");
         choice=sc.nextInt();
         while(choice != 1 && choice != 2){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();
         }
         if(choice == 1){ //asks user for account info then test whether it matches an account in database
            sc.nextLine();
            System.out.println("Enter your username: ");
            String username=sc.nextLine();
            System.out.println("Enter your password: ");
            String password=sc.nextLine();
            if(jbfy.login(username,password)){ //if match, goes to slide #6
               employer=jbfy.getEmployer(username,password);
               employerMenu(); 
            }else{ //if does not match, back to slide #3, let user to choose whether to sign in or sign up again
               employerStartScreen(); 
            }
         } else if (choice == 2){// go back to previous option
            employerStartScreen(); 
         }
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in employer signIn), please try again!");
         signIn();
      }
   } 
   
   //PPT slide #6 the menu interface for employer
   public static void employerMenu(){
      try{
         int choice;
         System.out.println("1.Add job\n2.Delete job\n3.View posted jobs\n4.Change account information\n5.Exit with saving all information to text file\n6.Exit without saving to text file\n7.Go back to previous option\n8.Print user information");
         choice=sc.nextInt();
         while(choice < 1 || choice > 8){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();   
         }
         if(choice == 1){ //goes to slide #8, add a job using database method, then back to employer menu
            jbfy.addJob();
            employerMenu();
         }
         if(choice == 2){ //goes to slide #13, delete a job using database method, then back to employer menu
            jbfy.deleteJob();
            employerMenu();
         }
         if(choice == 3){ //display all jobs posted, then back to employer menu
            jbfy.displayJob(employer.getExistingJob());
            employerMenu();
         }
         if(choice == 4){ //goes to slide #7, change the users information using database method, then back to employer menu
            employer.changeAccountInfo();
            employerMenu(); 
         }
         if(choice == 5){ //saves any informations to a given file, then exit
            jbfy.saveToFile();
            System.out.println("Thank you for using our program, be careful during Covid!");
         }
         if(choice == 6){ //exit without saving anything
            System.out.println("Thank you for using our program, be careful during Covid!");
         }
         if(choice == 7){ //back to slide #3
            employerStartScreen();  
         }
         if (choice==8){
            System.out.println(employer);
            System.out.println("");
            employerMenu(); 
         }
         
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in employer menu), please try again!");
         employerMenu();
      }
   }

   //ppt slide#15 - Employee start screen
   public static void employeeStartScreen(){
      try{
         int choice;
         System.out.println("Do you want to 1. Enter your information or 2. Go back to previous option?");
         System.out.println("Enter your choice: ");
         choice = sc.nextInt();
         while (choice != 1 && choice != 2 ){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
         }
      //ppt slide#15 - option 1
         if (choice == 1){
            jbfy.setEmployeeInfo();
            employee = jbfy.getEmployee();
            System.out.println(employee);
            employeeMenu();
         }
      //ppt slide#15 - option 2
         if (choice == 2){
            startscreen();
         }
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in employee start screen), please try again!");
         employeeStartScreen();
      }
   }

   //ppt slide#16 - Employee main menu
   public static void employeeMenu(){
      try{
         int choice;
         System.out.println("1. Display all jobs\n2. Display all full time jobs\n3. Display all part time jobs\n4. Search and display full time jobs by your demands\n5. Search and display part time jobs by your demands\n6. Search and display job list by keyword (job title)\n7. Search and display job list by keyword (company title)\n8. Print Resume\n9. Save selected jobs to a file\n10. Exit");
         System.out.println("Enter your option: ");
         choice=sc.nextInt();
         while (choice < 1 || choice > 10){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
         }
      //ppt slide#16 - option 1: Display all jobs
         if(choice == 1){
            jbfy.displayJob(jbfy.get1dJob());
            employeeMenu();
         }
      //ppt slide#16 - option 2: Display all full time jobs
         if(choice == 2){
            jbfy.displayJob(jbfy.allFullTime());
            employeeMenu();
         }
      //ppt slide#16 - option 3: Display all part time jobs
         if(choice == 3){
            jbfy.displayJob(jbfy.allPartTime());
            employeeMenu();
         }
      //ppt slide#16 - option 4: Search and display full time jobs by your demands
         if(choice == 4){
            Job [] joblist;
            joblist = jbfy.searchFullTimeDemand();
            searchFollowUp(joblist);
         }
      //ppt slide#16 - option 5: Search and display part time jobs by your demands
         if(choice == 5){
            Job [] joblist;
            joblist = jbfy.searchPartTimeDemand();
            searchFollowUp(joblist);
         }
      //ppt slide#16 - option 6: Search and display for job list by keyword (job title)
         if(choice == 6){
            Job [] joblist;
            joblist = jbfy.searchByTitle();
            searchFollowUp(joblist);
         }
      //ppt slide#16 - option 7: Search and display job list by keyword (company title)
         if(choice == 7){
            Job [] joblist;
            joblist = jbfy.searchByCompany();
            searchFollowUp(joblist);
         }
      //ppt slide#16 - option 8: Print Resume
         if(choice == 8){
            System.out.println(employee);
            employeeMenu();
         }
      //ppt slide#16 - option 9: Save selected jobs to a file
         if(choice == 9){
            jbfy.saveJobsToFile(jbfy.getSelectJob());
            employeeMenu();
         }
      //ppt slide#16 - option 10: Exit
         if(choice == 10){
            System.out.println("Thank you for using our program, be careful during Covid!");
         }
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in employee menu), please try again!");
         employeeMenu();
      }  
   }
   
   //ppt slide#23, 25 - follow up all searching options
   public static void searchFollowUp(Job[] jobslist){
      Job[] temp=jobslist;
      try{
         int choice;
         System.out.println("1. Display all possible jobs\n2. Sort and display all possible jobs\n3. Back to employee menu");
         choice = sc.nextInt();
         while (choice < 1 || choice > 3){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
         }
         if (choice == 1){
            jbfy.displayJob(jobslist);
            selectajob(jobslist);
         }
         if (choice == 2){
            Job[] sortedJob = sortJobs(jobslist);
            jbfy.displayJob(sortedJob);
            selectajob(sortedJob);
         }
         if (choice == 3){
            employeeMenu();
         }
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in searchFollowUp), please try again!");
         searchFollowUp(temp);
      }
       
   }
   
   //ppt slide#26 - Select jobs after display
   public static void selectajob(Job[] jobslist){
      Job[] temp=jobslist;
      try{
         int choice;
         System.out.println("1. Select a job from list by job number and store in the cart\n2. Display selected jobs\n3. Back to employee menu");
         choice = sc.nextInt();
         while (choice < 1 || choice > 3){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
         }
         if (choice == 1){
            int jobNumber;
            System.out.println("Enter the job number: ");
            jobNumber = sc.nextInt();
            jbfy.selectJob(jobNumber, jobslist);
            selectajob(temp);
         }
         if (choice == 2){
            jbfy.displayJob(jbfy.getSelectJob());
            selectajob(temp);
         }
         if (choice == 3){
            employeeMenu();
         }
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in select a job), please try again!");
         selectajob(temp);
      }
   }
   
   //ppt slide#19 - sort jobs and return a sorted job array
   public static Job[] sortJobs(Job[] jobslist){
      Job[] temp=jobslist;
      try{
         int choice;    
         System.out.println("1. Sort from high wage to low wage\n2. Sort from large company size to small company size");
         System.out.println("Enter your choice: ");
         choice = sc.nextInt();
         while (choice != 1 && choice != 2){
            System.out.println("invalid option, please try again!");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
         }
         if(choice == 1){
            return jbfy.sortByWage(jobslist);
         }
         if(choice == 2){
            return jbfy.sortByCompanySize(jobslist);
         }
      }catch(Exception e){
         flush = sc.nextLine();
         System.out.println("invalid input(error occured in sorting job), please try again!");
         sortJobs(temp);   
      }
      return null;
   }
}