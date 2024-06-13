package LockedMeApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileOperations {
    private final String directoryPath;

    public FileOperations(String directoryPath) {
        this.directoryPath = directoryPath;
        createDirectoryIfNotExists();
    }

    private void createDirectoryIfNotExists() {
        Path path = Paths.get(directoryPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                System.out.println("Created directory: " + directoryPath);
            } catch (IOException e) {
                System.err.println("Failed to create directory: " + e.getMessage());
            }
        }
    }

    public void listFiles() {
        File directory = new File(directoryPath);
        String[] files = directory.list();

        if (files != null && files.length > 0) {
            Arrays.sort(files, String::compareToIgnoreCase);
            System.out.println("Files in ascending order:");
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("The directory is empty.");
        }
    }

    public void addFile(String fileName) {
        if (!isValidFileName(fileName)) {
            System.out.println("Invalid file name. Please provide a valid name.");
            return;
        }

        File file = new File(directoryPath + File.separator + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File " + fileName + " added successfully.");
            } else {
                System.out.println("File " + fileName + " already exists.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while adding the file: " + e.getMessage());
        }
    }

    public void deleteFile(String fileName) {
        if (!isValidFileName(fileName)) {
            System.out.println("File not found!");
            return;
        }

        File directory = new File(directoryPath);
        String[] files = directory.list();

        if (files == null || files.length == 0) {
            System.out.println("No files available to delete.");
            return;
        }

        // Case-sensitive file deletion
        boolean fileDeleted = false;
        for (String file : files) {
            if (file.equals(fileName)) {
                File fileToDelete = new File(directoryPath + File.separator + fileName);
                if (fileToDelete.delete()) {
                    System.out.println("File " + fileName + " deleted successfully.");
                    fileDeleted = true;
                    break;
                } else {
                    System.out.println("An error occurred while deleting the file.");
                }
            }
        }

        if (!fileDeleted) {
            System.out.println("File " + fileName + " not found.");
        }
    }


    public void searchFile(String fileName) {
        if (!isValidFileName(fileName)) {
            System.out.println("File not found!");
            return;
        }

        File directory = new File(directoryPath);
        String[] files = directory.list();

        if (files != null && Arrays.asList(files).contains(fileName)) {
            System.out.println("File " + fileName + " found.");
        } else {
            System.out.println("File " + fileName + " not found.");
        }
    }

    private boolean isValidFileName(String fileName) {
        return fileName != null && !fileName.trim().isEmpty() && fileName.matches("[a-zA-Z0-9._-]+");
    }
}
