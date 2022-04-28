package filesapi.FileWriting;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCreation2 {
    public static void main(String[] args) {

        String data = "I will write this String to File in Java";
        int noOfLines = 10000;
        writeUsingFileWriter(data);

        writeUsingBufferedWriter(data, noOfLines);

        writeUsingFiles(data);

        writeUsingOutputStream(data);
        System.out.println("DONE");
    }

    /**
     * Use Streams when you are dealing with raw data
     *
     * @param data
     */
    private static void writeUsingOutputStream(String data) {
        try (OutputStream os = new FileOutputStream(new File("./src/main/java/filesapi/FileWriting/created-file4.txt"))) {
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use Files class from Java 1.7 to write files, internally uses OutputStream
     */
    private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("./src/main/java/filesapi/FileWriting/created-file3.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use BufferedWriter when number of write operations are more
     * It uses internal buffer to reduce real IO operations and saves time
     */
    private static void writeUsingBufferedWriter(String data, int noOfLines) {
        File file = new File("./src/main/java/filesapi/FileWriting/created-file2.txt");
        String dataWithNewLine = data + System.getProperty("line.separator");
        try (FileWriter fr = new FileWriter(file);
             BufferedWriter br = new BufferedWriter(fr)) {

            for (int i = noOfLines; i > 0; i--) {
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use FileWriter when number of write operations are less
     */
    private static void writeUsingFileWriter(String data) {
        File file = new File("./src/main/java/filesapi/FileWriting/created-file1.txt");
        try (FileWriter fr = new FileWriter(file)) {
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
