package com.tgt.igniteplus;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*********************************************************************************************************************/
public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<IgniteMembers> members = new ArrayList<>();
    static ArrayList<String> Department = new ArrayList<>();
    static int choice;
    static int flag;


/*********************************************************************************************************************/
//To display all the existing departments
    static void displayDept(){
        System.out.println("Here is a list of all the departments");
        System.out.println("--------------------------------------------------------------------------------------------");
        for(String dept : Department){
            System.out.println(dept);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

    }

    /**********************************************************************************************************************/
    //To display all the Department and its members
    static void printDepartment(){
        System.out.println("Here is a List of all the Departments and its members");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (IgniteMembers mem : members ){
            System.out.println(mem.getDepartment()+ "\t \t "+mem.getName());
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }
/*********************************************************************************************************************/
//To create a new department
static void createDept() {
    System.out.println("Please enter the department you wish to add");
    input.nextLine();
    String newDept = input.nextLine();
    if (Department.contains(newDept)) {
        System.out.println("The department already exists");
    } else {
        Department.add(newDept);
        System.out.println(newDept + " Successfully added");
    }
    System.out.println("-----------------------------------------------------------------------------------------------");
}
    /**********************************************************************************************************************/
    //to swap a members department
    static void swap(){
        input.nextLine();
        System.out.println("Enter the Member whose department you want to change");
        String updateName = input.nextLine();
        //input.nextLine();
        System.out.println("Enter the department");
        String updateDept = input.nextLine();

       for(IgniteMembers i: members){
           if(i.getName().equals(updateName)){
               i.setDepartment(updateDept);
               System.out.println(updateName+" Successfully shifted to " +updateDept);
               System.out.println("-------------------------------------------------------------------------------------------");
               return;
           }
       }
        System.out.println("Please enter a valid Name/Department");
    }

/**********************************************************************************************************************/


    static void addSkill(){
        input.nextLine();
        System.out.println("Enter the Department name you wish to add the Skill set to");
        String updateDept = input.nextLine();
        System.out.println("Enter the skill set you wish to add");
        String skillUpdate = input.nextLine();

        if(Department.contains(updateDept)){
            for(IgniteMembers mem : members){
                if(mem.getDepartment().equals(updateDept)){
                    mem.skillset.add(skillUpdate);
                }
            }
            System.out.println("Successfully added "+skillUpdate+" to "+updateDept);
        }
        else{
            System.out.println("Oops department not found");
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
/**********************************************************************************************************************/
//to list the members with a skill set
    static void skillUser(){
        input.nextLine();
        System.out.println("Enter the skill you are looking for");
        String lookFor = input.nextLine();
        System.out.println("The members with the Skill set are: ");
        for(IgniteMembers mem : members){
            if(mem.skillset.contains(lookFor)){
                System.out.println(mem.getName()+ "\t \t of the Department \t \t"+mem.getDepartment());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
    /**********************************************************************************************************************/
//to delete a department
    static void deleteDepartment(){
        input.nextLine();
        System.out.println("Enter the department you wish to delete");
        String delDept = input.nextLine();
        if(Department.contains(delDept)){
            Department.remove(delDept);
            System.out.println(delDept+" Successfully deleted!");
            System.out.println("--------------------------------------------------------------------------------------------");
        }
    }
    /**********************************************************************************************************************/
    static void createMember(){
        input.nextLine();
        System.out.println("Enter the name of the member you wish to add");
        String newMem = input.nextLine();
        if(members.contains(newMem)){
            System.out.println("The member already exists");
        }
        else{
            System.out.println("Enter the department you wish to add "+newMem+" in ");
            String dept = input.nextLine();
            members.add(new IgniteMembers(newMem,dept));
            System.out.println(newMem+" Successfully added to "+dept);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
    /**********************************************************************************************************************/
    public static void main(String[] args) {
	// write your code here

        HashSet<String> gauthamSS = new HashSet<>();
        HashSet<String> divyaSS = new HashSet<>();
        HashSet<String> naveenSS = new HashSet<>();
        HashSet<String> amitSS = new HashSet<>();


/**********************************************************************************************************************/

        members.add(new IgniteMembers("Gautham","VTU","Data Science",gauthamSS,28));
        members.add( new IgniteMembers("Divya","TGT","Data Science",divyaSS,26));
        members.add(new IgniteMembers("Naveen","TMT","Infrastructure",naveenSS,25));
        members.add(new IgniteMembers("Amit","DOJO","Infrastructure",amitSS,22));

        gauthamSS.add("Java");
        gauthamSS.add("SQL");
        gauthamSS.add("DS");

        divyaSS.add("Java");
        divyaSS.add("SQL");
        divyaSS.add("ML");

        naveenSS.add("Chef");
        naveenSS.add("Reach");
        naveenSS.add("AI");

        amitSS.add("Linux");
        amitSS.add("PSQL");
        amitSS.add("Scripting");

       Department.add("Data Science");
       Department.add("Infrastructure");
/**********************************************************************************************************************/
       do{

           System.out.println(" --------------------------------------------\n"+
                   "Option menu\n"+
                   "---------------------------------------------------------------------------------------------------\n"+

                   "1.To Display all the existing departments \n"+
                   "2.To Display all the Deaprtments and its members \n"+
                   "3.To create a new Department\n"+
                   "4.To swap Department \n"+
                   "5.To add skillset to all the members of a Department \n"+
                   "6. To list the members with a Skill Set\n"+
                   "7. To delete a Department\n"+
                   "8. To create a new member and assign it to a department \n"+

                   "----------------------------------------------------------------------------------------------------"


           );

           System.out.println("Please enter your Option");
           choice = input.nextInt();

            switch(choice){
               case 1: displayDept();
                   break;
               case 2: printDepartment();
                   break;
               case 3: createDept();
                   break;
                case 4: swap();
                break;
                case 5: addSkill();
                break;
                case 6: skillUser();
                break;
                case 7: deleteDepartment();
                break;
                case 8: createMember();
                break;
                default:
                    System.out.println("Please enter a valid Option");
           }
           System.out.println("Press 1 to continue. If not, press 0");
            flag = input.nextInt();
           System.out.println("----------------------------------------------------------------------------------------");
           }
       while(flag == 1);

/**********************************************************************************************************************/
       }
}

/*Output:
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        1
        Here is a list of all the departments
        --------------------------------------------------------------------------------------------
        Data Science
        Infrastructure
        --------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        2
        Here is a List of all the Departments and its members
        --------------------------------------------------------------------------------------------
        Data Science	 	 Gautham
        Data Science	 	 Divya
        Infrastructure	 	 Naveen
        Infrastructure	 	 Amit
        --------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        3
        Please enter the department you wish to add
        Cloud Computing
        Cloud Computing Successfully added
        -----------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        4
        Enter the Member whose department you want to change
        Ankitha
        Enter the department
        Cloud Cimputing
        Please enter a valid Name/Department
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        4
        Enter the Member whose department you want to change
        Divya
        Enter the department
        Cloud Computing
        Divya Successfully shifted to Cloud Computing
        -------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        5
        Enter the Department name you wish to add the Skill set to
        Infrastructure
        Enter the skill set you wish to add
        PHP
        Successfully added PHP to Infrastructure
        -----------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        6
        Enter the skill you are looking for
        PHP
        The members with the Skill set are:
        Naveen	 	 of the Department 	 	Infrastructure
        Amit	 	 of the Department 	 	Infrastructure
        -----------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        7
        Enter the department you wish to delete
        Data Science
        Data Science Successfully deleted!
        --------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        8
        Enter the name of the member you wish to add
        Ankitha
        Enter the department you wish to add Ankitha in
        Cloud Computing
        Ankitha Successfully added to Cloud Computing
        -----------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        1
        ----------------------------------------------------------------------------------------
        --------------------------------------------
        Option menu
        ---------------------------------------------------------------------------------------------------
        1.To Display all the existing departments
        2.To Display all the Deaprtments and its members
        3.To create a new Department
        4.To swap Department
        5.To add skillset to all the members of a Department
        6. To list the members with a Skill Set
        7. To delete a Department
        8. To create a new member and assign it to a department
        ----------------------------------------------------------------------------------------------------
        Please enter your Option
        2
        Here is a List of all the Departments and its members
        --------------------------------------------------------------------------------------------
        Data Science	 	 Gautham
        Cloud Computing	 	 Divya
        Infrastructure	 	 Naveen
        Infrastructure	 	 Amit
        Cloud Computing	 	 Ankitha
        --------------------------------------------------------------------------------------------
        Press 1 to continue. If not, press 0
        0
        ----------------------------------------------------------------------------------------

        Process finished with exit code 0

 */

