package testing.systemout.example2;

public class Main {
  public static void main(String... args) {
    Printer printer = new SystemOutPrinter();
    new Service(printer).doSomething("hello");

    Printer newPrinter = new FilePrinter("output.txt");
    new Service(newPrinter).doSomething("hello");
  }
}
