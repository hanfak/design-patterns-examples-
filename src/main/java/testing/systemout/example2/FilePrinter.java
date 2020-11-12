package testing.systemout.example2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePrinter implements Printer{
  private final String path;

  public FilePrinter(String path) {
    this.path = path;
  }

  @Override
  public void print(String input) {
    try {
      Files.write(Paths.get(path), input.getBytes());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
