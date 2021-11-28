package filesapi.filereading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReading {
    public void getPath() throws IOException {
        // File in same directory as this file
         Path path = Paths.get("./src/main/java/filesapi/filereading/ExampleText.txt");
        // File in main project directory
        // Path path = Paths.get("./ExampleText.txt");
        // File in directory one level above
        // Path path = Paths.get("./src/main/java/filesapi/ExampleText.txt");
        // File in test directory
//         Path path = Paths.get("./src/test/java/ExampleText.txt");





        System.out.println("The Path Name is: "+ path);

        String content = new String(Files.readAllBytes(path));
        System.out.println("content = " + content);

        Files.lines(path).forEach(System.out::print);
        System.out.println("\n**************\n");

        String contents = Files.lines(path).collect(Collectors.joining("\n"));
        System.out.println(contents);

        List<String> lines = Files.readAllLines(path);
        System.out.println("lines = " + lines);
    }

}

