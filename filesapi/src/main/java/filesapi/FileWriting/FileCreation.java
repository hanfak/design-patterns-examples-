package filesapi.FileWriting;

import java.io.*;

public class FileCreation {
    public static void main(String[] args) {

        System.out.println("Create an empty file");
        // Buffered writer is more efficient
        String file = "./src/main/java/filesapi/FileWriting/created-file.txt";
        String file1 = "./src/main/java/filesapi/FileWriting/created-file1a.txt";
        String file2 = "./src/main/java/filesapi/FileWriting/created-file2b.txt";
        String charsetName = "utf-8";

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), charsetName))) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Create a file with something in it");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file1), charsetName))) {
            writer.write("something"); // Pass anything, some out put from a function
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter writer = new FileWriter(file2, true);
            writer.write("Hello World");
            writer.write("\r\n");   // write new line
            writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
