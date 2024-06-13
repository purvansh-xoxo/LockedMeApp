package LockedMeApp;

public class MenuHelper {

    public static void displayMainMenu() {
        printLineSeparator();
        System.out.println("		---* LockedMe.com *---");
        System.out.println("1. List Files");
        System.out.println("2. File Operations");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public static void displayFileMenu() {
        printLineSeparator();
        System.out.println("		--- File Operations ---");
        System.out.println("1. Add a File");
        System.out.println("2. Delete a File");
        System.out.println("3. Search a File");
        System.out.println("4. Go Back");
        System.out.print("Choose an option: ");
    }

    private static void printLineSeparator() {
        System.out.println("----------------------------------------------------");
    }
}

