package testing.systemout.example2;

public class Service {

  private final Printer printer;

  public Service(Printer printer) {
    this.printer = printer;
  }

  public void doSomething(String input) {
    printer.print(input);
  }

}
