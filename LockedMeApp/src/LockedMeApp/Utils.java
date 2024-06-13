package LockedMeApp;

import java.io.File;

public class Utils {

    public static boolean isValidFileName(String fileName) {
        return fileName != null && !fileName.trim().isEmpty() && fileName.matches("[a-zA-Z0-9._-]+");
    }

    public static void printLineSeparator() {
        System.out.println("----------------------------------------------------");
    }

    public static String getFileSize(File file) {
        long size = file.length();
        if (size < 1024) return size + " B";
        int exp = (int) (Math.log(size) / Math.log(1024));
        char pre = "KMGTPE".charAt(exp - 1);
        return String.format("%.1f %sB", size / Math.pow(1024, exp), pre);
    }
}
