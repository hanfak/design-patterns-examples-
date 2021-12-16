package comparable.effectivejava.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Post java 7 use of try-with-resources
public class Io2 {
  public static void main(String... args) throws IOException {
    try(OutputStream  out = new FileOutputStream("out.txt")) {
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
