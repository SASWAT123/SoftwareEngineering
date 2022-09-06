package com.se.homeworktwo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Homework 2");
        Scanner scanner = new Scanner(System.in);

        //runMenu keeps triggering the menu till the user enters n
        String runMenu = "y";

        //populate the help for users
        Help help = new Help("help", "Display all the help commands available, enter the name of specific command if you want to check that.");
        Help csvData = new Help("csvData", "This command helps the user to enter the path of csv file they want to parse.");
        Help editHelp = new Help("editHelp", "This command helps the user to edit the help menu.");

        //array of help commands
        List<Help> helpCommands = new ArrayList<>();
        helpCommands.add(csvData);
        helpCommands.add(editHelp);

        //Until the user enters N or n we keep the console active for the user to enter information
        while(!runMenu.equalsIgnoreCase("n")){
            System.out.println("Enter your choice, press 'n' to terminate the application.");
            runMenu = scanner.nextLine();

            //Check the condition entered by the user and trigger respective functions
            if(runMenu.equalsIgnoreCase("n")){
                return;
            }else if(runMenu.equalsIgnoreCase(help.getCommandName())){
                System.out.println(help);
                for (Help command: helpCommands) {
                    System.out.println(command.toString());
                }
            }else if(runMenu.equalsIgnoreCase(String.format("help %s", csvData.getCommandName()))){
                System.out.println(csvData);
            }else if(runMenu.equalsIgnoreCase(String.format("help %s", editHelp.getCommandName()))){
                System.out.println(editHelp);
            }else if(runMenu.equalsIgnoreCase(String.format("help %s %s", editHelp.getCommandName(), csvData.getCommandName()))
                    || runMenu.equalsIgnoreCase(String.format("help %s %s", editHelp.getCommandName(), editHelp.getCommandName()))){
                //check helpCommand update functionality
                List<String> updateHelpFlag = Arrays.asList(runMenu.split(" "));

                System.out.println("Kindly enter the new help flag name:");
                String commandName = scanner.nextLine();
                if(updateHelpFlag.get(1).equalsIgnoreCase(csvData.getCommandName())){
                    csvData.setCommandName(commandName);
                }else{
                    editHelp.setCommandName(commandName);
                }
                updateHelpFlag.set(1, commandName);

                System.out.println("Kindly enter the new help flag description:");
                String commandDescription = scanner.nextLine();
                if(updateHelpFlag.get(1).equalsIgnoreCase(csvData.getCommandName())){
                    csvData.setCommandDescription(commandDescription);
                }else{
                    editHelp.setCommandDescription(commandDescription);
                }
            // TODO - edit this to parse the path for csv from commandline so the user can add any csv file from system
            }else if(runMenu.equalsIgnoreCase(csvData.getCommandName() + " " + "data/testFile.csv")){
                try {
                    readCSV("data/testFile.csv");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (CsvException e) {
                    throw new RuntimeException(e);
                }
            }else{     //print any other invalid choice
                System.out.println("Invalid choice, kindly use the help menu");
            }
        }
        scanner.close();

    }

    private static void readCSV(String filePath) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }
    }
}
