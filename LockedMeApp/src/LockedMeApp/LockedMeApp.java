package LockedMeApp;

import java.util.Scanner;

public class LockedMeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileOperations fileOps = new FileOperations("data");

        boolean running = true;

        while (running) {
            MenuHelper.displayMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    fileOps.listFiles();
                    break;
                case "2":
                    handleFileOperations(scanner, fileOps);
                    break;
                case "3":
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void handleFileOperations(Scanner scanner, FileOperations fileOps) {
        boolean backToMain = false;

        while (!backToMain) {
            MenuHelper.displayFileMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter file name to add: ");
                    String addFileName = scanner.nextLine();
                    fileOps.addFile(addFileName);
                    break;
                case "2":
                    System.out.print("Enter file name to delete: ");
                    String deleteFileName = scanner.nextLine();
                    fileOps.deleteFile(deleteFileName);
                    break;
                case "3":
                    System.out.print("Enter file name to search: ");
                    String searchFileName = scanner.nextLine();
                    fileOps.searchFile(searchFileName);
                    break;
                case "4":
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }
}
