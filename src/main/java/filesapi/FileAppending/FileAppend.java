package filesapi.FileAppending;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileAppend {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/java/filesapi/FileAppending/ExampleText.txt");
        Charset charset = StandardCharsets.UTF_8;
        List<String> list = Collections.singletonList("\nhello");
        List<String> multipleLines = Arrays.asList("Buenos Aires", "Córdoba", "La Plata"); // Adds new line
        String data = "Hello, goodbye\n nice to see you";
        byte[] bytes = data.getBytes();

        Files.write(path, list, charset, StandardOpenOption.APPEND);
        Files.write(path, multipleLines, charset, StandardOpenOption.APPEND);
        Files.write(path, bytes, StandardOpenOption.APPEND);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/java/filesapi/FileAppending/ExampleText.txt", true))){
            bw.newLine();
            bw.write("400:08311998:Inprise Corporation:249.95");
            bw.newLine();
            bw.write("400:08311998:Inprise Corporation:249.95"); // doesnot override
            bw.append("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
