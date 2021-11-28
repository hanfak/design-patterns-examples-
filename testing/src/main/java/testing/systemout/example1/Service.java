package testing.systemout.example1;

import java.io.PrintStream;

public class Service {

  private final PrintStream printStream;

  public Service(PrintStream printStream) {
    this.printStream = printStream;
  }

  public void doSomething(String input) {
    printStream.println(input);
  }

}
