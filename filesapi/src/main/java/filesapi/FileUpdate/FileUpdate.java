package filesapi.FileUpdate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//http://javaconceptoftheday.com/modify-replace-specific-string-in-text-file-in-java/

public class FileUpdate {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/java/filesapi/FileUpdate/ExampleText.txt");
        Path path = Paths.get("./src/main/java/filesapi/FileUpdate/ExampleText.txt");


        StringBuilder sb = new StringBuilder();

        String textinLine;

        try(FileInputStream fs = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(in)) {


            Files.lines(path).forEach(x -> {
                try {
                    sb.append(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

//            while(true) {
//                textinLine=br.readLine();
//                if (textinLine==null) {
//                    break;
//                }
//                sb.append(textinLine);
//            }

            String textToEdit1 = "boo";
            int indexOfStringToReplace = sb.indexOf(textToEdit1);
            sb.replace(indexOfStringToReplace,indexOfStringToReplace + textToEdit1.length(),"New Append text");

            String textToEdit2 = "xyz";
            int indexOfStringToReplace2 = sb.indexOf(textToEdit2);
            sb.replace(indexOfStringToReplace2,indexOfStringToReplace2 + textToEdit2.length(),"Second new edit text");
        }

        try(FileWriter fstream = new FileWriter(file);
            BufferedWriter outobj = new BufferedWriter(fstream)){

            outobj.write(sb.toString());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
