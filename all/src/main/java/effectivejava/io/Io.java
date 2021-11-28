package effectivejava.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Pre java 7 needed to close  resources
public class Io {
  public static void main(String... args) throws IOException {
    OutputStream out = null;
    try {
      out = new FileOutputStream("out.txt");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      out.close();
    }
  }
}
