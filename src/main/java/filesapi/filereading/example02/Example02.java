package filesapi.filereading.example02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example02 {
  public String processFile() throws IOException {
    try (BufferedReader br =
             new BufferedReader(new FileReader("./src/main/java/filesapi/filereading/ExampleText.txt"))) {
      return br.readLine();
    }
  }

  public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
  }

  public String processFile(BufferedReaderProcessor p) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/filesapi/filereading/ExampleText.txt"))) {
      return p.process(br);
    }
  }

  public static void main(String... args) throws IOException {
    String old = new Example02().processFile(); // Cannot change at run time
    System.out.println("old = " + old);
    System.out.println();
    // Can pass in strategies to change at runtime
    String oneLine = new Example02().processFile((BufferedReader br) -> br.readLine());
    System.out.println("oneLine = " + oneLine);
    System.out.println();
    String twoLines = new Example02().processFile((BufferedReader br) -> br.readLine() + br.readLine());
    System.out.println("twoLines = " + twoLines);

  }

}
