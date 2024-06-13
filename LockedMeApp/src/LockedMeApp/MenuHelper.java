package LockedMeApp;

public class MenuHelper {

    public static void displayMainMenu() {
        printLineSeparator();
        System.out.println("		---* LockedMe.com *---");
        System.out.println("Welcome to LockedMe");
        System.out.println("Developer : Purvansh Narang\n");
        System.out.println("1. List Files (ascending order)");
        System.out.println("2. Business File Operations");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public static void displayFileMenu() {
        printLineSeparator();
        System.out.println("		--- File Operations ---");
        System.out.println("1. Add a File");
        System.out.println("2. Delete a File");
        System.out.println("3. Search a File");
        System.out.println("4. Go Back to Main Menu");
        System.out.print("Choose an option: ");
    }

    private static void printLineSeparator() {
        System.out.println("----------------------------------------------------");
    }
}

