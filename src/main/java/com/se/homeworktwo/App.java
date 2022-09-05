package main.java.com.se.homeworktwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Homework 2");
        Scanner scanner = new Scanner(System.in);

        //runMenu keeps triggering the menu till the user enters n
        String runMenu = "y";

        //populate the help for users
        Help help = new Help("help", "Display all the help commands available, enter the name of specific command if you want to check that.");
        Help csvData = new Help("csvData", "This command helps the user to enter the path of csv file they want to parse.");
        Help editHelp = new Help("editHelp", "This command helps the user to edit the help menu.");

        //array of help commands
        List<Help>helpCommands = new ArrayList<>();
        helpCommands.add(csvData);
        helpCommands.add(editHelp);

        //Until the user enters N or n we keep the console active for the user to enter information
        while(!runMenu.equalsIgnoreCase("n")){
            System.out.println("Enter your choice, press 'n' to terminate the application.");
            runMenu = scanner.nextLine();

            //Check the condition entered by the user and trigger respective functions
            if(runMenu.equalsIgnoreCase("help")){
                System.out.println(help);
                for (Help command:helpCommands) {
                    System.out.println(command.toString());
                }
            }else if(runMenu.equalsIgnoreCase("csvData")){
                System.out.println(csvData.toString());
            }else if(runMenu.equalsIgnoreCase("editHelp")){
                System.out.println(editHelp.toString());
            }else if(runMenu.equalsIgnoreCase(("n"))){
                continue;
            }else{
                System.out.println("Invalid choice, kindly use the help menu");
            }
        }

    }
}
