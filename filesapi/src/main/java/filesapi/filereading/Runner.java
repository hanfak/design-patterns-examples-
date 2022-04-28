package filesapi.filereading;

import java.io.File;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        FileReading fileReading = new FileReading();
        fileReading.getPath();


        System.out.println("\n\n Some examples of using File methods");
        String s = "ExampleText.txt";
        File file = new File("./src/main/java/filesapi/filereading/" + s);
        System.out.println("File " + s + " exists: " + file.exists());
        System.out.println("File " + s + " absolute path: " + file.getAbsolutePath());
        System.out.println("File " + s + " canonical path: " + file.getCanonicalPath());
        System.out.println("File " + s + " path: " + file.getPath());
        System.out.println("File " + s + " name of file: " + file.getName());
        System.out.println("File " + s + " write permissions: " + file.canWrite());
        System.out.println("File " + s + " total space of file system: " + file.getTotalSpace());

        File dir = new File("./src/main/java/filesapi/filereading/");
        System.out.println("Dir " + s + " is directory: " + dir.isDirectory());
        System.out.println("Dir " + s + " number of files: " + dir.listFiles().length);
    }

}

