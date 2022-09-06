package com.se.homeworktwo;

public class Help {
    String commandName;
    String commandDescription;

    public Help(String commandName, String commandDescription) {
        this.commandName = commandName;
        this.commandDescription = commandDescription;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    @Override
    public String toString() {
        return  "commandName='" + commandName + '\'' +
                ", commandDescription='" + commandDescription;
    }
}
