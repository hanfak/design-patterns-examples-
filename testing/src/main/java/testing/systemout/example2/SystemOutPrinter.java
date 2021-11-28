package testing.systemout.example2;

public class SystemOutPrinter implements Printer {
  @Override
  public void print(String input) {
    System.out.println(input);
  }
}
